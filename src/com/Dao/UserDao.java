package com.Dao;

import com.bean.Users;
import sun.security.util.Password;

import java.util.ArrayList;

/**
 * Created by asus on 2017/4/18.
 */
public interface UserDao {
    public ArrayList<Users> findUsers();
    public boolean findUser(Users users);
    public int insertUser(Users users);
    public int update(Users users);
    public int delete(Users users);

}
