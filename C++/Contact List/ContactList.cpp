/*
Anton Adamovich
Drexel University
CS 171
3-12-15
*/

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

string promptForInput(const string & message);
void toLowerCase(string & input);
// The menus
string selectFileMenu(const string & originalFile);
void addContactMenu(const string & fileName);
void printAllContacts(const string & fileName);
void searchMenu(const string & fileName);
void deleteContactMenu(const string & fileName);

// Each contact is one line, spaces are delimiters
// The "main" menu, so punny
int main(){
	int menuCode = 0;
	string userInput = "";
	string workingFile = "contacts.txt";
	// 'contacts.txt' is the program's default file, this section makes sure it exists, and creates it if it doesn't
	fstream fileIO = fstream();
	fileIO.open(workingFile, ios_base::in | ios_base::out);
	if (!fileIO.is_open()){
		fileIO.open(workingFile, ios_base::in | ios_base::out | ios_base::trunc);
	}
	fileIO.close();
	fileIO.clear();

	cout << "Welcome to Contact List Manager! (TM)" << endl;
	cout << "Navigation in this program is controlled through a series of textual commands. " << endl
		<< "The following is a list of commands available for use on the current menu. " << endl
		<< "Commands are shown in CAPS." << endl;
	cout << "ADD: Prompts for and adds a new contact to the list. " << endl;
	cout << "DELETE: Removes a contact from the list. " << endl;
	cout << "SHOW: Displays all of the contents of the contacts list. " << endl;
	cout << "SEARCH: Begins a search for a contact based on a query. " << endl;
	cout << "HELP: Displays a list of commands relevant to the current menu. " << endl;
	cout << "EXIT: Exits out of the current menu, " << endl
		<< "doing this while on the main menu exits the program. " << endl;
	cout << endl << "=== MAIN MENU ===" << endl;
	cout << "Enter a command: ";
	getline(cin, userInput);
	toLowerCase(userInput);
	while (userInput != "exit"){
		if (userInput == "add"){
			addContactMenu(workingFile);
		}
		else{
			if (userInput == "delete"){
				deleteContactMenu(workingFile);
			}
			else{
				if (userInput == "show"){
					printAllContacts(workingFile);
				}
				else{
					if (userInput == "search"){
						searchMenu(workingFile);
					}
					else{
						if (userInput == "select"){
							workingFile = selectFileMenu(workingFile);
						}
						else{
							if (userInput == "help"){
								cout << "Navigation in this program is controlled through a series of textual commands. " << endl
									<< "The following is a list of commands available for use on the current menu. " << endl
									<< "Commands are shown in CAPS." << endl;
								cout << "ADD: Prompts for and adds a new contact to the list. " << endl;
								cout << "DELETE: Removes a contact from the list. " << endl;
								cout << "SHOW: Displays all of the contents of the contacts list. " << endl;
								cout << "SEARCH: Begins a search for a contact based on a query. " << endl;
								cout << "HELP: Displays a list of commands relevant to the current menu. " << endl;
								cout << "EXIT: Exits out of the current menu, " << endl
									<< "doing this while on the main menu exits the program. " << endl;
							}
							// Input was invalid
							else{
								cout << "Unfortunately, your command was invalid, " << endl
									<< "\"HELP\" displays a list of valid commands. " << endl;
							}
						}
					}
				}
			}
		}
		cout << endl << "=== MAIN MENU ===" << endl;
		cout << "Enter a command: ";
		getline(cin, userInput);
		toLowerCase(userInput);
	}
}

