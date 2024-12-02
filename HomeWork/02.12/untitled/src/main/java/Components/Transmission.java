package Components;

import Vehicles.Interfaces.Breakable;

public class Transmission implements Breakable {
    private Transmissions transmissionType = Transmissions.CASUAL;
    private boolean broken = false;

    public Transmission(Transmissions transmissionType){
        this.transmissionType = transmissionType;
    }

    public void setTransmission(Transmissions transmissionType){
        this.transmissionType = transmissionType;
    }
    public Transmissions getTransmission(){
        return transmissionType;
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "transmissionType=" + transmissionType.name() +
                '}';
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
