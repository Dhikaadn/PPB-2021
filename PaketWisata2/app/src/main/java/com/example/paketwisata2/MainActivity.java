package com.example.paketwisata2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_email, et_pass;
    Button bt_login, bt_register;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        bt_login = findViewById(R.id.bt_login);
        bt_register = findViewById(R.id.bt_register);

        preferences = getSharedPreferences("UserInfo",0);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailValue = et_email.getText().toString();
                String passwordValue = et_pass.getText().toString();

                String registeredEmail = preferences.getString("email","");
                String registeredPassword = preferences.getString("password","");

                if(emailValue.equals(registeredEmail) && passwordValue.equals(registeredPassword)){
                    Intent intent = new Intent(MainActivity.this, MapActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Email/Password tidak valid!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}