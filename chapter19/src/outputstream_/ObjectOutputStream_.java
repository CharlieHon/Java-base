package outputstream_;

import java.io.*;

public class ObjectOutputStream_ {
    // 演示ObjectOutputStream的使用，完成数据的序列化
    public static void main(String[] args) throws IOException {
        // 序列化后，保存的文件格式，不是文本，而是按照它的格式来保存
        String filePath = "e:/data.dat";
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeInt(100); // 自动装箱，下同
        oos.writeBoolean(true);
        oos.writeChar('h');
        oos.writeUTF("自由平等");
        // 保存一个Dog对象
        oos.writeObject(new Dog("旺财", 3, "中国", "黄色"));
        oos.close();
        System.out.println("完成序列化...");
    }
}