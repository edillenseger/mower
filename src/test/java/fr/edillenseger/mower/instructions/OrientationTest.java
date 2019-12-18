package fr.edillenseger.mower.instructions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrientationTest {

    @Test
    public void should_return_north_as_left_orientation_of_east(){
        Assertions.assertEquals(Orientation.N, Orientation.E.getLeft());
    }

    @Test
    public void should_return_west_as_left_orientation_of_north(){
        Assertions.assertEquals(Orientation.W, Orientation.N.getLeft());
    }

    @Test
    public void should_return_south_as_left_orientation_of_west(){
        Assertions.assertEquals(Orientation.S, Orientation.W.getLeft());
    }

    @Test
    public void should_return_east_as_left_orientation_of_south(){
        Assertions.assertEquals(Orientation.E, Orientation.S.getLeft());
    }

    @Test
    public void should_return_north_as_right_orientation_of_west(){
        Assertions.assertEquals(Orientation.N, Orientation.W.getRight());
    }

    @Test
    public void should_return_west_as_right_orientation_of_south(){
        Assertions.assertEquals(Orientation.W, Orientation.S.getRight());
    }

    @Test
    public void should_return_south_as_right_orientation_of_east(){
        Assertions.assertEquals(Orientation.S, Orientation.E.getRight());
    }

    @Test
    public void should_return_east_as_right_orientation_of_north(){
        Assertions.assertEquals(Orientation.E, Orientation.N.getRight());
    }
}