package PatternCommand;

import Derivative.Derivative;
import Insurance.InsuranceObligations;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayCommand implements Command{
    private Connection connection;

    public DisplayCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void execute() {
        try {
            // Запит до бази даних для отримання страхових зобов'язань
            String query = "SELECT * FROM contracts";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (!resultSet.next()) {
                        System.out.println("Дериватив не має страхових зобов'язань.");
                    } else {
                        System.out.println("Страхові зобов'язання в деривативі:");
                        do {
                            String policyNumber = resultSet.getString("policyNumber");
                            String policyType = resultSet.getString("policyType");
                            double levelRisk = resultSet.getDouble("levelRisk");
                            double value = resultSet.getDouble("value");
                            System.out.println("Номер полісу: " + policyNumber + ", Тип полісу: " + policyType + ", Ризик: " + levelRisk + ", Вартість: " + value);
                        } while (resultSet.next());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Помилка при взаємодії з базою даних: " + e.getMessage());
        }
    }
}
