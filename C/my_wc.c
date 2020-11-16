/* Antony Adamovich
*  my_cat.c for Programming Assignment 2
*  Prof. Linh B Ngo - CSC 331 - West Chester University
*  Created: 29-OCT-2019 - Last Edited: 29-OCT-2019
*  Description: Replicates some functionality of UNIX 
*   utility "wc"
*/

#include <stdio.h>
#include <string.h>

// Return first file index in argv, or -1 if invalid switches
int evalSwitches(int *usingL, int *usingW, int *usingC, int argc, char* argv[]){
    char l[] = "-l";
    char w[] = "-w";
    char c[] = "-c";
    
    for(int i = 1; i < argc; i++){
        if(argv[i][0] != '-'){
            if(i == 1){
                // No arguments
                *usingL = 1;
                *usingW = 1;
                *usingC = 1;
            }
            return i;
        }
        else{
            if(strcmp(argv[i], l) == 0){
                if(*usingL == 0){
                    *usingL = 1;
                }
                else{
                    return -1;
                } 
            }
            if(strcmp(argv[i], w) == 0){
                if(*usingW == 0){
                    *usingW = 1;
                }
                else{
                    return -1;
                } 
            }
            if(strcmp(argv[i], c) == 0){
                if(*usingC == 0){
                    *usingC = 1;
                }
                else{
                    return -1;
                } 
            }
        }
    }
    return -2;
}

int main(int argc, char* argv[]){
    FILE *nextFile;
    int usingL = 0;
    int usingW = 0;
    int usingC = 0;
    int firstFile = 0;
    
    int sumL = 0;
    int sumW = 0;
    int sumC = 0;
    
    int nextInt;
    char prevChar;
    char nextChar;
    
    int inWSpace = 1;
    // Find switches
    firstFile = evalSwitches(&usingL, &usingW, &usingC, argc, argv);
    //printf("%d\n", firstFile);
    //printf("%d %d %d %d", usingL, usingW, usingC, firstFile);
    if(firstFile == -1 || argc <= 1){
        printf("my_wc: [option ...] [file ...]");
        return 1;
    }
    // Loop for argument list
    for(int i = firstFile; i < argc; i++){
        nextFile = fopen(argv[i], "r");
        // If file failed to open, program quits
        if(nextFile == NULL){
            printf("my_wc: cannot open file\n");
            return 1;
        }
        sumW = 0;
        sumC = 0;
        sumL = 1;
        inWSpace = 1;
        prevChar = '0';
        // Loop for each file
        while(feof(nextFile) == 0){
            nextInt = fgetc(nextFile);
            if(nextInt != EOF){
                nextChar = nextInt;
                sumC++;
                if((nextChar >= 'A' && nextChar <= 'Z') || (nextChar >= 'a' && nextChar <= 'z')){
                    if(inWSpace == 1){
                        sumW++;
                    }
                    inWSpace = 0;
                }
                else{
                    inWSpace = 1;
                }
                if(nextChar == '\n'){
                    sumL++;
                }
            }
            prevChar = nextChar;
        }
        if(prevChar == '\n'){
            sumL--;
        }
        if(usingL == 1){
            printf("%d ", sumL);
        }
        if(usingW == 1){
            printf("%d ", sumW);
        }
        if(usingC == 1){
            printf("%d ", sumC);
        }
        printf("%s\n", argv[i]);
        // One file finished, close it
        fclose(nextFile);
        nextFile = NULL;
        
    }
    // File reading complete, exit 
    return 0;
    
}