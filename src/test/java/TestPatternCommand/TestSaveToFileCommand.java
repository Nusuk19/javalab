package TestPatternCommand;

import Derivative.Derivative;
import File.SaveInFile;
import Insurance.InsuranceObligations;
import PatternCommand.SaveToFileCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class TestSaveToFileCommand {
    @Test
    public void testExecute() {
        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        try {

            Derivative derivative = new Derivative();
            SaveInFile saveInFile = new SaveInFile();
            SaveToFileCommand command = new SaveToFileCommand(derivative, saveInFile);

            List<InsuranceObligations> obligationsList = new ArrayList<>();
            obligationsList.add(new InsuranceObligations("1", "Type1", 100.0, 0.2));

            for (InsuranceObligations contract : obligationsList) {
                derivative.addContracts(contract);
            }

            String input = "testFile.txt\n";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);


            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            command.execute();

            String consoleOutput = outputStream.toString().trim();

            assertTrue(consoleOutput.contains("Insurance obligations saved to the file."));


        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}
