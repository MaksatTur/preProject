package dao;

import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserHibernateDao implements UserDaoI {
    private Session session;

    public UserHibernateDao(Session session) {
        this.session = session;
    }

    @Override
    public List<User> getAllUsers() throws HibernateException {
        Query query = session.createQuery("from User");
        return query.list();
    }

    @Override
    public void deleteUserById(long id) throws HibernateException {
        User user = (User) session.get(User.class, id);
        if (user != null) {
            Transaction trx = session.beginTransaction();
            session.delete(user);
            trx.commit();
        }
    }

    @Override
    public void editUser(User user) throws HibernateException {
        Transaction trx = session.beginTransaction();
        session.update(user);
        trx.commit();
    }

    @Override
    public User getUserById(long id) throws HibernateException {
        return (User) session.get(User.class, id);
    }

    @Override
    public void addUser(User user) throws HibernateException {
        Transaction trx = session.beginTransaction();
        session.save(user);
        trx.commit();
    }
}
