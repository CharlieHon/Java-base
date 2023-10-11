package chapter07;
public class Homework {
    public static void main(String[] args) {
        Tool t1 = new Tool();
        double[] arr = {1.2, 2.5, 9.1, -1.2};
        Double res = t1.max(arr);
        if(res != null) {
            System.out.println("arr的最大值 = " + res);
        } else {
            System.out.println("arr的输入有误！");
        }
    }
}

class Tool {
    public Double max(double[] arr) {   // 返回一个包装类
        // 先判断arr是否为null，再判断长度是否为零
        if (arr != null && arr.length > 0){
            double res = arr[0];
            for (int i = 1; i < arr.length; ++i) {
                if (arr[i] > res)   res = arr[i];
            }
            return res;
        } else {
            return null;
        }
    }

    public int find(String target, String[] src) {
        if(src != null && src.length > 0) {
            for(int i = 0; i < src.length; ++i) {
                if(target.equals(src[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int[] copyArr(int[] oldArr) {
        int[] newArr = new int[oldArr.length];
        for(int i = 0; i < oldArr.length; ++i) {
            newArr[i] = oldArr[i];
        }
        return newArr;
    }
}