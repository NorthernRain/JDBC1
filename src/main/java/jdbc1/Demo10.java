package jdbc1;

import cn.tedu.DBUtils;

import java.sql.*;

/**
 * @author LeafDust
 * @create 2019-09-10 17:20
 */
public class Demo10 {
    public static void main(String[] args) {
        try (Connection connection = DBUtils.getConn()) {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.println("数据库名：" + databaseMetaData.getDatabaseProductName());
            System.out.println("数据库驱动版本：" + databaseMetaData.getDriverVersion());
            System.out.println("用户名：" + databaseMetaData.getUserName());

            String sql = "select * from emp";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            for (int i = 0; i < count; i++) {
                String name = resultSetMetaData.getColumnName(i + 1);
                String type = resultSetMetaData.getColumnTypeName(i + 1);
                System.out.println(name + ":" + type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
