/*
Anton Adamovich
Drexel University
CS 171
3-9-15
*/

#include <iostream>
#include <istream>
#include <string>
#include <cstring>

using namespace std;

string processLine(string line);

int main(){
	string fileName = "";
	string nextLine = "";
	cstring nextLineC = {'\0'};
	const string OUTPUT_FILE = "output.txt";
	
	ifstream fileIn = ifstream();
	bool terminate = false;
	
	cout << "This program formats text in a file to be more user-friendly. " << endl;
	cout << "Please enter the name and extension for a text file to be read by the program. " << endl;
	cout << "Example: testfile.txt" << cout;
	cin >> fileName;
	while((terminate == false) && (!fileIn.is_open())){
		cout << "Unfortunately, the program could not find the file specified. " << endl;
		cout << "Please enter the name and extension for a text file to be read or \"QUIT\" to quit. " << endl;
		cout << "Example: testfile.txt" << cout;
		cin >> fileName;
		if(fileName == "QUIT" || fileName == "quit"){
			terminate = true;
		}
	}
	
	if(terminate == false){
		ofstream fileOut = ofstream(OUTPUT_FILE, ios_base::trunc);
		while(!fileIn.eof()){
			cin.getline(nextLineC, 256);
			nextLine = string(nextLineC);
			processLine(nextLine);
		}
	}
	cout << "Program has terminated. "; // Press any key to continue...
}

ofstream processLine(string line){
	cout << line << endl;
}