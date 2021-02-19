package com.zhanglubin.multipleDataSources.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author zhanglubin
 * @date 2021/2/19
 */
@Configuration
@MapperScan(basePackages = "com.zhanglubin.multipleDataSources.mapper.datasourceMyself", sqlSessionFactoryRef = "myselfSqlSessionFactory")
public class DataSourcesConfigMyself {

    @Bean(name = "myselfDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.datasourcemyself")
    public DataSource getDateSourceMyself() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "myselfSqlSessionFactory")
    public SqlSessionFactory myselfSqlSessionFactory(@Qualifier("myselfDataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/myself/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean("myselfSqlSessionTemplate")
    public SqlSessionTemplate test2SqlSessionTemplate(@Qualifier("myselfSqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }
}
