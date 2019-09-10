package jdbc1;

import cn.tedu.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author LeafDust
 * @create 2019-09-10 9:26
 */
public class Demo1 {
    public static void main(String[] args) {
        try (Connection connection = DBUtils.getConn()) {
            Statement statement = connection.createStatement();
            String sql="select * from emp";
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                String ename=resultSet.getString("ename");
                System.out.println(ename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
