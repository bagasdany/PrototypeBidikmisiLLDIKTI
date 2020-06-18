package com.stepbystepara.bidikmisilldikti.Util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


import com.stepbystepara.bidikmisilldikti.udinus.LoginActivityUdinus;

import java.util.HashMap;

public class SessionManager {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private static final String KEY_USERNAME = "username";
    private static final String KEY_KAMPUS = "kampus";
//    private static final String KEY_ID = "id";
    private static final String is_login = "logginstatus";
    private static final String SHARE_NAME = "logginsession";
    private static final int MODE_PRIVATE = 0;
    private Context _context;

    public SessionManager(Context context)
    {
        this._context=context;
        sp =_context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        editor = sp.edit();
    }
    //ada us
    public void storeLogin(String username, String kampus)
    {
        editor.putBoolean(is_login,true);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_KAMPUS,kampus);
//        editor.putInt(KEY_ID,id);
        editor.commit();
    }


    public HashMap getDetailLogin()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put(KEY_KAMPUS,sp.getString(KEY_KAMPUS,null));
        map.put(KEY_KAMPUS,sp.getString(KEY_USERNAME,null));
//        map.put(KEY_ID,sp.getString(KEY_ID,null));
        return map;
    }
    public void checkLogin ()
    {
        if (!this.Loggin())
        {
            Intent login = new Intent(_context, LoginActivityUdinus.class);
            login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(login);
        }
    }
    public void logout()
    {
        editor.clear();
        editor.commit();
    }
    public Boolean Loggin()
    {
        return sp.getBoolean(is_login,false);
    }

}
