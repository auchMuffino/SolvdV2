package org.example;

import buildings.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import components.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.dao.jdbc.CarDAO;
import org.databases.DBCPDataSource;
import org.threads.MyThread;
import org.threads.MyThread2;
import org.w3c.dom.ls.LSOutput;
import vehicles.cars.*;
import vehicles.interfaces.ILambda;
import vehicles.interfaces.IMove;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, SQLException, XMLStreamException, JAXBException {
        Car BMW = new CasualCar(5, 280, 2300d, "BMW X5", new Engine("Cool", 240, 4.4d, FuelTypes.DIESEL),
                new Wheel[]{new Wheel(28, Seasons.MID_SEASON1, WheelTypes.UNIVERSAL),
                        new Wheel(28, Seasons.MID_SEASON2, WheelTypes.UNIVERSAL),
                        new Wheel(28, Seasons.MID_SEASON2, WheelTypes.UNIVERSAL),
                        new Wheel(28, Seasons.MID_SEASON1, WheelTypes.UNIVERSAL)},
                new Transmission(Transmissions.OFF_ROAD), CarBody.SUV, 70d, 7.5d, 55d);


        BMW.go(735);

        Mechanik vova = new Mechanik();


        List<Car> parking = new ArrayList<Car>();
        Random rnd1 = new Random(47);
        for (int i = 0; i < 10; i++) {
            parking.add(new CasualCar(rnd1.nextInt(1, 8), rnd1.nextInt(100, 400), 2300d, "Car " + i, new Engine("Cool" + i, rnd1.nextInt(50, 800), rnd1.nextDouble(0.3, 12.0), FuelTypes.DIESEL),
                            new Wheel[]{new Wheel(28, Seasons.MID_SEASON1, WheelTypes.UNIVERSAL),
                                    new Wheel(28, Seasons.MID_SEASON2, WheelTypes.UNIVERSAL),
                                    new Wheel(28, Seasons.MID_SEASON2, WheelTypes.UNIVERSAL),
                                    new Wheel(28, Seasons.MID_SEASON1, WheelTypes.UNIVERSAL)},
                            new Transmission(Transmissions.OFF_ROAD), CarBody.SUV, 70d, 7.5d, rnd1.nextDouble(0, 250)
                    )
            );
        }

        Set<CasualCar> carParking = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            carParking.add(new CasualCar(rnd1.nextInt(1, 8), rnd1.nextInt(100, 400), 2300d, "Car " + i, new Engine("Cool" + i, rnd1.nextInt(50, 800), rnd1.nextDouble(0.3, 12.0), FuelTypes.DIESEL),
                            new Wheel[]{new Wheel(28, Seasons.MID_SEASON1, WheelTypes.UNIVERSAL),
                                    new Wheel(28, Seasons.MID_SEASON2, WheelTypes.UNIVERSAL),
                                    new Wheel(28, Seasons.MID_SEASON2, WheelTypes.UNIVERSAL),
                                    new Wheel(28, Seasons.MID_SEASON1, WheelTypes.UNIVERSAL)},
                            new Transmission(Transmissions.OFF_ROAD), CarBody.SUV, 70d, 7.5d, rnd1.nextDouble(0, 250)
                    )
            );
        }

        for (Car car : carParking) {
            GasStation.refilling(car, 100);
        }

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
        for (int i = 1; i < parking.size(); i++) {
            System.out.println(lambda.topSpeed(parking.get(i), parking.get(i - 1)));
            System.out.println(lambda1.topSpeed(parking.get(i), parking.get(i - 1)));
        }

        Comparator<Car> c = (x, y) -> x.getTopSpeed() >= y.getTopSpeed() ? (x.getTopSpeed() == y.getTopSpeed() ? 0 : 1) : -1;

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

        for (Map.Entry<Transmission, List<Car>> item : phonesByCompany.entrySet()) {

            System.out.println(item.getKey());
            for (Car car : item.getValue()) {
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

        for (Method m : carMethods) {
            System.out.println("\tCar method mod->" + m.getModifiers());
            System.out.println("\tCar method return type->" + m.getReturnType());
            System.out.println("\tCar method name->" + m.getName());
            System.out.print("\tCar method parameters->" + m.getParameterTypes() + " " + m.getParameters());
        }

        System.out.println("Car fields:\n");
        for (Field f : carFields) {
            System.out.println("\tCar field parameters->" + f.getModifiers());
            System.out.println("\tCar field type->" + f.getType());
            System.out.println("\tCar field name->" + f.getName());
        }

        System.out.println("Car Constructors:\n");
        for (Constructor constructor : carConstructors) {
            System.out.println("\tCar constructor mod->" + constructor.getModifiers());
            System.out.println("\tCar constructor parameters->" + constructor.getParameters());
        }

        Car refCar = (CasualCar) carConstructors[0].newInstance();

        refCar.setCarBody(CarBody.SEDAN);
        // TODO
//        Read the following articles:
//        Threads, Connection Pool
//        Future, CompletionStage and CompletableFuture java docs
//        Create 2 Threads using Runnable and Thread.
//                Questions for the exam that must be covered in this lecture.

//!        Connection con = DBCPDataSource.getConnection();
//!        con.beginRequest();

//        CarDAO cd = new CarDAO();
//        List<Car> c1 = cd.getEntities();
//        System.out.println(c1);

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("test.xml"));
        Car xcar = new CasualCar();

        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case "title":
                        Attribute url = startElement.getAttributeByName(new QName("title"));
                        if (url != null) {
                            xcar.setTitle(url.getValue());
                        }
                        break;
                    case "top_speed":
                        nextEvent = reader.nextEvent();
                        xcar.setTopSpeed(Integer.valueOf(nextEvent.asCharacters().getData()));
                        break;
                    case "weight":
                        nextEvent = reader.nextEvent();
                        xcar.setWeight(Double.valueOf(nextEvent.asCharacters().getData()));
                        break;
                }
            }
            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
            }

            System.out.println(xcar);
        }

        Car book = new CasualCar();
        book.setWeight(200.0);
        book.setTitle("Book1");
        book.setEngine(new Engine("Cool", rnd1.nextInt(50, 800), rnd1.nextDouble(0.3, 12.0), FuelTypes.DIESEL));
        book.setFuelLevel(2.0);
        book.setFuelConsumption(2.0);
        book.setTankCapacity(20.);


        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(book, new File("./book.xml"));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./car1.json"), BMW);
        Car car = objectMapper.readValue(new File("./car1.json"), CasualCar.class);
        System.out.println(car);
    }
}