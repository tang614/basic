package com.tang.reflect;

import com.tang.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo03 {
    public static void main(String[] args) throws Exception {
        //获取Person的Class对象
        Class personClass = Person.class;
    
        //获取有参数的构造方法
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        
        //使用有参数的构造方法创建对象
        Object person = constructor.newInstance("张三", 45);
        System.out.println(person);
        
        //获取无参数的构造方法
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        
        //使用无参构造器创建对象
        Object o = constructor1.newInstance();
        System.out.println(o);
        
        //class对象中有newInstance()方法和无参构造器创建对象一样
        Object o1 = personClass.newInstance();
        System.out.println(o1);
    }
}
