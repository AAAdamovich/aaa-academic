/* 
Anton Adamovich
Drexel University
CS 171
2-26-15
*/

#include <iostream>
#include <string>

using namespace std;

string findAndReplace(const string &pattern, const string &replacement, string currentInput);

int main(){
	string pattern = "";
	string replacement = "";
	string currentInput = "";
	cout << "This program will find and replace text in lines of user input. " << endl;
	cout << "Please enter what you are looking for: " << endl;
	getline(cin, pattern);
	cout << "Please enter the replacement: " << endl;
	getline(cin, replacement);
	cout << endl << "Enter some text for the computer to search through: " << endl;
	getline(cin, currentInput);
	while (currentInput != "$$"){
		cout << endl << "Your processed input is below: " << endl;
		cout << (findAndReplace(pattern, replacement, currentInput)) << endl;
		cout << endl << "Enter some text for the computer to search through or '$$' to quit: " << endl;
		getline(cin, currentInput);
	}

}

string findAndReplace(const string &pattern, const string &replacement, string currentInput){
	int nextReplacePos = currentInput.find(pattern, 0);
	while (nextReplacePos != string::npos){
		currentInput.replace(nextReplacePos, pattern.length(), replacement);
		nextReplacePos = currentInput.find(pattern, (nextReplacePos + replacement.length() + 1));
	}
	return currentInput;

}