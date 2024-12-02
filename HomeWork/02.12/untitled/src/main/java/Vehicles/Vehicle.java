package Vehicles;

public abstract class Vehicle{
    Integer topSpeed = null;
    String title = "Untitled";
    Double weight = null;

    public Vehicle(){}

    abstract public void setTopSpeed(Integer topSpeed);

    abstract public void setTitle(String title);

    abstract public void setWeight(Double weight);

    abstract public Integer getTopSpeed();

    abstract public String getTitle();

    abstract public Double getWeight();
}
