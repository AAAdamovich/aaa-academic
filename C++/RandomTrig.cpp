/* Anton Adamovich
*  Drexel University
*  CS 171
*  2-19-15
*/

#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>
#include <cmath>

using namespace std;

double randomCoordinate();
void cartesianToPolar(double x, double y, double &r, double &theta);

int main(){
	const int POINTS_TO_GENERATE = 100000;
	double r = 0.0;
	double theta = 0.0;
	int inCircleCounter = 0;

	srand((int)(time(NULL)));
	cout << fixed << setprecision(9);

	for (int i = 0; i < POINTS_TO_GENERATE; i++){
		cartesianToPolar(randomCoordinate(), randomCoordinate(), r, theta);
		if (r <= 1.0){
			inCircleCounter++;
		}
	}
	cout << "This program attempts to calculate the value of pi using the " << endl << "Monte Carlo method. " << endl;
	cout << "This program's guess at pi is: ";
	cout << (4.0 * (((double)inCircleCounter) / ((double)POINTS_TO_GENERATE))) << endl;
	return 1;
}

double randomCoordinate(){
	// index is a number between 0.0 and 1.0, inclusive
	double index = (rand() / ((double)RAND_MAX));
	// Adjusts index to be a new random double between -1.0 and 1.0, inclusive
	double newCoordinate = ((index * 2.0) - 1.0);
	return newCoordinate;
}

void cartesianToPolar(double x, double y, double &r, double &theta){
	// Avoids a potential crash if x and y both equal 0
	while ((x == 0.0) && (y == 0.0)){
		x = randomCoordinate();
	}
	double thetaValue = atan2(x, y);
	r = (sqrt((pow(abs(x), 2.0)) + (pow(abs(y), 2.0))));
	theta = thetaValue;
}