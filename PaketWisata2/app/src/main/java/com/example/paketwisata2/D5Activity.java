package com.example.paketwisata2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicInteger;

public class D5Activity extends AppCompatActivity {
    private Button pesan5;
    private int hargaku5, terimaUpdate=0, jumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d5);

        pesan5 = (Button) findViewById(R.id.pesan5);

        Intent terima = getIntent();
        AtomicInteger terimaUpdate = new AtomicInteger(terima.getIntExtra("update", 0));
        AtomicInteger terimaUpdatej = new AtomicInteger(terima.getIntExtra("updatej",0));
        pesan5.setOnClickListener((view) ->{
            hargaku5 = 20000;
            jumlah = 1;
            terimaUpdate.addAndGet(hargaku5);
            terimaUpdatej.addAndGet(jumlah);
            Intent kirim = new Intent(D5Activity.this, MapActivity.class);
            kirim.putExtra("total", terimaUpdate.get());
            kirim.putExtra("jumlah", terimaUpdatej.get());
            startActivity(kirim);
        });
    }
}