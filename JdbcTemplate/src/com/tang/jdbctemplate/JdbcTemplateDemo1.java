package com.tang.jdbctemplate;

import com.tang.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate入门
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //导入jar包
    
        //创建JDBCTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    
        //调用方法
        String sql = "update account set salary = 5000 where id = ?";
        jdbcTemplate.update(sql,3);
        
    }
    
}
