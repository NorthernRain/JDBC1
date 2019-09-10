package jdbc1;

import cn.tedu.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * @author LeafDust
 * @create 2019-09-10 14:42
 */
public class Demo6 {
    public static void main(String[] args) {
        try (Connection connection = DBUtils.getConn()) {
            Statement statement = connection.createStatement();
            statement.execute("create table person(name varchar(10),age int)charset=utf8");
            String sql = "insert into person values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i <= 100; i++) {
                preparedStatement.setString(1, "name" + i);
                preparedStatement.setInt(2, 100 + i);
                preparedStatement.addBatch();
                if (i % 30 == 0) {
                    preparedStatement.executeBatch();
                }
            }
            preparedStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
