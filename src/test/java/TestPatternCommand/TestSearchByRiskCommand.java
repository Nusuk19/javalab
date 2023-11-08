package TestPatternCommand;

import Insurance.InsuranceObligations;
import PatternCommand.SearchByRiskCommand;
import Derivative.Derivative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TestSearchByRiskCommand {

    private SearchByRiskCommand searchByRiskCommand;

    @Mock
    private Derivative derivative;

    @BeforeEach
    public void setUp() {
        derivative = Mockito.mock(Derivative.class);
        searchByRiskCommand = new SearchByRiskCommand(derivative);
    }

    @Test
    public void testExecuteWithResults() {
        List<InsuranceObligations> contracts = new ArrayList<>();
        InsuranceObligations contract1 = new InsuranceObligations("123", "TypeA", 100, 0.5);
        InsuranceObligations contract2 = new InsuranceObligations("456", "TypeB", 150, 0.8);
        contracts.add(contract1);
        contracts.add(contract2);

        when(derivative.findContractsInRiskRange(0.0, 1.0)).thenReturn(contracts);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        System.setIn(new ByteArrayInputStream("0,0\n1,0\n".getBytes()));

        searchByRiskCommand.execute();

        String expectedOutput = "Введіть мінімальний ризик: Введіть максимальний ризик: Результати пошуку:\r\n" +
                "Номер Полісу 123,Тип полісу TypeA,Ризик: 0.5, Вартість: 50.0\r\n" +
                "Номер Полісу 456,Тип полісу TypeB,Ризик: 0.8, Вартість: 120.0\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testExecuteWithNoResults() {
        when(derivative.findContractsInRiskRange(0.0, 1.0)).thenReturn(new ArrayList<>());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        System.setIn(new ByteArrayInputStream("0,0\n1,0\n".getBytes()));

        searchByRiskCommand.execute();
        String expectedOutput = "Введіть мінімальний ризик: Введіть максимальний ризик: Немає результатів для заданих параметрів.\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

}
