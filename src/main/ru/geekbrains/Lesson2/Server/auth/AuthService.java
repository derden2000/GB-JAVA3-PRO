package main.ru.geekbrains.Lesson2.Server.auth;

import main.ru.geekbrains.Lesson2.Server.User;

public interface AuthService {

    boolean authUser(User user);
}
