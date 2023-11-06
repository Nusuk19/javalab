package org.example;


import Derivative.Derivative;
import PatternComand.Developer.Developer;
import File.LoadFromFile;
import File.SaveInFile;
import PatternCommand.*;

public class Main {
    public static void main(String[] args) {
        Derivative derivative = new Derivative();
        LoadFromFile dataFileHandler = new LoadFromFile();
        SaveInFile SaveInFile=new SaveInFile();
        Command addContractCommand = new AddConractCommand(derivative);
        Command CalculateTotalCostContactsCommand = new CalculateTotalCostContactsCommand(derivative);
        Command LoadDataCommand = new LoadDataCommand(derivative, dataFileHandler);
        Command SearchByRiskCommand = new SearchByRiskCommand(derivative);
        Command SortByRiskCommand = new SortByRiskCommand(derivative);
        Command DisplayCommand = new DisplayCommand(derivative);
        Command SaveToFileCommand=new SaveToFileCommand(derivative,SaveInFile);
        Command helpCommand = new HelpCommand();
        Command exitCommand = new ExitCommand();
        Command DeleteConractCommand=new DeleteContractCommand(derivative);

        Developer menu = new Developer(addContractCommand, DeleteConractCommand,LoadDataCommand, SearchByRiskCommand, SortByRiskCommand, CalculateTotalCostContactsCommand, DisplayCommand,SaveToFileCommand, helpCommand, exitCommand);


        while (true) {
            // Пауза
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
    }
}