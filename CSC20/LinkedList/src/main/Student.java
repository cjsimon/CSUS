package main;

/**
 * Defines a Student profile with a name, id, address, phone, and email
 * @author  Christopher Simon
 * @version 1.0
 */
public class Student {
    // class attributes
    private String name;
    private int    id;
    private String address;
    private String phone;
    private String email;

    // constructor
    public Student(String name, int id, String address, String phone, String email) {
        this.name    = name;
        this.id      = id;
        this.address = address;
        this.phone   = phone;
        this.email   = email;
    }

    //
    // Getters
    //

    // Name
    public String getName(){
        return name;
    }

    // Address
    public String getAddress(){
        return address;
    }

    // Phone
    public String getPhone(){
        return phone;
    }

    // Email
    public String getEmail(){
        return email;
    }

    //
    // Setters
    //

    // Name
    public void setName(String name){
        this.name = name;
    }

    // Address
    public void setAddress(String address){
        this.address = address;
    }

    // Phone
    public void setPhone(String phone){
        this.phone = phone;
    }

    // Email
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Combine all values from class's attributes
     * @return String
     */
    public String toString() {
        String s = (
            "Name: "        + name
            + "\nID: "      + id
            + "\nAddress: " + address
            + "\nPhone: "   + phone
            + "\nEmail: "   + email
        );
        return s;
    }
}