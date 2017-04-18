package com.bean;

import java.util.Date;

/**
 * Created by asus on 2017/4/18.
 */
public class Users {
    private int userId;
    private String username;
    private int userage;
    private int gender;
    private Date birthday;
    private String address;
    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    /*
    重写equals方法；
     */
    @Override
    public boolean equals(Object obj) {
        if (obj==null)
            return false;
        if (obj instanceof Users)
        {

            Users a= (Users)obj;
            System.out.println(a.getAddress());
            System.out.println(a.getAddress());
            if (a.getUserId() ==this.getUserId()
                    &&a.getUserage()==this.getUserage()
                    &&a.getGender()==(this.getGender())
                    &&a.getBirthday().equals(this.getBirthday())
                    &&a.getAddress().equals(this.getAddress())
                    &&a.getUsername().equals(this.getUsername()))
                return true;
        }
        return false;
    }
}
