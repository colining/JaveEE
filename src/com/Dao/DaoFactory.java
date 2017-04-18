package com.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by asus on 2017/4/18.
 */
public class DaoFactory {
    String name = null;
    private DaoFactory()
    {

    }
    static
    {
        InputStream inputStream = DaoFactory.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void  main(String []arg)
    {

    }
}
