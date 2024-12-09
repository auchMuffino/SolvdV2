package org.example;

import buildings.*;
import components.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import vehicles.cars.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files

import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
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

        for(Car car: carParking){
            GasStation.refilling(car,100);
        }

//        List<String> dataArr = new ArrayList<String>();
//
//        try {
//            File myObj = new File("src/main/resources/1.txt");
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                dataArr.addAll(List.of(myReader.nextLine().toLowerCase().split("\\W")));
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//        Map<String, Integer> wordsAndCounts = new HashMap<>();
//
//        for(String word: dataArr){
//            if(word.equals("")){
//                continue;
//            }
//            wordsAndCounts.put(word, wordsAndCounts.get(word) != null ?  wordsAndCounts.get(word) + 1: 1);
//        }
//        System.out.println(wordsAndCounts.size());

        UniqueWords w = new UniqueWords("src/main/resources/1.txt");
        System.out.println(w.countOfWords());
    }
}