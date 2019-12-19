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
        return this.ordinal() == 0 ? Orientation.get(Orientation.size() - 1) : Orientation.get(this.ordinal() - 1);
    }

    public Orientation getRight() {
        return this.ordinal() == Orientation.size() - 1 ? Orientation.get(0) : Orientation.get(this.ordinal() + 1);
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

    private static int size(){
        return Orientation.values().length;
    }

    private static Orientation get(int ordinal){
        return Orientation.values()[ordinal];
    }
}
