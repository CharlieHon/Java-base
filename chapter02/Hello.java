// 这是java的快速入门，演示java的开发步骤
// 1. public class Hello 表示Hello是一个类，是一个public公有的类
// 2. Hello{} 表示一个类的开始和结束
// 3. public static void main(String[] args) 表示一个主方法，即程序的入口
// 4. main() {} 表示方法的开始和结束
// 5. System.out.println("Hello, world!"); 表示输出“Hello, world!”到屏幕
// 6. ;表示语句结束
public class Hello {	// 如果源文件中包含一个public类，则源文件名称必须与之相同
	// 编写一个主方法
	public static void main(String[] args) {
		System.out.println("Hello, Charlie!");
	}
}

// 一个源文件中最多只能有一个public类。其他类的个数不限
// Dog是一个类
// 编译后，每一个类，都对应一个.class
class Dog{
	// 也可以将main方法写在非public类中，然后将指定运行非public类，这样入口方法就是
	// 非public的main方法
	public static void main(String[] args){
		System.out.println("Hello, Dog!");
	}
}

class Tiger{
	public static void main(String[] args){
		System.out.println("Hello, Tiger!");
	}
}