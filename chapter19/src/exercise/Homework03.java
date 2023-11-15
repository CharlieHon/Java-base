package exercise;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * 1. 编写一个dog.properties
 * name=tom
 * age=5
 * color=red
 * 2. 编写Dog类(name, age, color) 创建一个dog对象，读取dog.properties 用相应的
 * 内容完成属性初始化，并输出
 * 3. 将创建的Dog对象，序列化到文件 dog.dat文件
 */
public class Homework03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name", "tom");
        properties.setProperty("age", "5");
        properties.setProperty("color", "red");
        properties.store(new FileWriter("src/dog.properties"), null);

        Dog dog = new Dog();
        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");
        dog.setAge(age);
        dog.setColor(color);
        dog.setName(name);
        System.out.println(dog);

        String fileName = "e:/dog.dat";    // 序列化目标文件
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("创建文件：" + fileName);
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(dog);
        // 关闭流
        oos.close();
        System.out.println("序列化dog对象完成");
    }

    @Test
    public void m1() throws IOException, ClassNotFoundException {
        // 反序列化 dog对象
        String srcFilePath = "e:/dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(srcFilePath));
        Object obj = ois.readObject();
        System.out.println("反序列化成功");
        Dog dog = (Dog) obj;
        System.out.println(dog);
        ois.close();
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog() {
    }

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}