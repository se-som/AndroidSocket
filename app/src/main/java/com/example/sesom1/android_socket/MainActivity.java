package com.example.sesom1.android_socket;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sesom1.android_socket.fonction.LoginFunction;
import com.example.sesom1.android_socket.socketModule.NotificationListener;
import com.example.sesom1.android_socket.socketModule.SocketService;

import io.socket.client.Socket;

public class MainActivity extends AppCompatActivity {

    private Socket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SocketService.getInstance().conneted();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Singleton.getInstance().setName("Som");
//                Toast.makeText(getApplication(), Singleton.getInstance().getName() + "=", Toast.LENGTH_LONG).show();



            for (int i=0; i<=0; i++){
                LoginFunction loginFunction = new LoginFunction();
                loginFunction.setName("Som"+i);
                loginFunction.setPhone("09865");
                loginFunction.setAge(i);
                loginFunction.setTo("adiadiaisf");
                loginFunction.setNotificationListener(new NotificationListener() {
                    @Override
                    public void onResult(String result) {
                        Log.i("On", "Notification==" + result);

                    }
                });
                loginFunction.emit();
            }

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();


//                // Instantiate the RequestQueue.
//                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
//                String url ="http://54.172.34.141:4000/youtube/videos";
//
//            // Request a string response from the provided URL.
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                Log.i("Onsuc", response);
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.i("Onerror", "error");
//                    }
//                });
//                // Add the request to the RequestQueue.
//                queue.add(stringRequest);



            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The ac
        // tion bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
