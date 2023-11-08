package TestPatternCommand;

import Insurance.InsuranceObligations;
import PatternCommand.DeleteContractCommand;
import Derivative.Derivative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDeleteContractCommand {
    private DeleteContractCommand deleteContractCommand;
    private Derivative derivative;

    @BeforeEach
    public void setUp() {
        derivative = new Derivative();
        deleteContractCommand = new DeleteContractCommand(derivative);
    }

    @Test
    public void testExecuteWithExistingContract() {
        InsuranceObligations contract = new InsuranceObligations("1", "Type1", 100.0, 0.2);
        derivative.addContracts(contract);

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        String simulatedInput = "1\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        deleteContractCommand.execute();

        System.setIn(originalInput);
        System.setOut(originalOutput);

        assertTrue(derivative.getContracts().isEmpty());

        String programOutput = outputStream.toString().trim();
        assertTrue(programOutput.contains("Страхове зобов'язання з номером 1 було видалено."));
    }

    @Test
    public void testExecuteWithNonExistingContract() {
        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        String simulatedInput = "2\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        deleteContractCommand.execute();

        System.setIn(originalInput);
        System.setOut(originalOutput);

        assertTrue(derivative.getContracts().isEmpty());

        String programOutput = outputStream.toString();
        assertTrue(programOutput.contains("Страхове зобов'язання з номером 2 не було знайдено."));
    }
}
