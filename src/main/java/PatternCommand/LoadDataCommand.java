package PatternCommand;

import Derivative.Derivative;
import File.LoadFromFile;
import Insurance.InsuranceObligations;

import java.util.List;
import java.util.Scanner;

public class LoadDataCommand implements Command{
    private Derivative derivative;
    private LoadFromFile LoadFromFile;

    public LoadDataCommand(Derivative deravative, LoadFromFile loadFromFile) {
        this.derivative = deravative;
        this.LoadFromFile = loadFromFile;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу: ");
        String filename = scanner.nextLine();
        List<InsuranceObligations> loadedContracts = LoadFromFile.loadFromFile(filename);
        if (loadedContracts != null) {
            for (InsuranceObligations contract : loadedContracts) {
                derivative.addContracts(contract);
            }
        }
    }
}
