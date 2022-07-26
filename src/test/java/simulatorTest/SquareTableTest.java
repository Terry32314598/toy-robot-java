package simulatorTest;

import model.Command;
import simulator.SquareTable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SquareTableTest {

    static SquareTable table;


    @BeforeAll
    static void setup(){
        table=new SquareTable();
    }

    @AfterEach
    void cleanTable(){
        table.setRobot(null);
    }

    @Test
    void placeRobotTest(){
        assertThat(Objects.isNull(table.getRobot()),is(true)); // empty table
        table.placeRobot(10,10,"NORTH");
        assertThat(Objects.isNull(table.getRobot()),is(true)); // still empty table


        table.placeRobot(1,1,"WEST");
        assertThat(Objects.isNull(table.getRobot()),is(false)); // robot is placed on the table
    }


    @Test
    void feedCommandToRobotTest(){
        assertThat(Objects.isNull(table.getRobot()),is(true)); // empty table
        table.placeRobot(1,1,"SOUTH");
        assertThat(Objects.isNull(table.getRobot()),is(false)); // robot is placed on the table

        table.feedCommandToRobot(Command.RIGHT);
        table.feedCommandToRobot(Command.MOVE);
        assertThat(Objects.isNull(table.getRobot()),is(false)); // after valid move, robot is still on the table

        table.feedCommandToRobot(Command.MOVE);
        table.feedCommandToRobot(Command.MOVE);
        table.feedCommandToRobot(Command.MOVE);
        table.feedCommandToRobot(Command.MOVE);
        table.feedCommandToRobot(Command.MOVE);
        assertThat(Objects.isNull(table.getRobot()),is(false)); // ignore fall down operation


    }





}