string selectFileMenu(const string & originalFile){
	fstream fileIO = fstream();
	string fileName = "";
	string userResponse = "yes";
	cout << endl << "=== FILE SELECTION MENU ===" << endl;
	cout << "This program by default uses a file called \'contacts.txt\' " << endl 
		<< "to store the contact list. " << endl
		<< "You may specify your own file in this menu. Note, however, " << endl
		<< "that you will have to tell the program to use this file every time it runs. " << endl;
	// Loop only iterates if user specifies a file that doesn't exist, chooses not to create it, and requests to input another file name
	// The loop condition is forced by the logic inside the body, so it is always true, just wanted to show it explicitly
	while (userResponse == "yes"){
		fileName = promptForInput("Please enter a custom file name, extension excluded: ");
		fileName += ".txt";
		fileIO.open(fileName, ios_base::in | ios_base::out);
		if (!fileIO.is_open()){
			cout << "The file you specified does not exist, would you like to create it?" << endl
				<< "Enter \"YES\" or \"NO\": ";
			getline(cin, userResponse);
			toLowerCase(userResponse);
			while (!(userResponse == "yes" || userResponse == "no")){
				cout << "Unfortunately, your command was invalid, use either \"YES\" or \"NO\". " << endl;
				cout << "Would you like to create a new file named " << fileName << "? ";
				getline(cin, userResponse);
				toLowerCase(userResponse);
			}
			if (userResponse == "yes"){
				fileIO.open(fileName, ios_base::in | ios_base::out | ios_base::trunc);
				cout << "The file " << fileName << endl 
					<< "was created sucessfully and is ready for use." << endl;
				fileIO.close();
				fileIO.clear();
				cout << "You will now be returned to the main menu..." << endl;
				return fileName;
			}
			else{
				cout << "Would you like to input another file name? " << endl
					<< "Enter \"YES\" or \"NO\": ";
				getline(cin, userResponse);
				toLowerCase(userResponse);
				while (!(userResponse == "yes" || userResponse == "no")){
					cout << "Unfortunately, your command was invalid, use either \"YES\" or \"NO\". " << endl;
					cout << "Would you like to input another file name? ";
					getline(cin, userResponse);
					toLowerCase(userResponse);
				}
				if (userResponse == "no"){
					fileIO.close();
					fileIO.clear();
					cout << "You will now be returned to the main menu..." << endl;
					return originalFile;
				}
				// This is the only case that causes the loop to iterate again, if the user answered 'yes' to the above question
			}
		}
		else{
			cout << "File opened successfully. " << endl;
			fileIO.close();
			fileIO.clear();
			cout << "You will now be returned to the main menu..." << endl;
			return fileName;
		}
	}
	// In case something went wrong
	return originalFile;
}

void addContactMenu(const string & fileName){
	ofstream fileOut = ofstream(fileName, ios_base::app);
	string currentInput = "add";
	string contactLine = "";
	while (currentInput != "exit"){
		contactLine = "";
		if (currentInput == "add"){
			cout << "The program will prompt you for several fields during contact creation, " << endl
				<< "you may leave entires blank if you so desire. Please enter a ..." << endl;
			currentInput = promptForInput("First name: ");
			contactLine += (currentInput + " ");
			currentInput = promptForInput("Last name: ");
			contactLine += (currentInput + " ");
			currentInput = promptForInput("Phone number: ");
			contactLine += (currentInput + " ");
			currentInput = promptForInput("Email address: ");
			contactLine += currentInput;
			if (contactLine != "   "){
				fileOut << contactLine << endl << flush;
				cout << "Contact created. " << endl;
			}
			else{
				cout << "You left every entry during contact creation blank, no contact was created. " << endl;
			}
		}
		// If command wasn't "EXIT" or "ADD"
		else{
			cout << "Your command was invalid. " << endl;
		}
		cout << endl << "=== ADD CONTACT MENU ===" << endl;
		cout << "You may continue to add contacts via \"ADD\" or exit to main menu via \"EXIT\". " << endl;
		cout << "Enter a command: ";
		getline(cin, currentInput);
		toLowerCase(currentInput);
	}
	fileOut.close();
	fileOut.clear();
}

void printAllContacts(const string & fileName){
	ifstream fileIn = ifstream(fileName);
	string currentLine = "";
	string entry = "";
	int prevSpace = 0;
	int nextSpace = 0;
	int lineCounter = 1;
	cout << "Here is the full list of contacts for " << fileName << endl;
	getline(fileIn, currentLine);
	while ((!fileIn.eof()) && (currentLine != "")){
		cout << "        - Contact " << lineCounter << " - " << endl;
		// Extract first name
		nextSpace = currentLine.find(' ');
		entry = currentLine.substr(0, nextSpace);
		if (entry == ""){
			entry = "* NONE GIVEN *";
		}
		cout << "First Name: " << entry << endl;
		prevSpace = nextSpace;
		// Extract last name
		nextSpace = currentLine.find(' ', (prevSpace + 1));
		entry = currentLine.substr((prevSpace + 1), (nextSpace - prevSpace));
		if (entry == " "){
			entry = "* NONE GIVEN *";
		}
		cout << "Last Name:  " << entry << endl;
		prevSpace = nextSpace;
		// Extract phone number
		nextSpace = currentLine.find(' ', (prevSpace + 1));
		entry = currentLine.substr((prevSpace + 1), (nextSpace - prevSpace));
		if (entry == " "){
			entry = "* NONE GIVEN *";
		}
		cout << "Phone:      " << entry << endl;
		prevSpace = nextSpace;
		// Extract email address
		entry = currentLine.substr((prevSpace + 1));
		if (entry == ""){
			entry = "* NONE GIVEN *";
		}
		cout << "Email:      " << entry << endl;
		// Increment elements
		getline(fileIn, currentLine);
		lineCounter++;
	}
	fileIn.close();
	fileIn.clear();
}

