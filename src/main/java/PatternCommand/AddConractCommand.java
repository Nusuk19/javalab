package PatternCommand;

import File.SaveToDatabase;
import Derivative.Derivative;
import Insurance.InsuranceObligations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class AddConractCommand implements Command {
    private Connection connection; // Змінна для зберігання з'єднання з базою даних
    private static final Logger logger = LogManager.getLogger(AddConractCommand.class);

    public AddConractCommand(Connection connection) {
        this.connection = connection; // Збереження з'єднання з базою даних
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

            System.out.print("Введіть рівень ризику (наприклад, 0.3): ");
            double levelRisk = scanner.nextDouble();

            InsuranceObligations contract = new InsuranceObligations(input, policyType, value, levelRisk);

            // Збереження даних у базі даних
            try {
                SaveToDatabase.saveToDatabase(connection, contract);
                System.out.println("Страхове зобов'язання додане до бази даних.");
                logger.info("Страхове зобов'язання додане до бази даних.");
            } catch (SQLException e) {
                System.out.println("Помилка при збереженні даних у базі даних: " + e.getMessage());
                logger.error("Помилка при збереженні даних у базі даних: " + e.getMessage());
            }

            scanner.nextLine(); // Очистити буфер вводу
        }
    }
}
