package com.example.kavanpatel.healdoc;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSession {

    private String userName;
    private String userPassword;
    Context context;
    SharedPreferences sharedPreferences;


    // all getter and setter methods

   /* public String getUserName() {

        userName=sharedPreferences.getString("username","");
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        sharedPreferences.edit().putString("username",userName);
    }

    public String getUserPassword() {
        userPassword=sharedPreferences.getString("userpassword","");
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        sharedPreferences.edit().putString("userpassword",userPassword);
    }*/





    public void removed()
    {
        sharedPreferences.edit().clear().commit();
    }




    public UserSession(Context context)
    {
        this.context=context;
        sharedPreferences=context.getSharedPreferences("userinfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
    }
}
