package TestPatternCommand;

import PatternCommand.ExitCommand;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExitCommand {
    @Test
    public void testExecute() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ExitCommand exitCommand = new ExitCommand();

        exitCommand.execute();

        String programOutput = outputStream.toString().trim();

        String expectedOutput = "Завершення роботи програми.";
        assertEquals(expectedOutput, programOutput);

        System.setOut(System.out);
    }
}
