/*  Antony Adamovich
	Drexel University
	CS 171
	01 March 2015
    MIT License Copyright (c) 2019 Antony Adamovich Permission is hereby granted, free of charge, to any person obtaining a copy of this software
    and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions: The above copyright notice and this permission notice shall be included in all copies 
    or substantial portions of the Software. THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
    LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS 
    BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
    SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>

using namespace std;

double simulateLocking(const int n, char &door1, char &door2, char &door3, int &doorPlayer, int &doorMonty);
double simulateChanging(const int n, char &door1, char &door2, char &door3, int &doorPlayer, int &doorMonty);
void setupDoors(char &door1, char &door2, char &door3);
void pickDoorChoices(char door1, char door2, char door3, int &doorPlayer, int &doorMonty);
char revealDoor(int choice, char door1, char door2, char door3);
int randomInteger(int n);

int main(){
	// Program-wide constants, NUMBER_OF_RUNS dicates the amount of times the simulation will run, evenly divided among locking
	// the player's decision and changing it. For this reason it is preferable that it is an even integer
	// DESIRED_ACCURACY denotes the number of decimal places to be used in the final percentage calculation
	const int NUMBER_OF_RUNS = 200000;
	const int DESIRED_ACCURACY = 3;

	// Initial seeding of the RNG
	srand((unsigned int)(time(NULL)));
	// Initial declarations of simulation-based variables
	char door1 = '#';
	char door2 = '#';
	char door3 = '#';
	int doorPlayer = -1;
	int doorMonty = -1;
	// These variables record the results in %
	double lockWinP = -1.0;
	double changeWinP = -1.0;
	// The simulationing:
	lockWinP = simulateLocking((NUMBER_OF_RUNS / 2), door1, door2, door3, doorPlayer, doorMonty);
	changeWinP = simulateChanging((NUMBER_OF_RUNS / 2), door1, door2, door3, doorPlayer, doorMonty);
	// Printing
	cout << fixed << setprecision(DESIRED_ACCURACY);
	cout << "With " << NUMBER_OF_RUNS << " runs, divided evenly between the two catagories... " << endl;
	cout << "The player won " << lockWinP << "% of the time by staying with their original decision. " << endl;
	cout << "The player won " << changeWinP << "% of the time by changing their decision. " << endl;

	return 1;
}

/*  Simulates a game of "Let's Make a Deal" n times. For this function, the player always chooses to stay with their original 
	decision, meaning that doorPlayer will only change twice if n is 1. This function returns a percentage that represents 
	the percent of the times a player won the game vs the the times a player lost the game over playing the game n times. 

	@param const int n - The number of times this simulation is to be run. Expected to be greater than 1. 
	@param char &door1 - A charecter that representes what is behind door #1. Expected to be C or G, if not, 
		the program wide default is the pound sign. (#) The value of door1 changes often and unpredictably
		during the execution of this function. Its value outside this function is guaranteed to be C, G, or #. 
	@param char &door2 - See door1 above. 
	@param char &door3 - See door1 above. 
	@param int &doorPlayer - An integer that represents what door the player has picked, 1 is door1, 2 is door2, etc. Expected
		to be on the range [1, 3], if not, the program-wide default is -1. The value of doorPlayer changes often and unpredictably
		during the execution of this function. Its value outside this function is guaranteed to be -1, 1, 2, or 3
	@param int &doorMonty - see doorPlayer above, except this is Monty's pick, not the player's 

	@return double - A percentage representing the times a player won the simulated game vs not won the simulated game. Guaranteed
		to be on the range [0.0, 100.0] or -1.0 if the function experienced an internal exception. 
*/
double simulateLocking(const int n, char &door1, char &door2, char &door3, int &doorPlayer, int &doorMonty){
	// In case of stupid
	if (n <= 0){
		return -1.0;
	}
	// Amount of times player wins by locking in their decision
	int wins = 0;
	// This block simulates the player always locking their decision
	for (int i = 0; i < n; i++){
		// Variables are reset every run
		door1 = '#';
		door2 = '#';
		door3 = '#';
		doorPlayer = -1;
		doorMonty = -1;
		// One situation is generated
		setupDoors(door1, door2, door3);
		pickDoorChoices(door1, door2, door3, doorPlayer, doorMonty);
		// If the player won a car
		if ((revealDoor(doorPlayer, door1, door2, door3)) == 'C'){
			wins++;
		}
	}
	return ((((double)wins) / ((double)n)) * 100.0);
}

/*  See function "simulateLocking(const int n, char &door1, char &door2, char &door3, int &doorPlayer, int &doorMonty)"
	above. Parameters and return types are identical. 
	This function is different only in the fact that during the simulation, doorPlayer will be changed to a value on the range
	[1, 3] that isn't equal to doorMonty and doorPlayer. This action happens n times. 
*/
double simulateChanging(const int n, char &door1, char &door2, char &door3, int &doorPlayer, int &doorMonty){
	// In case of stupid
	if (n <= 0){
		return -1.0;
	}
	// Amount of times player wins by changing their decision after Monty's decision
	int wins = 0;
	// This block simulates the player always changing their decision
	int newChoice = -1;
	for (int i = 0; i < n; i++){
		// Variables are reset every run
		door1 = '#';
		door2 = '#';
		door3 = '#';
		doorPlayer = -1;
		doorMonty = -1;
		newChoice = -1;
		// One situation is generated
		setupDoors(door1, door2, door3);
		pickDoorChoices(door1, door2, door3, doorPlayer, doorMonty);
		// Player's choice changes to only availible door
		switch (doorPlayer){
		case 1:
			if (doorMonty == 2){
				newChoice = 3;
			}
			else{
				newChoice = 2;
			}
			break;
		case 2:
			if (doorMonty == 3){
				newChoice = 1;
			}
			else{
				newChoice = 3;
			}
			break;
		case 3:
			if (doorMonty == 2){
				newChoice = 1;
			}
			else{
				newChoice = 2;
			}
			break;
		default:
			// Something very strange happened
			cout << "There was a serious miscalculation during the simulation - This function will now terminate: " << endl;
			// Dump some variables
			cout << door1 << " " << door2 << " " << door3 << " " << doorPlayer << " " << doorMonty << endl;
			// Leave...
			return -1.0;
			break;
		}
		// Assign calculated choice to player's choice
		doorPlayer = newChoice;
		// If the player won a car with the new choice
		if ((revealDoor(doorPlayer, door1, door2, door3)) == 'C'){
			wins++;
		}
	}
	return ((((double)wins) / ((double)n)) * 100.0);
}

