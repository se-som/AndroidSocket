package com.example.sesom1.android_socket.fonction;

import com.example.sesom1.android_socket.config.K;
import com.example.sesom1.android_socket.socketModule.SocketEmit;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sesom1 on 1/11/2016.
 */
public class LoginFunction extends SocketEmit {
    private String name, phone;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getEven() {
        return K.FUNCTION.LOGIN + getAge();
    }

    @Override
    public JSONObject getDataObject() {
        JSONObject jsonData = new JSONObject();
        try {
            jsonData.put("name", getName());
            jsonData.put("phone", getPhone());
            jsonData.put("age", getAge());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonData;
    }
}

