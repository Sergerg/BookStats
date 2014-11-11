package org.bookstats;

import org.apache.ibatis.session.SqlSessionFactory;
import org.bookstats.mapper.UserMapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

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

    @Bean
    @Scope(value = "singleton")
    public DataSource getDataSource() {
        // Configure data source.
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUsername("tester");
        ds.setPassword("secret");
        ds.setUrl("jdbc:h2:mem;MODE=PostgreSQL");

        // Open connection to our database and create
        // table tbl_users
        try (Connection connection = ds.getConnection()) {

            Statement statement = connection.createStatement();
            String creatUsersSQL = "CREATE TABLE IF NOT EXISTS tbl_users ( "
                    + "id serial PRIMARY KEY, "
                    + "login varchar(100) UNIQUE NOT NULL, "
                    + "created timestamp DEFAULT CURRENT_TIMESTAMP ); ";

            statement.execute(creatUsersSQL);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    @Bean
    public SqlSessionFactory getSqlSessionFactory() {
        Resource[] resources = new Resource[] { new ClassPathResource(
                new ClassPathResource(getMapperXMLPath(UserMapper.class)).getPath()) };

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());
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

    // This method will returns path to MyBatis mapper.
    public static String getMapperXMLPath(Class<?> clazz) {
        return new ClassPathResource(clazz.getName()
                .replace(".", File.separator).concat(".xml")).getPath();
    }
}
