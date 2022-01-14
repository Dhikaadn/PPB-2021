package com.example.appsambongrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsambongrejo.API.APIRequestData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class form extends AppCompatActivity {
    private TextView paket1in, paket2in, paket3in, paket4in, paket5in, paket6in, totalin, hargain;
    private Button setujuin, cekin;
    String apaket1, apaket2, apaket3, apaket4, apaket5, apaket6, atotal, aharga;
    String bpaket1, bpaket2, bpaket3, bpaket4, bpaket5, bpaket6, btotal, bharga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Intent terima = getIntent();
        apaket1 = terima.getStringExtra("paket1");
        apaket2 = terima.getStringExtra("paket2");
        apaket3 = terima.getStringExtra("paket3");
        apaket4 = terima.getStringExtra("paket4");
        apaket5 = terima.getStringExtra("paket5");
        apaket6 = terima.getStringExtra("paket6");
        atotal = terima.getStringExtra("total");
        aharga = terima.getStringExtra("harga");

        paket1in = findViewById(R.id.tv_paket1);
        paket2in = findViewById(R.id.tv_paket2);
        paket3in = findViewById(R.id.tv_paket3);
        paket4in = findViewById(R.id.tv_paket4);
        paket5in = findViewById(R.id.tv_paket5);
        paket6in = findViewById(R.id.tv_paket6);
        totalin = findViewById(R.id.tv_total);
        hargain = findViewById(R.id.tv_harga);
        setujuin = findViewById(R.id.setuju);
        cekin = findViewById(R.id.cek);

        paket1in.setText(apaket1);
        paket2in.setText(apaket2);
        paket3in.setText(apaket3);
        paket4in.setText(apaket4);
        paket5in.setText(apaket5);
        paket6in.setText(apaket6);
        totalin.setText(atotal);
        hargain.setText(aharga);

        setujuin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bpaket1 = paket1in.getText().toString();
                bpaket2 = paket2in.getText().toString();
                bpaket3 = paket3in.getText().toString();
                bpaket4 = paket4in.getText().toString();
                bpaket5 = paket5in.getText().toString();
                bpaket6 = paket6in.getText().toString();
                btotal = totalin.getText().toString();
                bharga = hargain.getText().toString();
                createData();
                Intent intent = new Intent(form.this, Database.class);
                startActivity(intent);
                Toast.makeText(form.this, "Disetujui", Toast.LENGTH_SHORT).show();
            }
        });

        cekin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(form.this, Database.class);
                startActivity(intent);
            }
        });



    }

    private void createData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> simpanData = ardData.ardCreateData(bpaket1, bpaket2, bpaket3, bpaket4, bpaket5, bpaket6, btotal, bharga);

        simpanData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }
}