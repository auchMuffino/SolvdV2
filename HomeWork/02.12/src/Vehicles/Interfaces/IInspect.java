package Vehicles.Interfaces;

public interface IInspect {
    default boolean isBroken(Breakable brokenPart){
        if(brokenPart.getBroken()){
            System.out.println("This part is broken and require repair");
            return true;
        } else{
            System.out.println("This part is in good condition, no related problems found");
            return false;
        }
    }
}
