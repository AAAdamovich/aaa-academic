/* Anton Adamovich
* Drexel University
* CS 171
* 2-5-15
*/

#include <iostream>

using namespace std;

bool isLegal(char input);
int convertToInt(char input);
char convertToChar(int input);
char encrypt1(char input, int wheelPos);
char decrypt1(char input, int wheelPos);
char encrypt2(char input, int wheelPos);
char decrypt2(char input, int wheelPos);

int main(){
	int wheel1 = 0;
	int wheel2 = 0;
	char letterInput = '#';
	int encryptConditional = 1;

	cout << "This program performs simple encrytion with charecters. " << endl;
	cout << "Please enter a value for the initial position of wheel 1: ";
	cin >> wheel1;
	cout << "Also enter a position for wheel 2: ";
	cin >> wheel2;
	cout << "Would you like to encrypt or decrypt? " << endl 
		<< "For encryption enter 1, for decryption enter 0: ";
	cin >> encryptConditional;
	cout << endl << "Now enter a message to be encrypted, caps only. Make sure to terminate " << endl
		<< "your message with a '$' sign: " << endl;
	cin >> letterInput;
	while (letterInput != '$'){
		if (isLegal(letterInput)){
			if (encryptConditional >= 1){
				cout << encrypt2((encrypt1(letterInput, wheel1)), wheel2);
			}
			else{
				cout << decrypt1(letterInput, wheel1);
			}
			wheel1++;
			wheel1 %= 26;
		}
		else{
			cout << '#';
		}
		cin >> letterInput;
	}
	cout << endl;
}

/* (7n + (25 - x)) / 26 = c + 7n
*  25 - ((c + 7(26 - n)) / 26) = x
* 
*  (x + 23n) / 26 = c
*  23(26 - n)) + x
*/

bool isLegal(char input){
	if ((input >= 65) && (input <= 90)){
		return true;
	}
	return false;
}

int convertToInt(char input){
	return (int(input - 65));
}

char convertToChar(int input){
	return (char(input + 65));
}

char encrypt1(char input, int wheelPos){
	return (convertToChar(((7 * wheelPos) + (25 - (convertToInt(input)))) % 26));
}

char decrypt1(char input, int wheelPos){
	return (convertToChar(25 - ((((convertToInt(input)) + (7 * (26 - wheelPos)))) % 26)));
}

char encrypt2(char input, int wheelPos){
	return (convertToChar(((convertToInt(input)) + (23 * wheelPos)) % 26));
}

char decrypt2(char input, int wheelPos){
	return (convertToChar(25 - ((((convertToInt(input)) + (7 * (26 - wheelPos)))) % 26)));
}