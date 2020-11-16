/* Antony Adamovich
*  grsh.c for Programming Assignment 3
*  Prof. Linh B Ngo - CSC 331 - West Chester University
*  Created: 14-NOV-2019 - Last Edited: 05-DEC-2019
*  Description: A simple implementation of a CLI (Command
*   Line Interpreter) or "shell". Golden Ram SHell (grsh)
*   can be run in interactive mode or batch mode. 
*  Definitions:
*   PCO: Parallel Command Operator, refers to '&' token in 
*   command line arguments
*  Resources:
*   Thank you user "Ambroz Bizjak" for usage of dup2() and close()
*   https://stackoverflow.com/questions/9084099/re-opening-stdout-and-stdin-file-descriptors-after-closing-them
*/

#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <fcntl.h>

void complain();
char * getPath(const char *, const char *);
void runCommand(char ** commandv, int commandc, const char * path);
int countPC(char ** commandv, int commandc);

/* Returns an absolute path to the argument 'command' given the paths
*  in the ':' delimited 'path' argument. Returns NULL if the command
*  does not exist in any directories specified by 'path' or if said
*  directories cannot be accessed. 
*/
char * getPath(const char * path, const char * command){
    char * absolutePath = NULL;
    char * nextToken = NULL;
    char * pathCopy = strdup(path);
    
    // Tokenize copy of path and iterate through all tokens
    nextToken = strtok(pathCopy, ":");
    while(nextToken != NULL){
        // Reset absolutePath
        free(absolutePath);
        absolutePath = NULL;
        // + 2 : One for insertion of '/', one for terminating '\0'
        absolutePath = (char *) calloc(strlen(nextToken) + strlen(command) + 2, sizeof(char));
        absolutePath[0] = '\0';
        // Build absolutePath
        strcat(absolutePath, nextToken);
        strcat(absolutePath, "/");
        strcat(absolutePath, command);
        // Verify directory is reachable and command file is accessible
        if(access(absolutePath, X_OK) == 0){
            // Success, return valid path
            return absolutePath;
        }
        // Advance token scanner
        nextToken = strtok(NULL, ":");
    }
    // Failure, return null
    free(absolutePath);
    absolutePath = NULL;
    return NULL;
}

// The only error message printed by grsh to stderr
void complain(){
    fprintf(stderr, "An error has occurred\n");
}

// Given a list of paths, runs a command line stored in 'commandv'
void runCommand(char ** commandv, int commandc, const char * path){
    int mypid;
    char * absolutePath = NULL;
    
    // Fork and exec to run command specified. Sequential run,
    // parent waits for child to fully complete. 
    mypid = fork();
    if(mypid < 0){
        // Fork failed, print error and continue
        complain();
    }
    else{
        // Child path
        if (mypid == 0){
            // Get absolute path for command
            absolutePath = getPath(path, commandv[0]);
            if(absolutePath != NULL){
                // If path was obtained, exec into new process
                execv(absolutePath, commandv);
            }
            // If execution reaches here, error has occurred
            complain();
            // Quit out of child
            exit(0);
        }
        // Parent path, 
        else{
            wait(NULL);
        }
    }
}

/* Counts the number of '&' tokens in the commandv array.
*  Note this only pays attention to strings in commandv 
*  that are exactly "&\0"
*/
int countPCO(char ** commandv, int commandc){
    int sumPCO = 0;
    
    for(int i = 0; i < commandc; i++){
        if(strcmp(commandv[i], "&") == 0){
            sumPCO++;
        }
    }
    return sumPCO;
}

/* Returns the last index of a '&' token (PCO) in the
*  commandv array. (zero-indexed) Returns -1 if a PCO
*  does not exist in the 'commandv' argument. 
*/
int lastPCO(char ** commandv, int commandc){
    for(int i = commandc - 1; i >= 0; i--){
        if(strcmp(commandv[i], "&") == 0){
            return i;
        }
    }
    return -1;
}

