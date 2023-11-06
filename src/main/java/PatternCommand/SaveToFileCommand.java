package PatternCommand;

import Derivative.Derivative;

import File.SaveInFile;
import Insurance.InsuranceObligations;

import java.util.List;
import java.util.Scanner;


public class SaveToFileCommand implements Command {
    private Derivative derivative;
    private SaveInFile SaveInFile;

    public SaveToFileCommand(Derivative derivative, File.SaveInFile saveInFile) {
        this.derivative = derivative;
        SaveInFile = saveInFile;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу: ");
        String filename = scanner.nextLine();
        try {
            List<InsuranceObligations> saveContracts = derivative.getContracts();
            SaveInFile.saveToFile(filename, saveContracts);
            System.out.println("Страхові зобов'язання збережено в файлі.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
