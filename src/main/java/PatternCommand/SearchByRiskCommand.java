package PatternCommand;

import java.util.List;
import java.util.Scanner;

import Derivative.Derivative;
import Insurance.InsuranceObligations;

public class SearchByRiskCommand implements Command{
    private Derivative derivative;

    public SearchByRiskCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть мінімальний ризик: ");
        double minRisk = scanner.nextDouble();
        System.out.print("Введіть максимальний ризик: ");
        double maxRisk = scanner.nextDouble();
        List<InsuranceObligations> result = derivative.findContractsInRiskRange(minRisk, maxRisk);
        if (!(result).isEmpty()) {
            System.out.println("Результати пошуку:");
            for (InsuranceObligations contract : result) {
                System.out.println("Номер Полісу "+contract.getPolicyNumber()+",Тип полісу "+contract.getPolicyType()+",Ризик: " + contract.getLevelRisk() + ", Вартість: " + contract.calculateCost());
            }
        } else {
            System.out.println("Немає результатів для заданих параметрів.");
        }
    }
}
