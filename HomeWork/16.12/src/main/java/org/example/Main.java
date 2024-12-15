package org.example;

import buildings.*;
import components.*;
import org.w3c.dom.ls.LSOutput;
import vehicles.cars.*;
import vehicles.interfaces.ILambda;
import vehicles.interfaces.IMove;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

        /*TODO Add 7 collection streaming in the hierarchy with terminal and non-terminal operations.
            Use forEach(Consumer), map(Function), filter(Predicate)
         */

        List<Integer> numbers = Arrays.asList(3, 2, 3, 4, 6, 8, 2, 4, 62, 432);

        numbers = numbers.stream()
                .distinct()
                .map((number) -> number + 1)
                .collect(Collectors.toList());
        carParking = carParking.stream()
                .filter((car) -> car.getFuelLevel() > 100.0)
                .collect(Collectors.toSet());
        parking.forEach((car) -> System.out.println(car));
        System.out.println(carParking);

        ILambda lambda, lambda1;
        lambda = (x, y) -> x.getTopSpeed() > y.getTopSpeed() ? x.getTitle() + " faster than " + y.getTitle() : y.getTitle() + " faster than " + x.getTitle();
        lambda1 = (x, y) -> x.getEngine().getHorsePowers() > y.getEngine().getHorsePowers() ? x.getTitle() + " has more hp than " + y.getTitle() : y.getTitle() + " has more hp than " + x.getTitle();
        for(int i = 1; i < parking.size(); i++){
            System.out.println(lambda.topSpeed(parking.get(i), parking.get(i-1)));
            System.out.println(lambda1.topSpeed(parking.get(i), parking.get(i-1)));
        }

        Comparator<Car> c = (x,y) -> x.getTopSpeed() >= y.getTopSpeed() ? (x.getTopSpeed() == y.getTopSpeed() ? 0 : 1) : -1;

        parking.sort(c);

        Scanner sc = new Scanner(new File("src/main/resources/1.txt"));
        List<String> words = new ArrayList<>();
        while (sc.hasNextLine())
            words.addAll(Arrays.stream(sc.nextLine().toLowerCase().split("\\W")).toList());

        System.out.println(words.stream().distinct().filter((word) -> !word.isEmpty()).peek(System.out::println).count());

        Optional<String> streamm = words.stream().reduce((x, y) -> x + " " + y);
        System.out.println(streamm.get());

        words.stream().skip(10).limit(20).forEach(x -> System.out.println(x));

        Stream<Car> carStream = parking.stream();
        Map<Transmission, List<Car>> phonesByCompany = carStream.collect(
                Collectors.groupingBy(Car::getTransmission));

        for(Map.Entry<Transmission, List<Car>> item : phonesByCompany.entrySet()){

            System.out.println(item.getKey());
            for(Car car : item.getValue()){
                System.out.println((car.getTitle()));
            }
            System.out.println();
        }


        //reflection////////////////////////////////////////////
        //TODO Using reflection extract information(modifiers, return types, parameters, etc) about fields, constructors, methods.
        //            Create object and call method using the only reflection..

        Class<?> carRef = Class.forName("vehicles.cars.CasualCar");
        Method[] carMethods = carRef.getDeclaredMethods();
        Field[] carFields = carRef.getFields();
        Constructor<?>[] carConstructors = carRef.getDeclaredConstructors();

        System.out.println("Car methods:\n");
        Parameter[] params;

        for(Method m : carMethods){
            System.out.println("\tCar method mod->" + m.getModifiers());
            System.out.println("\tCar method return type->" + m.getReturnType());
            System.out.println("\tCar method name->" + m.getName());
            System.out.print("\tCar method parameters->" +m.getParameterTypes()+" "+m.getParameters());
        }

        System.out.println("Car fields:\n");
        for(Field f: carFields){
            System.out.println("\tCar field parameters->"+ f.getModifiers());
            System.out.println("\tCar field type->"+ f.getType());
            System.out.println("\tCar field name->"+ f.getName());
        }

        System.out.println("Car Constructors:\n");
        for(Constructor constructor: carConstructors) {
            System.out.println("\tCar constructor mod->" + constructor.getModifiers());
            System.out.println("\tCar constructor parameters->" + constructor.getParameters());
        }

        Car refCar = (CasualCar) carConstructors[0].newInstance();

        refCar.setCarBody(CarBody.SEDAN);

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