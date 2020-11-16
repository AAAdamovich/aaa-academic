/*
Anton Adamovich
Drexel University
CS 171
2-28-15
*/

#include <iostream>
#include <string>

using namespace std;

bool isPalindrome(const string &sequence);

int main(){
	string input = string();
	cout << "This program only outputs palindromes." << endl
		<< "Enter a word, and the computer will print out its palindrome version. " << endl << endl;
	cin >> input;
	cout << endl;
	cout << "Your palindrome is: " << endl << endl;

	if (isPalindrome(input)){
		cout << input << endl << endl;
	}
	else{
		string newPalindrome = input;
		int length = input.length();
		for (int i = 0; i < length; i ++){
			newPalindrome += input.at(length - (i + 1));
		}
		cout << newPalindrome << endl << endl;
	}
}

bool isPalindrome(const string &sequence){
	int length = sequence.length();
	if (length > 1){
		return ((sequence.at(0) == sequence.at(length - 1)) && (isPalindrome(sequence.substr(1, length - 2))));
	}
	else{
		return true;
	}
}