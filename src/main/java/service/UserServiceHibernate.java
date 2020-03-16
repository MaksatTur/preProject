package service;

import dao.UserHibernateDao;
import model.User;
import org.hibernate.SessionFactory;
import util.DbUtil;

import java.util.List;

public class UserServiceHibernate implements UserServiceI {
    private SessionFactory sessionFactory;
    private static UserServiceHibernate userServiceHibernate;

    private UserServiceHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserServiceHibernate getInstance() {
        if (userServiceHibernate == null) {
            userServiceHibernate = new UserServiceHibernate(DbUtil.getSessionFactory());
        }
        return userServiceHibernate;
    }

    @Override
    public List<User> getAllUsers() {
        return new UserHibernateDao(sessionFactory.openSession()).getAllUsers();
    }

    @Override
    public void deleteUserById(long id) {
        new UserHibernateDao(sessionFactory.openSession()).deleteUserById(id);
    }

    @Override
    public void editUser(User user) {
        new UserHibernateDao(sessionFactory.openSession()).editUser(user);
    }

    @Override
    public User getUserById(long id) {
        return new UserHibernateDao(sessionFactory.openSession()).getUserById(id);
    }

    @Override
    public void addUser(User user) {
        new UserHibernateDao(sessionFactory.openSession()).addUser(user);
    }
}
