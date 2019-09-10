package jdbc1;

import cn.tedu.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author LeafDust
 * @create 2019-09-10 15:48
 */
public class Demo8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入员工姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入工资：");
        int sal = scanner.nextInt();
        try (Connection connection = DBUtils.getConn()) {
            /*Statement statement = connection.createStatement();
            statement.execute("create table myemp(id int PRIMARY KEY auto_increment,name varchar(10),sal int)charset=utf8");*/
            String sql = "INSERT INTO myemp VALUES( NULL,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, sal);
            preparedStatement.executeUpdate();
            System.out.println("save success");
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println("主键：" + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
