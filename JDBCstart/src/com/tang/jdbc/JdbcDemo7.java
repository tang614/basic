package com.tang.jdbc;

import com.tang.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 登录案例，消除sql注入问题
 */
public class JdbcDemo7 {
    public static void main(String[] args) {
        //键盘输入，接受用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        String username = sc.nextLine();
        System.out.println("请输入你的密码");
        String password = sc.nextLine();
    
        boolean flag = new JdbcDemo7().login(username, password);
        
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
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        //连接数据库，检查用户名和密码是否正确
    
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where name = ? and password = ?";
            //获取执行sql对象
            pstmt = conn.prepareStatement(sql);
            //给？赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //执行查询，不需要传递sql
            rs = pstmt.executeQuery();
            
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,conn,rs);
            
            if(pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
        }
    
    
        return false;
    }
}
