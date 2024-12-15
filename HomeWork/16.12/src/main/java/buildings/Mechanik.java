package buildings;

import vehicles.interfaces.Breakable;
import vehicles.interfaces.IInspect;
import vehicles.interfaces.IRepair;

public final class Mechanik implements IRepair, IInspect {
    @Override
    public void repair(Breakable brokenPart) {
        brokenPart.breakQ(false);
    }
    public void say(){
        System.out.println("Ya bl ne znau 4to s etoi X ne tak");
    }
}
