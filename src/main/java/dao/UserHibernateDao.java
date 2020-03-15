package dao;

import interfaces.UserDao;
import model.User;

import java.util.List;

public class UserHibernateDao implements UserDao {
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUserById(long id) {

    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }
}
