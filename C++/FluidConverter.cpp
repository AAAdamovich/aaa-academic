/* Anton Adamovich
*  Drexel University
*  CS 171
*  4-24-15 : Last Modified 4-24-15
*
*  Program accepts a US fluid ounce quantity from the user and breaks it down into several other Imperial
*  units. Details below...
*
*  Conversion Table that I used:
*  1 FO = 0.000124007937 hogsheads = 1/8064
*  1 FO = 0.0078125 gallons = 1/128
*  1 FO = 0.03125 quarts = 1/32
*  1 FO = 0.0625 pints = 1/16
*  1 FO = 0.125 cups = 1/8
*  1 FO = 0.25 US gills = 1/4
*  1 FO = 6 teaspoons = 6/1
*/

#include <iostream>
#include <cmath>

using namespace std;

int main(){
	int fluidOunces = 0;
	int workingNum = 0;

	cout << "This program breaks down an amount of US Fluid Ounces " << endl 
		<< "into other imperial units. " << endl;
	cout << "Please enter an integer value of fluid ounces: " << endl;
	cin >> fluidOunces;
	cout << endl << "You have: " << endl;

	// The flow of the program is simple: use integer division to display the unit breakdons and
	// a modulus statement to reduce the "running total" as the program goes on
	workingNum = (fluidOunces / 8064);
	cout << workingNum << " Hogshed(s)" << endl;
	fluidOunces %= 8064;

	workingNum = (fluidOunces / 128);
	cout << workingNum << " Gallon(s)" << endl;
	fluidOunces %= 128;

	workingNum = (fluidOunces / 32);
	cout << workingNum << " Quart(s)" << endl;
	fluidOunces %= 32;

	workingNum = (fluidOunces / 16);
	cout << workingNum << " Pint(s)" << endl;
	fluidOunces %= 16;

	workingNum = (fluidOunces / 8);
	cout << workingNum << " Cup(s)" << endl;
	fluidOunces %= 8;

	workingNum = (fluidOunces / 4);
	cout << workingNum << " US Gill(s)" << endl;
	fluidOunces %= 4;

	// Only conversion exception as teaspoons are smaller than Fluid ounces
	workingNum = (fluidOunces * 6);
	cout << workingNum << " Teaspoon(s)" << endl << endl;

	return 1;
}