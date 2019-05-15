package main.ru.geekbrains.Lesson2.Server.persistance;

import main.ru.geekbrains.Lesson2.Server.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static Connection conn = null;

    public UserRepository(Connection conn) {
        this.conn = conn;
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = conn.prepareStatement("create table if not exists users (" +
                    "id int auto_increment primary key," +
                    " login varchar(25)," +
                    " password varchar(25)," +
                    " unique index uq_login(login));");
            prepareStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(User user) throws SQLException {
        PreparedStatement prepareStatement = conn.prepareStatement("insert into users(login, password) values (?, ?)");
        prepareStatement.setString(1, user.getLogin());
        prepareStatement.setString(2, user.getPassword());
        prepareStatement.execute();
    }

    public static User findByLogin(String Login) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("select id, login, password from users where login = ?")) {
            stmt.setString(1, Login);
            ResultSet rSet = stmt.executeQuery();

            if (rSet.next()) {
                    return new User(rSet.getInt(1), rSet.getString(2), rSet.getString(3));
            }
        }
        return new User(-1, "", "");
    }

    public List<User> getAllUsers() throws SQLException {
        ArrayList<User> result = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery("select * from users")
        )
        {
            while (resultSet.next()) {
            result.add(new User(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3)));
            }
        }

        return result;
    }
}
