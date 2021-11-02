package com.example.paketwisata2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicInteger;

public class D6Activity extends AppCompatActivity {
    private Button pesan6;
    private int hargaku6, terimaUpdate=0, jumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d6);

        pesan6 = (Button) findViewById(R.id.pesan6);

        Intent terima = getIntent();
        AtomicInteger terimaUpdate = new AtomicInteger(terima.getIntExtra("update", 0));
        AtomicInteger terimaUpdatej = new AtomicInteger(terima.getIntExtra("updatej",0));
        pesan6.setOnClickListener((view) ->{
            hargaku6 = 100000;
            jumlah = 1;
            terimaUpdate.addAndGet(hargaku6);
            terimaUpdatej.addAndGet(jumlah);
            Intent kirim = new Intent(D6Activity.this, MapActivity.class);
            kirim.putExtra("total", terimaUpdate.get());
            kirim.putExtra("jumlah", terimaUpdatej.get());
            startActivity(kirim);
        });
    }
}