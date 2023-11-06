package File;

import Insurance.InsuranceObligations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoadFromFile {
    private static final Logger logger= LogManager.getLogger(LoadFromFile.class);
    public List<InsuranceObligations> loadFromFile(String filename) {
        List<InsuranceObligations> contracts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Розбиваємо рядок на частини, якщо потрібно, та створюємо контракт
                InsuranceObligations contract = InsuranceObligations.fromString(line);
                if (contract != null) {
                    contracts.add(contract);
                }
            }
            logger.info("Успішна вичитка з файлу");
        } catch (IOException e) {
            logger.error("Помилка:", e);
        }

        return contracts;
    }

}

