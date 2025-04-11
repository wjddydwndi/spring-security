package com.example.security.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.cc.administrator.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DatabaseConfiguration {

    @Bean(name = "hikariConfig")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    // datasource
    @Bean(name="dataSource")
    public DataSource dataSource(@Qualifier("hikariConfig") HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }

    // sessionFactory
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 250313 jhj, 사용할 떄 설정할 것.
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/**/*Mapper.xml"));
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));
        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
        return sqlSessionFactoryBean.getObject();
    }

    // sqlSession
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource primaryDataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(primaryDataSource);
        dataSourceTransactionManager.setNestedTransactionAllowed(true);
        return dataSourceTransactionManager;
    }


}
