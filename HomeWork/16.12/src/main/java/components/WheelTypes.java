package components;

import java.util.HashMap;
import java.util.Map;

public enum WheelTypes {
    SPORT(500),
    OFF_ROAD(200),
    UNIVERSAL(170),
    CITY(140);


    private final Double topSpeed;
    private static final Map<Double, WheelTypes> BY_SPEED = new HashMap<>();

    WheelTypes(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    static{
        for (WheelTypes e: values()) {
            BY_SPEED.put(e.topSpeed, e);
        }
    }

    public static WheelTypes valueOfLabel(Double topSpeed) {
        for(WheelTypes wheel : values()){
            if(wheel.topSpeed >= topSpeed){
                return wheel;
            }
        }
        return null;
    }
}
