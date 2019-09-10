package jdbc1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author LeafDust
 * @create 2019-09-10 9:52
 */
public class Demo2 {
    public static void main(String[] args) {
        try {
            Properties properties=new Properties();
            InputStream ips=Demo2.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(ips);
            String name=properties.getProperty("name");
            String age=properties.getProperty("age");
            System.out.println(name+":"+age);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
