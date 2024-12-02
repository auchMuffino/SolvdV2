package Components;

import java.util.Objects;

public class Motor {
    private String motorTitle = "";
    private int horsePowers = 0;
    private double capacity = 0.0d;


    public Motor(String motorTitle, int horsePowers, double capacity) {
        this.motorTitle = motorTitle;
        this.horsePowers = horsePowers;
        this.capacity = capacity;
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
    public void setHorsePowers(double horsePowers){}


    public String getMotorTitle() {
        return motorTitle;
    }

    public void setEngineTitle(String engineTitle) {
        this.motorTitle = engineTitle;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineTitle='" + motorTitle + '\'' +
                ", horsePowers=" + horsePowers +
                ", capacity=" + capacity +
                '}';
    }
}
