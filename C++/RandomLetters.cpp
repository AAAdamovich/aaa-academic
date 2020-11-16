/* Anton Adamovich
*  Drexel University
*  CS 171
*  2-19-15
*/

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

char vowelGenerator(int input);
char consonantGenerator(int value);
int randomInteger(int n);

int main(){
	srand((int)(time(NULL)));
	for (int i = 0; i < 10; i++){
		cout << consonantGenerator(randomInteger(22)) << vowelGenerator(randomInteger(5))
			<< consonantGenerator(randomInteger(22)) << consonantGenerator(randomInteger(22))
			<< vowelGenerator(randomInteger(5)) << consonantGenerator(randomInteger(22));
		cout << endl;
	}
	return 1;
}

char vowelGenerator(int value){
	switch (value){
	case 0:
		return 'A';
		break;
	case 1:
		return 'E';
		break;
	case 2:
		return 'I';
		break;
	case 3:
		return 'O';
		break;
	case 4:
		return 'U';
		break;
	default:
		return '#';
		break;
	}
}

char consonantGenerator(int value){
	if ((value >= 0) && (value < 22)){
		char consonantArray[22] = { 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		return (consonantArray[value]);
	}
	return '#';
}

// Function uses code from CS 171 website: 
// https://www.cs.drexel.edu/~mcs171/Wi15/notes/08.4_random/generating.html?CurrentSlide=3
int randomInteger(int n){
	// index is a number between 0.0 (inclusive) and 1.0 (non-inclusive)
	double index = (rand() / (RAND_MAX + 1.0));
	// Adjusts index to be a new random integer between 0 and (n - 1), inclusive
	int newInteger = (int)(((double)n) * index);
	return newInteger;
}