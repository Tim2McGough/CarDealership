package com.pluralsight;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.List;

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

    // Placeholder for process methods
    public void processGetByPriceRequest() {}
    public void processGetByMakeModelRequest() {}
    public void processGetByYearRequest() {}
    public void processGetByColorRequest() {}
    public void processGetByMileageRequest() {}
    public void processGetByVehicleTypeRequest() {}
    public void processGetAllVehiclesRequest() {
        //Gets the dealershipObject to use method getvehicles to return a list stored in the allVehicles var.
        List<Vehicle> allVehicles = dealership.getVehicles();
        // using this created allVehicle var, run the helper method above to display them.
        displayVehicles(allVehicles); // Display the list using the helper method
    }

    public void processAddVehicleRequest() {}
    public void processRemoveVehicleRequest() {}
}
