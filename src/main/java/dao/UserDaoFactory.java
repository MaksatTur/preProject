package dao;

import util.DbUtil;

import java.io.*;
import java.util.Properties;

public class UserDaoFactory {

    private final String daoType = loadProperty();

    public UserDaoFactory() throws IOException {
    }

    public UserDaoI getUserDao() throws Exception {
        UserDaoI userDao = null;
        switch (daoType) {
            case "UserJdbcDao":
                userDao = new UserJdbcDao(DbUtil.getInstance().getMysqlConnection());
                break;
            case "UserHibernateDao":
                userDao = new UserHibernateDao(DbUtil.getInstance().getSessionFactory().openSession());
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
