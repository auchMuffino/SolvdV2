package Vehicles.Cars;

import Components.*;

public class CasualCar extends Car {

    private int numberOfSeats = 0;

    public CasualCar(){
        super();
    }
    public CasualCar(int numberOfSeats, Integer topSpeed, Double weight, String title, Engine engine,
                     Wheel[] wheels, Transmission transmission, CarBody carBody,
                     Double tankCapacity, Double fuelConsumption, Double fuelLevel){
        super(topSpeed, weight, title, engine, wheels, transmission, carBody, tankCapacity, fuelConsumption, fuelLevel);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "CasualCar{\n"+"\tNumber of seats:"+ this.numberOfSeats + "\n" + super.toString() + "\n}";
    }
}
