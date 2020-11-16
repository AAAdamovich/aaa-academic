/* Anton Adamovich
   Drexel University
   Computer Programming 9000
   4-22-15
*/

#ifndef SOCIALITE_H
#define SOCIALITE_H

#include <string>;

using namespace std;

class Socialite{
	private:
		string lastName;
		string firstName;
		string userID;
		string picturePath;
		string siteURL;
		string siteDescription;

	public:
		// Constructors
		Socialite();
		// Getters
		string getLastName();
		string getFirstName();
		string getUserID();
		string getPicturePath();
		string getSiteURL();
		string getSiteDescription();
		// Setters
		void setLastName(string name);
		void setFirstName(string name);
		void setUserID(string id);
		void setPicturePath(string path);
		void setSiteURL(string url);
		void setSiteDescription(string desc);
		// Utility
		string toString();
		string toHTML();
		string toFileHTML();
};

#endif