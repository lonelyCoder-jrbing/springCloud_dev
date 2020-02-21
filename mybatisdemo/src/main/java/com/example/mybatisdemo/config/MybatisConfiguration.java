package com.example.mybatisdemo.config;


import com.example.mybatisdemo.intercepters.page.PageInterceptor;
import com.example.mybatisdemo.intercepters.sqlExecuteTimeCount.SqlExecuteTimeCountInterceptor;
import com.example.mybatisdemo.intercepters.sqlExecuteTimeCount.SqlExecuteTimeCountInterceptor2;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaClass;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

import java.util.Properties;

/**
 * mybatis配置
 */
@Configuration
public class MybatisConfiguration {
//https://blog.csdn.net/wuyuxing24/article/details/89343951
    @Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty(PageInterceptor.PROPERTIES_KEY_DATABASE_TYPE, PageInterceptor.DATABASE_TYPE_MYSQL);
        properties.setProperty(PageInterceptor.PROPERTIES_KEY_PAGE_EXPRESSION_MATCHING, ".*Page.*");
        properties.setProperty(PageInterceptor.PROPERTIES_KEY_COUNT_SUFFIX, "_COUNT");
        interceptor.setProperties(properties);
        return interceptor;
    }

    @Bean
    public SqlExecuteTimeCountInterceptor timeCountInterceptor() {
        SqlExecuteTimeCountInterceptor interceptor = new SqlExecuteTimeCountInterceptor();
        return interceptor;
    }

    @Bean
    public SqlExecuteTimeCountInterceptor2 timeCountInterceptor2(){
        return  new SqlExecuteTimeCountInterceptor2();
    }
}
