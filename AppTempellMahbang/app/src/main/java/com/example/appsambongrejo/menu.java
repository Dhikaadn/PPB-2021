package com.example.appsambongrejo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appsambongrejo.databinding.ActivityMenuBinding;

public class menu extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMenuBinding binding;
    private CardView cd1, cd2, cd3, cd4, cd5, cd6;
    private TextView total;
    private TextView harga;
    private TextView paket1;
    private TextView paket2;
    private TextView paket3;
    private TextView paket4;
    private TextView paket5;
    private TextView paket6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cd1 = findViewById(R.id.cd1);
        cd2 = findViewById(R.id.cd2);
        cd3 = findViewById(R.id.cd3);
        cd4 = findViewById(R.id.cd4);
        cd5 = findViewById(R.id.cd5);
        cd6 = findViewById(R.id.cd6);
        total = findViewById(R.id.total);
        harga = findViewById(R.id.harga);
        paket1 = findViewById(R.id.paket1);
        paket2 = findViewById(R.id.paket2);
        paket3 = findViewById(R.id.paket3);
        paket4 = findViewById(R.id.paket4);
        paket5 = findViewById(R.id.paket5);
        paket6 = findViewById(R.id.paket6);

        Intent terima = getIntent();
        int terimaTotal = terima.getIntExtra("total", 0);
        int terimaHarga = terima.getIntExtra("harga",0);
        int terimaPaket1 = terima.getIntExtra("paket1",0);
        int terimaPaket2 = terima.getIntExtra("paket2",0);
        int terimaPaket3 = terima.getIntExtra("paket3",0);
        int terimaPaket4 = terima.getIntExtra("paket4",0);
        int terimaPaket5 = terima.getIntExtra("paket5",0);
        int terimaPaket6 = terima.getIntExtra("paket6",0);


        total.setText(Integer.toString(terimaTotal));
        harga.setText(Integer.toString(terimaHarga));
        paket1.setText(Integer.toString(terimaPaket1));
        paket2.setText(Integer.toString(terimaPaket2));
        paket3.setText(Integer.toString(terimaPaket3));
        paket4.setText(Integer.toString(terimaPaket4));
        paket5.setText(Integer.toString(terimaPaket5));
        paket6.setText(Integer.toString(terimaPaket6));


        cd1.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateHarga = terima.getIntExtra("harga",0);
            int updatePaket1 = terima.getIntExtra("paket1",0);
            int updatePaket2 = terima.getIntExtra("paket2",0);
            int updatePaket3 = terima.getIntExtra("paket3",0);
            int updatePaket4 = terima.getIntExtra("paket4",0);
            int updatePaket5 = terima.getIntExtra("paket5",0);
            int updatePaket6 = terima.getIntExtra("paket6",0);
            Intent update = new Intent(menu.this, desc1.class);
            update.putExtra("update", updateTotal);
            update.putExtra("update2",updateHarga);
            update.putExtra("update3",updatePaket1);
            update.putExtra("update4",updatePaket2);
            update.putExtra("update5",updatePaket3);
            update.putExtra("update6",updatePaket4);
            update.putExtra("update7",updatePaket5);
            update.putExtra("update8",updatePaket6);
            startActivity(update);
        });

        cd2.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateHarga = terima.getIntExtra("harga",0);
            int updatePaket1 = terima.getIntExtra("paket1",0);
            int updatePaket2 = terima.getIntExtra("paket2",0);
            int updatePaket3 = terima.getIntExtra("paket3",0);
            int updatePaket4 = terima.getIntExtra("paket4",0);
            int updatePaket5 = terima.getIntExtra("paket5",0);
            int updatePaket6 = terima.getIntExtra("paket6",0);
            Intent update = new Intent(menu.this, desc2.class);
            update.putExtra("update", updateTotal);
            update.putExtra("update2",updateHarga);
            update.putExtra("update3",updatePaket1);
            update.putExtra("update4",updatePaket2);
            update.putExtra("update5",updatePaket3);
            update.putExtra("update6",updatePaket4);
            update.putExtra("update7",updatePaket5);
            update.putExtra("update8",updatePaket6);
            startActivity(update);
        });

        cd3.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateHarga = terima.getIntExtra("harga",0);
            int updatePaket1 = terima.getIntExtra("paket1",0);
            int updatePaket2 = terima.getIntExtra("paket2",0);
            int updatePaket3 = terima.getIntExtra("paket3",0);
            int updatePaket4 = terima.getIntExtra("paket4",0);
            int updatePaket5 = terima.getIntExtra("paket5",0);
            int updatePaket6 = terima.getIntExtra("paket6",0);
            Intent update = new Intent(menu.this, desc3.class);
            update.putExtra("update", updateTotal);
            update.putExtra("update2",updateHarga);
            update.putExtra("update3",updatePaket1);
            update.putExtra("update4",updatePaket2);
            update.putExtra("update5",updatePaket3);
            update.putExtra("update6",updatePaket4);
            update.putExtra("update7",updatePaket5);
            update.putExtra("update8",updatePaket6);
            startActivity(update);
        });

        cd4.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateHarga = terima.getIntExtra("harga",0);
            int updatePaket1 = terima.getIntExtra("paket1",0);
            int updatePaket2 = terima.getIntExtra("paket2",0);
            int updatePaket3 = terima.getIntExtra("paket3",0);
            int updatePaket4 = terima.getIntExtra("paket4",0);
            int updatePaket5 = terima.getIntExtra("paket5",0);
            int updatePaket6 = terima.getIntExtra("paket6",0);
            Intent update = new Intent(menu.this, desc4.class);
            update.putExtra("update", updateTotal);
            update.putExtra("update2",updateHarga);
            update.putExtra("update3",updatePaket1);
            update.putExtra("update4",updatePaket2);
            update.putExtra("update5",updatePaket3);
            update.putExtra("update6",updatePaket4);
            update.putExtra("update7",updatePaket5);
            update.putExtra("update8",updatePaket6);
            startActivity(update);
        });

        cd5.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateHarga = terima.getIntExtra("harga",0);
            int updatePaket1 = terima.getIntExtra("paket1",0);
            int updatePaket2 = terima.getIntExtra("paket2",0);
            int updatePaket3 = terima.getIntExtra("paket3",0);
            int updatePaket4 = terima.getIntExtra("paket4",0);
            int updatePaket5 = terima.getIntExtra("paket5",0);
            int updatePaket6 = terima.getIntExtra("paket6",0);

            Intent update = new Intent(menu.this, desc5.class);
            update.putExtra("update", updateTotal);
            update.putExtra("update2",updateHarga);
            update.putExtra("update3",updatePaket1);
            update.putExtra("update4",updatePaket2);
            update.putExtra("update5",updatePaket3);
            update.putExtra("update6",updatePaket4);
            update.putExtra("update7",updatePaket5);
            update.putExtra("update8",updatePaket6);
            startActivity(update);
        });

        cd6.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateHarga = terima.getIntExtra("harga",0);
            int updatePaket1 = terima.getIntExtra("paket1",0);
            int updatePaket2 = terima.getIntExtra("paket2",0);
            int updatePaket3 = terima.getIntExtra("paket3",0);
            int updatePaket4 = terima.getIntExtra("paket4",0);
            int updatePaket5 = terima.getIntExtra("paket5",0);
            int updatePaket6 = terima.getIntExtra("paket6",0);
            Intent update = new Intent(menu.this, desc6.class);
            update.putExtra("update", updateTotal);
            update.putExtra("update2",updateHarga);
            update.putExtra("update3",updatePaket1);
            update.putExtra("update4",updatePaket2);
            update.putExtra("update5",updatePaket3);
            update.putExtra("update6",updatePaket4);
            update.putExtra("update7",updatePaket5);
            update.putExtra("update8",updatePaket6);
            startActivity(update);
        });

        harga.setOnClickListener(view -> {
            String totalform = total.getText().toString();
            String hargaform = harga.getText().toString();
            String paket1form = paket1.getText().toString();
            String paket2form = paket2.getText().toString();
            String paket3form = paket3.getText().toString();
            String paket4form = paket4.getText().toString();
            String paket5form = paket5.getText().toString();
            String paket6form = paket6.getText().toString();

            Intent kirim = new Intent(menu.this, form.class);
            kirim.putExtra("total", totalform);
            kirim.putExtra("harga",hargaform);
            kirim.putExtra("paket1",paket1form);
            kirim.putExtra("paket2",paket2form);
            kirim.putExtra("paket3",paket3form);
            kirim.putExtra("paket4",paket4form);
            kirim.putExtra("paket5",paket5form);
            kirim.putExtra("paket6",paket6form);
            startActivity(kirim);
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayMap();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayMap() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        // Using the coordinates for Google headquarters.
        String data = getString(R.string.google_mtv_coord_zoom12);
        intent.setData(Uri.parse(data));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}