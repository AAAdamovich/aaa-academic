/* Anton Adamovich
*  Drexel University
*  CS 171
*  2-23-15
*/

#include <iostream>
#include <string>

using namespace std;

int convertRomanNumber(string numeral);
int convertRomanCharecter(char numeral);

int main(){
	cout << (convertRomanNumber("DCCCXC")) << endl;
	return 1;
}


/* MCMLXXVIII
*  I = 1
*  V = 5
*  X = 10
*  L = 50
*  C = 100
*  D = 500
*  M = 1000
*
*  Go right to left
*  If next is smaller than current, do (current - next) and skip next
*/
int convertRomanNumber(string numeral){
	int decimalNumber = 0;
	for (int i = (numeral.size() - 1); i >= 0; i--){
		int current = convertRomanCharecter(numeral.at(i));
		int next = 0;
		if (i > 0){
			next = convertRomanCharecter(numeral.at(i - 1));
		}
		if (next < current){
			decimalNumber += current;
			decimalNumber -= next;
			i--;
		}
		else{
			decimalNumber += current;
		}
	}
	return decimalNumber;
}

int convertRomanCharecter(char numeral){
	switch (numeral){
		case 'I':
			return 1;
			break;
		case 'V':
			return 5;
			break;
		case 'X':
			return 10;
			break;
		case 'L':
			return 50;
			break;
		case 'C':
			return 100;
			break;
		case 'D':
			return 500;
			break;
		case 'M':
			return 1000;
			break;
		default:
			return 0;
			break;
	}
}