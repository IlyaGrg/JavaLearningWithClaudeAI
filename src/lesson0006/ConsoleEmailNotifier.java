package lesson0006;

public class ConsoleEmailNotifier implements Notifier {
    private String from;

    public ConsoleEmailNotifier(String from) {
        if (from == null || from.isBlank()) {
            throw new IllegalArgumentException("Введите корректную почту: ");
        }
        this.from = from;
    }

    @Override
    public void send(String recipient, String message) {
        System.out.println("Email от " + from + " для " + recipient + ": " + message);
    }
}