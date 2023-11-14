package wrap_;

public class Test {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader = new BufferedReader_(new FileReader_());
        bufferedReader.readFiles(2);
        // 多次读取字符串
        BufferedReader_ bufferedReader1 = new BufferedReader_(new StringReader_());
        bufferedReader1.readStrings(5);
    }
}
