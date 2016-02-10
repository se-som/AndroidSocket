package com.example.sesom1.android_socket;

/**
 * Created by sesom1 on 1/12/2016.
 */
public class Singleton {
    private static Singleton mSingleton = null;
    private String name;

    public static Singleton getInstance(){
        if(null == mSingleton){
            mSingleton = new Singleton();
        }
        return mSingleton;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
