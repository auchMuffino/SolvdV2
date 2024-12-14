package org.example;

import buildings.*;
import components.*;
import vehicles.cars.*;
import vehicles.interfaces.ILambda;
import vehicles.interfaces.IMove;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
            Car BMW = new CasualCar(5,280,2300d,"BMW X5", new Engine("Cool", 240, 4.4d, FuelTypes.DIESEL),
                    new Wheel[]{new Wheel(28, Seasons.MID_SEASON1, WheelTypes.UNIVERSAL),
                            new Wheel(28, Seasons.MID_SEASON2, WheelTypes.UNIVERSAL),
                            new Wheel(28, Seasons.MID_SEASON2, WheelTypes.UNIVERSAL),
                            new Wheel(28, Seasons.MID_SEASON1, WheelTypes.UNIVERSAL)},
                    new Transmission(Transmissions.OFF_ROAD), CarBody.SUV, 70d, 7.5d, 55d);


            BMW.go(735);

            Mechanik vova = new Mechanik();


        List<Car> parking = new ArrayList<Car>();
        Random rnd1 = new Random(47);
        for(int i = 0; i < 10; i++){
            parking.add(new CasualCar(rnd1.nextInt(1,8), rnd1.nextInt(100,400), 2300d,"Car "+i, new Engine("Cool" + i, rnd1.nextInt(50, 800), rnd1.nextDouble(0.3, 12.0), FuelTypes.DIESEL),
                    new Wheel[]{new Wheel(28, Seasons.MID_SEASON1, WheelTypes.UNIVERSAL),
                            new Wheel(28, Seasons.MID_SEASON2, WheelTypes.UNIVERSAL),
                            new Wheel(28, Seasons.MID_SEASON2, WheelTypes.UNIVERSAL),
                            new Wheel(28, Seasons.MID_SEASON1, WheelTypes.UNIVERSAL)},
                    new Transmission(Transmissions.OFF_ROAD), CarBody.SUV, 70d, 7.5d, rnd1.nextDouble(0,250)
                    )
            );
        }

        Set<CasualCar> carParking = new HashSet<>();

        for(int i = 0; i < 10; i++){
            carParking.add(new CasualCar(rnd1.nextInt(1,8), rnd1.nextInt(100,400), 2300d,"Car "+i, new Engine("Cool" + i, rnd1.nextInt(50, 800), rnd1.nextDouble(0.3, 12.0), FuelTypes.DIESEL),
                            new Wheel[]{new Wheel(28, Seasons.MID_SEASON1, WheelTypes.UNIVERSAL),
                                    new Wheel(28, Seasons.MID_SEASON2, WheelTypes.UNIVERSAL),
                                    new Wheel(28, Seasons.MID_SEASON2, WheelTypes.UNIVERSAL),
                                    new Wheel(28, Seasons.MID_SEASON1, WheelTypes.UNIVERSAL)},
                            new Transmission(Transmissions.OFF_ROAD), CarBody.SUV, 70d, 7.5d, rnd1.nextDouble(0,250)
                    )
            );
        }

        for(Car car: carParking){
            GasStation.refilling(car,100);
        }

        /*TODO Create 3 custom Lambda functions with generics.
           Create 5 complex Enums(with fields, methods, blocks).] (I'll just change my existing enums)
           Create 3 custom Lambda functions with generics.
         */
        ILambda lambda, lambda1;
        lambda = (x, y) -> x.getTopSpeed() > y.getTopSpeed() ? x.getTitle() + " faster than " + y.getTitle() : y.getTitle() + " faster than " + x.getTitle();
        lambda1 = (x, y) -> x.getEngine().getHorsePowers() > y.getEngine().getHorsePowers() ? x.getTitle() + " has more hp than " + y.getTitle() : y.getTitle() + " has more hp than " + x.getTitle();
        for(int i = 1; i < parking.size(); i++){
            System.out.println(lambda.topSpeed(parking.get(i), parking.get(i-1)));
            System.out.println(lambda1.topSpeed(parking.get(i), parking.get(i-1)));
        }

        Comparator<Car> c = (x,y) -> x.getTopSpeed() >= y.getTopSpeed() ? (x.getTopSpeed() == y.getTopSpeed() ? 0 : 1) : -1;

        parking.sort(c);

        System.out.println(parking);
        /* previous HomeWork does not required for hierarchy
          List<String> dataArr = new ArrayList<String>();

        try {
            File myObj = new File("src/main/resources/1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                dataArr.addAll(List.of(myReader.nextLine().toLowerCase().split("\\W")));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Map<String, Integer> wordsAndCounts = new HashMap<>();

        for(String word: dataArr){
            if(word.equals("")){
                continue;
            }
            wordsAndCounts.put(word, wordsAndCounts.get(word) != null ?  wordsAndCounts.get(word) + 1: 1);
        }
        System.out.println(wordsAndCounts.size());


        UniqueWords w = new UniqueWords("src/main/resources/1.txt");
        System.out.println(w.countOfWords());
        */
    }
}