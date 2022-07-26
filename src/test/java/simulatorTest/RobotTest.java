package simulatorTest;

import model.Command;
import model.Direction;
import model.Position;
import simulator.Robot;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RobotTest {

    static Robot robot;


    @Test
    void copyTest(){
        // initialize a robot at (0,0,SOUTH)
        robot = new Robot(Position.builder().x(0).y(0).build(),Direction.builder().aspect(0).build());

        Robot snapShot = robot.copy();
        robot.setDirection(Direction.builder().aspect(2).build());
        robot.setPosition(Position.builder().x(1).y(1).build());

        assertThat(snapShot.getPosition().getX(),is(0));
        assertThat(snapShot.getPosition().getY(),is(0));
        assertThat(snapShot.getDirection().getAspect(),is(0));
    }

    @Test
    void executeCommandTest(){
        // initialize a robot at (0,0,SOUTH)
        robot = new Robot(Position.builder().x(0).y(0).build(),Direction.builder().aspect(0).build());

        robot.executeCommand(Command.RIGHT);
        assertThat(robot.getPosition().getX(),is(0)); // not move
        assertThat(robot.getDirection().getAspect(),is(1));  // face west now

        robot.executeCommand(Command.LEFT);
        robot.executeCommand(Command.LEFT);
        assertThat(robot.getPosition().getY(),is(0)); //not move
        assertThat(robot.getDirection().getAspect(),is(3)); //face east


        robot.executeCommand(Command.MOVE);
        assertThat(robot.getPosition().getY(),is(0));
        assertThat(robot.getPosition().getX(),is(1)); // at(1,0)
        assertThat(robot.getDirection().getAspect(),is(3)); //face east

        robot.executeCommand(Command.LEFT);
        robot.executeCommand(Command.MOVE);
        robot.executeCommand(Command.MOVE);
        robot.executeCommand(Command.MOVE);
        assertThat(robot.getPosition().getY(),is(3));
        assertThat(robot.getPosition().getX(),is(1)); // at(1,0)
        assertThat(robot.getDirection().getAspect(),is(2)); //face north

        robot.executeCommand(Command.RIGHT);
        robot.executeCommand(Command.RIGHT);
        robot.executeCommand(Command.MOVE);
        robot.executeCommand(Command.MOVE);
        assertThat(robot.getPosition().getY(),is(1));
        assertThat(robot.getPosition().getX(),is(1)); // at(1,1)
        assertThat(robot.getDirection().getAspect(),is(0)); //face south

        robot.executeCommand(Command.RIGHT);
        robot.executeCommand(Command.MOVE);
        assertThat(robot.getPosition().getY(),is(1));
        assertThat(robot.getPosition().getX(),is(0)); // at(0,1)
        assertThat(robot.getDirection().getAspect(),is(1)); //face west

        robot.executeCommand(Command.REPORT);
        assertThat(robot.getPosition().getY(),is(1));
        assertThat(robot.getPosition().getX(),is(0)); // at(0,1)
        assertThat(robot.getDirection().getAspect(),is(1)); //face west
    }

}
