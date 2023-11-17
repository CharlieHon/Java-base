package qqframe;

import qqserver.service.QQServer;

/**
 * 该类创建QQServer对象，启动后台的服务
 */
public class QQFrame {
    public static void main(String[] args) {
        new QQServer();
    }
}
