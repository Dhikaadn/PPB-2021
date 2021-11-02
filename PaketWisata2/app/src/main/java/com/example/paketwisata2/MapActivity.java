package com.example.paketwisata2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.paketwisata2.databinding.ActivityMapBinding;

public class MapActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMapBinding binding;
    private CardView cd1, cd2, cd3, cd4, cd5, cd6;
    private TextView total;
    private TextView jumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        cd1 = (CardView) findViewById(R.id.cd1);
        cd2 = (CardView) findViewById(R.id.cd2);
        cd3 = (CardView) findViewById(R.id.cd3);
        cd4 = (CardView) findViewById(R.id.cd4);
        cd5 = (CardView) findViewById(R.id.cd5);
        cd6 = (CardView) findViewById(R.id.cd6);
        total = (TextView) findViewById(R.id.total);
        jumlah = (TextView) findViewById(R.id.jumlah);

        Intent terima = getIntent();
        int terimaTotal = terima.getIntExtra("total", 0);
        int terimaJumlah = terima.getIntExtra("jumlah",0);

        total.setText("Total : "+"Rp"+Integer.toString(terimaTotal)+",00");
        jumlah.setText("Jumlah paket : "+Integer.toString(terimaJumlah));



        cd1.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateJumlah = terima.getIntExtra("jumlah",0);
            Intent update = new Intent(MapActivity.this, D1Activity.class);
            update.putExtra("update", updateTotal);
            update.putExtra("updatej",updateJumlah);
            startActivity(update);
        });

        cd2.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateJumlah = terima.getIntExtra("jumlah",0);
            Intent update = new Intent(MapActivity.this, D2Activity.class);
            update.putExtra("update", updateTotal);
            update.putExtra("updatej",updateJumlah);
            startActivity(update);
        });

        cd3.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateJumlah = terima.getIntExtra("jumlah",0);
            Intent update = new Intent(MapActivity.this, D3Activity.class);
            update.putExtra("update", updateTotal);
            update.putExtra("updatej",updateJumlah);
            startActivity(update);
        });

        cd4.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateJumlah = terima.getIntExtra("jumlah",0);
            Intent update = new Intent(MapActivity.this, D4Activity.class);
            update.putExtra("update", updateTotal);
            update.putExtra("updatej",updateJumlah);
            startActivity(update);
        });


        cd5.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateJumlah = terima.getIntExtra("jumlah",0);
            Intent update = new Intent(MapActivity.this, D5Activity.class);
            update.putExtra("update", updateTotal);
            update.putExtra("updatej",updateJumlah);
            startActivity(update);
        });

        cd6.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateJumlah = terima.getIntExtra("jumlah",0);
            Intent update = new Intent(MapActivity.this, D6Activity.class);
            update.putExtra("update", updateTotal);
            update.putExtra("updatej",updateJumlah);
            startActivity(update);
        });

        total.setOnClickListener(view -> {
            String totalin = total.getText().toString();
            String jumlahin = jumlah.getText().toString();

            Intent kirim = new Intent(MapActivity.this, CartActivity.class);
            kirim.putExtra("total", totalin);
            kirim.putExtra("jumlah",jumlahin);
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