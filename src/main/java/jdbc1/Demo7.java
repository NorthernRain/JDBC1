package jdbc1;

import cn.tedu.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author LeafDust
 * @create 2019-09-10 15:12
 */
public class Demo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入查询的页数：");
        int page = scanner.nextInt();
        System.out.println("请输入查询的条数：");
        int count = scanner.nextInt();
        try (Connection connection = DBUtils.getConn()) {
            String sql = "select * from person limit ?,?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (page - 1) * count);
            preparedStatement.setInt(2, count);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String name=resultSet.getString(1);
                int age=resultSet.getInt(2);
                System.out.println(name+": "+age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
