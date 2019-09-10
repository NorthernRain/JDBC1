package jdbc1;

import cn.tedu.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author LeafDust
 * @create 2019-09-10 16:25
 */
public class Demo9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入球队名称：");
        String teamName = scanner.nextLine();
        System.out.println("请输入球员姓名：");
        String playerName = scanner.nextLine();
        try (Connection connection = DBUtils.getConn()) {
            String sql = "insert into team values(null,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, teamName);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                int teamId = resultSet.getInt(1);
                String sql1 = "insert into player values(null,?,?)";
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
                preparedStatement1.setString(1, playerName);
                preparedStatement1.setInt(2, teamId);
                preparedStatement1.executeUpdate();
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
