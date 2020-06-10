package com.tang.junit;

public class CalculateTest {
    public static void main(String[] args) {
        
        //创建对象
        Calculator c = new Calculator();
        //调用方法
        int addResult = c.add(1, 2);
        System.out.println(addResult);
    
        int subResult = c.sub(3, 2);
        System.out.println(subResult);
    }
}

