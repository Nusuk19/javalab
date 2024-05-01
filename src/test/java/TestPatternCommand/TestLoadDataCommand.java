package TestPatternCommand;

import File.LoadFromDatabase;
import Insurance.InsuranceObligations;
import PatternCommand.LoadDataCommand;
import Derivative.Derivative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestLoadDataCommand {
    private LoadDataCommand loadDataCommand;
    private Derivative derivative;
    private LoadFromDatabase loadFromDatabase;

    @BeforeEach
    public void setUp() {
        derivative = new Derivative();
        loadFromDatabase = Mockito.mock(LoadFromDatabase.class);
        loadDataCommand = new LoadDataCommand(derivative, loadFromDatabase);
    }

    @Test
    public void testExecuteWithValidFile() {
        String simulatedInput = "testfile.txt";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        List<InsuranceObligations> loadedContracts = new ArrayList<>();
        loadedContracts.add(new InsuranceObligations("1", "Type1", 100.0, 0.2));

        Mockito.when(loadFromDatabase.loadFromFile("testfile.txt")).thenReturn(loadedContracts);

        loadDataCommand.execute();

        List<InsuranceObligations> contractsInDerivative = derivative.getContracts();
        assertEquals(1, contractsInDerivative.size());
    }

    @Test
    public void testExecuteWithInvalidFile() {
        String simulatedInput = "nonexistentfile.txt";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        Mockito.when(loadFromDatabase.loadFromFile("nonexistentfile.txt")).thenReturn(null);

        loadDataCommand.execute();

        List<InsuranceObligations> contractsInDerivative = derivative.getContracts();
        assertEquals(0, contractsInDerivative.size());
    }
}
