package model;


import exception.InvalidDirectionException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


/**
 * Use integer to represent four aspects
 *      south = 0
 *      west = 1
 *      north = 2
 *      east = 3
 *
 * */
@Setter
@Getter
@Slf4j
@Builder
public class Direction {
    private int aspect;

    public void turnRight() {
        aspect = (aspect + 1) % 4;
    }

    // turn left equals to turn right three times.
    public void turnLeft() {
        aspect = (aspect + 3) % 4;
    }


    /**
     * translate int aspect to readable String
     *
     * @param aspect
     *        int value for aspect.
     *
     * @throws  InvalidDirectionException if we get int out of range 0-4
     *
     * */
    public static String translateToStringDirection(int aspect){
        switch (aspect){
            case 0:
                return "SOUTH";
            case 1:
                return "WEST";
            case 2:
                return "NORTH";
            case 3:
                return "EAST";
            default:
                log.error("cannot translate the input direction, allowed value is 0-3, but the input is : " + aspect);
                throw new InvalidDirectionException("invalid direction int value :" + aspect);
        }
    }

    /**
     * translate String aspect to int
     *
     * @param aspect
     *        String value for aspect
     *
     * @throws  InvalidDirectionException if we get String which is not SOUTH|WEST|NORTH|EAST
     *
     * */
    public static int translateFromString(String aspect){
        switch (aspect){
            case "SOUTH":
                return 0;
            case "WEST":
                return 1;
            case "NORTH":
                return 2;
            case "EAST":
                return 3;
            default:
                log.error("cannot translate the input direction :" + aspect);
                throw new InvalidDirectionException("invalid direction String  :" + aspect);
        }
    }

}
