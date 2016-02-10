package com.example.sesom1.android_socket.config;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sesom1 on 1/13/2016.
 */
public class SC {
    public static String getString(String string, String defaultValue){
        if(null == string){
            return defaultValue;
        }
        return string;
    }
    public static String getString(JSONObject dataObject, String key, String defaultValue){
        try {
            return dataObject.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

}
