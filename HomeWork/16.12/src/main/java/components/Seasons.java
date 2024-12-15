package components;

import java.time.LocalDate;

public enum Seasons {
    WINTER(LocalDate.of(LocalDate.now().getYear(),10,1), LocalDate.of(LocalDate.now().getYear() + 1,3,1)),
    SUMMER(LocalDate.of(LocalDate.now().getYear(),6,1), LocalDate.of(LocalDate.now().getYear(),9,1)),
    MID_SEASON1(LocalDate.of(LocalDate.now().getYear(),9,1), LocalDate.of(LocalDate.now().getYear(),10,1)),
    MID_SEASON2(LocalDate.of(LocalDate.now().getYear(),3,1), LocalDate.of(LocalDate.now().getYear(),6,1));

    private final LocalDate seasonStart;
    private final LocalDate seasonEnd;

    Seasons(LocalDate seasonStart, LocalDate seasonEnd) {
        this.seasonStart = seasonStart;
        this.seasonEnd = seasonEnd;
    }

    public static Seasons valueOfLabel(LocalDate date) {
        for(Seasons seasons : values()){
            if(seasons.seasonStart.isAfter(date) && seasons.seasonEnd.isBefore(date)){
                return seasons;
            }
        }
        return null;
    }

}
