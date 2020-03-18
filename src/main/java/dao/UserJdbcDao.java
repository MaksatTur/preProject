package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao {
    private Connection connection;

    public UserJdbcDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            String query = "select id, name, surname, dateOfBirth, passport from users";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSurname(rs.getString(3));
                user.setDateOfBirth(rs.getDate(4));
                user.setPassport(rs.getString(5));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void deleteUserById(long id) {
        String query = "delete from users where id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editUser(User user) {
        String query = "update users set name = ?, surname = ?, dateOfBirth = ?, passport = ? where id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.setDate(3, new Date(user.getDateOfBirth().getTime()));
            stmt.setString(4, user.getPassport());
            stmt.setLong(5, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(long id) {
        User user = null;
        String query = "select id, name, surname, dateOfBirth, passport from users where id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSurname(rs.getString(3));
                user.setDateOfBirth(rs.getDate(4));
                user.setPassport(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        String query = "insert into users(name, surname, dateOfBirth, passport) values(?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.setDate(3, new Date(user.getDateOfBirth().getTime()));
            stmt.setString(4, user.getPassport());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
