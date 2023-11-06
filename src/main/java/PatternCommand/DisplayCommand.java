package PatternCommand;

import Derivative.Derivative;
import Insurance.InsuranceObligations;
import java.util.List;

public class DisplayCommand implements Command{
    private Derivative derivative;

    public DisplayCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public void execute() {
        List<InsuranceObligations> contracts = derivative.getContracts();
        if (contracts.isEmpty()) {
            System.out.println("Дериватив не має страхових зобов'язань.");
        } else {
            System.out.println("Страхові зобов'язання в деривативі:");
            for (InsuranceObligations contract : contracts) {
                System.out.println("Номер полісу: " + contract.getPolicyNumber()+ ",Тип полісу "+contract.getPolicyType()+", Ризик: " + contract.getLevelRisk() + ", Вартість: " + contract.getValue());
            }
        }
    }
}

