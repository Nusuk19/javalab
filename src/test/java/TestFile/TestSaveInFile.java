package TestFile;

import File.SaveInFile;
import Insurance.InsuranceObligations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSaveInFile {
    private SaveInFile saveInFile;
    private String testFileName;

    @BeforeEach
    public void setUp() {
        saveInFile = new SaveInFile();
        testFileName = "testfile.txt";
    }

    @Test
    public void testSaveToFile() {
        List<InsuranceObligations> testContracts = new ArrayList<>();
        testContracts.add(new InsuranceObligations("3423","AP",3434,4));
        testContracts.add(new InsuranceObligations("3423","AP",3434,4));


        saveInFile.saveToFile(testFileName, testContracts);


        File testFile = new File(testFileName);
        assertTrue(testFile.exists());

        testFile.delete();
    }
}
