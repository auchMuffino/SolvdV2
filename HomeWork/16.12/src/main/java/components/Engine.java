package components;

import jakarta.xml.bind.annotation.*;
import vehicles.interfaces.Breakable;

import java.util.Objects;

@XmlRootElement(name = "engine")
//@XmlType(propOrder = { "engine_title", "horse_powers", "capacity", "is_broken"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Engine implements Breakable {
    @XmlElement(name = "engine_title")
    private String engineTitle = "";
    @XmlElement(name = "horse_powers")
    private int horsePowers = 0;
    @XmlElement(name = "capacity")
    private double capacity = 0.0d;
    private FuelTypes fuelType = FuelTypes.DIESEL;
    @XmlElement(name = "is_broken")
    private boolean broken = false;


    public Engine(String engineTitle, int horsePowers, double capacity, FuelTypes fuelType) {
        this.engineTitle = engineTitle;
        this.horsePowers = horsePowers;
        this.capacity = capacity;
        this.fuelType = fuelType;
    }
    public Engine() {
    }


    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public int getHorsePowers() {
        return horsePowers;
    }

    public void setHorsePowers(int horsePowers) {
        this.horsePowers = horsePowers;
    }
    //public void setHorsePowers(double horsePowers){}


    public String getEngineTitle() {
        return engineTitle;
    }

    public void setEngineTitle(String engineTitle) {
        this.engineTitle = engineTitle;
    }

    public void setFuelType(FuelTypes fuelType){
        this.fuelType = fuelType;
    }

    public FuelTypes getFuelType(){
        return fuelType;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineTitle='" + engineTitle + '\'' +
                ", horsePowers=" + horsePowers +
                ", capacity=" + capacity +
                ", fuelType=" + fuelType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return horsePowers == engine.horsePowers && Double.compare(capacity, engine.capacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineTitle, horsePowers, capacity, fuelType);
    }

    @Override
    public void breakQ() {
        this.broken = true;
    }

    @Override
    public void breakQ(boolean value) {
        this.broken = value;
    }

    public boolean getBroken(){
        return this.broken;
    }
}
