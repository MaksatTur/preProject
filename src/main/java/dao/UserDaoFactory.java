package dao;

import util.DbHelper;

import java.io.*;
import java.util.Properties;

public class UserDaoFactory {

    private final String daoType = loadProperty();

    public UserDaoFactory() throws IOException {
    }

    public UserDao getUserDao() throws Exception {
        UserDao userDao = null;
        switch (daoType) {
            case "UserJdbcDao":
                userDao = new UserJdbcDao(DbHelper.getInstance().getConnection());
                break;
            case "UserHibernateDao":
                userDao = new UserHibernateDao();
                break;
            default:
                userDao = new UserHibernateDao();
        }
        return userDao;
    }

    private String loadProperty() throws IOException {
        String result;
        Properties properties = new Properties();
        InputStream in = getClass().getResourceAsStream("..\\app.properties");
        properties.load(in);
        result = properties.getProperty("daotype");
        return result;
    }
}
