package simulator;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import model.Command;
import model.Direction;
import model.Position;

import java.util.Objects;

/**
 *   SquareTable represents a square table top, of dimensions 5 units x 5 units.
 *   SquareTable can hold robot on it for gaming by passing command to robot
 *   SquareTable can also accept position information to place a robot on it.
 *
 * */
@Setter
@Getter
@Slf4j
public class SquareTable {
    private final int dimension = 5;
    private Robot robot; // will be placed on the table


    /**
     * accept position coordinates and aspect, check if it's valid to place a robot
     *
     * @param x
     *        x-coordinate
     * @param y
     *        y-coordinate
     * @param aspect
     *        direction the robot will face to
     *
     * */
    public void placeRobot(int x,int y,String aspect) {
        Robot robot = new Robot();
        robot.setDirection(Direction.builder()
                .aspect(Direction.translateFromString(aspect))
                .build());
        robot.setPosition(Position.builder()
                .x(x)
                .y(y)
                .build());

        if (isOnTheTable(robot)) {
            this.robot = robot;
        } else {
            this.robot = null;
        }
    }

    /**
     * accept position coordinates and aspect, check if it's valid to place a robot
     * if there are no robots on the table, the command will be ignored.
     * if the command will cause fall down from the table, it will be ignored.
     *
     * @param command
     *        a legal command will be passed to robot
     *
     * */
    public void feedCommandToRobot(Command command) {
        if (Objects.isNull(robot)) {
            log.warn("No robot is currently on the table, waiting for a PLACE command, this command "
                    + command + " is ignored");
            return;
        }
        Robot snapshot = robot.copy();

        robot.executeCommand(command);
        if (!isOnTheTable(robot)) {
            this.robot = snapshot;
        }
    }


    //check if a position is a valid position on the table
    private boolean isOnTheTable(Robot robot) {
        if (Objects.isNull(robot) || Objects.isNull(robot.getPosition())) {
            log.warn("invalid robot, please initialize it");
            return false;
        }

        return !(robot.getPosition().getX() < 0
                || robot.getPosition().getX() >= dimension
                || robot.getPosition().getY() < 0
                || robot.getPosition().getY() >= dimension);
    }
}
