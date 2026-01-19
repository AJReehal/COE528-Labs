/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1;

/**
 *
 * @author ajreehal
 */

/**
 * Flight class represents a flight with its details such as origin, destination, departure time, capacity, and price.
 */
public class Flight {
    private int flightNumber;          // Unique flight number
    private String origin;             // Departure city
    private String destination;        // Arrival city
    private String departureTime;      // Date and time of departure
    private int capacity;              // Total number of seats
    private int numberOfSeatsLeft;     // Seats available for booking
    private double originalPrice;      // Original price of the flight

    // Constructor to create a Flight object
    public Flight(int flightNumber, String origin, String destination, String departureTime, 
                  int capacity, double originalPrice) {

        // Ensure origin and destination are not the same
        if (origin.equalsIgnoreCase(destination)) {
            throw new IllegalArgumentException("Origin and Destination cannot be the same. RETRY");
        }

        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.originalPrice = originalPrice;
        this.numberOfSeatsLeft = capacity;  // Initially all seats are available
    }

    // Getters for all instance variables
    public int getFlightNumber() { return flightNumber; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getDepartureTime() { return departureTime; }
    public int getCapacity() { return capacity; }
    public double getOriginalPrice() { return originalPrice; }
    public int getNumberOfSeatsLeft() { return numberOfSeatsLeft; }

    // Setters for all instance variables
    public void setFlightNumber(int flightNumber) { this.flightNumber = flightNumber; }

    public void setDestination(String destination) {
        if (destination.equalsIgnoreCase(origin)) {
            throw new IllegalArgumentException("Origin and Destination cannot be the same. RETRY");
        }
        this.destination = destination;
    }

    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setOriginalPrice(double originalPrice) { this.originalPrice = originalPrice; }

    public void setOrigin(String origin) {
        if (origin.equalsIgnoreCase(destination)) {
            throw new IllegalArgumentException("Origin and Destination cannot be the same. RETRY");
        }
        this.origin = origin;
    }

    // Method to book a seat
    // Returns true if booking successful, false if flight is full
    public boolean bookASeat() {
        if (numberOfSeatsLeft > 0) {
            numberOfSeatsLeft--;  // Reduce available seats
            return true;
        } else {
            return false;
        }
    }

    // toString method to display flight information
    @Override
    public String toString() {
        return "Flight " + flightNumber + ", " + origin + " to " + destination
               + ", " + departureTime + ", original price: " + originalPrice + "$";
    }
}
