package model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
/**
 *  Command represents all the command a robot can understand and will do the related move.
 *
 *  IGNORE is for all unknown command. We then catch it when parsing
 *
 * */
public enum Command {
    MOVE,
    LEFT,
    RIGHT,
    REPORT,
    IGNORE;


    /**
     * parse input string to a certain Command pre-defined in our system.
     *
     * @param command
     *        Stirng of the potential command.
     *
     * */
    public static Command parse(String command){
        try {
           return Command.valueOf(command);
        } catch (IllegalArgumentException e) {
            log.error("Invalid command "+ command + " is ignored.");
            return Command.IGNORE;
        }
    }
}
