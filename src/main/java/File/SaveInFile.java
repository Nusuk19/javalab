package File;

import Insurance.InsuranceObligations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class SaveInFile {
    private static final Logger logger= LogManager.getLogger(SaveInFile.class);
    public void saveToFile(String filename, List<InsuranceObligations> contracts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (InsuranceObligations contract : contracts) {
                // Записати дані контракту в файл
                writer.write(contract.toString());
                writer.newLine(); // Додати роздільник між контрактами
            }
            logger.info("Дані успішно збережені у файл");
        } catch (IOException e) {
            logger.error("Помилка:", e);
        }
    }
}
