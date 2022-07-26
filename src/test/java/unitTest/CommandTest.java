package unitTest;

import exception.CommandParseFailureException;
import model.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommandTest {

    @Test
    void parseValidCommandTest(){
       Command moveCommand =  Command.parse("MOVE");
        assertThat(moveCommand,is(Command.MOVE));
        Command leftCommand =  Command.parse("LEFT");
        assertThat(leftCommand,is(Command.LEFT));
        Command rightCommand =  Command.parse("RIGHT");
        assertThat(rightCommand,is(Command.RIGHT));
        Command reportCommand =  Command.parse("REPORT");
        assertThat(reportCommand,is(Command.REPORT));
    }

    @Test()
    void parseInvalidCommandTest(){
        Command invalidCommand =  Command.parse("Invalid Command");
        assertThat(invalidCommand,is(Command.IGNORE));
    }
}
