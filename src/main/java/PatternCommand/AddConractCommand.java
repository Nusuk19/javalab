package PatternCommand;

import Derivative.Derivative;
import File.LoadFromFile;
import Insurance.InsuranceObligations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Scanner;

public class AddConractCommand implements Command {
    private Derivative derivative;
    private static final Logger logger= LogManager.getLogger(AddConractCommand.class);

    public AddConractCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public void execute() {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введіть номер полісу (або # для виходу): ");
            String input = scanner.nextLine();

            if (input.equals("#")) {
                System.out.println("Дані успішно введено");
                break;
            }

            System.out.print("Введіть тип полісу: ");
            String policyType = scanner.nextLine();

            System.out.print("Введіть вартість страхового зобов'язання: ");
            double value = scanner.nextDouble();

            System.out.print("Введіть рівень ризику: ");
            double levelRisk = scanner.nextDouble();

            InsuranceObligations contract = new InsuranceObligations(input, policyType, value, levelRisk);
            derivative.addContracts(contract);
            System.out.println("Страхове зобов'язання додане до деривативу.");
            logger.info("Страхове зобов'язання додане до деривативу.");

            scanner.nextLine();
        }
    }
}

