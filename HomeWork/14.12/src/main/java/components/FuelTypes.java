package components;

import java.util.HashMap;
import java.util.Map;

public enum FuelTypes {
    DIESEL(320d),
    GAS(300d),
    PETROL(470d),
    ELECTRICITY(420d);

    private final Double topSpeed;
    private static final Map<Double, FuelTypes> BY_SPEED = new HashMap<>();

    FuelTypes(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    static{
        for (FuelTypes e: values()) {
            BY_SPEED.put(e.topSpeed, e);
        }
    }

    public static FuelTypes valueOfLabel(Double topSpeed) {
        return BY_SPEED.get(topSpeed);
    }

}
