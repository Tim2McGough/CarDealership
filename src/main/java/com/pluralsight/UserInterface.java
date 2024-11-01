package com.pluralsight;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.util.*;

public class UserInterface {
    private Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    // Display method - will call init and then show menu
    public void display() {

        Scanner scanner = new Scanner(System.in);

        //While exit is false, run this menu. Exit is only true when user makes it so by selecting 99
        boolean exit = false; // Loop control

        while (!exit) {
            displayMenu(); // Show the menu, listed at the bottom of UI

            // Read user input
            System.out.print("What would you like to do? : ");
            int choice = scanner.nextInt();

            // Handle user choice with a switch statement
            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99: // Exit code
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }



    // Helper method to display vehicles
    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
    private void displayMenu() {
        System.out.println("\n--- Dealership Menu ---");
        System.out.println("1. Find vehicles by price");
        System.out.println("2. Find vehicles by make/model");
        System.out.println("3. Find vehicles by year range");
        System.out.println("4. Find vehicles by color");
        System.out.println("5. Find vehicles by mileage range");
        System.out.println("6. Find vehicles by type");
        System.out.println("7. List all vehicles");
        System.out.println("8. Add a vehicle");
        System.out.println("9. Remove a vehicle");
        System.out.println("99. Quit");
    }

    // scanner to be used in the process methods below
    Scanner scanner = new Scanner(System.in);
    // Process methods
    public void processGetByPriceRequest() {
        System.out.println();
    }

    public void processGetByMakeModelRequest() {
        System.out.println();
    }
    public void processGetByYearRequest() {
        System.out.println();
    }
    public void processGetByColorRequest() {
        System.out.println("Sure, What's the color of car you are looking for?");
        String colorSelection = scanner.nextLine();
        //create matchingVehicles list to store any that match the request
        List<Vehicle> matchingVehicles = new ArrayList<>();
        // getting vehicles loop. Each time something fits it goes to our empty list we just made.
        for (Vehicle vehicle : dealership.getVehicles()) {
            // if we got a match add that vehicle and display it.
            if (vehicle.getColor().equalsIgnoreCase(colorSelection)) {
                matchingVehicles.add(vehicle);
            }
        }

        if (matchingVehicles.isEmpty()) {
            System.out.println("Sorry, we don't have any vehicles in " + colorSelection + ".");

            // HashSet ignores duplicates and doesn't care about order, so we only present user with colors rather than a bunch of the same ones.

            Set<String> availableColors = new HashSet<>();
            //Runs through the dealership to get a list of colors and then
            for (Vehicle vehicle : dealership.getVehicles()) {
                //assigns available colors to availableColors so we can print it on ln 129
                availableColors.add(vehicle.getColor());
            }

            System.out.println("Here are some colors we do have available: " + availableColors);
        } else {
            // If we had something in the color they want we just display that.
            displayVehicles(matchingVehicles);
        }
    }


    public void processGetByMileageRequest() {
        System.out.println();
    }
    public void processGetByVehicleTypeRequest() {
        System.out.println("Sure, What's the type of car you are looking for? \n 1)Car 2)Truck 3)SUV 4)Van 5)Back");
        int choice = scanner.nextInt();
        List<Vehicle> filteredVehicles = new ArrayList<>();
        switch (choice) {
            case 1:  filteredVehicles = filterVehiclesByType("Car");// write code to show only what is asked for if car
            case 2: list<Vehicle> // write code to show only what is asked for. Do this for case 3 and 4 as well.
            case 3:
            case 4:
            case 5: // write code to go back to the previous selection.

            default:
                throw new IllegalStateException("Please try again " + choice + "Isn't a valid selection.");
        }

    }

    public void processGetAllVehiclesRequest() {
        //Gets the dealershipObject to use method getvehicles to return a list stored in the allVehicles var.
        List<Vehicle> allVehicles = dealership.getVehicles();
        // using this created allVehicle var, run the helper method above to display them.
        displayVehicles(allVehicles); // Display the list using the helper method
    }

    public void processAddVehicleRequest() {}
    public void processRemoveVehicleRequest() {}
}
