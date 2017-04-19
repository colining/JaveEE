package com.Dao;

import com.bean.Users;
import com.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by asus on 2017/4/18.
 */
public class UserDaoImp implements UserDao {
    @Override
    public ArrayList<Users> findUsers() {
        ArrayList<Users> arrayList = new ArrayList();
        try {
            String sql = "SELECT  * FROM  users";
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next())
            {
               Users users = new Users();
               users.setUserId(resultSet.getInt(1));
               users.setUsername(resultSet.getString(2));
               users.setUserage(resultSet.getInt(3));
               users.setGender(resultSet.getInt(4));
               users.setBirthday(resultSet.getDate(5));
               users.setAddress(resultSet.getString(6));
               arrayList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override
    public boolean findUser(Users users) {
        try {
            String sql = "SELECT  * FROM  users";
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Users users1 = new Users();
                users1.setUserId(resultSet.getInt(1));
                users1.setUsername(resultSet.getString(2));
                users1.setUserage(resultSet.getInt(3));
                users1.setGender(resultSet.getInt(4));
                users1.setBirthday(resultSet.getDate(5));
                users1.setAddress(resultSet.getString(6));
                if (users1.equals(users))
                    return true;
            }
        } catch (SQLException e) {
        e.printStackTrace();
    }
        return false;
    }

    @Override
    public int insertUser(Users users) {
        try {
            String sql = "insert into users(userid,username,userage,gender,birthday,address ) values(?,?,?,?,?,?)";
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(users.getUserId()));
            preparedStatement.setString(2,users.getUsername());
            preparedStatement.setString(3, String.valueOf(users.getUserage()));
            preparedStatement.setString(4, String.valueOf(users.getGender()));
            preparedStatement.setString(5, String.valueOf(users.getBirthday()));
            preparedStatement.setString(6,users.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Users users) {
        try {
            String sql = "update users set username = ? where userid = ?";
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,users.getUsername());
            preparedStatement.setString(2, String.valueOf(users.getUserId()));
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Users users) {
        try {
            String sql = "delete from users where userid = ?";
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(users.getUserId()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
