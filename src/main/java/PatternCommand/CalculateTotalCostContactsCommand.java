package PatternCommand;

import Derivative.Derivative;

public class CalculateTotalCostContactsCommand implements Command{
    private Derivative derivative;

    public CalculateTotalCostContactsCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public void execute() {
        double totalCost = derivative.CalculateTotalCost();
        System.out.println("Загальна вартість деривативу: " + totalCost);
    }
}

