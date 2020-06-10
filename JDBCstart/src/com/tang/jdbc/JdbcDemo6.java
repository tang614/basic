package com.tang.jdbc;

import com.tang.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 登录案例，但存在sql注入问题
 */
public class JdbcDemo6 {
    public static void main(String[] args) {
        //键盘输入，接受用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        String username = sc.nextLine();
        System.out.println("请输入你的密码");
        String password = sc.nextLine();
    
        boolean flag = new JdbcDemo6().login(username, password);
        
        if(flag){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
    
    
    public boolean login(String username,String password){
        if(username == null || password ==null){
            return false;
        }
    
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
    
        //连接数据库，检查用户名和密码是否正确
    
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where name = '" + username + "'and password = '" + password + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(stmt,conn,rs);
        }
    
    
        return false;
    }
}
