package components;

import java.util.HashMap;
import java.util.Map;

public enum Transmissions {
    SPORT(CarBody.SPORT),
    CASUAL(CarBody.SEDAN),
    OFF_ROAD(CarBody.OFF_ROAD);


    private final CarBody body;
    private static final Map<CarBody, Transmissions> BY_BODY = new HashMap<>();


    Transmissions(CarBody body) {
        this.body = body;
    }

    static{
        for (Transmissions e: values()) {
            BY_BODY.put(e.body, e);
        }
    }

    public static Transmissions valueOfLabel(CarBody body) {
        return BY_BODY.get(body);
    }
}
