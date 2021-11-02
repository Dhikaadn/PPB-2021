package com.example.paketwisata2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText et_nama, et_alamat, et_email, et_pass;
    Button bt_register;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_nama = findViewById(R.id.et_nama);
        et_alamat = findViewById(R.id.et_alamat);
        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        bt_register = findViewById(R.id.bt_register);

        preferences = getSharedPreferences("UserInfo", 0);

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameValue = et_nama.getText().toString();
                String alamatValue = et_alamat.getText().toString();
                String emailValue = et_email.getText().toString();
                String passwordValue = et_pass.getText().toString();

                if ((nameValue.length()>1)){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("name", nameValue);
                    editor.putString("alamat", alamatValue);
                    editor.putString("email", emailValue);
                    editor.putString("password", passwordValue);
                    editor.apply();
                    Toast.makeText(MainActivity2.this, "Registered!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity2.this, "Isi data yang masing kosong!!", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
    }