package Vehicles.Cars;

import Components.*;
import Vehicles.Interfaces.IMove;
import Vehicles.Vehicle;

import java.util.Arrays;

public abstract class Car extends Vehicle implements IMove {
    protected Integer topSpeed;
    protected Double weight;
    protected String title;
    protected Engine engine;
    protected Wheel[] wheels;
    protected Transmission transmission;
    protected CarBody carBody;
    protected Double tankCapacity;
    protected Double fuelConsumption;
    protected Double fuelLevel;

    protected static int numberOfCars=0;

    static {
        System.out.println("Current number of cars:" + numberOfCars);
    }

    public Car(){
        numberOfCars++;
    }

    public Car(Integer topSpeed, Double weight, String title, Engine engine,
               Wheel[] wheels, Transmission transmission, CarBody carBody,
               Double tankCapacity, Double fuelConsumption, Double fuelLevel) {

        setTopSpeed(topSpeed);
        setWeight(weight);
        setTitle(title);
        setEngine(engine);
        setTransmission(transmission);
        setCarBody(carBody);
        setTankCapacity(tankCapacity);
        setFuelConsumption(fuelConsumption);
        setFuelLevel(fuelLevel);
        setWheels(wheels);
        numberOfCars++;
    }

    @Override
    public void setTopSpeed(Integer topSpeed){
        if(topSpeed > 0)
            this.topSpeed = topSpeed;
    }

    @Override
    public void setTitle(String title){
        if(!title.isEmpty())
            this.title = title;
    }

    @Override
    public void setWeight(Double weight){
        if(weight > 0.d)
            this.weight = weight;
    }

    public final void setEngine(Engine engine){
        this.engine = engine;
    }

    public final void setWheels(Wheel[] wheels){
        this.wheels = new Wheel[wheels.length];
        System.arraycopy(wheels, 0, this.wheels, 0, wheels.length);
    }

    public final void setCarBody(CarBody carBody) {
        this.carBody = carBody;
    }

    public final void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public final void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public final void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public final void setFuelLevel(double fuelLevel){
        this.fuelLevel = fuelLevel;
    }

    @Override
    public Integer getTopSpeed(){
        return this.topSpeed;
    }

    @Override
    public String getTitle(){
        return this.title;
    }

    @Override
    public Double getWeight(){
        return this.weight;
    }

    public final Transmission getTransmission() {
        return transmission;
    }

    public final CarBody getCarBody() {
        return carBody;
    }

    public final Double getFuelConsumption() {
        return fuelConsumption;
    }

    public final Double getTankCapacity() {
        return tankCapacity;
    }

    public final Engine getEngine() {
        return engine;
    }

    public final Wheel[] getWheels() {
        return wheels;
    }

    public final Double getFuelLevel() {
        return fuelLevel;
    }

    public void go(int kms) {
        if(this.engine.getBroken() || this.transmission.getBroken()){
            System.out.println("You cant go because some parts of your car are broken");
        } else {
            if ((fuelLevel - (kms * 0.01) * this.fuelConsumption) < 0) {
                System.out.println("Not enough fuel, you should go to gestation first for this trip");
            } else {
                this.fuelLevel -= (kms * 0.01) * this.fuelConsumption;
                System.out.println("Great trip! Current fuel level: " + this.fuelLevel + "L");
            }
        }
    }

    @Override
    public String toString(){
        return "Car{\n" +
                "\tTitle: " + this.title + ",\n" +
                "\tTop Speed: " + this.topSpeed + ",\n" +
                "\tWeight: " + this.weight + ",\n" +
                "\tBody: " + this.carBody.name() + ",\n" +
                "\tTank Capacity: " + this.tankCapacity + ",\n" +
                "\tFuel Consumption" + this.fuelConsumption + ",\n" +
                "\tEngine: " + this.engine + ",\n" +
                "\tWheels{\n" + "\t" + Arrays.toString(this.wheels) + "\n}\n" +
                "\tTransmission: " +this.transmission+",\n" +
                "\tCurrent Fuel Level: "+ this.fuelLevel + "\n" +
                "}";
    }


}
