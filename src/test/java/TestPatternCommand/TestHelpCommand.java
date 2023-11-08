package TestPatternCommand;

import PatternCommand.HelpCommand;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHelpCommand {
    @Test
    public void testExecute() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        HelpCommand helpCommand = new HelpCommand();

        helpCommand.execute();

        String programOutput = outputStream.toString();

        String expectedOutput = "Довідка:\r\n" +
                "0. Добавити страхівку - додавання страхівки до деративи\r\n" +
                "1. Видалити страхівку - видалення страхівки з деративи\r\n" +
                "2. Завантажити дані з файлу\r\n" +
                "3. Пошук за ризиком - вводимо діапазон ризику(кінці включно)\r\n" +
                "4. Сортування за ризиком - сортуємо страхівки по спаданню ризиків\r\n" +
                "5. Обчислення загальної ціни\r\n" +
                "6. Показати усі страхівки\r\n" +
                "7. Зберегти дані у файл\r\n" +
                "9. Вихід - заврешення роботи програми\r\n";
        assertEquals(expectedOutput, programOutput);

        System.setOut(System.out);
    }
}
