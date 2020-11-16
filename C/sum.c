/* Antony Adamovich
*  sum.c for Programming Assignment 1
*  Prof. Linh B Ngo - CSC 331 - West Chester University
*  Created: 28-SEP-2019 - Last Edited: 10-FEB-2020
*   Edited 10-FEB-2020: Addition of #define constant
*  Description: Generates sum of integers from a 10
*   line file, one integer per line. File path is 
*   specified as command line argument. 
*/

#include <stdio.h>
#define LINES 10

int main(int argc, char *argv[]){
    
    int intArray[LINES];
    int sum = 0;
    FILE *txtFile;
    txtFile = fopen(argv[1], "r");
    // Read integers into array
    for(int i = 0; i < LINES; i++){
        fscanf(txtFile, "%i ", &intArray[i]);
        sum += intArray[i];
    }
    // Print sum
    printf("%i\n", sum);
    
    fclose(txtFile);
}