package PatternCommand;

import Derivative.Derivative;

import File.SaveInFile;
import Insurance.InsuranceObligations;

import java.util.List;
import java.util.Scanner;


public class SaveToFileCommand implements Command {
    private Derivative derivative;
    private SaveInFile saveInFile;

    public SaveToFileCommand(Derivative derivative, SaveInFile saveInFile) {
        this.derivative = derivative;
        this.saveInFile = saveInFile;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу: ");
        String filename = scanner.nextLine();
        try {
            List<InsuranceObligations> saveContracts = derivative.getContracts();
            if (saveContracts.isEmpty()) {
                throw new RuntimeException("No insurance obligations to save.");
            }
            saveInFile.saveToFile(filename, saveContracts);
            System.out.println("Insurance obligations saved to the file.");;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
