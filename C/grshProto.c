/* Antony Adamovich
*  grsh.c for Programming Assignment 3
*  Prof. Linh B Ngo - CSC 331 - West Chester University
*  Created: 14-NOV-2019 - Last Edited: 01-DEC-2019
*  Description: A simple implementation of a CLI (Command
*   Line Interpreter) or "shell". Golden Ram SHell (grsh)
*   can be run in interactive mode or batch mode. 
*/

#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

void complain();
char * getPath(const char *, const char *);
void runCommand(char ** commandv, int commandc, const char * path);

char * getPath(const char * path, const char * command){
    char * absolutePath = NULL;
    char * nextToken = NULL;
    char * pathCopy = strdup(path);
    
    nextToken = strtok(pathCopy, ":");
    while(nextToken != NULL){
        // Print nextToken
        //printf("Token (path): %s\n", nextToken);
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
        // Print absolutePath
        //printf("Full Path: %s\n", absolutePath);
        if(access(absolutePath, X_OK) == 0){
            // Success, return valid path
            printf("SUCCESS\n");
            
            return absolutePath;
        }
        // Advance token scanner
        nextToken = strtok(NULL, ":");
    }
    // Failure, return null
    free(absolutePath);
    absolutePath = NULL;
    printf("absolutePath freed\n");
    return NULL;
    
    /*char pathCheck [100];
    char * nextToken;
    char * tokenPath = strdup(path);
    
    nextToken = strtok(tokenPath, ":");
    while(nextToken != NULL){
        // Print nextToken
        //printf("Token (path): %s\n", nextToken);
        // Reset pathCheck
        pathCheck[0] = '\0';
        strcat(pathCheck, nextToken);
        strcat(pathCheck, "/");
        strcat(pathCheck, command);
        // Print pathCheck
        //printf("Full Path: %s\n", pathCheck);
        if(access(pathCheck, X_OK) == 0){
            // Success, return valid path
            free(nextToken);
            free(tokenPath);
            //printf("SUCCESS\n");
            char * ptr = pathCheck;
            return ptr;
        }
        // Advance token scanner
        nextToken = strtok(NULL, ":");
    }
    // Failure, return null
    free(nextToken);
    free(tokenPath);
    return NULL;*/
}

void complain(){
    fprintf(stderr, "An error has occurred\n");
}

void runCommand(char ** commandv, int commandc, const char * path){
    int mypid;
    char * absolutePath = NULL;
    
    for(int i = 0; i < commandc; i++){
        printf("1: Commandv[%d]: %s\n", i, commandv[i]);
    }
    
    mypid = fork();
    if(mypid < 0){
        // Fork failed, print error and continue
        complain();
    }
    else{
        // Child path
        if (mypid == 0){
            for(int i = 0; i < commandc; i++){
                printf("2: Commandv[%d]: %s\n", i, commandv[i]);
            }
            // Check for file access (go through path)
            absolutePath = getPath(path, commandv[0]);
            
            printf("absolutePath: %s\n", absolutePath);
            for(int i = 0; i < commandc; i++){
                printf("3: Commandv[%d]: %s\n", i, commandv[i]);
            }
            if(absolutePath != NULL){
                execv(absolutePath, commandv);
            }
            // If execution reaches here, error has occurred
            complain();
            // Cleanup before exit
            free(absolutePath);
            // Quit out of child
            exit(0);
        }
        // Parent path
        else{
            wait(NULL);
        }
    }
}

