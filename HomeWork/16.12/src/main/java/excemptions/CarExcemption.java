package excemptions;

import vehicles.cars.Car;
import vehicles.cars.CasualCar;

public class CarExcemption extends Exception{
    protected Car carWithExcemptions = null;

    public CarExcemption(){}
    public CarExcemption(String msg){super(msg);}
    public CarExcemption(Car c){this.carWithExcemptions = c;}

    public Car getCarWithExcemptions() {
        return carWithExcemptions;
    }
}
