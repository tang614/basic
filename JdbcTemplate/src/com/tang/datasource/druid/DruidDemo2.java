package com.tang.datasource.druid;

import com.tang.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类,给account表添加一条记录
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt =null;
        
        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            //定义sql
            String sql = "insert into account values(null,?,?)";
            //获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //给？赋值
            pstmt.setString(1,"wangwu");
            pstmt.setDouble(2,500);
            //执行sql
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }
    
    }
}
