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
 * NonMember class represents a passenger who is not a frequent flyer member.
 * This class extends the abstract Passenger class.
 */
public class NonMember extends Passenger {

    // Constructor to create a NonMember object
    // Takes name and age as parameters
    public NonMember(String name, int age) {
        super(name, age); // Call Passenger constructor to set name and age
    }

    // This method calculates the discounted ticket price based on age
    @Override
    public double applyDiscount(double price) {
        if (getAge() > 65) {       // Passengers older than 65 get 10% discount
            return price * 0.9;    
        } else {                    // Others get no discount
            return price;           
        }
    }
}



