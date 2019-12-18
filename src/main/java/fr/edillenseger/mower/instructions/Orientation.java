package fr.edillenseger.mower.instructions;

public enum Orientation {
    //Sortering in clockwise
    //Possibility to add others orientation if the sort is respected
    N,E,S,W;

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
}
