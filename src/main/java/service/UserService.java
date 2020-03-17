package service;

import dao.UserDaoFactory;
import dao.UserDaoI;
import dao.UserHibernateDao;
import dao.UserJdbcDao;
import model.User;
import org.hibernate.SessionFactory;
import util.DbUtil;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class UserService implements UserServiceI {
    private static UserService instance;
    private UserDaoI userDao;

    private UserService() {
        try {
            UserDaoFactory userDaoFactory = new UserDaoFactory();
            userDao = userDaoFactory.getUserDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
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
}
