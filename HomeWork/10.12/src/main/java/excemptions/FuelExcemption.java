package excemptions;

import Components.FuelTypes;

public class FuelExcemption extends CarExcemption{
    private Double fuelLevel = null;

    public FuelExcemption(){}
    public FuelExcemption(String msg){super(msg);}
    public FuelExcemption(Double fuelLevel){this.fuelLevel = fuelLevel;}

    public Double getFuelLevel() {
        return fuelLevel;
    }
}
