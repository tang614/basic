package com.tang.jdbc;

import com.tang.domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个对象，查询emp表数据并将其封装为对象，然后装载集合，返回
 */
public class JdbcDemo4 {
    
    public static void main(String[] args) {
        List<Emp> list = new JdbcDemo4().findAll();
        System.out.println(list);
    }
    
    /**
     * 查询所有emp对象
     * @return
     */
    public List<Emp> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = new ArrayList<Emp>();
        try{
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "120851tzw");
            //定义sql语句
            String sql = "select * from emp";
            //获取执行sql对象的Statement
            stmt = conn.createStatement();
            //执行sql语句
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                
                //创建emp对象，并赋值
                Emp emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setSalary(salary);
                
                //装载集合
                list.add(emp);
            }
            
        }catch (ClassNotFoundException | SQLException e){
           e.printStackTrace();
        }finally {
            //释放资源
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return list;
    }
}
