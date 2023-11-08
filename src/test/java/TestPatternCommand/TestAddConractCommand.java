package TestPatternCommand;

import PatternCommand.AddConractCommand;
import Derivative.Derivative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAddConractCommand {
    private AddConractCommand addContractCommand;
    private Derivative derivative;

    @BeforeEach
    public void setUp() {
        derivative = new Derivative();
        addContractCommand = new AddConractCommand(derivative);
    }

    @Test
    public void testExecuteWithUserInput() {
        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        String simulatedInput = "0\nType1\n100,0\n2,0\n#\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        addContractCommand.execute();

        System.setIn(originalInput);
        System.setOut(originalOutput);

        assertTrue(derivative.getContracts().size() == 1);

        String programOutput = outputStream.toString();
        assertTrue(programOutput.contains("Страхове зобов'язання додане до деривативу."));
    }
}
