/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;

/**
 *
 * @author ajreehal
 */
/*
 * Manager class: This class manages flights and tickets for an airline.
 * It allows creating flights, displaying available flights, booking seats, 
 * and keeping track of issued tickets.
 */

import java.util.Scanner;

public class Manager {

    private Flight[] flights;   // Array to store all flights
    private Ticket[] tickets;   // Array to store all issued tickets

    private int flightCount;    // Number of flights currently in the array
    private int ticketCount;    // Number of tickets currently issued
    
    // Constructor: initializes the arrays and counters
    public Manager() {
        flights = new Flight[50];   // Maximum 50 flights
        tickets = new Ticket[250];   // Maximum 250 tickets
        flightCount = 0;             // Initially, no flights
        ticketCount = 0;             // Initially, no tickets
    }

    // Method to create flights by taking input from the user
    public void createFlights() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many flights do you want to add? ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter flight details:");

            System.out.print("Flight number: ");
            int number = sc.nextInt();
            sc.nextLine();

            System.out.print("Origin: ");
            String origin = sc.nextLine();

            System.out.print("Destination: ");
            String destination = sc.nextLine();

            System.out.print("Departure time: ");
            String time = sc.nextLine();

            System.out.print("Capacity: ");
            int capacity = sc.nextInt();

            System.out.print("Original price: ");
            double price = sc.nextDouble();
            sc.nextLine(); // consume newline

            // Create a new flight object and store it in the array
            flights[flightCount] = new Flight(number, origin, destination, time, capacity, price);
            flightCount++; // Increase flight count
        }
    }

    // Method to display flights that match the origin and destination and still have seats left
    public void displayAvailableFlights(String origin, String destination) {
        for (int i = 0; i < flightCount; i++) {
            Flight f = flights[i];

            // Check if flight matches and has available seats
            if (f.getOrigin().equalsIgnoreCase(origin) &&
                f.getDestination().equalsIgnoreCase(destination) &&
                f.getNumberOfSeatsLeft() > 0) {

                System.out.println(f); // Print flight details
            }
        }
    }

    // Method to find a flight by its flight number
    public Flight getFlight(int flightNumber) {
        for (int i = 0; i < flights.length; i++) {
            if (flights[i] != null && flights[i].getFlightNumber() == flightNumber) {
                return flights[i]; // Return the matching flight
            }
        }
        return null; // Return null if flight not found
    }

    // Method to book a seat for a passenger
    public void bookSeat(int flightNumber, Passenger p) {
        Flight flight = getFlight(flightNumber);

        if (flight == null) {
            System.out.println("Flight not found."); // No flight with this number
            return;
        }

        if (!flight.bookASeat()) {
            System.out.println("Flight is fully booked."); // No seats left
            return;
        }

        // Apply discount depending on passenger type (Member/NonMember)
        double finalPrice = p.applyDiscount(flight.getOriginalPrice());

        // Create a ticket and store it
        Ticket t = new Ticket(p, flight, finalPrice);
        tickets[ticketCount] = t;
        ticketCount++;

        System.out.println("Ticket booked successfully!");
        System.out.println(t); // Show ticket details
    }

    // Main method to test the Manager class
    public static void main(String[] args) {
        Manager manager = new Manager();

        // Create some flights manually for testing
        manager.flights[0] = new Flight(1030, "Toronto", "London", "01/05/26 7:50 pm", 3, 1000.0);
        manager.flights[1] = new Flight(1040, "Toronto", "New York", "03/01/26 9:00 am", 2, 800.0);
        manager.flights[2] = new Flight(1050, "Toronto", "Afghanistan", "08/07/26 6:00 pm", 1, 950.0);
        manager.flightCount = 3;

        // Create passengers
        Passenger member = new Member("Johnny Test", 30, 6);      // Member with 6 yrs -> 50% discount
        Passenger senior = new NonMember("LeBron James", 70);     // Age > 65 -> 10% discount

        // Display available flights from Toronto to London
        System.out.println("Available flights Toronto → London:");
        manager.displayAvailableFlights("Toronto", "London");

        // Book seats
        manager.bookSeat(1030, member);   // Book flight for Johnny
        manager.bookSeat(1050, senior);   // Book flight for LeGM

        // Try to overbook flight 1050 (only 1 seat)
        manager.bookSeat(1050, member);   // Should fail

        // Display available flights again for Toronto -> London
        System.out.println("\nFlights after booking Toronto -> London:");
        manager.displayAvailableFlights("Toronto", "London");

        // Display available flights to other destinations
        System.out.println("\nAvailable flights Toronto -> New York:");
        manager.displayAvailableFlights("Toronto", "New York");

        System.out.println("\nAvailable flights Toronto -> Afghanistan:");
        manager.displayAvailableFlights("Toronto", "Afghanistan");
    }
}



