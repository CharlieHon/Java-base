package properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties02 {
    public static void main(String[] args) throws IOException {
        // 使用 Properties类 堆区mysql.properties对象
        // 1. 创建Properties对象
        Properties properties = new Properties();
        // 2. 加载指定配置文件
        properties.load(new FileReader("src/mysql.properties"));
        // 3. 把k-v显示到控制台
        properties.list(System.out);
        // 4. 根据key获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名=" + user);
        System.out.println("密码=" + pwd);
    }
}
