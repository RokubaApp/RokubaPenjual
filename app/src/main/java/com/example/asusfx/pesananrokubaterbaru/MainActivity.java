package com.example.asusfx.pesananrokubaterbaru;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout LnTambah, LnListRoti, LnUmum, LnDelivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        ab.hide();

        setContentView(R.layout.activity_main);

        LnTambah = findViewById(R.id.LnTambah);
        LnTambah.setOnClickListener(this);

        LnListRoti = findViewById(R.id.LnListRoti);
        LnListRoti.setOnClickListener(this);

        LnDelivery = findViewById(R.id.LnDelivery);
        LnDelivery.setOnClickListener(this);

        LnUmum = findViewById(R.id.LnUmum);
        LnUmum.setOnClickListener(this);
    }

    private void tambahMenu(){startActivity(new Intent(getApplicationContext(),TambahMenu.class));}
    private void tampil_Roti(){startActivity(new Intent(getApplicationContext(),Tampil_Roti.class));}
    private void delivery(){startActivity(new Intent(getApplicationContext(),Delivery.class));}
    private void umum(){startActivity(new Intent(getApplicationContext(),Umum.class));}

    public void onClick(View v){
        if(v == LnTambah) {
            tambahMenu();
        }else if(v == LnListRoti){
            tampil_Roti();
        }else if(v == LnDelivery){
            delivery();
        }else if(v == LnUmum){
            umum();
        }
    }
}
