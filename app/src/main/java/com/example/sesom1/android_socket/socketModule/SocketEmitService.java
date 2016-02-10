package com.example.sesom1.android_socket.socketModule;

import org.json.JSONObject;

/**
 * Created by sesom1 on 1/11/2016.
 */
public interface SocketEmitService {
    abstract String getEven();
    abstract JSONObject getDataObject();
    abstract void emit();
}
