package com.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by asus on 2017/4/18.
 */
public class DaoFactory {
    private static String classname = null;
    private  static Properties properties = null;

    private DaoFactory() {
        /*
        不可实例化
         */
    }
    /*
    工厂加载配置文件
     */
    static {
        InputStream inputStream = DaoFactory.class.getClassLoader().getResourceAsStream("Daoconfig.properties");
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*
    进行类的实例化
     */
    public static Object newIntance(String name)
    {
        try {
            classname = properties.getProperty(name);
            return Class.forName(classname).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
