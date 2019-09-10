package jdbc1;

import cn.tedu.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author LeafDust
 * @create 2019-09-10 18:32
 */
public class Demo99 {
    public static void insertIntoPlayer(Connection connection, String sql_search, String playerName, int teamId) throws Exception {
        int playerId = -1;
        sql_search = "select id from player where name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql_search);
        preparedStatement.setString(1, playerName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            playerId = resultSet.getInt(1);
        }
        if (playerId == -1) {
            String sql1 = "insert into player values(null,?,?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setString(1, playerName);
            preparedStatement1.setInt(2, teamId);
            preparedStatement1.executeUpdate();
        }
    }

    public static void main(String[] args) {
        int teamId = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入球队名称：");
        String teamName = scanner.nextLine();
        System.out.println("请输入球员姓名：");
        String playerName = scanner.nextLine();
        try (Connection connection = DBUtils.getConn()) {
            String sql_search = "select id from team where name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql_search);
            preparedStatement.setString(1, teamName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                teamId = resultSet.getInt(1);
            }
            if (teamId == -1) {
                String sql = "insert into team values(null,?)";
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement1.setString(1, teamName);
                preparedStatement1.executeUpdate();
                ResultSet resultSet1 = preparedStatement1.getGeneratedKeys();
                while (resultSet1.next()) {
                    teamId = resultSet1.getInt(1);
                    insertIntoPlayer(connection, sql_search, playerName, teamId);
                }
            } else {
                insertIntoPlayer(connection, sql_search, playerName, teamId);
            }
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
