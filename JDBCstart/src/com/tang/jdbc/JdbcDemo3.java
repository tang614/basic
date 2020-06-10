package com.tang.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC快速入门：查询account表
 */
public class JdbcDemo3 {
    public static void main(String[] args) throws Exception {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        
        //获取数据库连接对象
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "120851tzw");
    
        //定义sql语句
        String sql = "select * from account";
        
        //获取执行sql对象的Statement
        stmt = conn.createStatement();
        
        //执行sql语句
        rs = stmt.executeQuery(sql);
        
        //游标向下移一行
        while (rs.next()){
            //获取数据
            int id = rs.getInt(1);
            String name = rs.getString("name");
            double salary = rs.getDouble(3);
            
            System.out.println(id+"----"+name+"----"+salary);
        }
        
        //释放资源
        stmt.close();
        conn.close();
        rs.close();
    
    
    }
}
