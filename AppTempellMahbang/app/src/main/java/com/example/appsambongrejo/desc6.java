package com.example.appsambongrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicInteger;

public class desc6 extends AppCompatActivity {
    private Button pesan6;
    private int price6, terimaUpdate=0, total, paket1, paket2, paket3, paket4, paket5, paket6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc6);

        pesan6 = findViewById(R.id.pesan6);

        Intent terima = getIntent();
        AtomicInteger terimaUpdate = new AtomicInteger(terima.getIntExtra("update", 0));
        AtomicInteger terimaUpdate2 = new AtomicInteger(terima.getIntExtra("update2",0));
        AtomicInteger terimaUpdate3 = new AtomicInteger(terima.getIntExtra("update3",0));
        AtomicInteger terimaUpdate4 = new AtomicInteger(terima.getIntExtra("update4",0));
        AtomicInteger terimaUpdate5= new AtomicInteger(terima.getIntExtra("update5",0));
        AtomicInteger terimaUpdate6= new AtomicInteger(terima.getIntExtra("update6",0));
        AtomicInteger terimaUpdate7= new AtomicInteger(terima.getIntExtra("update7",0));
        AtomicInteger terimaUpdate8= new AtomicInteger(terima.getIntExtra("update8",0));
        pesan6.setOnClickListener((view) ->{
            price6 = 100000;
            total = 1;
            paket1 = 0;
            paket2 = 0;
            paket3 = 0;
            paket4 = 0;
            paket5 = 0;
            paket6 = 1;
            terimaUpdate.addAndGet(total);
            terimaUpdate2.addAndGet(price6);
            terimaUpdate3.addAndGet(paket1);
            terimaUpdate4.addAndGet(paket2);
            terimaUpdate5.addAndGet(paket3);
            terimaUpdate6.addAndGet(paket4);
            terimaUpdate7.addAndGet(paket5);
            terimaUpdate8.addAndGet(paket6);
            Intent kirim = new Intent(desc6.this, menu.class);
            kirim.putExtra("total", terimaUpdate.get());
            kirim.putExtra("harga", terimaUpdate2.get());
            kirim.putExtra("paket1", terimaUpdate3.get());
            kirim.putExtra("paket2", terimaUpdate4.get());
            kirim.putExtra("paket3", terimaUpdate5.get());
            kirim.putExtra("paket4", terimaUpdate6.get());
            kirim.putExtra("paket5", terimaUpdate7.get());
            kirim.putExtra("paket6", terimaUpdate8.get());
            startActivity(kirim);

        });
    }
}