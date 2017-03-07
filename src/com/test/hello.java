package com.test;

/**
 * Created by asus on 2017/3/7.
 */
public class hello {
    public  static  String i="博智";
    static
    {
        i="咨询";
        System.out.println("写了static");
    }
    {
        i="咨询";
        System.out.println("啥也不写");
    }
    public  static  void  main(String [] arg)
    {
        System.out.println(i);
    }
}
