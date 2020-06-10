package com.tang.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 追加写/续写：使用两个参数的构造方法
 */
public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
        
        //append:true 表示再次执行时追加在之前的文件之后
        FileOutputStream fos = new FileOutputStream("day_01基础加强\\b.txt",true);
        fos.write("您好".getBytes());
        
        // “\r\n”表示换行
        fos.write("\r\n".getBytes());
        fos.close();
    }
}
