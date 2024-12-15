package vehicles.interfaces;

import components.Engine;
import vehicles.cars.Car;

public interface ILambda {
    String topSpeed(Car x, Car y);



    default void normalFun()
    {
        System.out.println("Hello");
    }
}
