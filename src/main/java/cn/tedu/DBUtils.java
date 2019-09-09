package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author LeafDust
 * @create 2019-09-09 16:47
 */
public class DBUtils {
    public static Connection getConn() throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3", "root", "123456");
        return connection;
    }
}
