package com.example.asusfx.pesananrokubaterbaru;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahMenu extends AppCompatActivity implements View.OnClickListener{

    EditText txtNama, txtHarga;
    Button btnSimpan;
    String nama, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_menu);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSimpan= findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(this);

        txtNama =  findViewById(R.id.txtNama);
        txtHarga =  findViewById(R.id.txtHarga);
    }

    public void onClick(View v){
        String nama = txtNama.getText().toString();
        String harga = txtHarga.getText().toString();
        if(TextUtils.isEmpty(nama)) {
            txtNama.setError("Nama Harus Diisi");
        }else if(TextUtils.isEmpty(harga)) {
            txtHarga.setError("Harga Harus Diisi");
        }else{
            findViewById(R.id.btnSimpan).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TambahMenu.this);

                builder.setTitle("Konfirmasi");
                builder.setMessage("Apakah Anda Yakin Data Sudah Benar ? ");

                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TambahMenu.this, "Data Dimasukkan Ke Database", Toast.LENGTH_SHORT).show();
                        activity_main();
                    }
                });

                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TambahMenu.this, "Silahkan Cek Kembali", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });}
    }

    private void activity_main(){
        Intent intent = new Intent(TambahMenu.this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
