package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author LeafDust
 * @create 2019-09-09 14:34
 */
public class Demo1 {
    public static void main(String[] args) {

        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3","root","123456");
            Statement statement=connection.createStatement();
            String sql="create table t1(id int,name varchar(10))charset=utf8";
            statement.execute(sql);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
