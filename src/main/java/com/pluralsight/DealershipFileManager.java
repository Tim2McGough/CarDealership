package com.pluralsight;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            // This makes assigns name address and phone to the dealership using 17-20.
                Dealership dealership = new Dealership(name, address, phone);
                // Get the list of vehicles and add them to the dealership we just made.
                dealership.getVehicles().addAll(getVehicles());

                return dealership;}

        } catch (IOException e){
            System.out.println("error reading file: " + e.getMessage());
        }// We need to say what happens incase dealerline is null.
        return null;
    }

    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("WorkshopFiles/WorkshopFiles/inventory.csv"))) {
            // Skip the first line (dealership details handled above)
            br.readLine();

            // Read each vehicle line
            String vehicleLine;
            while ((vehicleLine = br.readLine()) != null) {
                String[] vehicleDetails = vehicleLine.split("\\|");
                int vin = Integer.parseInt(vehicleDetails[0]);
                int year = Integer.parseInt(vehicleDetails[1]);
                String make = vehicleDetails[2];
                String model = vehicleDetails[3];
                String vehicleType = vehicleDetails[4];
                String color = vehicleDetails[5];
                int odometer = Integer.parseInt(vehicleDetails[6]);
                double price = Double.parseDouble(vehicleDetails[7]);

                Vehicle vehicle = new Vehicle();
                vehicle.setVin(vin);
                vehicle.setYear(year);
                vehicle.setMake(make);
                vehicle.setModel(model);
                vehicle.setVehicleType(vehicleType);
                vehicle.setColor(color);
                vehicle.setOdometer(odometer);
                vehicle.setPrice(price);

                vehicles.add(vehicle);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return vehicles;
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
