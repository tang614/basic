package com.tang.reflect;

import com.tang.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo02 {
    public static void main(String[] args) throws Exception {
        //获取Person的Class对象
        Class personClass = Person.class;
        
        //Field[] getField()获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field:fields){
            System.out.println(field);
        }
    
        Field a = personClass.getField("a");
        System.out.println(a);
        
        //获取成员变量a的值
        Person person = new Person();
        Object value = a.get(person);
        System.out.println(value);
        
        //设置a的值
        a.set(person,"张三");
        System.out.println(person);
        
        //Field[] getDeclaredFields(),获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField:declaredFields){
            System.out.println(declaredField);
        }
        
        Field d = personClass.getDeclaredField("d");
        System.out.println(d);
        //忽略访问权限的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(person);
        System.out.println(value2);
    
    }
}
