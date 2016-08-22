typedef struct {
	int month;
	int day;
	int year;
} Date_t;

typedef struct {
	char *name;
	date_t birth;
} Person_t;

void main(void) {
	// Create a new date_t called d
	Date_t d;
	d.month = 1;
	d.date = 2;
	d.year = 3;
	
	// Create a new person called p
	Person_t chris;
	chris.name = "Chris";
	chris.birth.month = 12;
	chris.birth.day = 25;
	chris.birth.year = 1995;
	
	// Create another person
	Person_t person;
	person = {"Chris", 12, 25, 1995};
	
	
	printPerson(person);
}