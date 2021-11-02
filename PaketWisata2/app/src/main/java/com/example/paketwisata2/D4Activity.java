package com.example.paketwisata2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicInteger;

public class D4Activity extends AppCompatActivity {
    private Button pesan4;
    private int hargaku4, terimaUpdate=0, jumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d4);

        pesan4 = (Button) findViewById(R.id.pesan4);

        Intent terima = getIntent();
        AtomicInteger terimaUpdate = new AtomicInteger(terima.getIntExtra("update", 0));
        AtomicInteger terimaUpdatej = new AtomicInteger(terima.getIntExtra("updatej",0));
        pesan4.setOnClickListener((view) ->{
            hargaku4 = 55000;
            jumlah = 1;
            terimaUpdate.addAndGet(hargaku4);
            terimaUpdatej.addAndGet(jumlah);
            Intent kirim = new Intent(D4Activity.this, MapActivity.class);
            kirim.putExtra("total", terimaUpdate.get());
            kirim.putExtra("jumlah", terimaUpdatej.get());
            startActivity(kirim);
        });

    }
}