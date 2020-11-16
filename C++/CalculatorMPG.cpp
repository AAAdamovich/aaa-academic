/* Anton Adamovich
*  Drexel University
*  CS 171
*  4-24-15 : Last Modified 4-24-15
*
*  Program calculates fuel efficiency of a chevrolet Camaro, total gas burned, and total cost of a trip 
*  whose parameters are entered by a user. These parameters are: distance driven, average speed, 
*  and cost of gasoline at the time. Fuel efficiency equation is provided:
*  FE = 71.7 * s * (2 + 0.0192 * s) (-4.5) + e(-5.1*s) – 1
*  where 's' is average speed and 'e' is Euler's number (a constant)
*/

#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main(){
	const double E = 2.71828;

	double avgSpeed = 0.0;
	double distance = 0.0;
	double price = 0.0;
	double fuelEfficiency = 0.0;
	double totalCost = 0.0;
	double gasConsumed = 0.0;
	
	cout << "This program will calculate the fuel efficiency of a Chevrolet Camaro " << endl
		<< "for a particular long distance trip, as well as some other statistics. " << endl << endl;
	cout << "Please enter your average speed during a trip in MPH (Miles Per Hour): ";
	cin >> avgSpeed;
	// Number is fixed to positive range only for later calculations
	avgSpeed = abs(avgSpeed);
	cout << "What is the total distance driven? (in miles): ";
	cin >> distance;
	// Similar to above, just in case
	distance = abs(distance);
	cout << "What is the price per gallon of gasoline during the trip? (in US dollars): ";
	cin >> price;
	// Check to ensure price is not 0 or negative
	while (price <= 0){
		cout << "Even the computer knows gasoline isn't free, try another price: ";
		cin >> price;
	}
	// The following equation calculates fuel efficiency in a Chevrolet Camaro, the use of magic numbers was not avoided
	fuelEfficiency = ((71.7 * avgSpeed * (pow((2.0 + (0.0192 * avgSpeed)), -4.5))) + (pow(E, (-5.1 * avgSpeed))) - 1.0);
	// Total gas consumed
	gasConsumed = (distance / fuelEfficiency);
	// Totals cost of gas during the trip
	totalCost = (gasConsumed * price);

	cout << endl << "Using the values you specified above, " << endl 
		<< "here are some statistics about your trip: " << endl;
	// Stream modifier to avoid crazy decimals
	cout << setprecision(5);
	cout << "Fuel Efficiency:                " << fuelEfficiency << " miles per gallon. " << endl;
	cout << "Amount of gasoline expended:    " << gasConsumed << " gallons. " << endl;
	// Stream modifiers are used to always display exactly two cent values
	cout << fixed << setprecision(2);
	cout << "Total cost of this trip:        $" << totalCost << " (USD)" << endl << endl;

	return 1;
}