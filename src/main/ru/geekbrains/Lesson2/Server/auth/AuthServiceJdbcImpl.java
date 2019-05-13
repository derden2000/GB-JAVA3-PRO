package main.ru.geekbrains.Lesson2.Server.auth;

import main.ru.geekbrains.Lesson2.Server.User;
import main.ru.geekbrains.Lesson2.Server.persistance.UserRepository;

import java.sql.SQLException;

public class AuthServiceJdbcImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceJdbcImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean authUser(User user) {
        String pass = null;
        try {
            User find = userRepository.findByLogin(user.getLogin());
            pass = find.getPassword();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (pass != null) {
            return pass.equals(user.getPassword());
        } else {
            return false;
        }
    }
}
