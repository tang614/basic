package com.tang.reflect;

import com.tang.domain.Person;

public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        
        //获取Class对象的方式
        
        //1、Class.forName(全类名)
        Class cls1 = Class.forName("com.tang.domain.Person");
        System.out.println(cls1);
        
        //2、类名.class
        Class cls2 = Person.class;
        System.out.println(cls2);
        
        //3、对象.getClass()
        Person p = new Person();
        Class cls3 = p.getClass();
    }
}
