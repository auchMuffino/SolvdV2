package Buildings;

import Vehicles.Cars.*;

public class CarWash {
    public static void cleanCar(Car car) throws InterruptedException {
        System.out.println("Perform cleaning ------------->");
        for(int i = 0; i<10; i++){
            System.out.println("<--***-->");
            Thread.sleep(100);
        }
        System.out.println("Car clean!");
    }
}
