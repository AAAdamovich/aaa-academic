/* Antony Adamovich
*  my_cat.c for Programming Assignment 2
*  Prof. Linh B Ngo - CSC 331 - West Chester University
*  Created: 17-OCT-2019 - Last Edited: 29-OCT-2019
*  Description: Replicates some functionality of UNIX 
*   utility "cat"
*/

#include <stdio.h>

int main(int argc, char *argv[]){
    FILE *nextFile;
    char *line = NULL;
    size_t size = 0;
    
    // Loop for argument list
    for(int i = 1; i < argc; i++){
        nextFile = fopen(argv[i], "r");
        // If file failed to open, program quits
        if(nextFile == NULL){
            printf("my_cat: cannot open file\n");
            return 1;
        }
        
        // Loop for each file
        while(getline(&line, &size, nextFile) != -1){
            printf("%s", line);
        }
        // One file finished, close it
        fclose(nextFile);
        nextFile = NULL;
        
    }
    // File reading complete, exit 
    return 0;
}