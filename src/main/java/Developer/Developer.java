package Developer;

import PatternCommand.Command;

import java.util.Scanner;

public class Developer {
    private Command addContractCommand;
    private Command DeleteContractCommand;
    private Command loadDataCommand;
    private Command searchByRiskCommand;
    private Command sortByRiskCommand;
    private Command calculateTotalCostContactsCommand;
    private Command DisplayCommand;
    private Command SaveToFileCommand;
    private Command helpCommand;
    private Command exitCommand;

    public Developer(
            Command addContractCommand,
            Command DeleteContractCommand,
            Command loadDataCommand,
            Command searchByRiskCommand,
            Command sortByRiskCommand,
            Command calculateTotalCostContactsCommand,
            Command DisplayCommand,
            Command SaveToFile,
            Command helpCommand,
            Command exitCommand
    ) {
        this.addContractCommand = addContractCommand;
        this.DeleteContractCommand = DeleteContractCommand;
        this.loadDataCommand = loadDataCommand;
        this.searchByRiskCommand = searchByRiskCommand;
        this.sortByRiskCommand = sortByRiskCommand;
        this.calculateTotalCostContactsCommand = calculateTotalCostContactsCommand;
        this.DisplayCommand = DisplayCommand;
        this.SaveToFileCommand = SaveToFile;
        this.helpCommand = helpCommand;
        this.exitCommand = exitCommand;
    }

    public void displayMenu() {
        System.out.println("Меню:");
        System.out.println("0. Добавити страхівку");
        System.out.println("1. Видалити страхівку");
        System.out.println("2. Завантажити дані з файлу");
        System.out.println("3. Пошук за ризиком");
        System.out.println("4. Сортування за ризиком");
        System.out.println("5. Обчислення загальної ціни");
        System.out.println("6. Показати усі страхівки");
        System.out.println("7. Зберегти дані у файл");
        System.out.println("8. Довідка");
        System.out.println("9. Вихід");
    }

    public Command handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                return addContractCommand;
            case 1:
                return DeleteContractCommand;
            case 2:
                return loadDataCommand;
            case 3:
                return searchByRiskCommand;
            case 4:
                return sortByRiskCommand;
            case 5:
                return calculateTotalCostContactsCommand;
            case 6:
                return DisplayCommand;
            case 7:
                return SaveToFileCommand;
            case 8:
                return helpCommand;
            case 9:
                return exitCommand;
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                return null;
        }
    }
}

