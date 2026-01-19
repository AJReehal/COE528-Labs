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
 * Passenger is an abstract class representing any flight passenger.
 * Both Member and NonMember classes will extend this class.
 */
public abstract class Passenger {
    private String name; // Passenger's name
    private int age;     // Passenger's age

    // Constructor to create a Passenger
    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Setter method to update name
    public void setName(String name) {
        this.name = name;
    }

    // Setter method to update age
    public void setAge(int age) {
        this.age = age;
    }

    // Abstract method to calculate ticket price after discount
    // Each subclass (Member or NonMember) must provide its own implementation
    public abstract double applyDiscount(double price);
}


