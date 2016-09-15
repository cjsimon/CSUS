/**
 * This class defines Csc20Student's profile with extension of CsusStudent
 * Csc20 lab 4 assignment
 * @author  Christopher Simon
 * @version 1.0
 */
public class Csc20Student extends Student {
    // attributes
    private boolean isMajor;
    private int units;

    // constructor   
    public Csc20Student(String name, int id, String address, String phone, String email, boolean isMajor, int units) {
        //Pass the existing parameters to the parent constructor
        super(name, id, address, phone, email);
        //Set the major and units for the
        this.isMajor = isMajor;
        this.units = units;
    }

    //
    // Getters
    //

    // Major
    public boolean getMajor() {
        return isMajor;
    }

    // Units
    public int getUnits() {
        return units;
    }

    //
    // Setters
    //

    // Units
    public void setUnits(int units) {
        this.units = units;
    }

    // Major
    public void setMajor (boolean value) {

    }

    /**
     * Combine all values from class's attributes
     * @return String
     */
    public String toString() {
        //Indicate the status of the major according to the boolean value
        String majorStatus = isMajor ? "Yes" : "No";
        //Get the existing data from the super class
        //combine it with the new attributes of the extension
        String s = String.format(
            super.toString()
            + "\nMajor: "  + majorStatus
            + "\nUnits: "  + units
        );
        return s;
    }
}