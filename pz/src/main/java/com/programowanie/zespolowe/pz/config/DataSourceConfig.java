//package com.programowanie.zespolowe.pz.config;
//
//
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean(name = "mainDataSource")
//    public DataSource createMainDataSource() {
//        MysqlDataSource ds = new MysqlDataSource();
//        ds.setDatabaseName("pzdb");
//        ds.setPassword("");
//        ds.setUser("root");
//        ds.setURL("jdbc:mysql://localhost:3306/pzdb");
//        return ds;
//    }
//}
