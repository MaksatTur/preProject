package service;

import dao.UserJdbcDao;
import interfaces.UserDao;
import model.User;
import util.DbUtil;

import java.sql.Connection;
import java.util.List;

public class UserService implements interfaces.UserService {

    private UserJdbcDao userDao;

    public UserService() {
        try {
            Connection connection = DbUtil.getInstance().getMysqlConnection();
            this.userDao = new UserJdbcDao(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
