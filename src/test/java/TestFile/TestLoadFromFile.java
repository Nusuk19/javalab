package TestFile;

import static org.junit.Assert.*;

import File.LoadFromFile;

import Insurance.InsuranceObligations;
import org.junit.Test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TestLoadFromFile {
    @Test
    public void testLoadFromFileValidFile() {
        try {
            File tempFile = createTempDataFile();
            LoadFromFile loadFromFile = new LoadFromFile();

            List<InsuranceObligations> contracts = loadFromFile.loadFromFile(tempFile.getAbsolutePath());
            assertNotNull(contracts);
            assertEquals(2, contracts.size());
            tempFile.delete();
        } catch (IOException e) {
            fail("Ошибка создания временного файла");
        }
    }

    @Test
    public void testLoadFromFileInvalidFile() {
        LoadFromFile loadFromFile = new LoadFromFile();
        List<InsuranceObligations> contracts = loadFromFile.loadFromFile("nonexistentfile.txt");
        assertNotNull(contracts);
        assertEquals(0, contracts.size());
    }

    private File createTempDataFile() throws IOException {
        File tempFile = File.createTempFile("test_data", ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write("InsuranceObligations{policyNumber='345', policyType='АР', value=456.0, LevelRisk=2.0}\n");
        writer.write("InsuranceObligations{policyNumber='345', policyType='АР', value=456.0, LevelRisk=2.0}\n");
        writer.close();
        return tempFile;
    }
}
