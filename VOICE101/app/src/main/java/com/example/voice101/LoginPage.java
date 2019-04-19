package com.example.voice101;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;

public class LoginPage extends AppCompatActivity {

    TextView creattxv,forgettxv;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        
        //find all component
        creattxv = findViewById(R.id.cerateId);
        forgettxv = findViewById(R.id.forgetId);
        loginbtn = findViewById(R.id.loginId);


        //create text view work
        creattxv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegistrationPage.class);
                startActivity(intent);
            }
        });

        //forget text view work
        forgettxv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RecoverPage.class);
                startActivity(intent);
            }
        });


        //login button work

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SetLocationPage.class);
                startActivity(intent);
            }
        });
        
    }
}