int main (int argc, char * argv[]){
    
    const char * DEFAULT_PATH = "/bin";
    FILE * source = NULL;
    char * line = NULL;
    char * lineCopy = NULL;
    size_t size = 0;
    char * path = NULL;
    //char path [100];
    char * nextToken = NULL;
    char ** commandv = NULL;
    // For strtok_r
    char ** tokCounter = NULL;
    char ** tokGetter = NULL;
    //OLD
    //char * commandv [30];
    char * exePath = NULL;
    int commandc = 0;
    int countR = 0;
    int pathLength = 0;
    int pMode = 0;
    // 0 is default
    int mypid;
    
    // Initial setup of path
    path = calloc(strlen(DEFAULT_PATH) + 1, sizeof(char));
    path[0] = '\0';
    strcat(path, DEFAULT_PATH);
    
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
            // Test printing
            printf("Line: %s", line);
            
            // Exit command (built in)
            if(strcmp(line, "exit\n") == 0){
                return 0;
            }
            
            // TOKENIZATION
            
            //commandv = (char **) calloc(strlen(line), sizeof(char *));
            
            
            //nextToken = strtok(line, " \n");
            // X
            /*lineCopy = strdup(line);
            printf("lineCopy: %s", lineCopy);
            nextToken = strtok(lineCopy, " \n");
            if(nextToken != NULL){
                numTokens = 1;
                printf("numTokens: %d\n", numTokens);
            }
            while(strtok(NULL, " \n") != NULL){
                numTokens++;
                printf("numTokens: %d\n", numTokens);
            }*/
            //X
            //commandv = (char **) calloc(numTokens + 1, sizeof(char *));
            
            nextToken = strtok(line, " \n");
            
            while(nextToken != NULL){
                // Print nextToken
                printf("Token: %s\n", nextToken);
                
                // Add token to commandv
                //*
                printf("Next size**: %d\n", (commandc + 1));
                commandv = (char **) realloc(commandv, (commandc + 1) * sizeof(char *));
                
                commandv[commandc] = strdup(nextToken);
                
                printf("0: Commandv[%d]: %s\n", commandc, commandv[commandc]);
                
                commandc++;
                
                // Advance token scanner
                nextToken = strtok(NULL, " \n");
            }
            
            // Set null pointer at the end of commandv (for execv)
            
            commandv[commandc] = NULL;
            
            // END TOKENIZATION
            
            // Look for redirection operator
            
            for(int i = 1; i < commandc; i++){
                printf("Looking for >\n");
                nextToken = commandv[i];
                if(strcmp(nextToken, ">") == 0){
                    printf("Redirection Detected at [%d]\n", (commandc - 1));
                    countR++;
                    // TO DO:
                        // Look for multiple '>' or more than 1 file, in that 
                        // case, skip next code block
                }
            }
            if(countR > 0){
                // First argument for safe array access (short circuit eval)
                if(commandc >= 3 && (countR == 1 && commandv[commandc - 2])){
                    // Modify file descriptor here
                    printf("File descriptor to be modified\n");
                }
                else{
                    // Print error for bad usage of redirection
                    complain();
                }
            }
            
            printf("commandc %d\n", commandc);
            // Path command (built in)
            if(strcmp(commandv[0], "path") == 0){
                // Wipe contents of path
                free(path);
                path = NULL;
                pathLength = 0;
                
                for(int i = 0; i < commandc; i++){
                    printf("PA: Commandv[%d]: %s\n", i, commandv[i]);
                }
                
                for(int i = 1; i < commandc; i++){
                    // Add +1 for ':' delimiter
                    pathLength += (strlen(commandv[i]) + 1);
                }
                // Add +1 for terminating '\0'
                pathLength++;
                //printf("Next size (path): %d\n", pathLength);
                //path = (char *) calloc(pathLength, sizeof(char));
                // Initialize path for future append
                //path[0] = '\0';
                
                for(int i = 1; i < commandc; i++){
                    // + 2 : One for insertion of ':', one for terminating '\0'
                    if(path == NULL){
                        printf("Next size: %d\n", (int)(strlen(commandv[i]) + 2));
                        path = (char *) calloc(strlen(commandv[i]) + 2, sizeof(char));
                    }
                    else{
                        printf("Next size: %d\n", (int)(strlen(path) + strlen(commandv[i]) + 2));
                        path = (char *) realloc(path, sizeof(char) * (strlen(path) + strlen(commandv[i]) + 2));
                    }
                    path[0] = '\0';
                    strcat(path, commandv[i]);
                    strcat(path, ":");

                    printf("Path: %s\n", path);

                    for(int j = 0; j < commandc; j++){
                        printf("PAj: Commandv[%d]: %s\n", j, commandv[j]);
                    }
                }
            }
            // Cd command (built in)
            else if(strcmp(commandv[0], "cd") == 0){
                if(commandc == 1 || commandc > 2){
                    complain();
                }
                else{
                    if(chdir(commandv[1]) != 0){
                        complain();
                    }
                }
            }
            // Non-built-in command
            else{
                printf("Running the juice\n");
                runCommand(commandv, commandc, path);
            }
            
            
            
            

            // Parallel Command mode (TO DO)
            /*if(strcmp(nextToken, "&") == 0){
                printf("PARALLEL COMMANDS TO DO\n");
            }
            
            
            // Redirection Operator
            if(strcmp(nextToken, ">") == 0){
                printf("REDIRECTION OPERATOR TO DO\n");
            }
            */
            
            
            
            

            // Each command line parse requires state reset for the following variables:
            //free(nextCommand);
            //nextCommand = NULL;
            
            /*for(int i = 0; i < commandc; i++){
                free(commandv[i]);
                commandv[i] = NULL;
            }*/
            free(commandv);
            commandv = NULL;
            commandc = 0;
            countR = 0;
            tokCounter = NULL;
            tokGetter = NULL;
            //free(tokenLine);
            //tokenLine = NULL;
            
            // Print prompt before returning control to user 
            if(argc == 1){
                // (Interactive mode only)
                printf("grsh> ");
            }
        }
        // Program Cleanup
        free(path);
        path = NULL;
        /*for(int i = 0; i < commandc; i++){
            free(commandv[i]);
            commandv[i] = NULL;
        }*/
        free(commandv);
        commandv = NULL;
        free(exePath);
        exePath = NULL;
        if(argc == 2){
            // One file finished, close it
            fclose(source);
            source = NULL;
        }
        // EOF (or failure) reached, exit with no error
        return 0;
    }
    // Wrong number of arguments, print generic error and exit
    complain();
    //write(STDERR_FILENO, ERROR_MSG, strlen(ERROR_MSG));
    return 1;
}