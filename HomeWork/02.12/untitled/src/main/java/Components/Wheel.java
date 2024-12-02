package Components;

public class Wheel {
    private WheelTypes type;
    private int ratio = 0;
    private Seasons season = Seasons.MID_SEASON;

    public Wheel(int ratio, Seasons season, WheelTypes type) {
        this.ratio = ratio;
        this.season = season;
        this.type = type;
    }


    public Seasons getSeason() {
        return season;
    }

    public WheelTypes getType() {
        return type;
    }

    public void setType(WheelTypes type) {
        this.type = type;
    }

    public void setSeason(Seasons season) {
        this.season = season;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "\n\tratio=" + ratio +
                ",\n\tseason=" + season.name() +
                ",\n\ttype=" + this.type.name() +
                "\n}";
    }
}
