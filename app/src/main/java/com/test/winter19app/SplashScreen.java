package com.test.winter19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    Log.i("Splash 1","Thread Working 1");
                    Thread.sleep(3000);
                    //Log.i("Splash 2","Thread Working 2");

                    Intent splashToMainIntent = new Intent(SplashScreen.this,
                            MainActivity.class);
                    startActivity(splashToMainIntent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t.start();


    }

}
