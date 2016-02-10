package com.example.sesom1.android_socket.socketModule;

import com.example.sesom1.android_socket.config.Config;
import com.example.sesom1.android_socket.config.K;
import org.json.JSONObject;
import java.net.URISyntaxException;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * Created by sesom1 on 1/11/2016.
 */
public class SocketService {
    private static SocketService mInstance = null;
    private static Socket sockets;
    private Socket socket;

    public static SocketService getInstance() {
        if (mInstance == null) {
            mInstance = new SocketService();
        }
        return mInstance;
    }

    public static Socket getSockets() {
        return sockets;
    }

    public void setSockets(Socket socket) {
        this.sockets = socket;
    }

    public void conneted() {
        try {
            socket = IO.socket(Config.VALUE.URL);
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                }
            }).on("even", new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                }

            }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                }
            });
            socket.connect();
            setSockets(socket);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void doEmit(final Socket mSocket, final String even, JSONObject jsonData, final NotificationListener listen) {
        mSocket.emit(even, jsonData);
        mSocket.on(even + K.STRING._RESULT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                mSocket.off(even +  K.STRING._RESULT);
                JSONObject obj = new JSONObject();
                obj = (JSONObject) args[0];
                listen.onResult(obj.toString());
            }
        });
    }

    public void emitEven(String even, JSONObject dataObject, NotificationListener listen) {
        doEmit(getSockets(), even, dataObject, listen);
    }
}
