package jdbc1;

import cn.tedu.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author LeafDust
 * @create 2019-09-10 11:46
 */
public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        try (Connection connection = DBUtils.getConn()) {
           /* Statement statement = connection.createStatement();
            String sql = "select count(*) from user where username='" + username + "' and password='" + password + "'";
            System.out.println(sql);
            */
            String sql = "select count(*) from user where username=? and password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    System.out.println("登录成功！");
                } else {
                    System.out.println("登录失败！");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
