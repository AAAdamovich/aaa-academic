/* Antony Adamovich
*  my_grep.c for Programming Assignment 2
*  Prof. Linh B Ngo - CSC 331 - West Chester University
*  Created: 29-OCT-2019 - Last Edited: 29-OCT-2019
*  Description: Replicates some functionality of UNIX 
*   utility "grep"
*/

#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]){
    FILE *nextFile;
    char *line = NULL;
    size_t size = 0;
    
    if(argc <= 1){
        printf("my_grep: searchterm [file ...]\n");
        return 1;
    }
    
    char *query = argv[1];
    
    if(argc == 2){
        while(getline(&line, &size, stdin) != -1){
            if(query[0] == '\0'){
                printf("%s", line);
            }
            else{
                if(strstr(line, query) != NULL){
                    printf("%s", line);
                }
            }
        }
    }
    // Loop for argument list
    for(int i = 2; i < argc; i++){
        nextFile = fopen(argv[i], "r");
        // If file failed to open, program quits
        if(nextFile == NULL){
            printf("my_grep: cannot open file\n");
            return 1;
        }
        
        // Loop for each file
        while(getline(&line, &size, nextFile) != -1){
            if(query[0] == '\0'){
                printf("%s", line);
            }
            else{
                if(strstr(line, query) != NULL){
                    printf("%s", line);
                }
            }
        }
        // One file finished, close it
        fclose(nextFile);
        nextFile = NULL;
        
    }
    // File reading complete, exit 
    return 0;
}