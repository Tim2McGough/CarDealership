package com.pluralsight;
import java.io.*;

public class DealershipFileManager {
    //Methods:

    // reads data file for information about dealership. This is the top line of our inventory everytime so
    // commanding it to buff read.oneline is sufficient.
    public Dealership getDealership(){
        try (BufferedReader br = new BufferedReader(new FileReader("WorkshopFiles/WorkshopFiles/inventory.csv")))
        { String dealerLine = br.readLine();
            // This is used with the else later to ensure the first line is correctly labelled.
            if (dealerLine != null) {
            // Here we cut the dealership into parts delimited by | and assign those parts to diff var.
            String[] dealershipDetails = dealerLine.split("\\|");
            String name = dealershipDetails[0];
            String address = dealershipDetails[1];
            String phone = dealershipDetails[2];
            // This gives us the info we asked for making getDealership return the variables above.
            return new Dealership(name,address,phone);}

        } catch (IOException e){
            System.out.println("error reading file: " + e.getMessage());
        }// We need to say what happens incase dealerline is null.
        return null;
    }
    //Saves a dealership into the file that can later be grabbed using getDealership.
    public void saveDealership(Dealership dealership) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("WorkshopFiles/WorkshopFiles/inventory.csv"))) {
            // Write the dealership details to the first line
            // uses the methods listed in dealership to get variables for each field.
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine(); // Move to the next line for potential vehicle entries
            //This says for each vehicle in our vehicle object call the get vehicle method then,
            // Loop through each vehicle and write its details in the order that we find it in the csv
            for (Vehicle vehicle : dealership.getVehicles()) {
                bw.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" + vehicle.getPrice());
                bw.newLine(); // Move to a new line for the next vehicle
            }

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

}
