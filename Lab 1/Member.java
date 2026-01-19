/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;

/**
 *
 * @author ajreehal
 */
/**
 * Member class represents a frequent flyer passenger.
 * This class extends the abstract Passenger class.
 */
public class Member extends Passenger {
    
    // How many years the passenger has been a member
    private int yearsOfMembership;
    
    // Constructor to create a Member object
    // Takes name, age, and years of membership as parameters
    public Member(String name, int age, int yearsOfMembership) {
        super(name, age);               // Call Passenger constructor to set name and age
        this.yearsOfMembership = yearsOfMembership; // Set years of membership
    }
    
    // Getter for yearsOfMembership
    public int getYearsOfMembership() {
        return yearsOfMembership;
    }
    
    // Setter for yearsOfMembership
    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }
    
    // This method calculates the discounted ticket price based on membership years
    @Override
    public double applyDiscount(double price) {
        if (yearsOfMembership > 5) {          // More than 5 years -> 50% discount
            return price * 0.5;
        } else if (yearsOfMembership > 1) {   // Between 1 and 5 years -> 10% discount
            return price * 0.9;
        } else {                              // 1 year or less -> no discount
            return price;
        }
    }
}
