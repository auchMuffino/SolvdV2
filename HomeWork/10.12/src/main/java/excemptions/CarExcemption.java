package excemptions;

import Vehicles.Cars.Car;
import Vehicles.Cars.CasualCar;

public class CarExcemption extends Exception{
    protected Car carWithExcemptions = null;

    public CarExcemption(){}
    public CarExcemption(String msg){super(msg);}
    public CarExcemption(Car c){this.carWithExcemptions = c;}

    public Car getCarWithExcemptions() {
        return carWithExcemptions;
    }
}
