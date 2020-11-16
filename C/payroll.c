/* Antony Adamovich
*  payroll.c for Programming Assignment 1
*  Prof. Linh B Ngo - CSC 331 - West Chester University
*  Created: 24-SEP-2019 - Last Edited: 28-SEP-2019
*  Description: Accepts four command line arguments: 
*   first name, last name, hours worked, and hourly rate.
*   Calculates total payment and prints information to console 
*/

#include <stdio.h>
#include <math.h>

int main(int argc, char *argv[]){
    
    int hoursWorked;
    double hourlyRate;
    sscanf(argv[3], "%i", &hoursWorked);
    sscanf(argv[4], "%lf", &hourlyRate);
    double totalPayment = ((double)hoursWorked) * hourlyRate;

    printf("%s, %s: %.2f\n", argv[2], argv[1], totalPayment);

}