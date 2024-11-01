package com.pluralsight;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {

    private Dealership dealership;
    private UserInterface ui;

    @BeforeEach
    void setUp() {
        // Set up dealership with test data
        dealership = new Dealership("Test Dealership", "123 Test St", "555-1234");
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle redCar = new Vehicle();
        redCar.setColor("Red");
        vehicles.add(redCar);

        Vehicle blueCar = new Vehicle();
        blueCar.setColor("Blue");
        vehicles.add(blueCar);

        Vehicle greenCar = new Vehicle();
        greenCar.setColor("Green");
        vehicles.add(greenCar);

        dealership.getVehicles().addAll(vehicles);

        // Initialize UserInterface with test dealership
        ui = new UserInterface(dealership);
    }

    @Test
    void testProcessGetByColorRequestWithExistingColor() {
        // Test for color that exists
        ui.processGetByColorRequest("Red");
        // Verify output manually, or redirect System.out for automated testing
        // In a real test environment, we would capture the output and verify it
    }

    @Test
    void testProcessGetByColorRequestWithNonexistentColor() {
        // Test for color that does not exist
        ui.processGetByColorRequest("Purple");
        // Verify output or alternative suggestions
    }
}
