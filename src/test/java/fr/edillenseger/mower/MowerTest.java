package fr.edillenseger.mower;

import fr.edillenseger.mower.instructions.Coordinates;
import fr.edillenseger.mower.instructions.Orientation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MowerTest {

    @Test
    public void should_turn_left_mower(){
        Mower mower = new Mower();
        mower.coordinates = new Coordinates(1, 1);
        mower.orientation = Orientation.N;
        mower.turnLeft();
        Assertions.assertEquals(1, mower.coordinates.x);
        Assertions.assertEquals(1, mower.coordinates.y);
        Assertions.assertEquals(Orientation.W, mower.orientation);
    }

    @Test
    public void should_turn_right_mower(){
        Mower mower = new Mower();
        mower.coordinates = new Coordinates(1, 1);
        mower.orientation = Orientation.N;
        mower.turnRight();
        Assertions.assertEquals(1, mower.coordinates.x);
        Assertions.assertEquals(1, mower.coordinates.y);
        Assertions.assertEquals(Orientation.E, mower.orientation);
    }

    @Test
    @Disabled("TODO Implements methods")
    public void should_move_forward(){
        Mower mower = new Mower();
        mower.coordinates = new Coordinates(1, 1);
        mower.orientation = Orientation.N;
        mower.turnLeft();
        Assertions.assertEquals(1, mower.coordinates.x);
        Assertions.assertEquals(2, mower.coordinates.y);
        Assertions.assertEquals(Orientation.N, mower.orientation);
    }
}
