package inputstream_;


import outputstream_.Dog;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {   // 演示反序列化
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "e:/data.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        /*
        1. 读取(反序列化)的顺序需要和保存数据(序列化)的顺序一致
        2. 否则会出现异常
         */
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readUTF());
        Object dog = ois.readObject();
        System.out.println("运行类型=" + dog.getClass());
        // dog信息=Dog{name='旺财', age=3, color='null'}null outputstream_.Master@66a29884
        System.out.println("dog信息=" + dog);
        // 1. 如果希望调用Dog的方法，需要向下转型
        // 2. 需要将Dog类的定义，拷贝到可以引用的位置
        Dog dog1 = (Dog) dog; // 'outputstream_.Dog' is not public in 'outputstream_'. Cannot be accessed from outside package
        System.out.println(dog1.getName());
    }
}
