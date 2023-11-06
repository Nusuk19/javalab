package PatternCommand;

import Derivative.Derivative;

public class SortByRiskCommand implements Command{
    private Derivative derivative;

    public SortByRiskCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public void execute() {
        derivative.sortByRiskLevel();
        System.out.println("Зобов'язання відсортовані за рівнем ризику.");
    }
}

