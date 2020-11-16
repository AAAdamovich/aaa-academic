/* Antony Adamovich
*  sort.c for Programming Assignment 1
*  Prof. Linh B Ngo - CSC 331 - West Chester University
*  Created: 28-SEP-2019 - Last Edited: 28-SEP-2019
*  Description: Program reads integers from a file 
*   specified by a command line argument into an array.
*   This array is then sorted and printed to console. 
*/

#include <stdio.h>

// Bubble Sort
void sort(int array[], int size){
    int temp;
    for(int i = 0; i < size; i++){
        for(int j = i + 1; j < size; j++){
            if(array[i] > array[j]){
                // Found new local minimum, swap
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
}

int main(int argc, char *argv[]){
    FILE *inputFile;
    // Temp variable for individual integers in file
    int nextNum;
    // Number of integers in the file
    int read = 0;
    inputFile = fopen(argv[1], "r");
    
    while(feof(inputFile) == 0){
        read += fscanf(inputFile, "%i ", &nextNum);
    }
    // Create integer array with size matched to number
    // of integers in the file
    int numbers[read];
    // Copy of the number of integers in the file
    int numbersSize = read;
    // Reset input pointer within file
    rewind(inputFile);
    
    while(feof(inputFile) == 0){
        fscanf(inputFile, "%i ", &numbers[--read]);   
    }
    sort(numbers, numbersSize);
    // Print contents of array
    for(int i = 0; i < numbersSize - 1; i++){
        printf("%i ", numbers[i]);
    }
    // Last entry is special case for Submitty
    printf("%i\n", numbers[numbersSize - 1]);

    fclose(inputFile);
}