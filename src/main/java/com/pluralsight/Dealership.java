package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

    /*
    private static void main(String[] args) {
        System.out.println("Please enter your Name: ");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your Address: ");
        System.out.println("Please enter your Phone: ");


    }

    private ArrayList<Vehicle> vehicles = new ArrayList();



 try(
    FileReader frOne = new FileReader("WorkshopFiles/WorkshopFiles/inventory.csv");
    BufferedReader brOne = new BufferedReader(frOne))

    {

        String line;
        // While line is not empty, print out that line. If line is empty, move on.
        while ((line = brOne.readLine()) != null) {
            // The header needs to be skipped. This works but there might be a better way in case file is changed later.
            if (line.startsWith("D")) {
                continue;  // Skip to the next line
            }

            // Split the data using | as that's how it is in the example
            String[] parts = line.split("\\|");
            //not sure if this is the right way to do this line.
            Vehicles vehicle = new vehicle(
                    parts[0],  // Vin
                    parts[1],  // year
                    parts[2],  // make
                    parts[3],  // Model
                    parts[4],  // Type
                    parts[5],  // color
                    parts[6],  // odometer
                    parts[7],  // Price
                    String.valueOf(parts[1]);
            String.valueOf(parts[2]);
            String.valueOf(parts[5]);
            String.valueOf(parts[7]);
            );


            transactions.add(transaction);
        }
    }
}
*/