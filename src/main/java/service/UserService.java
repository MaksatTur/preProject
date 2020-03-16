package service;

import dao.UserDaoI;
import dao.UserHibernateDao;
import dao.UserJdbcDao;
import model.User;
import org.hibernate.SessionFactory;
import util.DbUtil;

import java.sql.Connection;
import java.util.List;

public class UserService implements UserServiceI {

    private UserDaoI userDao;

    public UserService(boolean isJDBC) {
        if (isJDBC) {
            try {
                Connection connection = DbUtil.getInstance().getMysqlConnection();
                this.userDao = new UserJdbcDao(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            this.userDao = new UserHibernateDao(DbUtil.getSessionFactory().openSession());
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
