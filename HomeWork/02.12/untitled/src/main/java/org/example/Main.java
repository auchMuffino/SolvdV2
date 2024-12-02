package org.example;

import Buildings.*;
import Components.*;
import Vehicles.Cars.Car;
import Vehicles.Cars.CasualCar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
            Car BMW = new CasualCar(5,280,2300d,"BMW X5", new Engine("Cool", 240, 4.4d, FuelTypes.DIESEL),
                    new Wheel[]{new Wheel(28, Seasons.MID_SEASON, WheelTypes.UNIVERSAL),
                            new Wheel(28, Seasons.MID_SEASON, WheelTypes.UNIVERSAL),
                            new Wheel(28, Seasons.MID_SEASON, WheelTypes.UNIVERSAL),
                            new Wheel(28, Seasons.MID_SEASON, WheelTypes.UNIVERSAL)},
                    new Transmission(Transmissions.OFF_ROAD), CarBody.SUV, 70d, 7.5d, 55d);


            BMW.go(735);

            Mechanik vova = new Mechanik();

            if(vova.isBroken(BMW.getEngine())){
                vova.repair(BMW.getEngine());
                System.out.println("1");
            } else if (vova.isBroken(BMW.getTransmission())) {
                vova.repair(BMW.getTransmission());
                System.out.println("2");
            } else {
                vova.say();
            }
            CarWash.cleanCar(BMW);
    }
}