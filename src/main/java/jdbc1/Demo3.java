package jdbc1;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author LeafDust
 * @create 2019-09-10 10:51
 */
public class Demo3 {
    public static void main(String[] args) {
        //创建数据库连接池对象
        BasicDataSource dataSource = new BasicDataSource();
        //设置数据库连接信息
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/newdb3");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        //设置初始连接数量
        dataSource.setInitialSize(3);
        //设置最大连接数
        dataSource.setMaxActive(5);
        //从连接池中获取连接  抛异常
        try {
            Connection connection=dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
