package fr.edillenseger.mower.instructions;

public enum Orientation {
    //Sorted clockwise
    //Possibility to add others orientation if the sort is respected
    N("North", 0, 1),
    E("East", 1, 0),
    S("South", 0, -1),
    W("West", -1, 0);

    private String label;
    private int incrementX;
    private int incrementY;

    Orientation(String label, int incrementX, int incrementY) {
        this.label = label;
        this.incrementX = incrementX;
        this.incrementY = incrementY;
    }

    public Orientation getLeft() {
        if(this.ordinal() == 0){
            return Orientation.values()[Orientation.values().length - 1];
        }
        return Orientation.values()[this.ordinal() - 1];
    }

    public Orientation getRight() {
        if(this.ordinal() == Orientation.values().length - 1){
            return Orientation.values()[0];
        }
        return Orientation.values()[this.ordinal() + 1];
    }

    public String getLabel() {
        return label;
    }

    public int getIncrementX() {
        return incrementX;
    }

    public int getIncrementY() {
        return incrementY;
    }
}
