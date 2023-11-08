package TestDeveloper;

import Developer.Developer;
import PatternCommand.Command;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

public class TestDeveloper {
    private Developer developer;
    private Command mockAddContractCommand;
    private Command mockDeleteContractCommand;
    private Command mockLoadDataCommand;
    private Command mockSearchByRiskCommand;
    private Command mockSortByRiskCommand;
    private Command mockCalculateTotalCostCommand;
    private Command mockDisplayCommand;
    private Command mockSaveToFileCommand;
    private Command mockHelpCommand;
    private Command mockExitCommand;

    @Before
    public void setUp() {
        mockAddContractCommand = Mockito.mock(Command.class);
        mockDeleteContractCommand = Mockito.mock(Command.class);
        mockLoadDataCommand = Mockito.mock(Command.class);
        mockSearchByRiskCommand = Mockito.mock(Command.class);
        mockSortByRiskCommand = Mockito.mock(Command.class);
        mockCalculateTotalCostCommand = Mockito.mock(Command.class);
        mockDisplayCommand = Mockito.mock(Command.class);
        mockSaveToFileCommand = Mockito.mock(Command.class);
        mockHelpCommand = Mockito.mock(Command.class);
        mockExitCommand = Mockito.mock(Command.class);

        developer = new Developer(
                mockAddContractCommand, mockDeleteContractCommand, mockLoadDataCommand,
                mockSearchByRiskCommand, mockSortByRiskCommand, mockCalculateTotalCostCommand,
                mockDisplayCommand, mockSaveToFileCommand, mockHelpCommand, mockExitCommand
        );
    }

    @Test
    public void testHandleUserInputAddContract() {
        String input = "0\n";
        setSystemInput(input);
        Command resultCommand = developer.handleUserInput();
        assertNotNull(resultCommand);
    }

    @Test
    public void testHandleUserInputDeleteContract() {
        String input = "1\n";
        setSystemInput(input);
        Command resultCommand = developer.handleUserInput();
        assertNotNull(resultCommand);
    }

    @Test
    public void testHandleUserInputLoadData() {
        String input = "2\n";
        setSystemInput(input);
        Command resultCommand = developer.handleUserInput();
        assertNotNull(resultCommand);
    }

    @Test
    public void testHandleUserInputSearchByRisk() {
        String input = "3\n";
        setSystemInput(input);
        Command resultCommand = developer.handleUserInput();
        assertNotNull(resultCommand);
    }

    @Test
    public void testHandleUserInputSortByRisk() {
        String input = "4\n";
        setSystemInput(input);
        Command resultCommand = developer.handleUserInput();
        assertNotNull(resultCommand);
    }

    @Test
    public void testHandleUserInputCalculateTotalCost() {
        String input = "5\n";
        setSystemInput(input);
        Command resultCommand = developer.handleUserInput();
        assertNotNull(resultCommand);
    }

    @Test
    public void testHandleUserInputDisplay() {
        String input = "6\n";
        setSystemInput(input);
        Command resultCommand = developer.handleUserInput();
        assertNotNull(resultCommand);
    }

    @Test
    public void testHandleUserInputSaveToFile() {
        String input = "7\n";
        setSystemInput(input);
        Command resultCommand = developer.handleUserInput();
        assertNotNull(resultCommand);
    }

    @Test
    public void testHandleUserInputHelp() {
        String input = "8\n";
        setSystemInput(input);
        Command resultCommand = developer.handleUserInput();
        assertNotNull(resultCommand);
    }

    @Test
    public void testHandleUserInputExit() {
        String input = "9\n";
        setSystemInput(input);
        Command resultCommand = developer.handleUserInput();
        assertNotNull(resultCommand);
    }

    private void setSystemInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
