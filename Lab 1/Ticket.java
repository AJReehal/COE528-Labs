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
 * Ticket class represents a flight ticket issued to a passenger.
 * Each ticket has a unique ticket number, a passenger, a flight, and a final price.
 */
public class Ticket {
    private Passenger passenger;        // The passenger who owns the ticket
    private Flight flight;              // The flight associated with the ticket
    private double price;               // Final ticket price (after discount)
    private int number;                 // Unique ticket number
    private static int nextTicketNum = 1; // Static variable to keep track of next ticket number

    // Constructor to create a Ticket
    // Automatically assigns a unique ticket number
    public Ticket(Passenger passenger, Flight flight, double price) {
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;

        this.number = nextTicketNum;  // Assign the current ticket number
        nextTicketNum++;              // Increment for the next ticket
    }

    // Getter for passenger
    public Passenger getPassenger() {
        return passenger;
    }

    // Getter for flight
    public Flight getFlight() {
        return flight;
    }

    // Getter for ticket price
    public double getPrice() {
        return price;
    }

    // Getter for ticket number
    public int getNumber() {
        return number;
    }

    // Setter for passenger
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    // Setter for flight
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // toString method returns a readable string describing the ticket
    @Override
    public String toString() {
        return passenger.getName() + ", Flight " + flight.getFlightNumber() + ", "
               + flight.getOrigin() + " to " + flight.getDestination() + ", "
               + flight.getDepartureTime() + ", original price: " + flight.getOriginalPrice() + "$, "
               + "ticket price: $" + String.format("%.2f", price);
    }
}




