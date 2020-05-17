//package com;
//
//import com.zaxxer.hikari.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.sql.DataSource;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Map;
//
//
//public class Datasource {
//
//    @Value("${spring.datasource.url}")
//    private String databaseUrl;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @RequestMapping("/db")
//    String db(Map<String, Object> model) {
//        try (Connection connection = dataSource.getConnection()) {
//            Statement stmt = connection.createStatement();
//            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
//            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
//            ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
//
//            ArrayList<String> output = new ArrayList<String>();
//            while (rs.next()) {
//                output.add("Read from DB: " + rs.getTimestamp("tick"));
//            }
//
//            model.put("records", output);
//            return "db";
//        } catch (Exception e) {
//            model.put("message", e.getMessage());
//            return "error";
//        }
//    }
//
//    @Bean
//    public DataSource dataSource(){
//        if(databaseUrl == null || databaseUrl.isEmpty()){
//            return new HikariDataSource();
//        }else {
//            HikariConfig config = new HikariConfig();
//            config.setJdbcUrl(databaseUrl);
//            return new HikariDataSource(config);
//        }
//    }
//}
