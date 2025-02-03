package org.example;

public enum Banknote {
    MIN(100),
    MEAN(500),
    MAX(1000),
    ;

    private final int value;

    Banknote(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
