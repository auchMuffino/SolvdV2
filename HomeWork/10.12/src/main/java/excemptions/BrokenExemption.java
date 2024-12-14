package excemptions;

import Components.Engine;
import Components.Transmission;
import Vehicles.Cars.Car;

public class BrokenExemption extends CarExcemption{
    private Engine brokenEngine = null;
    private Transmission brokenTransmission = null;

    public BrokenExemption(){}
    public BrokenExemption(String msg){super(msg);}
    public BrokenExemption(Car car){super(car); this.brokenEngine = car.getEngine();}
    public BrokenExemption(Engine brokenEngine){this.brokenEngine = brokenEngine;}
    public BrokenExemption(Transmission brokenTransmission){this.brokenTransmission = brokenTransmission;}

    public Engine getBrokenEngine() {
        return brokenEngine;
    }
    public Transmission getBrokenTransmission(){
        return brokenTransmission;
    }
}
