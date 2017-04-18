package com.Dao;

import com.bean.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/4/18.
 */
public class UserDaoImpTest {
    UserDao userDaoImp = new UserDaoImp();
    Properties properties = new Properties();
    InputStream in= UserDaoImpTest.class.getResourceAsStream("db.properties");
    String databse;
    @Before
    public void setUp() throws Exception {
//        try {
//            properties.load(in);
//           databse = properties.getProperty(databse);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void findUsers() throws Exception {
        ArrayList<Users> arrayList = new ArrayList<>();
        arrayList = userDaoImp.findUsers();
        System.out.println(arrayList);
        System.out.println(databse);
    }

    @Test
    public void findUser() throws Exception {
        Users users = new Users();
        users.setUserId(1);
        users.setUsername("colin");
        users.setUserage(21);
        users.setGender(0);
        users.setAddress("cugb");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        users.setBirthday(simpleDateFormat.parse("1996/01/26"));
//        System.out.println(simpleDateFormat.parse("1996/01/26").toString());
//        System.out.println(simpleDateFormat.format(new Date(96, 00, 26)));
        java.sql.Date date = new java.sql.Date(96,00,26);
        users.setBirthday(date);
        System.out.println(userDaoImp.findUser(users));
    }

    @Test
    public void insertUser() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}