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
    UserDao userDao = null;

    @Before
    public void setUp() throws Exception {
        //����ת��
        userDao = (UserDao) DaoFactory.newIntance("UserDao");
    }

    @After
    public void tearDown() throws Exception {

    }
    /*
    ��ѯȫ���û�
     */
    @Test
    public void findUsers() throws Exception {
        ArrayList<Users> arrayList = new ArrayList<>();
        arrayList = userDao.findUsers();
        System.out.println(arrayList);

    }
    /*
    �ҵ�ĳһ���ض����û�
     */
    @Test
    public void findUser() throws Exception {
        Users users = new Users();
        users.setUserId(1);
        users.setUsername("colin");
        users.setUserage(21);
        users.setGender(0);
        users.setAddress("cugb");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        java.sql.Date date = new java.sql.Date(96,00,26);
        users.setBirthday(date);
        System.out.println(userDao.findUser(users));
    }

    /*
    �����û�
     */
    @Test
    public void insertUser() throws Exception {
        Users users = new Users();
        users.setUserId(3);
        users.setUsername("zhangsan");
        users.setUserage(21);
        users.setGender(1);
        users.setAddress("tqinghua");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        java.sql.Date date = new java.sql.Date(96,00,26);
        users.setBirthday(date);
        userDao.insertUser(users);
    }
    /*
    �޸��û�
     */
    @Test
    public void update() throws Exception {
        Users users = new Users();
        users.setUserId(3);
        users.setUsername("lisi");
        users.setUserage(21);
        users.setGender(1);
        users.setAddress("tqinghua");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        java.sql.Date date = new java.sql.Date(96,00,26);
        users.setBirthday(date);
        userDao.update(users);
    }
    /*
    ɾ���û�
     */
    @Test
    public void delete() throws Exception {
        Users users = new Users();
        users.setUserId(3);
        userDao.delete(users);
    }

}