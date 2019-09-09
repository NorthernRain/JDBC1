package cn.tedu;


import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author LeafDust
 * @create 2019-09-09 16:52
 */
public class Demo04 {
    @Test
    public void insert() {
        try (Connection connection = DBUtils.getConn()) {
            Statement statement = connection.createStatement();
            String sql = "insert into emp(empno,ename) values(101,'Lucy')";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("insert");
    }

    @Test
    public void update() {
        try (Connection connection = DBUtils.getConn()) {
            Statement statement = connection.createStatement();
            String sql = "update emp set ename='hanmeimei' where ename='Lucy'";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("update");
    }

    @Test
    public void delete() {
        try (Connection connection = DBUtils.getConn()) {
            Statement statement = connection.createStatement();
            String sql = "delete from emp where ename='hanmeimei'";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("delete");
    }

    @Test
    public void select() {
        try (Connection connection = DBUtils.getConn()) {
            Statement statement = connection.createStatement();
            String sql = "select empno,ename from emp where ename='hanmeimei'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int empno = resultSet.getInt(1);
                String ename = resultSet.getString(2);
                System.out.println(empno + ":" + ename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("select");
    }
}