void searchMenu(const string & fileName){
	ifstream fileIn = ifstream(fileName);
	string query = "";
	string userResponse = "yes";
	string currentLine = "";
	string lineCopy = "";
	string entry = "";
	int nextSpace = 0;
	int prevSpace = 0;
	int lineCounter = 1;
	bool matchFound = false;

	cout << endl << "=== SEARCH MENU ===" << endl;
	// At the bottom of this function is a user request to search again, this giant loop controls this
	while (userResponse == "yes"){
		// Reset some values so that a search can run more than once
		lineCounter = 1;
		matchFound = false;
		fileIn.clear();
		fileIn.seekg(0, ios_base::beg);
		// Actual search process begins
		query = promptForInput("Enter your search term: ");
		toLowerCase(query);
		getline(fileIn, currentLine);
		// Searches entire contacts file
		while ((!fileIn.eof()) && (currentLine != "")){
			// This section generates a string that is an lowercase-only version of the current line, to compare against the lowercase-only user query
			lineCopy = currentLine;
			toLowerCase(lineCopy);
			// If there was a match, the entire contact is printed
			if ((lineCopy.find(query, 0)) != string::npos){
				matchFound = true;
				cout << "The following contacts matched your entire search term: " << endl;
				cout << "        - Contact " << lineCounter << " - " << endl;
				// Extract first name
				nextSpace = currentLine.find(' ');
				entry = currentLine.substr(0, nextSpace);
				if (entry == ""){
					entry = "* NONE GIVEN *";
				}
				cout << "First Name: " << entry << endl;
				prevSpace = nextSpace;
				// Extract last name
				nextSpace = currentLine.find(' ', (prevSpace + 1));
				entry = currentLine.substr((prevSpace + 1), (nextSpace - prevSpace));
				if (entry == " "){
					entry = "* NONE GIVEN *";
				}
				cout << "Last Name:  " << entry << endl;
				prevSpace = nextSpace;
				// Extract phone number
				nextSpace = currentLine.find(' ', (prevSpace + 1));
				entry = currentLine.substr((prevSpace + 1), (nextSpace - prevSpace));
				if (entry == " "){
					entry = "* NONE GIVEN *";
				}
				cout << "Phone:      " << entry << endl;
				prevSpace = nextSpace;
				// Extract email address
				entry = currentLine.substr((prevSpace + 1));
				if (entry == ""){
					entry = "* NONE GIVEN *";
				}
				cout << "Email:      " << entry << endl;
			}
			getline(fileIn, currentLine);
			lineCounter++;
		}
		if (matchFound == false){
			cout << "The search did not find a contact that included your query" << endl;
		}
		// Here, the user can search again
		cout << endl << "=== SEARCH MENU ===" << endl;
		cout << "Would you like to conduct another search? " << endl
			<< "Enter \"YES\" or \"NO\": ";
		getline(cin, userResponse);
		toLowerCase(userResponse);
		while (!(userResponse == "yes" || userResponse == "no")){
			cout << "Unfortunately, your command was invalid, use either \"YES\" or \"NO\". " << endl;
			cout << "Would you like to search the contact list for a keyword? ";
			getline(cin, userResponse);
			toLowerCase(userResponse);
		}
		// Loop goes again if "yes", closes if "no"
	}
	cout << "You will now be returned to the main menu..." << endl;
	fileIn.close();
	fileIn.clear();
}

