/*
Anton Adamovich
Drexel University
CS 171
3-17-15
Runs a game/simulation based on the landing of a lunar module on the moon's surface
*/

#include <iostream>
#include <fstream>
#include <string>
#include <cmath>

using namespace std;

double promptForDouble(const string & message, double lower, double upper);
string promptForString(const string & message);
void introduction(istream & is, ostream & os, string target, string replacement);
void updateStatus(double & velocity, double burnAmount, double & fuelRemaining, double & height);
void touchdown(double & elapsedTime, double & velocity, double & burnAmount, double & height);
void finalAnalysis(ostream & os, double velocity);

int main(){
	// Introduction and variable declarations
	double elapsedTime = 0.0;
	double fuelToBurn = 0.0;
	double velocity = 0.0;
	double height = 0.0;
	double fuel = 0.0;
	bool fuelIsEmpty = false;
	ifstream fileIn = ifstream("input.txt");
	cout << "Welcome to LUNAR LANDER! (TM)" << endl;
	introduction(fileIn, cout, "$SPACECRAFT", "Spacey 5000");
	fileIn.close();
	// Simulation control settings
	height = 1000.0;
	fuel = 150.0;
	// The game begins
	cout << endl << "=== LUNAR LANDER ===" << endl;
	cout << "Beginning descent..." << endl;

	while (height > 0.0){
		if ((fuel <= 0.0) && (fuelIsEmpty == false)){
			fuelIsEmpty = true;
			cout << "! ! ! CAUTION: NO FUEL ! ! !" << endl;
		}
		if (!fuelIsEmpty){
			cout << endl << endl;
			cout << "Status of your spacecraft:" << endl;
			cout << "Time  : " << (int)elapsedTime << " seconds" << endl;
			cout << "Height: " << (int)height << " feet" << endl;
			cout << "Speed : " << (int)velocity << " feet/second" << endl;
			cout << "Fuel  : " << (int)fuel << " units" << endl;
			promptForDouble("", 0.0, fuel);
		}
		
	}

	return 1;
}

/*  Prompts the user for a decimal numer based on a message which is passed to this function.
	User's number must be between two bounds (inclusive), designated by upper and lower
	@PARAM const string & message
	The message to be shown to the user before input operations
	@PARAM double lower
	The lower bound of a user's input
	@PARAM double upper
	The upper bound of a user's input
	@RETURN double
	Input from the user, a decimal number between lower and upper (inclusive)
*/
double promptForDouble(const string & message, double lower, double upper){
	double userInput = 0.0;
	do{
		cout << message;
		cin >> userInput;
		if ((userInput < lower) || (userInput > upper)){
			cout << "Your number is outside of the valid range." << endl 
				<< "It should be between " << lower << " and " << upper << "." << endl;
		}
	} while ((userInput < lower) || (userInput > upper));
	return userInput;
}

/*  Prompts the user for a string based on a message which is passed to this function. 
	The entire string submitted by the user, up until a newline charecter, is then returned
	@PARAM const string & message
		The message to be shown to the user before input operations
	@RETURN string
		Input from the user, everything that was typed in before a newline charecter
*/
string promptForString(const string & message){
	string userInput = "";
	cout << message;
	getline(cin, userInput);
	return userInput;
}

/*  Prints out instuctions for the lunar lander game based on user request. The instuctions are obtained from an input stream, 
	parsed for occurences of a target, and then outputted to an output stream with all targets replaced with the replacement.
	@PARAM istream & is
		The input stream from which the instuctions are being obtained
	@PARAM ostream & os
		The output stream the modified instructions are being written to
	@PARAM string target
		A query that designates stings to be parsed from input, not to be included in output
	@PARAM string replacement
		In output, all strings matching the target are replaced with this value
*/
void introduction(istream & is, ostream & os, string target, string replacement){
	string userInput = "";
	string nextLine = "";
	int lastLinePointer = 0;
	int targetIndex = static_cast<int>(string::npos);

	userInput = promptForString("Would you like to view the tutorial? \nType \"YES\" to do so, or hit enter to continue: ");
	if ((userInput == "yes") || (userInput == "YES")){
		getline(is, nextLine);
		while (!(is.eof())){
			targetIndex = nextLine.find(target, 0);
			while (targetIndex != static_cast<int>(string::npos)){
				nextLine.replace(targetIndex, target.length(), replacement);
				targetIndex = nextLine.find(target, (targetIndex + replacement.length()));
			}
			os << nextLine << endl;
			getline(is, nextLine);
			targetIndex = static_cast<int>(string::npos);
		}
		// Reset streams
		is.clear();
		os.flush();
	}
}

/*  
	@PARAM double & velocity
		
	@PARAM double burnAmount
		
	@PARAM double & fuelRemaining
		
	@PARAM double & height
		
*/
void updateStatus(double & velocity, double burnAmount, double & fuelRemaining, double & height){
	const double GRAVITY = 5.0;
	double prevVelocity = velocity;

	fuelRemaining -= burnAmount;
	velocity += (GRAVITY - burnAmount);
	height -= ((prevVelocity + velocity) / 2.0);
}

/*
	@PARAM double & elapsedTime
		
	@PARAM double & velocity
		
	@PARAM double & burnAmount
		
	@PARAM double & height
		
*/
void touchdown(double & elapsedTime, double & velocity, double & burnAmount, double & height){
	const double GRAVITY = -5.0;
	// Variables
	double delta = 0.0;
	// The values represent what the velocity, height, and elapsed time were 1 step ago, before 1 call to updateStatus(...)
	double lastVelocity = (velocity + GRAVITY + burnAmount);
	double lastHeight = (height + ((lastVelocity + velocity) / 2.0));
	double lastTime = (elapsedTime - 1.0);
	// These values will be important to the touchdown calculations...
	delta = ((sqrt(((pow(lastVelocity, 2)) + (lastHeight * (10.0 - (2.0 * burnAmount))))) - lastVelocity) / (5.0 - burnAmount));
	elapsedTime = (lastTime + delta);
	velocity = (lastVelocity + ((5.0 - burnAmount) * delta));
}

/*  
	@PARAM ostream & os
	
	@PARAM double velocity
	
*/
void finalAnalysis(ostream & os, double velocity){
	if (velocity == 0.0){
		os << "Congratulations! A perfect landing!! " << endl;
	}
	else{
		if (velocity < 2.0){
			os << "A little bumpy. " << endl;
		}
		else{
			if (velocity < 5.0){
				os << "A dangerously bad landing. " << endl;
			}
			else{
				if (velocity < 10.0){
					os << "Your ship was dead on arrival. " << endl;
				}
				else{
					if (velocity < 30.0){
						os << "You made yourself a lovely hole for a tombstone. " << endl;
					}
					else{
						if (velocity < 50.0){
							os << "What a crater, you show that moon who's boss. " << endl;
						}
						else{
							os << "It's almost as if you wanted to go through the moon. Gotta go fast. " << endl;
						}
					}
				}
			}
		}
	}
}