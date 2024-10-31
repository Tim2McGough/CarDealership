package com.pluralsight;

public class Main {
    // Test
    public static void main(String[] args) {
        //declares manager to be a variable of a newly created  DealershipFileManager object
        DealershipFileManager manager = new DealershipFileManager();
        // tells manager to run the getdealership method and assign it to a dealership
        Dealership dealership = manager.getDealership();
        // if dealership isnt empty it prints out what was grabbed in the getdealership method.
        if (dealership != null) {
            System.out.println("Dealership Loaded:");
            System.out.println("Name: " + dealership.getName());
            System.out.println("Address: " + dealership.getAddress());
            System.out.println("Phone: " + dealership.getPhone());
            // just in case
        } else {
            System.out.println("Failed to load dealership.");
        }
    }
}
