package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by asus on 2017/4/18.
 */


public class JDBCUtils {
        private  static String drivername;          //驱动名称
        private  static String url;                 //地址
        private  static String username;            //用户名
        private  static String password;            //密码;
    /*
    私有构造方法，不可实例化
     */
    private JDBCUtils() {
    }
    /*
    类加载后执行。且执行一次，
    加载配置文件
     */
    static
    {
        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            drivername = properties.getProperty("drivername");
            url =properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    建立数据库连接；
     */
    public  static Connection getConnection()
    {
        Connection connection = null;
        try {
            Class.forName(drivername);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    /*
    释放数据库连接；
     */
    public static void free(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection)
    {
        try {
            if (resultSet!=null)
            {
                resultSet.close();
            }
            if (preparedStatement!=null)
            {
                preparedStatement.close();
            }
            if (connection!=null)
            {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

