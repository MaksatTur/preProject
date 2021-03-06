package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void deleteUserById(long id);
    void editUser(User user);
    User getUserById(long id);
    void addUser(User user);
    User login(String login, String password);
}
