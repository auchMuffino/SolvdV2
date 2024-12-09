package buildings;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.Main;
import vehicles.cars.Car;

public final class GasStation {
    private static final Logger LOGGER = LogManager.getLogger(GasStation.class.getName());
    public static void refilling(Car car, double value) throws InterruptedException {
        if((car.getFuelLevel() + value) > car.getTankCapacity()){
            LOGGER.info("Not enough capacity in car tank");
            System.out.println("GasStation: Your tank will be overloaded with " + ((car.getFuelLevel() + value) - car.getTankCapacity()) + "L of fuel");
        } else{
            System.out.println("Perform filling ------------->");
            for(int i = 0; i<10; i++){
                System.out.println("<--***-->");
                Thread.sleep(100);
            }
            car.setFuelLevel(car.getFuelLevel() + value);
            System.out.println("Car filled");
        }
    }
}
