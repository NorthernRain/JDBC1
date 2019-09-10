package cn.tedu;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author LeafDust
 * @create 2019-09-09 16:47
 */
public class DBUtils {
    public static Connection getConn() throws Exception {
        Properties properties = new Properties();
        InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(ips);
        //注册驱动
        Class.forName(properties.getProperty("driver"));
        //建立连接
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        return connection;
    }
}
