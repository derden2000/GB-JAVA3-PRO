package main.ru.geekbrains.Lesson2.Client;

import java.util.List;

public interface MessageReciever {

    void submitMessage(TextMessage message);

    void userConnected(String login);

    void userDisconnected(String login);

    void initClientsOnline(List<String> list);

}