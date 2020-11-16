/* Anton Adamovich
Drexel University
Computer Programming 9000
4-22-15
*/

#include "Socialite.h";

#include <sstream>

using namespace std;

// Constructors

Socialite::Socialite(){
	lastName = "";
	firstName = "";
	userID = "";
	picturePath = "";
	siteURL = "";
	siteDescription = "";
}

// Getters

string Socialite::getLastName(){
	return lastName;
}

string Socialite::getFirstName(){
	return firstName;
}

string Socialite::getUserID(){
	return userID;
}

string Socialite::getPicturePath(){
	return picturePath;
}

string Socialite::getSiteURL(){
	return siteURL;
}

string Socialite::getSiteDescription(){
	return siteDescription;
}

// Setters

void Socialite::setLastName(string name){
	lastName = name;
}

void Socialite::setFirstName(string name){
	firstName = name;
}

void Socialite::setUserID(string id){
	userID = id;
}

void Socialite::setPicturePath(string path){
	picturePath = path;
}

void Socialite::setSiteURL(string url){
	siteURL = url;
}

void Socialite::setSiteDescription(string desc){
	siteDescription = desc;
}

// Utility

string Socialite::toString();
string Socialite::toHTML();
string Socialite::toFileHTML();

};