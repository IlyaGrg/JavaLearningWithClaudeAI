package lesson0006;

public class ConsoleSmsNotifier implements Notifier {
    //src/lesson0006/ConsoleSmsNotifier.java:2: error: ConsoleSmsNotifier is not abstract and does not override abstract method send(String,String) in Notifier
    //public class ConsoleSmsNotifier implements Notifier{
    //       ^
    //1 error
    //нельзя сделать метод закрытее, чем в договоре. Отвечая на вопрос, тогда не получилось бы определить какой версией метода воспользоваться
    @Override
    public void send(String recipient, String message) {
        System.out.println("SMS => " + recipient + ": " + message);
    }
    //src/lesson0006/ConsoleSmsNotifier.java:8: error: send(String,String) in ConsoleSmsNotifier cannot implement send(String,String) in Notifier
    //    void send(String recipient, String message){
    //         ^
    //  attempting to assign weaker access privileges; was public
    //1 error
}