package fr.edillenseger.mower;

import fr.edillenseger.mower.instructions.Coordinates;
import fr.edillenseger.mower.instructions.Orientation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MowerTest {

    @Test
    public void should_turn_left_mower(){
        Mower mower = new Mower(new Coordinates(1, 1), Orientation.N);
        mower.turnLeft();
        Assertions.assertEquals(1, mower.coordinates.x);
        Assertions.assertEquals(1, mower.coordinates.y);
        Assertions.assertEquals(Orientation.W, mower.orientation);
    }

    @Test
    public void should_turn_right_mower(){
        Mower mower = new Mower(new Coordinates(1, 1), Orientation.N);
        mower.turnRight();
        Assertions.assertEquals(1, mower.coordinates.x);
        Assertions.assertEquals(1, mower.coordinates.y);
        Assertions.assertEquals(Orientation.E, mower.orientation);
    }

    @Test
    public void should_move_forward_to_the_north(){
        Mower mower = new Mower(new Coordinates(1, 1), Orientation.N);
        mower.forward(new Coordinates(5, 5));
        Assertions.assertEquals(1, mower.coordinates.x);
        Assertions.assertEquals(2, mower.coordinates.y);
        Assertions.assertEquals(Orientation.N, mower.orientation);
    }

    @Test
    public void should_move_forward_to_the_south(){
        Mower mower = new Mower(new Coordinates(1, 1), Orientation.S);
        mower.forward(new Coordinates(5, 5));
        Assertions.assertEquals(1, mower.coordinates.x);
        Assertions.assertEquals(0, mower.coordinates.y);
        Assertions.assertEquals(Orientation.S, mower.orientation);
    }

    @Test
    public void should_move_forward_to_the_west(){
        Mower mower = new Mower(new Coordinates(1, 1), Orientation.W);
        mower.forward(new Coordinates(5, 5));
        Assertions.assertEquals(0, mower.coordinates.x);
        Assertions.assertEquals(1, mower.coordinates.y);
        Assertions.assertEquals(Orientation.W, mower.orientation);
    }

    @Test
    public void should_move_forward_to_the_east(){
        Mower mower = new Mower(new Coordinates(1, 1), Orientation.E);
        mower.forward(new Coordinates(5, 5));
        Assertions.assertEquals(2, mower.coordinates.x);
        Assertions.assertEquals(1, mower.coordinates.y);
        Assertions.assertEquals(Orientation.E, mower.orientation);
    }

    @Test
    public void should_not_move_forward_if_moving_is_outside_the_max_coordinates(){
        Mower mower = new Mower(new Coordinates(1, 5), Orientation.N);
        mower.forward(new Coordinates(5, 5));
        Assertions.assertEquals(1, mower.coordinates.x);
        Assertions.assertEquals(5, mower.coordinates.y);
        Assertions.assertEquals(Orientation.N, mower.orientation);
    }
}
