package model;

import exception.CommandParseFailureException;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *  PlaceCommandDetector is a tool for detect PLACE command and extract the value of it.
 *
 * */
@Slf4j
public class PlaceCommandDetector {

    private final String commandRegex ="PLACE\\s[0-4],[0-4],(EAST|SOUTH|NORTH|WEST)";
    private Pattern commandPattern = Pattern.compile(commandRegex);


    private final String coordinateRegex="[0-4],[0-4]";
    private Pattern coordinatePattern = Pattern.compile(coordinateRegex);

    private final String directionRegex="EAST|SOUTH|NORTH|WEST";
    private Pattern directionPattern = Pattern.compile(directionRegex);

    public boolean isPlaceCommand(String command){
        Matcher matchResult =  commandPattern.matcher(command);
       return matchResult.find();
    }

    /**
     * extract the coordinates from a PLACE command
     *
     * @param command
     *        Stirng of a PLACE command.
     *
     * @return an int array containing two elements : [x,y]
     *
     * @throws  CommandParseFailureException if regex doesn't find any match result
     * */
    public int[] parsePlacePosition(String command){
        Matcher matchResult =  coordinatePattern.matcher(command);
        if(matchResult.find()){
            String[] coordinate = matchResult.group().split(",");
            return new int[]{Integer.parseInt(coordinate[0]),Integer.parseInt(coordinate[1])};
        }else{
            log.error("invalid command is : " + command);
            throw new CommandParseFailureException("Unable to parse PLACE command for coordinate");
        }
    }

    /**
     * extract the aspect from a PLACE command
     *
     * @param command
     *        Stirng of a PLACE command.
     *
     * @throws  CommandParseFailureException if regex doesn't find any match result
     * */
    public String parsePlaceDirection(String command){
        Matcher matchResult =  directionPattern.matcher(command);
        if(matchResult.find()){
            return matchResult.group();
        }else{
            log.error("invalid command is : " + command);
            throw new CommandParseFailureException("Unable to parse PLACE command for direction");
        }
    }

}
