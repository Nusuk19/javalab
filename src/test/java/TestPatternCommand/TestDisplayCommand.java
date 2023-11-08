package TestPatternCommand;

import Insurance.InsuranceObligations;
import PatternCommand.DisplayCommand;
import Derivative.Derivative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDisplayCommand {
    private DisplayCommand displayCommand;
    private Derivative derivative;

    @BeforeEach
    public void setUp() {
        derivative = new Derivative();
        displayCommand = new DisplayCommand(derivative);
    }

    @Test
    public void testExecuteWithEmptyDerivative() {
        PrintStream originalOutput = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        displayCommand.execute();

        System.setOut(originalOutput);

        String programOutput = outputStream.toString();
        assertEquals("Дериватив не має страхових зобов'язань.\r\n", programOutput);
    }

    @Test
    public void testExecuteWithNonEmptyDerivative() {
        List<InsuranceObligations> contracts = new ArrayList<>();
        contracts.add(new InsuranceObligations("1", "Type1", 100.0, 0.2));
        contracts.add(new InsuranceObligations("2", "Type2", 200.0, 0.3));
        for(InsuranceObligations contract: contracts){
            derivative.addContracts(contract);
        }

        PrintStream originalOutput = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        displayCommand.execute();

        System.setOut(originalOutput);

        String programOutput = outputStream.toString();
        assertTrue(programOutput.contains("Страхові зобов'язання в деривативі:"));
        assertTrue(programOutput.contains("Номер полісу: 1,Тип полісу Type1, Ризик: 0.2, Вартість: 100.0"));
        assertTrue(programOutput.contains("Номер полісу: 2,Тип полісу Type2, Ризик: 0.3, Вартість: 200.0"));
    }
}
