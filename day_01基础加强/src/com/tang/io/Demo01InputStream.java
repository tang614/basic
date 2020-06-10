package com.tang.io;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo01InputStream {
    public static void main(String[] args) throws IOException {
    
        FileInputStream fis = new FileInputStream("day_01基础加强\\a.txt");
        
        // int read()读取文件中的一个字节并返回，读取到文件的末尾并返回-1
        /*int i = fis.read();
        System.out.println(i);*/  //97
    
        /*i = fis.read();
        System.out.println(i);*/  //98
    
        /*i = fis.read();
        System.out.println(i);*/  //99
    
        /*i = fis.read();
        System.out.println(i);*/  //-1
        
        //以上读取过程为重复过程
        int len = 0; //记录读取到的字节
        while ((len = fis.read())!=-1){
            System.out.println(len);
        }
        
        //释放资源
        fis.close();
    }
}
