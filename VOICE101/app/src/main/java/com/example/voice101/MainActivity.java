package com.example.voice101;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean connection;

                //check network connection
                connection = isNetworkAvailable();

                if (connection){
                    doWork();

                    //show splash then go login page

                    Intent intent = new Intent(MainActivity.this,LoginPage.class);
                    startActivity(intent);
                    finish();

                }
                else
                {
                    Toast.makeText(MainActivity.this,"Please Network Connected Your Phone",Toast.LENGTH_LONG).show();
                }
            }
        });
        thread.start();
    }

    //splashScreen
    private void doWork() {
        for (counter=20;counter<=100;counter+=20)
        {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(counter);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //network connection check method
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
