package PatternCommand;

public class ExitCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Завершення роботи програми.");
        System.exit(0);
    }
}
