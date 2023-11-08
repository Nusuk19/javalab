package TestPatternCommand;

import Insurance.InsuranceObligations;
import PatternCommand.CalculateTotalCostContactsCommand;
import Derivative.Derivative;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TestCalculateTotalCostContactsCommand {
    private CalculateTotalCostContactsCommand calculateTotalCostCommand;
    private Derivative derivative;

    @BeforeEach
    public void setUp() {
        derivative = new Derivative();
        calculateTotalCostCommand = new CalculateTotalCostContactsCommand(derivative);
    }

    @Test
    public void testExecuteWithEmptyDerivative() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        calculateTotalCostCommand.execute();

        String programOutput = outputStream.toString().trim();

        String expectedOutput = "Загальна вартість деривативу: 0.0";
        Assert.assertEquals(expectedOutput, programOutput);

        System.setOut(System.out);
    }

    @Test
    public void testExecuteWithNonEmptyDerivative() {
        List<InsuranceObligations> contracts = new ArrayList<>();
        contracts.add(new InsuranceObligations("1", "Type1", 100.0, 0.2));
        contracts.add(new InsuranceObligations("2", "Type2", 200.0, 0.3));
        for(InsuranceObligations contract: contracts){
            derivative.addContracts(contract);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        calculateTotalCostCommand.execute();

        String programOutput = outputStream.toString().trim();

        String expectedOutput = "Загальна вартість деривативу: 80.0";
        Assert.assertEquals(expectedOutput, programOutput);

        System.setOut(System.out);
    }
}
