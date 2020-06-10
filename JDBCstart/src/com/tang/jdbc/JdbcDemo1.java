package com.tang.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        Statement stmt = null;
        Connection conn = null;
        
        //导入驱动jar包
        
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        
        //获取数据库连接对象
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "120851tzw");
    
        //定义sql语句
        String sql = "update account set salary = 150 where id=1";
        //获取执行sql对象的Statement
        stmt = conn.createStatement();
        
        //执行sql语句
        int count = stmt.executeUpdate(sql);
    
        System.out.println(count);
        
        stmt.close();
        conn.close();
    
    
    }
}
