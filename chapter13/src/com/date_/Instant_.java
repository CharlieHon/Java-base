package com.date_;

import java.time.Instant;
import java.util.Date;

public class Instant_ {
    public static void main(String[] args) {
        // 1. 通过静态方法 now() 获取表示当前时间戳的对象
        Instant now = Instant.now();
        System.out.println(now);    // 2023-10-30T12:02:12.096Z
        // 2. 通过 from() 方法把 Instant 转成 Date
        Date date = Date.from(now);
        // 3. 通过 date 的 toInstant() 把 Date 对象转成 Instant 对象
        Instant now1 = date.toInstant();
    }
}
