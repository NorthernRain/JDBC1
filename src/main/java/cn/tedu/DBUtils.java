package cn.tedu;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
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
    //创建数据库连接池对象
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        Properties properties = new Properties();
        InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(ips);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //注册驱动

        //设置数据库连接信息
        dataSource.setDriverClassName(properties.getProperty("driver"));
        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
        //设置初始连接数量
        dataSource.setInitialSize(3);
        //设置最大连接数
        dataSource.setMaxActive(5);
    }
    public static Connection getConn() throws Exception {
        //从连接池中获取连接  抛异常
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        return connection;
    }
}
