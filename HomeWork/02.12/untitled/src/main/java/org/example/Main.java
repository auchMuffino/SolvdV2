package org.example;

import buildings.*;
import components.*;
import vehicles.Cars.Car;
import vehicles.Cars.CasualCar;

import java.util.*;

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


        List<Car> parking = new ArrayList<Car>();
        Random rnd1 = new Random(47);
        for(int i = 0; i < 10; i++){
            parking.add(new CasualCar(rnd1.nextInt(1,8), rnd1.nextInt(100,400), 2300d,"Car "+i, new Engine("Cool" + i, rnd1.nextInt(50, 800), rnd1.nextDouble(0.3, 12.0), FuelTypes.DIESEL),
                    new Wheel[]{new Wheel(28, Seasons.MID_SEASON, WheelTypes.UNIVERSAL),
                            new Wheel(28, Seasons.MID_SEASON, WheelTypes.UNIVERSAL),
                            new Wheel(28, Seasons.MID_SEASON, WheelTypes.UNIVERSAL),
                            new Wheel(28, Seasons.MID_SEASON, WheelTypes.UNIVERSAL)},
                    new Transmission(Transmissions.OFF_ROAD), CarBody.SUV, 70d, 7.5d, rnd1.nextDouble(0,250)
                    )
            );
        }

        Set<CasualCar> carParking = new HashSet<>();

        for(int i = 0; i < 10; i++){
            carParking.add(new CasualCar(rnd1.nextInt(1,8), rnd1.nextInt(100,400), 2300d,"Car "+i, new Engine("Cool" + i, rnd1.nextInt(50, 800), rnd1.nextDouble(0.3, 12.0), FuelTypes.DIESEL),
                            new Wheel[]{new Wheel(28, Seasons.MID_SEASON, WheelTypes.UNIVERSAL),
                                    new Wheel(28, Seasons.MID_SEASON, WheelTypes.UNIVERSAL),
                                    new Wheel(28, Seasons.MID_SEASON, WheelTypes.UNIVERSAL),
                                    new Wheel(28, Seasons.MID_SEASON, WheelTypes.UNIVERSAL)},
                            new Transmission(Transmissions.OFF_ROAD), CarBody.SUV, 70d, 7.5d, rnd1.nextDouble(0,250)
                    )
            );
        }

        System.out.println(carParking.size());

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