/*  This function assigns parameters door1, door2, and door3 a value of either C or G, with the additional rule that two of the doors
	have to be a 'G' and only one can be a 'C'. 
	See function "simulateLocking(const int n, char &door1, char &door2, char &door3, int &doorPlayer, int &doorMonty)"
	above for explanations of door1, door2, and door3. These parameters have rules that are upheld everywhere in the program
*/
void setupDoors(char &door1, char &door2, char &door3){
	int doorGen = randomInteger(3);
	switch (doorGen){
		case 0:
			door1 = 'C';
			door2 = 'G';
			door3 = 'G';
			break;
		case 1:
			door1 = 'G';
			door2 = 'C';
			door3 = 'G';
			break;
		case 2:
			door1 = 'G';
			door2 = 'G';
			door3 = 'C';
			break;
		default:
			// In case of strange behavior, reset values
			door1 = '#';
			door2 = '#';
			door3 = '#';
			break;
	}
}

/*  See function "simulateLocking(const int n, char &door1, char &door2, char &door3, int &doorPlayer, int &doorMonty)"
	above. Parameters and return types are identical.
	This function is different only in the fact that during the simulation, doorPlayer will be changed to a value on the range
	[1, 3] that isn't equal to doorMonty and doorPlayer. This action happens n times.

	NOTE: There HAS to be a better way of doing this. My initial design plan involved using a dynamic-storage array to store
	Monty's potential choices, which then could be easily extracted using a for-each loop, but I didn't have enough
	knowledge about C++ to complete said task. I settled for this design instead...
*/
void pickDoorChoices(char door1, char door2, char door3, int &doorPlayer, int &doorMonty){
	// Logic array that expresses which doors Monty is able to choose, he can't choose doors with false values
	bool validChoices[3] = {true, true, true};
	for (int i = 0; i < 3; i++){
		if ((revealDoor((i + 1), door1, door2, door3)) == 'C'){
			validChoices[i] = false;
		}
	}
	// Player makes his/her choice...
	doorPlayer = (1 + randomInteger(3));
	// ... Monty adjusts
	validChoices[doorPlayer - 1] = false;

	int choice1 = -1;
	int choice2 = -1;
	// This entire loop relies on Monty only having up to two choices avalible, negative values for the choices haven't been added
	// to the final choice pool. This loop also always assigns choice1 a value first, which will be important later
	for (int i = 0; i < 3; i++){
		if (validChoices[i]){
			if (choice1 < 0){
				choice1 = (i + 1);
			}
			else{
				choice2 = (i + 1);
			}
		}
	}
	// If there is only one choice, Monty takes it
	if (choice2 < 0){
		doorMonty = choice1;
	}
	else{
		// Monty will have a max of two choices, so he picks either 1 or 2
		int montyChoice = (1 + randomInteger(2));
		if (montyChoice == 1){
			doorMonty = choice1;
		}
		else{
			doorMonty = choice2;
		}
	}
}

/*  Takes in an integer choice that represents one of three doors, which are also parameters, and returns the charecter representation
	of whatever door choice was refrencing

	@param int choice - An integer on the range [1, 3] that represents door1, door2, and door3 respectively
	@param char door1 - See function "simulateLocking(const int n, char &door1, char &door2, char &door3, int &doorPlayer, int &doorMonty)"
		above for explanations of door1, door2, and door3. These parameters have rules that are upheld everywhere in the program
	@param char door2 - See door1 above
	@param char door3 - See door1 above

	@return char - A charecter, either C or G, or the default, #, that represents what is behind the corresponding door that is marked by
		 the integer parameter choice
*/
char revealDoor(int choice, char door1, char door2, char door3){
	switch (choice){
		case 1:
			return door1;
			break;
		case 2:
			return door2;
			break;
		case 3:
			return door3;
			break;
		default:
			// Returns the default value for door in the event that someone panics
			return '#';
			break;
	}
}

/*  Takes in an integer n as a parameter and returns a random integer between 0, inclusive, and n - 1, inclusive
	Function uses code from CS 171 website:
	https://www.cs.drexel.edu/~mcs171/Wi15/notes/08.4_random/generating.html?CurrentSlide=3

	@param int n - An integer that is preferred to be positive. Function returns coherent values if n is negative 
	but this is not recommended. A value of 0 for n will make this function always return 0

	@return int - A random number on the range [0, n)
*/
int randomInteger(int n){
	// index is a number between 0.0 (inclusive) and 1.0 (non-inclusive)
	double index = ((double)rand() / ((double)((unsigned int)RAND_MAX + unsigned int(1))));
	// Adjusts index to be a new random integer between 0 and (n - 1), inclusive
	int newInteger = (int)(((double)n) * index);
	return newInteger;
}