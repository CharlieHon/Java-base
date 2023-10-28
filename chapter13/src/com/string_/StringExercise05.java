package com.string_;

public class StringExercise05 {
    String str = new String("hsp");
    final char[] ch = {'j', 'a', 'v', 'a'};
    public void change(String str, char ch[]) {
        str = "java";   // str指向常量池的"java"
        ch[0] = 'h';
    }

    public static void main(String[] args) {
        StringExercise05 ex = new StringExercise05();
        ex.change(ex.str, ex.ch);   // ex.str不受影响
        System.out.print(ex.str + ", ");
        System.out.println(ex.ch);  // hsp, hava
    }
}
