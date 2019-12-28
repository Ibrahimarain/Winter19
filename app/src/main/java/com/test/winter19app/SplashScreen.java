package com.test.winter19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class SplashScreen extends AppCompatActivity {

    AsyncHttpClient client = new AsyncHttpClient();
    String url = "http://dummy.restapiexample.com/api/v1/employees";
    ArrayList<String> nameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        AsyncHttpResponseHandler responseHandler = new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Toast.makeText(SplashScreen.this,"Success",Toast.LENGTH_LONG).show();

                try {
                    JSONArray jsonArray = new JSONArray(new String(responseBody));
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject singleObject = jsonArray.getJSONObject(i);
                        String empName = singleObject.getString("employee_name");
                        String empAge = singleObject.getString("employee_age");
                        Log.i("JSON data",empName+" :\t "+empAge);
                        nameList.add(empName);

                        Intent splashToMainIntent = new Intent(SplashScreen.this,
                                MainActivity.class);
                        startActivity(splashToMainIntent);
                        finish();

                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(SplashScreen.this,"Try again, Failed to connect.",Toast.LENGTH_LONG).show();

            }
        };

        client.get(url, responseHandler);




        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    Log.i("Splash 1","Thread Working 1");
                    Thread.sleep(3000);
                    //Log.i("Splash 2","Thread Working 2");


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //t.start();




    }

}
