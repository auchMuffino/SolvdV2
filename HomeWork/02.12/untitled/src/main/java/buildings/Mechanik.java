package buildings;

import vehicles.Interfaces.Breakable;
import vehicles.Interfaces.IInspect;
import vehicles.Interfaces.IRepair;

public final class Mechanik implements IRepair, IInspect {
    @Override
    public void repair(Breakable brokenPart) {
        brokenPart.breakQ(false);
    }
    public void say(){
        System.out.println("Ya bl ne znau 4to s etoi X ne tak");
    }
}
