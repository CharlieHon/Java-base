package properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Properties01 {
    public static void main(String[] args) throws IOException {
        // 读取mysql.properties文件，并得到ip，user和pwd
        String filePath = "src/mysql.properties";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = null;
        while ((line = br.readLine()) != null) {    // 循环读取
            String[] split = line.split("=");
            // 如果要求指定得到ip值
            if ("ip".equals(split[0]))
                System.out.println(split[0] + "值：" + split[1]);
        }
        br.close();
    }
}
