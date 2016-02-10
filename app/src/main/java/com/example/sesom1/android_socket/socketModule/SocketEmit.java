package com.example.sesom1.android_socket.socketModule;

import com.example.sesom1.android_socket.config.K;
import com.example.sesom1.android_socket.config.SC;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sesom1 on 1/11/2016.
 */
public class SocketEmit implements SocketEmitService {
    private NotificationListener mListener = null;
    private String To, DateTime, PartnerID, HubID, Type, DeviceType, DeviceOS, FromIP, Region;
    private String ID, ObjectType;

    @Override
    public String getEven() {
        return null;
    }

    @Override
    public JSONObject getDataObject() {
        return null;
    }

    @Override
    public void emit() {
        SocketService.getInstance().emitEven(getEven(), getAllDataObject(), getCallBack());
    }

    public NotificationListener getCallBack() {
        return mListener;
    }

    public void setNotificationListener(NotificationListener Listener) {
        this.mListener = Listener;
    }

    private JSONObject getAllDataObject() {
        JSONObject data = new JSONObject();
        try {
            data.put(K.STRING.HEADER, getHeaderObject());
            data.put(K.STRING.BODY, getBodyObject());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

    private JSONObject getHeaderObject() {
        JSONObject headerObject = new JSONObject();
        try {
            headerObject.put(K.HEADER.TO, SC.getString(getTo(), ""));
            headerObject.put(K.HEADER.DATE_TIME, SC.getString(getDateTime(), ""));
            headerObject.put(K.HEADER.PARTNER_ID, SC.getString(getPartnerID(), ""));
            headerObject.put(K.HEADER.HUB_ID, SC.getString(getHubID(), ""));
            headerObject.put(K.HEADER.TYPE, SC.getString(getType(), ""));
            headerObject.put(K.HEADER.DEVICE_TYPE, SC.getString(getDeviceType(), ""));
            headerObject.put(K.HEADER.DEVICE_OS, SC.getString(getDeviceOS(), ""));
            headerObject.put(K.HEADER.FROM_IP, SC.getString(getFromIP(), ""));
            headerObject.put(K.HEADER.REGION, SC.getString(getRegion(), ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return headerObject;
    }

    private JSONObject getBodyObject() {
        JSONObject bodyObject = new JSONObject();
        try {
            bodyObject.put(K.BODY.ID, SC.getString(getID(), ""));
            bodyObject.put(K.BODY.OBJECT_TYPE, SC.getString(getObjectType(), ""));
            bodyObject.put(K.BODY.ACTION, getEven());
            bodyObject.put(K.BODY.DATA, getDataObject());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bodyObject;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getPartnerID() {
        return PartnerID;
    }

    public void setPartnerID(String partnerID) {
        PartnerID = partnerID;
    }

    public String getHubID() {
        return HubID;
    }

    public void setHubID(String hubID) {
        HubID = hubID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(String deviceType) {
        DeviceType = deviceType;
    }

    public String getDeviceOS() {
        return DeviceOS;
    }

    public void setDeviceOS(String deviceOS) {
        DeviceOS = deviceOS;
    }

    public String getFromIP() {
        return FromIP;
    }

    public void setFromIP(String fromIP) {
        FromIP = fromIP;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getObjectType() {
        return ObjectType;
    }

    public void setObjectType(String objectType) {
        ObjectType = objectType;
    }

}
