package com.example.asusfx.pesananrokubaterbaru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.example.asusfx.pesananrokubaterbaru.Adapter;
import com.example.asusfx.pesananrokubaterbaru.List_Data;
import com.example.asusfx.pesananrokubaterbaru.R;
import com.example.asusfx.pesananrokubaterbaru.Baca_Roti;

public class Tampil_Roti extends AppCompatActivity {

    private List<List_Data> list_data;
    private RecyclerView rv;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil__roti);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv = findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list_data = new ArrayList<>();
        adapter = new Adapter(getApplicationContext(),list_data);
        getDataRoti();
    }

    private void getDataRoti() {
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i=0; i< array.length(); i++){
                        JSONObject ob = array.getJSONObject(i);
                        List_Data data = new List_Data(ob.getString("namaRoti")
                                ,ob.getInt("harga")
                                ,ob.getString("jenisRoti")
                                ,ob.getString("kubaRoti")
                                ,ob.getString("gambar"));
                        list_data.add(data);
                    }
                    rv.setAdapter(adapter);
                } catch (JSONException a){
                    a.printStackTrace();
                }
            }
        };
        Baca_Roti baca_roti = new Baca_Roti(listener);
        RequestQueue requestQueue = Volley.newRequestQueue(Tampil_Roti.this);
        requestQueue.add(baca_roti);
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
