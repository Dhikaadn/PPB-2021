package com.example.appsambongrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appsambongrejo.API.APIRequestData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {
    private int xId;
    private String xPaket1, xPaket2, xPaket3, xPaket4, xPaket5, xPaket6, xTotal, xHarga;
    private EditText etPaket1, etPaket2, etPaket3, etPaket4, etPaket5, etPaket6, etTotal, etHarga;
    private Button btnUbah;
    private String yPaket1, yPaket2, yPaket3, yPaket4, yPaket5, yPaket6, yHarga, yTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent terima = getIntent();
        xId = terima.getIntExtra("xId",-1);
        xPaket1 = terima.getStringExtra("xPaket1");
        xPaket2 = terima.getStringExtra("xPaket2");
        xPaket3 = terima.getStringExtra("xPaket3");
        xPaket4 = terima.getStringExtra("xPaket4");
        xPaket5 = terima.getStringExtra("xPaket5");
        xPaket6 = terima.getStringExtra("xPaket6");
        xTotal = terima.getStringExtra("xTotal");
        xHarga = terima.getStringExtra("xHarga");

        etPaket1 = findViewById(R.id.et_paket1);
        etPaket2 = findViewById(R.id.et_paket2);
        etPaket3 = findViewById(R.id.et_paket3);
        etPaket4 = findViewById(R.id.et_paket4);
        etPaket5 = findViewById(R.id.et_paket5);
        etPaket6 = findViewById(R.id.et_paket6);
        etTotal = findViewById(R.id.et_total);
        etHarga = findViewById(R.id.et_harga);
        btnUbah = findViewById(R.id.btn_ubah);

        etPaket1.setText(xPaket1);
        etPaket2.setText(xPaket2);
        etPaket3.setText(xPaket3);
        etPaket4.setText(xPaket4);
        etPaket5.setText(xPaket5);
        etPaket6.setText(xPaket6);
        etTotal.setText(xTotal);
        etHarga.setText(xHarga);

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yPaket1 = etPaket1.getText().toString();
                yPaket2 = etPaket2.getText().toString();
                yPaket3 = etPaket3.getText().toString();
                yPaket4 = etPaket4.getText().toString();
                yPaket5 = etPaket5.getText().toString();
                yPaket6 = etPaket6.getText().toString();
                yTotal = etTotal.getText().toString();
                yHarga = etHarga.getText().toString();
                updateData();
                Intent intent = new Intent(UpdateActivity.this, Database.class);
                startActivity(intent);
                Toast.makeText(UpdateActivity.this, "Update berhasil", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void updateData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> ubahData = ardData.ardUpdateData(xId, yPaket1, yPaket2, yPaket3, yPaket4, yPaket5, yPaket6, yTotal, yHarga);

        ubahData.enqueue(new Callback<ResponseModel>() {
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