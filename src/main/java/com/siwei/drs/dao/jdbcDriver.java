package com.siwei.drs.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName: jdbcDriver
 * @Description: TODO
 * @Author: Rui Bao
 * @Date: 2024/06/27 16:45
 **/

public class jdbcDriver {

    public static final String postgreSqlConfigPath = "src/main/resources/postgreSqlConfig.yml";

    /**
     * @param postgreSqlConfigPath :
     * @Title:
     * @Description: TODO 使用配置文件连接数据库
     * @return: java.sql.Connection
     * @Author: Rui Bao
     * @Date: 2024/06/27 18:29
     **/
    public static Connection connect(String postgreSqlConfigPath) {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(postgreSqlConfigPath)); // 从配置文件读取连接信息
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            return DriverManager.getConnection(url, user, password);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        var clockStart = System.currentTimeMillis();
        try (Connection conn = jdbcDriver.connect(postgreSqlConfigPath)) {
            /*
             * Do something.
             */

            // 获取数据库元数据
            DatabaseMetaData metaData = conn.getMetaData();
            // 获取所有表的名称
            String[] types = {"TABLE"};
            ResultSet resultSet = metaData.getTables(null, null, "%", types);
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                System.out.println(tableName);
            }
            System.out.println("Connected to the database successfully.");
        }
        System.err.format("Took %,d ms\n", System.currentTimeMillis() - clockStart);
    }
}