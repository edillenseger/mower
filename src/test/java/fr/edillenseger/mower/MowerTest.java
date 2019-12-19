package fr.edillenseger.mower;

import fr.edillenseger.mower.instructions.Coordinates;
import fr.edillenseger.mower.instructions.Mower;
import fr.edillenseger.mower.instructions.Orientation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MowerTest {

    @Test
    public void should_turn_left(){
        Mower mower = new Mower(new Coordinates(1, 1), Orientation.N);
        mower.turnLeft();
        Assertions.assertEquals(1, mower.getCoordinates().getX());
        Assertions.assertEquals(1, mower.getCoordinates().getY());
        Assertions.assertEquals(Orientation.W, mower.getOrientation());
    }

    @Test
    public void should_turn_right(){
        Mower mower = new Mower(new Coordinates(1, 1), Orientation.N);
        mower.turnRight();
        Assertions.assertEquals(1, mower.getCoordinates().getX());
        Assertions.assertEquals(1, mower.getCoordinates().getY());
        Assertions.assertEquals(Orientation.E, mower.getOrientation());
    }

    @Test
    public void should_move_forward(){
        Mower mower = new Mower(new Coordinates(1, 1), Orientation.N);
        mower.moveForward(new Coordinates(5, 5));
        Assertions.assertEquals(1, mower.getCoordinates().getX());
        Assertions.assertEquals(2, mower.getCoordinates().getY());
        Assertions.assertEquals(Orientation.N, mower.getOrientation());
    }

    @Test
    public void should_not_move_forward_if_moving_is_outside_the_max_coordinates(){
        Mower mower = new Mower(new Coordinates(1, 5), Orientation.N);
        mower.moveForward(new Coordinates(5, 5));
        Assertions.assertEquals(1, mower.getCoordinates().getX());
        Assertions.assertEquals(5, mower.getCoordinates().getY());
        Assertions.assertEquals(Orientation.N, mower.getOrientation());
    }
}
