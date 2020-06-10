package com.tang.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门：account表添加一条记录、删除一条记录
 */
public class JdbcDemo2 {
    public static void main(String[] args) throws Exception {
        Statement stmt = null;
        Connection conn = null;

        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        
        //获取数据库连接对象
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "120851tzw");
    
        //定义sql语句
        String sql = "insert into account values(null,'tom',500)";
        //String sql = "delete from account where id = 1";
        
        //获取执行sql对象的Statement
        stmt = conn.createStatement();
        
        //执行sql语句
        int count = stmt.executeUpdate(sql);
        
        if(count > 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    
        //释放资源
        stmt.close();
        conn.close();
    
    
    }
}
