package service;

import dao.UserDaoFactory;
import dao.UserDao;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance;
    private UserDao userDao;

    private UserServiceImpl() {
        try {
            UserDaoFactory userDaoFactory = new UserDaoFactory();
            userDao = userDaoFactory.getUserDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User login(String login, String password) {
        return userDao.login(login, password);
    }
}
