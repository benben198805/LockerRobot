package LockerRobot;

public enum BoxSize {
    SIZE_S("S"), SIZE_L("L"), SIZE_M("M");
    private String value;

    public String getValue() {
        return value;
    }

    BoxSize(String value) {
        this.value = value;
    }
}