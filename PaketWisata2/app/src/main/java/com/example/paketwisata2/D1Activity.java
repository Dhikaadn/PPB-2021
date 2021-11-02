package com.example.paketwisata2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class D1Activity extends AppCompatActivity {
    private Button pesan1;
    private int hargaku, terimaUpdate=0, jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d1);

        pesan1 = (Button) findViewById(R.id.pesan1);

        Intent terima = getIntent();
        AtomicInteger terimaUpdate = new AtomicInteger(terima.getIntExtra("update", 0));
        AtomicInteger terimaUpdatej = new AtomicInteger(terima.getIntExtra("updatej",0));
        pesan1.setOnClickListener((view) ->{
            hargaku = 50000;
            jumlah = 1;
            terimaUpdate.addAndGet(hargaku);
            terimaUpdatej.addAndGet(jumlah);
            Intent kirim = new Intent(D1Activity.this, MapActivity.class);
            kirim.putExtra("total", terimaUpdate.get());
            kirim.putExtra("jumlah", terimaUpdatej.get());
            startActivity(kirim);

        });


    }
}