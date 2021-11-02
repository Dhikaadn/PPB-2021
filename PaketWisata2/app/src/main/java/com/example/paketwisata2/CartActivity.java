package com.example.paketwisata2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class CartActivity extends AppCompatActivity {
    private TextView total;
    private TextView jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        total = (TextView) findViewById(R.id.total);
        jumlah = (TextView) findViewById(R.id.jumlah);



        Intent terima = getIntent();
        String terimaTotal = terima.getStringExtra("total");
        String terimaJumlah = terima.getStringExtra("jumlah");
        total.setText(terimaTotal);
        jumlah.setText(terimaJumlah);




    }

    public void konfirmasi(View view) {
        Toast.makeText(CartActivity.this, "Pembayaran dikonfirmasi", Toast.LENGTH_SHORT).show();
    }
}