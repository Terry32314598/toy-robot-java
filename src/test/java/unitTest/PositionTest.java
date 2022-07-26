package unitTest;

import model.Position;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PositionTest {


    @Test
    void moveRightAlongXcoordinatesTest(){
        Position position  = new Position(2,2);
        position.moveRightAlongXcoordinates();
        assertThat(position.getX(),is(3));
        assertThat(position.getY(),is(2));
    }

    @Test
    void moveLeftAlongXcoordinatesTest(){
        Position position  = new Position(2,2);
        position.moveLeftAlongXcoordinates();
        assertThat(position.getX(),is(1));
        assertThat(position.getY(),is(2));
    }

    @Test
    void moveUpAlongYcoordinatesTest(){
        Position position  = new Position(2,2);
        position.moveUpAlongYcoordinates();
        assertThat(position.getX(),is(2));
        assertThat(position.getY(),is(3));
    }

    @Test
    void moveDownAlongYcoordinates(){
        Position position  = new Position(2,2);
        position.moveDownAlongYcoordinates();
        assertThat(position.getX(),is(2));
        assertThat(position.getY(),is(1));
    }
}
