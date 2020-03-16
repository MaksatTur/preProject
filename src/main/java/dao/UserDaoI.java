package dao;

import model.User;

import java.util.List;

public interface UserDaoI {
    List<User> getAllUsers();
    void deleteUserById(long id);
    void editUser(User user);
    User getUserById(long id);
    void addUser(User user);
}
