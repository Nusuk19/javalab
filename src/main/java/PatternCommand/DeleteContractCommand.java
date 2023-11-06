package PatternCommand;

import Derivative.Derivative;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class DeleteContractCommand implements Command{
    private Derivative derivative;
    private static final Logger logger= LogManager.getLogger(DeleteContractCommand.class);

    public DeleteContractCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер страхового зобов'язання для видалення: ");
        String policyNumberToDelete = scanner.nextLine();
        boolean removed = derivative.removeContractByPolicyNumber(policyNumberToDelete);

        if (removed) {
            System.out.println("Страхове зобов'язання з номером " + policyNumberToDelete + " було видалено.");
            logger.info("Страхове зобов'язання видалене з деривативу.");
        } else {
            System.out.println("Страхове зобов'язання з номером " + policyNumberToDelete + " не було знайдено.");
            logger.info("Страхове зобов'язання не знайдене в деревативі");
        }
    }

}