void deleteContactMenu(const string & fileName){
	int totalContacts = 0;
	int deletionNum = 0;
	int lineCounter = 1;
	int length = 0;
	int beginRemoval = 0;
	string whiteOut = "";
	string input = "";
	// This obtains the number of lines in the file, I didn't want to print out all of the contacts every time
	string currentLine = "";
	ifstream fileIn = ifstream(fileName);
	getline(fileIn, currentLine);
	while ((!fileIn.eof()) && (currentLine != "")){
		getline(fileIn, currentLine);
		totalContacts++;
	}
	currentLine = "";
	fileIn.close();
	fileIn.clear();

	cout << endl << "=== DELETE CONTACT MENU ===" << endl;
	cout << "Deletion of contacts is done by specifying a contact's position in the list. " << endl
		<< "For example, if you want to delete the third contact in the contact list, " << endl
		<< "enter \"3\" upon the program's prompt to do so. " << endl;
	cout << "Command list: " << endl;
	cout << "PROMPT: Prompts for contact deletion. " << endl;
	cout << "SHOW: Displays all the contacts in the list. " << endl;
	cout << "HELP: Displays these instructions again. " << endl;
	cout << "EXIT: Exits to main menu. " << endl;

	cout << "Enter a command: ";
	getline(cin, input);
	toLowerCase(input);
	while (input != "exit"){
		// SHOW command
		if (input == "show"){
			printAllContacts(fileName);
		}
		else{
			// HELP command
			if (input == "help"){
				cout << endl << "Deletion of contacts is done by specifying a contact's position in the list. " << endl
					<< "For example, if you want to delete the third contact in the contact list, " << endl
					<< "enter \"3\" upon the program's prompt to do so. " << endl;
				cout << "Command list: " << endl;
				cout << "PROMPT: Prompts for contact deletion. " << endl;
				cout << "SHOW: Displays all the contacts in the list. " << endl;
				cout << "HELP: Displays these instructions again. " << endl;
				cout << "EXIT: Exits to main menu. " << endl;
			}
			else{
				// PROMPT command, or actual deletion
				if (input == "prompt"){
					// This loop allows the user to delete multiple contacts
					while (input != "no"){
						cout << "Enter the number of the contact you wish to delete: ";
						cin.sync();
						cin >> deletionNum;
						cin.ignore(numeric_limits<streamsize>::max(), '\n');
						cin.sync();
						if ((deletionNum < 1) || (deletionNum > totalContacts)){
							cout << "That contact number does not exist" << endl;
							cout << "Would you like to enter another number? " << endl
								<< "Enter \"YES\" or \"NO\": ";
							cin.ignore(numeric_limits<streamsize>::max(), '\n');
							cin.sync();
							getline(cin, input);
							toLowerCase(input);
							while (!(input == "yes" || input == "no")){
								cout << "Unfortunately, your command was invalid, use either \"YES\" or \"NO\". " << endl;
								cout << "Would you like to delete another contact? ";
								getline(cin, input);
								toLowerCase(input);
							}
							// An input of "yes" makes this inner loop iterate again, "no" puts the user back in the deletion menu
						}
						else{
							cout << deletionNum;
							fstream fileIO = fstream(fileName, ios_base::in | ios_base::out);
							getline(fileIO, currentLine);
							while ((!fileIO.eof()) && (currentLine != "")){
								length = currentLine.length();
								// Set the beginning of the removal index on the line before the line to be removed
								if ((lineCounter + 1) == deletionNum){
									beginRemoval = fileIO.tellg();
								}
								// Then, the line counter arrives at the removal point, if its the first line, the removal index is 0 by default
								if (lineCounter == deletionNum){
									for (int i = 0; i < length; i++){
										whiteOut += "\b";
									}
									fileIO.seekp(beginRemoval);
									fileIO << whiteOut << flush;
								}
								getline(fileIO, currentLine);
								lineCounter++;
							}
							fileIO.close();
							fileIO.clear();
							cin.ignore(5, '\n');
							cin.sync();
							cout << "Deletion successful, would you like to delete another contact? " << endl
								<< "Enter \"YES\" or \"NO\": ";
							while (!(input == "yes" || input == "no")){
								cout << "Unfortunately, your command was invalid, use either \"YES\" or \"NO\". " << endl;
								cout << "Would you like to delete another contact? ";
								getline(cin, input);
								toLowerCase(input);
							}
							// An input of "yes" alows the user to delete more contacts, "no" ends this loop
						}
					}
				}
				// No matching commands, bad user input
				else{
					cout << "Unfortunately, your commands was invalid. " << endl 
						<< "You may type \"HELP\" for a list of commands. " << endl;
				}
			}
		}
		cout << endl << "=== DELETE CONTACT MENU ===" << endl;
		cout << "Enter a command: ";
		getline(cin, input);
		toLowerCase(input);
	}
	
}

string promptForInput(const string & message){
	string input = "";

	cout << message;
	getline(cin, input);
	input = (input.substr(0, (input.find(' ', 0))));

	return  input;
}

void toLowerCase(string & input){
	char currentLetter = '~';
	for (int i = 0; i < (input.length()); i++){
		currentLetter = input.at(i);
		if ((currentLetter >= 'A') && (currentLetter <= 'Z')){
			currentLetter += ('z' - 'Z');
			input.replace(i, 1, 1, currentLetter);
		}
	}
}