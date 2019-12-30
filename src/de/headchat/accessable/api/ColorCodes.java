package de.headchat.accessable.api;

public enum ColorCodes {
    GREEN_SOFT(85, 255, 85, "a"), BRAUN(165, 96, 36, "0"), BLUE_SOFT(85, 255, 255, "b"), BLUE(0, 0, 170, "1"), RED_SOFT(255, 85, 85, "c"), GREEN(0, 170, 0, "2"),
    PINK(255, 85, 255, "d"), TURKIS(0, 170, 170, "3"), YELLOW(255, 255, 85, "e"), RED(170, 0, 0, "4"), WHITE(255, 255, 255, "f"), PURPLE(170, 170, 0, "5"), ORANGE(255, 165, 0, "6"), SILVER(170, 170, 170, "7"), GRAY(85, 85, 85, "8"), SEA_BLUE(85, 85, 255, "9"),BLACK(0, 0, 0, "0"), HAUTFARBE(238,207,180, "f"), HELL_BRAUN(200,160,87,"6");

    int r;
    int g;
    int b;
    String c;

    ColorCodes(int r, int g, int b, String code) {
        this.r = r;
        this.g = g;
        this.b = b;
        c = code;
    }
    
    

    protected String getC() {
        return c;
    }

    protected void setC(String c) {
        this.c = c;
    }

    protected int getB() {
        return b;
    }

    protected int getG() {
        return g;
    }

    protected int getR() {
        return r;
    }

    protected void setB(int b) {
        this.b = b;
    }

    protected void setG(int g) {
        this.g = g;
    }

    protected void setR(int r) {
        this.r = r;
    }
}


