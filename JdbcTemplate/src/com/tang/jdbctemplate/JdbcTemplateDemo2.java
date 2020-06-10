package com.tang.jdbctemplate;

import com.tang.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo2 {
    
    //Junit单元测试，可以让方法独立执行
    
    
    //获取JDBCTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    
    
    /**
     * 将id = 1的员工工资改为800
     */
    @Test
    public void test1(){
        //定义sql
        String sql = "update emp set salary = 800 where id = 1";
        template.update(sql);
    }
    
    
    /**
     * 添加一条记录
     */
    @Test
    public void test2(){
        String sql = "insert into emp(id,name,salary) values(?,?,?)";
        template.update(sql,null,"ton",900);
    }
}
