package main.ru.geekbrains.Lesson2.Server.auth;

import main.ru.geekbrains.Lesson2.Server.User;
import main.ru.geekbrains.Lesson2.Server.persistance.UserRepository;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class AuthServiceJdbcImpl implements AuthService {

    private final UserRepository userRepository;

    private static Logger logger = Logger.getLogger(AuthServiceJdbcImpl.class.getName());

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
            String message = "";
            for(StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                message = message + System.lineSeparator() + stackTraceElement.toString();
            }
            logger.error(String.format("%s - %s", e, message));
            // e.printStackTrace();
        }
        if (pass != null) {
            return pass.equals(user.getPassword());
        } else {
            return false;
        }
    }
}
