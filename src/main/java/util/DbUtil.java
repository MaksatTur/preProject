package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static DbUtil instance;

    private DbUtil() {
    }

    public static DbUtil getInstance() {
        if (instance == null) {
            instance = new DbUtil();
        }
        return instance;
    }

    public Connection getMysqlConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:mysql://").
                    append("localhost:").
                    append("3306/").
                    append("task1?").
                    append("serverTimezone=Asia/Bishkek");
            return DriverManager. getConnection(url.toString(), "root", "root");
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
}
