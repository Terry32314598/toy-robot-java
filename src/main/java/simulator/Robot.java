package simulator;


import exception.RobotException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import model.Command;
import model.Direction;
import model.Position;


/**
 *   A robot has the following five behavior
 *
 *   1. copy itself
 *   2. turn right
 *   3. turn left
 *   4. move one step forward in the direction it is currently facing
 *   5. report its position and the direction it faces to.
 *
 *   all mysterious commands will be ignored.
 *
 * */

@Setter
@Getter
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Robot {

    private Position position;
    private Direction direction;

    public Robot copy(){
        Position positionClone = Position.builder()
                .x(position.getX())
                .y(position.getY())
                .build();
        Direction directionClone = Direction.builder()
                .aspect(direction.getAspect())
                .build();
        return new Robot(positionClone,directionClone);
    }

    public void executeCommand(Command command){
        switch (command) {
            case MOVE:
                move();
                break;
            case LEFT:
                turnLeft();
                break;
            case RIGHT:
                turnRight();
                break;
            case REPORT:
               reportStatus();
                break;
        }
    }

    private void move() throws RobotException{
        switch (direction.getAspect()) {
            case 0:
                position.moveDownAlongYcoordinates();
                break;
            case 1:
                position.moveLeftAlongXcoordinates();
                break;
            case 2:
                position.moveUpAlongYcoordinates();
                break;
            case 3:
                position.moveRightAlongXcoordinates();
                break;
            default:
                throw new RobotException("Invalid direction for robot :" + direction.getAspect());
        }
    }

    private void turnLeft(){
        direction.turnLeft();
    }

    private void turnRight(){
        direction.turnRight();
    }


    private void reportStatus(){
        log.info("-----------report the status of toy robot-----------");
        log.info(position.getX() + ", " + position.getY() + ", " + Direction.translateToStringDirection(direction.getAspect()));
    }
}
