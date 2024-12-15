package excemptions;

import components.FuelTypes;

public class WrongFuelTypeExcemption extends CarExcemption{
    private FuelTypes fType = null;

    public WrongFuelTypeExcemption(){}
    public WrongFuelTypeExcemption(String msg){super(msg);}
    public WrongFuelTypeExcemption(FuelTypes fType){this.fType = fType;}

    public FuelTypes getfType() {
        return fType;
    }
}
