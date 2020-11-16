/* Anton Adamovich
*  Drexel University
*  CS 171
*  2-23-15
*/

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

void computeBloodAlcoholConcentration(int numDrinks, int weight, int duration, double &maleBAC, double &femaleBAC);
string impairment(double bac);
int promptForInteger(string const &message, int lower, int upper);
char promptForMorF(string const &message);
void showImpairmentChart(int weight, int duration, bool isMale);

int main(){
	const int WEIGHT_MAX = 1000;
	// Equivalent, in minutes, to a 24-hour day
	const int DELAY_MAX = 1440;

	char gender = ' ';
	int weight = 0;
	int timeSinceLastDrink = 0;
	bool isMale = false;

	cout << "This program calculates your BAC on a per-drink basis. " << endl;
	cout << "To begin, ";
	gender = promptForMorF("Are you male or female? (Enter 'M' or 'F'): ");
	if (gender == 'M' || gender == 'm'){
		isMale = true;
	}
	if (gender == 'F' || gender == 'f'){
		isMale = false;
	}
	weight = promptForInteger("Enter your weight, in pounds: ", 0, WEIGHT_MAX);
	timeSinceLastDrink = promptForInteger("How long (in minutes) has it been since your last drink? ", 0, DELAY_MAX);
	cout << endl;
	showImpairmentChart(weight, timeSinceLastDrink, isMale);
	return 1;
}

/* Computes both a female's and male's BAC (Blood Alcohol Concentration), to be passed using refrence parameters. 
*  Calculation is done based on a person's weight, how much time has elapsed since the last drink, and how many drinks were taken at that time
*  @param int numDrinks - The number of drinks a person has taken
*  @param int weight - The weight (In pounds) of the person
*  @param int duration - The amount of time (In minutes) elapsed since the last drink
*  @param double &maleBAC - The calculated BAC of a male given all other non-refrence values
*  @param double &femaleBAC - The calculated BAC of a female given all other non-refrence values
*/
void computeBloodAlcoholConcentration(int numDrinks, int weight, int duration, double &maleBAC, double &femaleBAC){
	const double FEMALE_BAC_CONSTANT = 4.5;
	const double MALE_BAC_CONSTANT = 3.8;

	double newFemaleBAC = ((((double)numDrinks) / ((double)weight)) * FEMALE_BAC_CONSTANT);
	double newMaleBAC = ((((double)numDrinks) / ((double)weight)) * MALE_BAC_CONSTANT);
	newFemaleBAC -= ((((double)duration) / 40.0) * 0.01);
	newMaleBAC -= ((((double)duration) / 40.0) * 0.01);
	if (newFemaleBAC < 0.0){
		newFemaleBAC = 0.0;
	}
	if (newMaleBAC < 0.0){
		newMaleBAC = 0.0;
	}
	femaleBAC = newFemaleBAC;
	maleBAC = newMaleBAC;
}

/* Accepts a number representing a person's BAC and returns a corresponding message based on how intoxicated they are
*  I used constants different than the ones offered in Figure 2 becuase I found those difficult to understand
*  @param double bac - A person's BAC (Blood Alcohol Concentration)
*  @return string - A message that reflects a person's level of intoxication based on their BAC
*/
string impairment(double bac){
	const double LV0 = 0.00;
	const double LV1 = 0.04;
	const double LV2 = 0.08;
	const double LV3 = 0.10;
	const double LV4 = 0.30;
	const string RE_LV0 = "Safe To Drive";
	const string RE_LV1 = "Some Impairment";
	const string RE_LV2 = "Driving Skills Significantly Affected";
	const string RE_LV3 = "Criminal Penalties in Most US States";
	const string RE_LV4 = "Legally Intoxicated - Criminal Penalties in All US States";
	const string RE_LV5 = "Death is Possible!";

	if (bac == LV0){
		return RE_LV0;
	}
	if (bac < LV1){
		return RE_LV1;
	}
	if (bac < LV2){
		return RE_LV2;
	}
	if (bac < LV3){
		return RE_LV3;
	}
	if (bac < LV4){
		return RE_LV4;
	}
	return RE_LV5;
}

/* Accepts and displays a message that promts the user for input regarding an integer, 
*  to be between bounds defined by the parameters lower and upper
*  @param string const &message - The message to be displayed
*  @param int lower - The lower bound of input, forces user to input a number greater than or equal to it
*  @param int upper - The upper bound of input, forces user to input a number less than or equal to it
*  @return int - A user-specified integer to be returned
*/
int promptForInteger(string const &message, int lower, int upper){
	int input = 0;

	cout << message;
	cin >> input;
	while ((input < lower) || (input > upper)){
		cout << "Unfortunately, your input was invalid, please try again. " << endl;
		cout << message;
		cin >> input;
	}
	return input;
}

/* Accepts and displays a message that prompts the user for input regarding their biological gender
*  @param string const &message - The message to be displayed
*  @return char - A user-specified charecter representing their biological gender. 'M' or 'm' for male and 'F' or 'f' for female
*/
char promptForMorF(string const &message){
	string inputAll = "";
	char input = ' ';

	cout << message;
	cin >> inputAll;
	input = inputAll.at(0);
	while (((input != 'M') && (input != 'F')) && ((input != 'm') && (input != 'f'))){
		cout << "Unfortunately, your input was invalid, please try again. " << endl;
		cout << message;
		cin >> inputAll;
		input = inputAll.at(0);
	}
	return input;
}

/* Accepts the user's weight, time since last drink (In minutes), and biological gender. 
*  Then displays a table representing a user's potential BAC across the amount of drinks that could have been ingested, 
*  leading to a max BAC of 0.4
*  @param int weight - The weight (In pounds) of the user
*  @param int duration - The amount of time (In minutes) elapsed since the user last had a drink
*  @param bool isMale - Reflects the user's biological gender
*/
void showImpairmentChart(int weight, int duration, bool isMale){
	double maleBAC = 0.0;
	double femaleBAC = 0.0;
	double desiredBAC = 0.0;
	int numDrinks = 0;

	cout << weight << " pounds, ";
	if (isMale){
		cout << "Male" << endl << endl;
	}
	else{
		cout << "Female" << endl << endl;
	}
	cout << "# drinks | BAC  |     Status" << endl;
	cout << "         |      |" << endl;

	cout << fixed << setprecision(2);

	while (desiredBAC < 0.4){
		computeBloodAlcoholConcentration(numDrinks, weight, duration, maleBAC, femaleBAC);
		if (isMale){
			desiredBAC = maleBAC;
		}
		else{
			desiredBAC = femaleBAC;
		}
		cout << setw(8);
		cout << numDrinks << " | " << desiredBAC << " | " << impairment(desiredBAC) << endl;
		numDrinks++;
	}
	cout << endl;
}