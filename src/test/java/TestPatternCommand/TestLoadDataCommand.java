package TestPatternCommand;

import File.LoadFromFile;
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
    private LoadFromFile loadFromFile;

    @BeforeEach
    public void setUp() {
        derivative = new Derivative();
        loadFromFile = Mockito.mock(LoadFromFile.class);
        loadDataCommand = new LoadDataCommand(derivative, loadFromFile);
    }

    @Test
    public void testExecuteWithValidFile() {
        String simulatedInput = "testfile.txt";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        List<InsuranceObligations> loadedContracts = new ArrayList<>();
        loadedContracts.add(new InsuranceObligations("1", "Type1", 100.0, 0.2));

        Mockito.when(loadFromFile.loadFromFile("testfile.txt")).thenReturn(loadedContracts);

        loadDataCommand.execute();

        List<InsuranceObligations> contractsInDerivative = derivative.getContracts();
        assertEquals(1, contractsInDerivative.size());
    }

    @Test
    public void testExecuteWithInvalidFile() {
        String simulatedInput = "nonexistentfile.txt";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        Mockito.when(loadFromFile.loadFromFile("nonexistentfile.txt")).thenReturn(null);

        loadDataCommand.execute();

        List<InsuranceObligations> contractsInDerivative = derivative.getContracts();
        assertEquals(0, contractsInDerivative.size());
    }
}
