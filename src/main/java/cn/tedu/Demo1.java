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
        //1.注册驱动： 告诉虚拟机使用的是哪个数据库软件
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3", "root", "123456");
            System.out.println(connection);
            //3.创建SQL执行对象
            Statement statement = connection.createStatement();
            //4.执行SQL语句
            String sql = "create table jdbct1(id int primary key auto_increment,name varchar(10)) charset=utf8";
            statement.execute(sql);
            System.out.println("success");
            //5.关闭资源
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
