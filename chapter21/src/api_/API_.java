package api_;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 演示 InetAddress类 的使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        // 1. 获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);  // Charlie/169.254.93.117
        // 2. 根据指定的主机名，获取InetAddress对象
        InetAddress host1 = InetAddress.getByName("Charlie");
        System.out.println("host1=" + host1);   // host1=Charlie/169.254.93.117
        // 3. 根据域名返回InetAddress对象，比如 www.baidu.com 对应的
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2=" + host2);   // host2=www.baidu.com/182.61.200.7
        // 4. 通过InetAddress对象，获取对应的地址
        String hostAddress = host2.getHostAddress();
        System.out.println("host2对应的ip=" + hostAddress);    // host2对应的ip=182.61.200.7
        // 5. 通过InetAddress对象，获取对应的主机名/域名
        String hostName = host2.getHostName();
        System.out.println("host2对应的主机名/域名=" + hostName);   // host2对应的主机名/域名=www.baidu.com
    }
}
