package components;

import java.util.*;

public enum CarBody {
    SUV("Sport utility vehicle"),
    SEDAN("Sedan"),
    CROSSOVER("CrossOver"),
    COUPE("Coupe"),
    MICRO("Micro"),
    HATCHBACK("Hatch Back"),
    OFF_ROAD("Off road"),
    PICK_UP("Pick up"),
    WAGON("Wagon"),
    VAN("Kidnappers car"),
    LIMOUSINE("Limo"),
    SPORT("Basketball");


    private static final Map<String, CarBody> BY_TITLE = new HashMap<>();
    private final String title;


    CarBody(String title) {
        this.title = title;
    }

    static{
        for (CarBody e: values()) {
            BY_TITLE.put(e.title, e);
        }
    }

    public static CarBody valueOfLabel(String title) {
        return BY_TITLE.get(title);
    }

}