int main (int argc, char * argv[]){
    const char * DEFAULT_PATH = "/bin:/usr/bin";
    
    // ========== VARIABLES ==========
    
    // Points to either stdout or a file (for batch mode)
    FILE * source = NULL;
    // For getline operations
    char * line = NULL;
    size_t size = 0;
    // Environment path variable, ':' delimited
    char * path = NULL;
    // Temporary for string tokenization
    char * nextToken = NULL;
    // Parsed form of command line
    char ** commandv = NULL;
    // Number of tokens parsed into commandv
    int commandc = 0;
    // Number of '>' tokens in commandv
    int countR = 0;
    // Used in calloc for path
    int pathLength = 0;
    // Copies of file descriptors for stdout and stderr
    int stdoutCopy = -1;
    int stderrCopy = -1;
    // File descriptors after redirection
    int reout;
    int reerr;
    // Index of last occurrence of '&' token in commandv
    int indexLastPCO = -1;
    // PID identification for forked processes
    int mypid = 1;
    // 0 only for original (root) parent process, 1 for all children
    int spawned = 0;
    
    // ========== PATH SETUP ==========
    
    path = calloc(strlen(DEFAULT_PATH) + 1, sizeof(char));
    path[0] = '\0';
    strcat(path, DEFAULT_PATH);
    
    // ========== PROGRAM MODE IDENTIFICATION ==========
    
    // Batch mode
    if(argc == 2){
        source = fopen(argv[1], "r");
        // If file failed to open, program quits
        if(source == NULL){
            complain();
            return 1;
        }
    }
    // Interactive mode
    if(argc == 1){
        source = stdin;
    }
    // Valid modes: Interactive / Batch
    if(argc == 1 || argc == 2){
        // Print prompt
        if(argc == 1){
            // (Only in interactive mode)
            printf("grsh> ");
        }
        while(getline(&line, &size, source) != -1){
            
            // ========== COMMAND: EXIT ==========
            
            if(strcmp(line, "exit\n") == 0){
                return 0;
            }
            
            // ========== TOKENIZATION ==========
            
            // Overzealous allocation to size of command line. 
            // Will always be larger than the number of tokens
            // but contains a good deal of wasted space. 
            commandv = (char **) calloc(strlen(line), sizeof(char *));
            nextToken = strtok(line, " \n");
            while(nextToken != NULL){
                // Add token to commandv
                commandv[commandc] = strdup(nextToken);
                commandc++;             
                // Advance token scanner
                nextToken = strtok(NULL, " \n");
            }
            // Set null pointer at the end of commandv (for execv)
            commandv[commandc] = NULL;
            
            // ========== PARALLEL COMMANDS ==========

            while(countPCO(commandv, commandc) > 0){ 
                mypid = fork();
                if(mypid < 0){
                    // Fork failed, print error and continue
                    complain();
                    // Avoids infinite loop
                    break;
                }
                else{
                    indexLastPCO = lastPCO(commandv, commandc);
                    // Child path - Head of list (maybe more PCO's)
                    if (mypid == 0){
                        // Mark this process as a non-root process
                        spawned = 1;
                        // Wipe out '&' token and everything after it
                        for(int i = indexLastPCO; i < commandc; i++){
                            commandv[i] = NULL;
                        }
                        // Update commandc to reflect new size
                        commandc = indexLastPCO;
                        
                    }
                    // Parent path - One command
                    else{
                        for(int i = 0; i < commandc; i++){
                            // Move everything after '&' token to beginning of
                            // commandv (zero-indexed)
                            if(i < (commandc - indexLastPCO - 1)){
                                commandv[i] = commandv[indexLastPCO + i + 1];
                            }
                            // After move, wipe out everything after the moved command
                            else{
                                commandv[i] = NULL;
                            }
                        }
                        // Update commandc to reflect new size
                        commandc = (commandc - indexLastPCO - 1);
                    }
                } 
            }
            
            // ========== FILE REDIRECTION ==========
            
            // Count number of > operators in commandv
            for(int i = 1; i < commandc; i++){
                nextToken = commandv[i];
                if(strcmp(nextToken, ">") == 0){
                    countR++;
                }
            }
            if(countR > 0){
                // First argument for safe array access (short circuit eval)
                if(commandc >= 3 && (countR == 1 && strcmp(commandv[commandc - 2], ">") == 0)){
                    // Duplicate values of stdout and stderr file descriptors
                    stdoutCopy = dup(STDOUT_FILENO);
                    stderrCopy = dup(STDERR_FILENO);
                    // Close stdout and stderr
                    close(STDOUT_FILENO);
                    close(STDERR_FILENO);
                    // Open file descriptors to file specified by '>' operator
                    // NOTE: Both stdout and stderr are redirected to the same file
                    reout = open(commandv[commandc - 1], O_CREAT|O_WRONLY|O_TRUNC, S_IRWXU);
                    reerr = open(commandv[commandc - 1], O_WRONLY|O_APPEND);
                    // Strip out '>' and file name from commandv
                    commandv[commandc - 2] = '\0';
                    commandc -= 2;
                }
                // More than 1 '>' token, more than one argument after '>', no argument before '>'
                else{
                    // Print error for bad usage of redirection
                    complain();
                }
            }
            
            // ========== COMMAND: PATH ==========
            
            if(strcmp(commandv[0], "path") == 0){
                // Wipe contents of path
                free(path);
                path = NULL;
                // Reset pathLength
                pathLength = 0;
                // Count length of path to be created for calloc
                for(int i = 1; i < commandc; i++){
                    // Add +1 for ':' delimiter
                    pathLength += (strlen(commandv[i]) + 1);
                }
                // Add +1 for terminating '\0'
                pathLength++;
                path = (char *) calloc(pathLength, sizeof(char));
                // Initialize path for future append
                path[0] = '\0';
                // Transfer arguments of path command into variable
                for(int i = 1; i < commandc; i++){
                    strcat(path, commandv[i]);
                    strcat(path, ":");
                }
            }
            
            // ========== COMMAND: CD ==========
            
            else if(strcmp(commandv[0], "cd") == 0){
                if(commandc == 1 || commandc > 2){
                    // cd was called with no arguments or multiple paths
                    complain();
                }
                else{
                    // chdir changes working directory, 0 is success
                    if(chdir(commandv[1]) != 0){
                        // Requested directory cannot be accessed
                        complain();
                    }
                }
            }
            
            // ========== COMMAND: * ==========
            
            else{
                runCommand(commandv, commandc, path);
            }
            
            // ========== LOOPING RESET TASKS ==========
            
            // In the event file descriptors were changed...
            if(stderrCopy >= 0 || stdoutCopy >= 0){
                // Close redirected outputs to stderr and stdout
                close(reout);
                close(reerr);
                // Restore normal functionality of stderr and stdout
                dup2(stdoutCopy, STDOUT_FILENO);
                dup2(stderrCopy, STDERR_FILENO);
                // Close temporary duplicate file descriptors
                close(stdoutCopy);
                close(stderrCopy);
            }
            // Each command line parse requires state reset for the following variables:
            // File descriptors are flagged as unchanged at values < 0
            stdoutCopy = -1;
            stderrCopy = -1;
            // Wipe the contents of commandv for next parse
            free(commandv);
            commandv = NULL;
            commandc = 0;
            // Reset count of redirection operators
            countR = 0;
            // For commands involving PCO's, wait here for all children to 
            // exit before starting next command line
            wait(NULL);
            // Specifically, all children should exit here without parsing next command line
            if(spawned == 1){
                free(path);
                path = NULL;
                exit(0);
            }
            // Print prompt before returning control to user 
            if(argc == 1){
                // (Interactive mode only)
                printf("grsh> ");
            }
        } // end while(getline(&line, &size, source) != -1)
        
        // ========== PROGRAM CLEANUP ==========
        
        free(path);
        path = NULL;
        free(commandv);
        commandv = NULL;
        if(argc == 2){
            // In batch mode, close file
            fclose(source);
            source = NULL;
        }
        // EOF (or failure) reached, exit with no error
        return 0;
    } // end if(argc == 1 || argc == 2)
    // Wrong number of arguments, print generic error and exit
    complain();
    return 1;
} // end main