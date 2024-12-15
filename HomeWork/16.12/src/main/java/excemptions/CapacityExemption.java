package excemptions;

import vehicles.cars.Car;

public class CapacityExemption extends CarExcemption{
    public CapacityExemption(){}
    public CapacityExemption(String msg){super(msg);}
    public CapacityExemption(Car car){super(car);}
}
