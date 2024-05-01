package PatternCommand;

import Derivative.Derivative;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteContractCommand implements Command {
    private Connection connection;
    private static final Logger logger = LogManager.getLogger(DeleteContractCommand.class);

    public DeleteContractCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер страхового зобов'язання для видалення: ");
        String policyNumberToDelete = scanner.nextLine();

        try {
            // Запит до бази даних для видалення страхового зобов'язання
            String deleteQuery = "DELETE FROM contracts WHERE policyNumber = ?";
            try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
                statement.setString(1, policyNumberToDelete);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Страхове зобов'язання з номером " + policyNumberToDelete + " було видалено.");
                    logger.info("Страхове зобов'язання видалене з бази даних.");
                } else {
                    System.out.println("Страхове зобов'язання з номером " + policyNumberToDelete + " не було знайдено.");
                    logger.info("Страхове зобов'язання не знайдене в базі даних.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Помилка при видаленні страхового зобов'язання з бази даних: " + e.getMessage());
            logger.error("Помилка при видаленні страхового зобов'язання з бази даних: " + e.getMessage());
        }
    }
}
