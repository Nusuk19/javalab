package TestPatternCommand;

import PatternCommand.SortByRiskCommand;
import Derivative.Derivative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSortByRiskCommand {
    private Derivative derivative;
    private SortByRiskCommand sortByRiskCommand;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        derivative = new Derivative();
        sortByRiskCommand = new SortByRiskCommand(derivative);
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testExecute() {
        sortByRiskCommand.execute();

        String expectedOutput = "Зобов'язання відсортовані за рівнем ризику.\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
