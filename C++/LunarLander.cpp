/* Anton Adamovich
*  Drexel University
*  Computer Programming I
*  1-29-15 : Last Modified 4-27-15 -> Reduced logic cases improving program flow and added documentation
*/

using namespace std;

#include <iostream>;

int main(){
	const double GRAVITY = -1.63;
	double altitude = 0.0;
	double velocity = 0.0;
	double acceleration = 0.0;
	int fuelToBurn = 0;
	int fuelLeft = 200;
	int stepCounter = 0;
	bool fuelIsEmpty = false;

	// Initial Setup of velocity & altitude
	cout << "This program will simulate the falling of a lunar lander. " << endl;
	cout << "Please enter an initial altitude (In meters): ";
	cin >> altitude;
	while (altitude < 0){
		cout << "Altitude cannot be negative, please enter an initial positive value for altitude: ";
		cin >> altitude;
	}
	cout << "Please enter an initial velocity magnitude, (In meters/second) keeping in mind " << endl 
		<< "that negative values start the lander moving towards the surface: ";
	cin >> velocity;
	cout << endl;
	
	// The Lunar Lander simulations begins
	do{
		if (fuelLeft > 0){
			// While the lander still has fuel, the program prompts the user to burn some
			cout << "At this time, how many integer units of fuel would you like to burn? " << endl
				<< "The lander has " << fuelLeft << " units of fuel remaining: ";
			cin >> fuelToBurn;
			// Check for invalid user-input
			while (fuelToBurn < 0){
				cout << "Unfortunately, you cannot burn negative units of fuel, please input a non-negative integer: ";
				cin >> fuelToBurn;
			}
			// Check the user isn't burning more fuel than he/she has
			while (fuelToBurn > fuelLeft){
				cout << "Unfortunately, you don't have enough fuel to burn that much. Please enter a lower number or 0. " << endl
					<< "The lander has " << fuelLeft << " units of fuel remaining: ";
				cin >> fuelToBurn;
			}
		}
		// In the event fuel is reduced to zero, the message is printed only once
		if ((!fuelIsEmpty) && (fuelLeft <= 0)){
			cout << endl << "!! CAUTION !! NO FUEL" << endl << endl;
			fuelIsEmpty = true;
		}
		// Each tick, (loop iteration) these values are updated
		acceleration = (GRAVITY + (0.1 * double(fuelToBurn)));
		fuelLeft -= fuelToBurn;
		// Reset fuelToBurn variable
		fuelToBurn = 0;
		velocity += acceleration;
		altitude += velocity;
		stepCounter++;
		// The program then prints a status report as long as the lander hasn't landed yet
		if (altitude > 0){
			cout << "After " << stepCounter << " second(s): " << endl << "the altitude is " << altitude
				<< " and the magnitude of the velocity is " << velocity << ". " << endl;
		}
	} while(altitude > 0);
	// Loop terminates when the next tick would put the altitude at or below zero
	// An end-game message is then printed, along with information about success/failure
	cout << endl << "The lander has reached the surface of the moon at the " << stepCounter << " second mark. " << endl;
	cout << "At this time, it would have had a velocity of " << velocity << ". " << endl;
	if (velocity < -2.0){
		cout << "Unfortunately, the lander has crashed. " << endl << endl;
	}
	else{
		cout << "The lander has landed safely. " << endl << endl;
	}
	return 1;
}