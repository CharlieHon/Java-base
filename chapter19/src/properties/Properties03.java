package properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties03 {
    public static void main(String[] args) throws IOException {
        // 使用Properties创建/修改对象
        Properties properties = new Properties();   // class Properties extends Hashtable<Object,Object>
        // 创建
        // 如果该文件没有key，就是创建
        // 如果有，就是修改
        properties.setProperty("charset", "utf-8");
        properties.setProperty("user", "汤姆丁");  // 保存时，中文存储对应的Unicode编码
        properties.setProperty("pwd", "888888");
        // 将k-v存储到文件中即可
        properties.store(new FileOutputStream("src/mysql2.properties"), null);
        System.out.println("保存配置文件成功~");
    }
}
