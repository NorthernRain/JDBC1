package jdbc1;

import cn.tedu.DBUtils;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @author LeafDust
 * @create 2019-09-10 14:29
 */
public class Demo5 {
    public static void main(String[] args) {
        String sql1 = "insert into emp(empno,ename) values(200,'aaa')";
        String sql2 = "insert into emp(empno,ename) values(201,'bbb')";
        String sql3 = "insert into emp(empno,ename) values(202,'ccc')";
        String sql4 = "insert into emp(empno,ename) values(203,'ddd')";
        try (Connection connection = DBUtils.getConn()) {
            Statement statement=connection.createStatement();
            statement.addBatch(sql1);
            statement.addBatch(sql2);
            statement.addBatch(sql3);
            statement.addBatch(sql4);
            statement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
