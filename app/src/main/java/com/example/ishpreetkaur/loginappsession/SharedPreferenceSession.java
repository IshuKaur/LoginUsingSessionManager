package com.example.ishpreetkaur.loginappsession;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SharedPreferenceSession
{
    SharedPreferences sharedPreferences;
    Context context;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE=0;
    private static final String PREF_NAME="abc@gmail.com";
    public static final String KEY_NAME="name";
    public static final String KEY_EMAIL="email";
    private static final String IS_LOGIN = "IsLoggedIn";

    public SharedPreferenceSession(Context context)
    {
        this.context=context;
        sharedPreferences=context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=sharedPreferences.edit();
    }

    public void createLoginSession(String name,String email)
    {
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_NAME,name);
        editor.putString(KEY_EMAIL,email);
        editor.commit();
    }

    public boolean isLoggedIn()
    {
        return sharedPreferences.getBoolean(IS_LOGIN,false);
    }

    public void checkLogin()
    {
        if(!this.isLoggedIn())
        {
            Intent intent=new Intent(context,AfterLoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public HashMap<String,String> getUserDetails()
    {
        HashMap<String,String> hashMap=new HashMap<String,String>();
        hashMap.put(KEY_NAME,sharedPreferences.getString(KEY_NAME,null));
        hashMap.put(KEY_EMAIL,sharedPreferences.getString(KEY_EMAIL,null));
        return hashMap;
    }

    public void logoutUSer()
    {
        editor.clear();
        editor.commit();
        Intent intent=new Intent(context,AfterLoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
