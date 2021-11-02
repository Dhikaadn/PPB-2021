package com.example.paketwisata2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class D2Activity extends AppCompatActivity {
    private Button pesan2;
    private int hargaku2, terimaUpdate=0, jumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d2);

        pesan2 = (Button) findViewById(R.id.pesan2);

        Intent terima = getIntent();
        AtomicInteger terimaUpdate = new AtomicInteger(terima.getIntExtra("update", 0));
        AtomicInteger terimaUpdatej = new AtomicInteger(terima.getIntExtra("updatej",0));
        pesan2.setOnClickListener((view) ->{
            hargaku2 = 100000;
            jumlah = 1;
            terimaUpdate.addAndGet(hargaku2);
            terimaUpdatej.addAndGet(jumlah);
            Intent kirim = new Intent(D2Activity.this, MapActivity.class);
            kirim.putExtra("total", terimaUpdate.get());
            kirim.putExtra("jumlah", terimaUpdatej.get());
            startActivity(kirim);
        });

    }


}