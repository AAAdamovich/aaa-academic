/*
Anton Adamovich
Drexel University
CS 171
2-26-15
*/

#include <iostream>
#include <string>

using namespace std;

bool isVowel(char letter);
string convertToPigLatin(string word);

int main(){
	string currentWord = "";
	cout << "This program does some buisness with pig latin. " << endl;
	cout << "Please enter a sentence of words, with '$$' as the final word" << endl
		<< "to terminate the program: " << endl;
	cin >> currentWord;
	cout << "Your processed input is below: " << endl << endl;
	while (currentWord != "$$"){
		cout << (convertToPigLatin(currentWord)) << endl;
		cin >> currentWord;
	}
	cout << endl;
}

bool isVowel(char letter){
	switch (letter){
	case 'A':
	case 'a':
	case 'E':
	case 'e':
	case 'I':
	case 'i':
	case 'O':
	case 'o':
	case 'U':
	case 'u':
		return true;
		break;
	default:
		return false;
		break;
	}
}

string convertToPigLatin(string word){
	if (word.empty()){
		return word;
	}
	char nextLetter = word.at(0);
	if (isVowel(nextLetter)){
		return (word + "way");
	}
	while(!isVowel(nextLetter)){
		word = (word.substr(1) + word.at(0));
		nextLetter = word.at(0);
	}
	return (word + "ay");
}