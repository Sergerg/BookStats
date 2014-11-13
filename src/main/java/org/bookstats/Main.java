package org.bookstats;

import org.apache.ibatis.session.SqlSessionFactory;
import org.bookstats.mapper.AuthorMapper;
import org.bookstats.mapper.UserMapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 11.11.2014
 * Time: 6:46
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // Грузим по-умолчанию созданный из конфига!
    @Autowired
    DataSource dataSource;

    // MyBatis init mappers list
    @Bean
    public SqlSessionFactory getSqlSessionFactory() {
        // Список файлов мапперов
        Resource[] resources = new Resource[] {
                new ClassPathResource(
                        new ClassPathResource(getMapperXMLPath(UserMapper.class)).getPath()),
                new ClassPathResource(
                        new ClassPathResource(getMapperXMLPath(AuthorMapper.class)).getPath())};

        // Mybatis
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(resources);

        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return sqlSessionFactory;
    }

    @Bean
    public UserMapper getUserMapper() {
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(
                getSqlSessionFactory());
        return sessionTemplate.getMapper(UserMapper.class);
    }
    @Bean
    public AuthorMapper getAuthorMapper() {
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(
                getSqlSessionFactory());
        return sessionTemplate.getMapper(AuthorMapper.class);
    }

    // This method will returns path to MyBatis mapper.
    public static String getMapperXMLPath(Class<?> clazz) {
        return new ClassPathResource(clazz.getName()
                .replace(".", File.separator).concat(".xml")).getPath();
    }
}
