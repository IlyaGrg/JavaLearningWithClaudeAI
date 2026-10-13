package lesson0006;

import java.util.ArrayList;

public class FakeNotifier implements Notifier {
    private ArrayList<String> messages = new ArrayList<>();

    @Override
    public void send(String recipient, String message) {
        messages.add(recipient + ": " + message);
    }

    public int getSentCount() {
        return messages.size();
    }

    public String getLastMessage(){
        if (messages.size() > 0){
            return messages.get(messages.size() - 1);
        }
        else{
            throw new LastMessageException("Последнее сообщение не найдено, так как сообщений не существует");
        }
    }
}