package wrap_;

public class BufferedReader_ extends Reader_ {  // 包装流
    private Reader_ reader_;    // 属性是 Reader_类型

    // 接受 Reader子类对象
    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    // 多次读取文件
    public void readFiles(int num) {
        for (int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }

    // 扩展 readString，批量处理字符串数据
    public void readStrings(int num) {
        for (int i = 0; i < num; i++) {
            reader_.readString();
        }
    }
}
