/* Java-Chapter02作业 */
// JDK, JRE, JVM的关系
/**
 * JDK(Java Development Kit，Java开发工具包),
 * JRE(Java Runtime Environment，Java运行环境)
 * JVM(Java Virtual Machine，Java虚拟机)
 * 1. JDK = JRE + java开发工具(java, javac, javadoc等)
 * 2. JRE = JVM + 核心类库[类]
 */

// 环境变量path配置及其作用
/**
 * 1. 环境变量的作用是为了在dos的任意目录，可以
 * 使用javac和java目录
 * 2. 先配置 JAVA_HOME = 指向jdk安装的主目录
 * 3. 编辑 path 环境变量，增加 %JAVA_HOME%\bin (%%表示引用)
 */

// Java编写步骤
/**
 * 1. 编写 java 的源代码
 * 2. javac 编译，得到对应的 .class 字节码文件
 * 3. java 运行，本质就是把 .class 加载到jvm 运行
*/

// Java编写的7个规范
/**
 * 1. 类，方法的注释，使用 javadoc 的方式，即文档注释
 * 2. 非 javadoc 注释，往往是对代码的说明(给程序的维护者)，说明如何修改，注意事项
 * 3. 使用 tab ，整体将代码右移，使用 shift+tab 整体左移
 * 4. 运算符和 = 的两边，给空格
 * 5. 源码文件使用utf-8 编码
 * 6. 行宽的字符不要超过 80
 * 7. 代码编程风格有两种 次行风格 行尾风格(推荐)
 */

// 初学java易犯错误
/**
 * 1. 编译或者运行时，找不到文件 javac Hello.java，把文件名或者目录找对
 * 2. 主类名和文件名不一致，修改时保持一致即可
 * 3. 缺少 ;
 * 4. 拼写错误，比如 1 -> l 0 -> o
 */