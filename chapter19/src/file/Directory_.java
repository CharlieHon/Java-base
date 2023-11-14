package file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Directory_ {
    public static void main(String[] args) {

    }

    // 判断 e:\\news3.txt 是否存在，如果存在就删除
    @Test
    public void m1() {
        String filePath = "e:/news3.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("文件删除成功");
            } else {
                System.out.println("文件删除失败");
            }
        } else {
            System.out.println("该文件不存在...");
        }
    }

    // 判断 e:\\demo 是否存在，如果存在就删除
    // 在java编程中，目录也被当作文件
    @Test
    public void m2() {
        String filePath = "e:/demo";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("目录删除成功");
            } else {
                System.out.println("目录删除失败");
            }
        } else {
            System.out.println("该目录不存在...");
        }
    }

    // 判断 e:/demo/a/b 是否存在，如果不存在就创建
    // 创建一级目录：mkdir()
    // 创建多级目录：mkdirs()
    @Test
    public void m3() {
        String direPath = "e:/demo/a/b";
        File file = new File(direPath);
        if (file.exists()) {
            System.out.println("该目录存在");
        } else {
            if (file.mkdirs()) {    // mkdirs：创建多级目录
                System.out.println("多级目录创建成功");
            } else {
                System.out.println("多级目录创建失败");
            }
        }
    }
}
