package dao;

import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import util.DbHelper;

import java.util.List;

public class UserHibernateDao implements UserDao {
    private SessionFactory sessionFactory;

    public UserHibernateDao() {
        sessionFactory = createSessionFactory();
    }

    private SessionFactory createSessionFactory() {
        Configuration configuration = DbHelper.getInstance().getConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    @Override
    public List<User> getAllUsers() throws HibernateException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User").list();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    @Override
    public void deleteUserById(long id) throws HibernateException {
        Session session = sessionFactory.openSession();
        User user = (User) session.get(User.class, id);
        if (user != null) {
            Transaction trx = session.beginTransaction();
            session.delete(user);
            trx.commit();
        }
        session.close();
    }

    @Override
    public void editUser(User user) throws HibernateException {
        Session session = sessionFactory.openSession();
        Transaction trx = session.beginTransaction();
        session.merge(user);
        trx.commit();
        session.close();
    }

    @Override
    public User getUserById(long id) throws HibernateException {
        Session session = sessionFactory.openSession();
        User user = (User) session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void addUser(User user) throws HibernateException {
        Session session = sessionFactory.openSession();
        Transaction trx = session.beginTransaction();
        session.save(user);
        trx.commit();
        session.close();
    }
}
