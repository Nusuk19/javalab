package PatternCommand;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Довідка:");
        System.out.println("0. Добавити страхівку - додавання страхівки до деративи");
        System.out.println("1. Видалити страхівку - видалення страхівки з деративи");
        System.out.println("2. Завантажити дані з файлу");
        System.out.println("3. Пошук за ризиком - вводимо діапазон ризику(кінці включно)");
        System.out.println("4. Сортування за ризиком - сортуємо страхівки по спаданню ризиків");
        System.out.println("5. Обчислення загальної ціни");
        System.out.println("6. Показати усі страхівки");
        System.out.println("7. Зберегти дані у файл");
        System.out.println("9. Вихід - заврешення роботи програми");
    }
}
