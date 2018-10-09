package com.zhihe.tool.util;

public class Log {
    public static void e(String s){
        System.out.println("E:" + s);
    }
    public static void w(String s){
        System.out.println("W:" + s);
    }
    public static void i(String i){
        System.out.println("I:" + i);
    }
    public static void i(Object i){
        System.out.println("I:" + i.toString());
    }
}
