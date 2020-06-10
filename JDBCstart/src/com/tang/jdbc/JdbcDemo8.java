package com.tang.jdbc;

import com.tang.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDemo8 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
    
        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            
            //开启事务
            conn.setAutoCommit(false);
            
            //定义sql
            String sql1 = "update account set salary = salary + ? where id = ?";
            String sql2 = "update account set salary = salary - ? where id = ?";
            
            //获取执行sql对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            
            //设置参数
            pstmt1.setDouble(1,100);
            pstmt1.setInt(2,2);
            
            pstmt2.setDouble(1,100);
            pstmt2.setInt(2,3);
            
            pstmt1.executeUpdate();
            //手动制造异常
            //int i= 3/0;
            pstmt2.executeUpdate();
            
            //提交事务
            conn.commit();
            
            
        } catch (SQLException e) {
            //事务回滚
            if(conn !=null){
                try {
                    conn.rollback();
                } catch (SQLException a) {
                    a.printStackTrace();
                }
            }
            
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt1,conn);
            JDBCUtils.close(pstmt2,null);
            
            
        }
    }
}
