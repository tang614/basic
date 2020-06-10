package com.tang.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01OutputStream {
    public static void main(String[] args) throws IOException {
        
        FileOutputStream fos = new FileOutputStream(new File("day_01基础加强\\a.txt"));
        
        //添加数字100
        fos.write(49);
        fos.write(48);
        fos.write(48);
        
        //添加字母ABCDE
        byte[] bytes = {65,66,67,68,69};
        fos.write(bytes);
        
        //off表示开始索引
        fos.write(bytes,1,2);
        
        //写入字符串
        byte[] bytes1 = "您好".getBytes();
        fos.write(bytes1);
        
        //释放资源
        fos.close();
    }
}
