package cn.tedu;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * @author LeafDust
 * @create 2019-09-09 15:55
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3", "root", "123456");
            Statement statement = connection.createStatement();
            //String sql="insert into emp(empno,ename) values(100,'Tom')";
            // String sql="update emp set ename='Jerry' where ename='Tom'" ;
            //String sql="DELETE FROM emp WHERE ename='Jerry'" ;
            //statement.executeUpdate(sql);
            String sql = "select ename,deptno,sal FROM emp";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String ename = resultSet.getString("ename");
                int deptno = resultSet.getInt("deptno");
                double sal = resultSet.getDouble("sal");
                System.out.println(ename + "\0" + deptno + "\0" + sal);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
