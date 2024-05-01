package org.example;


import Derivative.Derivative;
import Developer.Developer;

import File.LoadFromDatabase;
import File.SaveToDatabase;
import Insurance.InsuranceObligations;
import PatternCommand.*;
import PatternCommand.SaveToFileCommand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Derivative derivative = new Derivative();

        // Підключення до бази даних
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance_db", "root", "1324576809Aa")) {
            LoadFromDatabase dataDatabaseHandler = new LoadFromDatabase();
            SaveToDatabase saveToDatabase = new SaveToDatabase();

            // Передача з'єднання до бази даних в об'єкти роботи з базою даних
            List<InsuranceObligations> initialContracts = dataDatabaseHandler.loadFromDatabase(connection);
            for (InsuranceObligations contract : initialContracts) {
                derivative.addContracts(contract);
            }

            Command addContractCommand = new AddConractCommand(connection);
            Command calculateTotalCostContractsCommand = new CalculateTotalCostContactsCommand(derivative);
            Command loadDataCommand = new LoadDataCommand(derivative, dataDatabaseHandler, connection);
            Command searchByRiskCommand = new SearchByRiskCommand(derivative);
            Command sortByRiskCommand = new SortByRiskCommand(derivative);
            Command displayCommand = new DisplayCommand(connection);
            Command saveToFileCommand = new SaveToFileCommand(derivative, saveToDatabase, connection);
            Command helpCommand = new HelpCommand();
            Command exitCommand = new ExitCommand();
            Command deleteContractCommand = new DeleteContractCommand(connection);

            Developer menu = new Developer(addContractCommand, deleteContractCommand, loadDataCommand, searchByRiskCommand, sortByRiskCommand, calculateTotalCostContractsCommand, displayCommand, saveToFileCommand, helpCommand, exitCommand);


            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                menu.displayMenu();
                Command selectedCommand = menu.handleUserInput();
                if (selectedCommand != null) {
                    selectedCommand.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}