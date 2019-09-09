package cn.tedu;


import org.junit.Test;

import java.sql.Connection;
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
        System.out.println("update");
    }

    @Test
    public void delete() {
        System.out.println("delete");
    }

    @Test
    public void select() {
        System.out.println("select");
    }
}
