package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author LeafDust
 * @create 2019-09-09 15:33
 */
public class Demo2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3","root","123456");
            Statement statement=connection.createStatement();
            String sql="drop table t1";
            statement.execute(sql);
            System.out.println("delete successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
