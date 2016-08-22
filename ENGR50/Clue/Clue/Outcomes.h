#pragma once
#ifndef Outcomes
#define Outcomes

// Symbolic constants for indecies of outcomes
/*
typedef enum index {
	suspects = 0,
	weapons = 1,
	rooms = 2
};
*/

typedef struct Outcomes_t {
	static const int totalSuspects = 6;
	__readonly char* __readonly suspects[totalSuspects] = {
		"Ms. Scarlet",
		"Colonel Mustard",
		"Mrs. White",
		"Mr. Green",
		"Mrs. Peacock",
		"Professor Plum"
	};

	static const int totalWeapons = 6;
	__readonly char* __readonly weapons[totalWeapons] = {
		"Candlestick",
		"Knife",
		"Lead Pipe",
		"Revolver",
		"Rope",
		"Wrench"
	};

	static const int totalRooms = 9;
	__readonly char* __readonly rooms[totalRooms] = {
		"Hall",
		"Lounge",
		"Dining Room",
		"Kitchen",
		"Ballroom",
		"Conservatory",
		"Billiard Room",
		"Library",
		"Study",
	};

	// The list of possible outcomes includeing suspects, weapons and rooms
	__readonly char** __readonly outcomes[3] = {
		suspects,
		weapons,
		rooms
	};

	// Symbolic constants for indecies
	static const int SUSPECT_INDEX	= 0;
	static const int WEAPON_INDEX	= 1;
	static const int ROOM_INDEX		= 2;

	// The current outcome
	char* suspect;
	char* weapon;
	char* room;
} Outcome_t;

void generateOutcome(Outcome_t* o);

// Generates a random suspect, weapon and room for a given Outcome_t 
void generateOutcome(Outcome_t* o) {
	short randomSuspect		= (rand() % o->totalSuspects);
	short randomWeapon		= (rand() % o->totalWeapons);
	short randomRoom		= (rand() % o->totalRooms);
	char* selectedSuspect	= o->outcomes[o->SUSPECT_INDEX][randomSuspect];
	char* selectedWeapon	= o->outcomes[o->WEAPON_INDEX][randomWeapon];
	char* selectedRoom		= o->outcomes[o->ROOM_INDEX][randomRoom];

	o->suspect = selectedSuspect;
	o->weapon = selectedWeapon;
	o->room = selectedRoom;
}
#endif