/* Anton Adamovich
   Drexel University
   CS 9000
   4-15-13
*/

#include <iostream>
#include <cmath>

using namespace std;

/* The Following grading scale is what I used for the -/+ calculations
   97 - 100 === A+ 
   93 - 96  === A
   89 - 92  === A-
   85 - 88  === B+
   81 - 84  === B
   77 - 80  === B-
   76 - 73  === C+
   72 - 69  === C
   68 - 65  === C-
   60 - 64  === D
   < 60     === F
*/

// (-60) 0 - 4[0](0.blah - 1) | 5 - 8 (1.blah - 2)
int main()
{
	int grade = 0;
	int intRange = 0;
	double range = 0.0;
	
	cout << "Please enter a grade between 0 and 100, inclusive, "
		<< "or a negative number to exit the program: " << endl;
	cin >> grade;
	while (grade >= 0){
		if (grade > 100){
			cout << "Your input was invalid, numbers greater than 100 are not accepted" << endl;
		}
		else{
			// Here, the program normalizes the 0-100 grade and turns it into a 0-10 scale
			// Numbers below a 60 are turned into some negative number that represents
			// any grade with a value of F or lower
			range = ((((double)grade) - 60.0) / 4.0);
			if (range < 0){
				// Prevents a negative number to being rounded up to 0
				range -= 1.0;
			}
			range = ceil(range);
			cout << range << endl;
			intRange = (int)range;

			switch (intRange){
				//case 0:
			case 1:
				cout << "Not so good: D" << endl;
				break;
			case 2:
				cout << "C-" << endl;
				break;
			case 3:
				cout << "Not bad: C" << endl;
				break;
			case 4:
				cout << "C+" << endl;
				break;
			case 5:
				cout << "B-" << endl;
				break;
			case 6:
				cout << "Good job: B" << endl;
				break;
			case 7:
				cout << "B+" << endl;
				break;
			case 8:
				cout << "A-" << endl;
				break;
			case 9:
				cout << "Very good: A" << endl;
				break;
			case 10:
				cout << "Congratulations, you got a perfect score: A+" << endl;
				break;
			default:
				cout << "We need to talk: F" << endl;
				break;
			}
		}
		cout << "Please enter a grade between 0 and 100, inclusive, "
			<< "or a negative number to exit the program: " << endl;
		cin >> grade;
	}
	
	return 1;
}
