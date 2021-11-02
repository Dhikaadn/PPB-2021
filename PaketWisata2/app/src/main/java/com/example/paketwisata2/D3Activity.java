package com.example.paketwisata2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicInteger;

public class D3Activity extends AppCompatActivity {
    private Button pesan3;
    private int hargaku3, terimaUpdate=0, jumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d3);

        pesan3 = (Button) findViewById(R.id.pesan3);

        Intent terima = getIntent();
        AtomicInteger terimaUpdate = new AtomicInteger(terima.getIntExtra("update", 0));
        AtomicInteger terimaUpdatej = new AtomicInteger(terima.getIntExtra("updatej",0));
        pesan3.setOnClickListener((view) ->{
            hargaku3 = 30000;
            jumlah = 1;
            terimaUpdate.addAndGet(hargaku3);
            terimaUpdatej.addAndGet(jumlah);
            Intent kirim = new Intent(D3Activity.this, MapActivity.class);
            kirim.putExtra("total", terimaUpdate.get());
            kirim.putExtra("jumlah", terimaUpdatej.get());
            startActivity(kirim);
        });
    }
}