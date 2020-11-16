/* Anton Adamovich Copyright 2015
*  Drexel University
*  Computer Programming I
*  2-6-2015
*/

#include <iostream>
#include <cmath>
#include <string>
#include <iomanip>

using namespace std;

int makeCheckDigit(int value);
string convertDigit(int value);
string barcode(int value);

// I usually avoid declaring variables globally but this was the only way to make the program "serviceable" as mentioned in the prompt
const string HALFBAR = ":";
const string FULLBAR = "|";

int main(){
	cout << barcode(90210) << endl;
}

// Accepts a 5-digit integer postal code and generates an integer "check digit" to be returned
// @param int value - A 5-digit postal code
// @return int - An integer check digit to verify a barcode
int makeCheckDigit(int value){
	if (value == 0){
		return 0;
	}
	int checkSum = 0;
	int nextDigit = 0;
	for (int i = 1; i <= 10000; i *= 10){
		checkSum += ((value % (i * 10)) / i);
	}
	checkSum %= 10;
	return (10 - checkSum);
}

// Accepts a single integer (0-9) and returns its barcode representation
// @param int value - A single digit
// @return string - A string representing the barcode for the given integer/*
string convertDigit(int value){
	switch (value){
	case 0:
		return (FULLBAR + FULLBAR + HALFBAR + HALFBAR + HALFBAR);
		break;
	case 1:
		return (HALFBAR + HALFBAR + HALFBAR + FULLBAR + FULLBAR);
		break;
	case 2:
		return (HALFBAR + HALFBAR + FULLBAR + HALFBAR + FULLBAR);
		break;
	case 3:
		return (HALFBAR + HALFBAR + FULLBAR + FULLBAR + HALFBAR);
		break;
	case 4:
		return (HALFBAR + FULLBAR + HALFBAR + HALFBAR + FULLBAR);
		break;
	case 5:
		return (HALFBAR + FULLBAR + HALFBAR + FULLBAR + HALFBAR);
		break;
	case 6:
		return (HALFBAR + FULLBAR + FULLBAR + HALFBAR + HALFBAR);
		break;
	case 7:
		return (FULLBAR + HALFBAR + HALFBAR + HALFBAR + FULLBAR);
		break;
	case 8:
		return (FULLBAR + HALFBAR + HALFBAR + FULLBAR + HALFBAR);
		break;
	case 9:
		return (FULLBAR + HALFBAR + FULLBAR + HALFBAR + HALFBAR);
		break;
	default:
		return "";
		break;
	}
}

// Accepts a 5-digit postal code and generates the full barcode representation, including endcaps and a check digit
// @param int value - A 5-digit postal code
// @return string - A barcode representation of the postal code passed to the function, in string form
string barcode(int value){
	int newValue = 0;
	string master = FULLBAR;
	for (int i = 10000; i >= 1; i /= 10){
		newValue = ((value % (i * 10)) / i);
		master += (convertDigit(newValue));
	}
	master += (convertDigit(makeCheckDigit(value)));
	master += FULLBAR;
	return master;
}

/* --= Development Musings =--
* 
*  0 - ||:::
*  1 - :::||
*  2 - ::|:|
*  3 - ::||:
*  4 - :|::|
*  5 - :|:|:
*  6 - :||::
*  7 - |:::|
*  8 - |::|:
*  9 - |:|::
*
*  %10 --> [4] / 1
*  %100 --> [54] / 10
*  %1000 --> [154] / 100
*  %10000 --> [9154] / 1000
*  %100000 --> [19154] / 10000
*/