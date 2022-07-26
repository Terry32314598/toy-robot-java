package unitTest;

import exception.CommandParseFailureException;
import model.PlaceCommandDetector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlaceCommandTest {

    static PlaceCommandDetector detector;

    @BeforeAll
    static void setup(){
        detector= new PlaceCommandDetector();
    }

    @Test
    void isPlaceCommandTest(){
        assertThat(detector.isPlaceCommand("PLACE 0,0,NORTH"),is(true));
        assertThat(detector.isPlaceCommand(" PLACE 0,0,NORTH "),is(true));
        assertThat(detector.isPlaceCommand("invalid command"),is(false));
    }

    @Test
    void parsePlacePositionTest(){
        assertThat(detector.parsePlacePosition(" PLACE 0,0,NORTH "),is(new int[]{0,0}));
        Assertions.assertThrows(CommandParseFailureException.class,()->detector.parsePlacePosition("invalid command"));
    }

    @Test
    void parsePlaceDirection(){
        assertThat(detector.parsePlaceDirection(" PLACE 0,0,NORTH "),is("NORTH"));
        Assertions.assertThrows(CommandParseFailureException.class,()->detector.parsePlacePosition("invalid command"));
    }


}
