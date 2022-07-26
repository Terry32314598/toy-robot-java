package unitTest;

import exception.InvalidDirectionException;
import model.Direction;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Assertions;

public class DirectionTest {

    @Test
    void translateToStringDirectionTest(){
       assertThat( Direction.translateToStringDirection(0),is("SOUTH"));
       assertThat( Direction.translateToStringDirection(1),is("WEST"));
       assertThat( Direction.translateToStringDirection(2),is("NORTH"));
       assertThat( Direction.translateToStringDirection(3),is("EAST"));
       Assertions.assertThrows(InvalidDirectionException.class,()->  Direction.translateToStringDirection(4));
    }


    @Test
    void translateFromStringTest(){
        assertThat( Direction.translateFromString("SOUTH"),is(0));
        assertThat( Direction.translateFromString("WEST"),is(1));
        assertThat( Direction.translateFromString("NORTH"),is(2));
        assertThat( Direction.translateFromString("EAST"),is(3));
        Assertions.assertThrows(InvalidDirectionException.class,()->  Direction.translateFromString("InvalidDirection"));
    }

    @Test
    void turningTest(){
        Direction direction = Direction.builder().aspect(0).build();
        direction.turnRight();
        assertThat(direction.getAspect(),is(1));
        direction.turnRight();
        assertThat(direction.getAspect(),is(2));
        direction.turnRight();
        assertThat(direction.getAspect(),is(3));
        direction.turnRight();
        assertThat(direction.getAspect(),is(0));
        direction.turnLeft();
        assertThat(direction.getAspect(),is(3));
        direction.turnLeft();
        assertThat(direction.getAspect(),is(2));
        direction.turnLeft();
        assertThat(direction.getAspect(),is(1));
        direction.turnLeft();
        assertThat(direction.getAspect(),is(0));
    }
}
