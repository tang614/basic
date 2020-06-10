package com.tang.test;

import com.tang.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    
    /**
     * 初始化方法：
     * 用于资源的申请，所有的测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }
    
    /**
     * 释放资源的方法
     * 在所有方法执行之后都会执行该方法
     */
    @After
    public void close(){
        System.out.println("close...");
    }
    
    /**
     * 测试add方法
     */
    @Test
    public void testAdd(){
        //创建计算器对象
        Calculator c = new Calculator();
        //调用add方法
        int addResult = c.add(1, 3);
        //System.out.println(addResult);
        
        //断言
        Assert.assertEquals(4,addResult);
    
    }
}
