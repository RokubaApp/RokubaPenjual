package com.example.asusfx.pesananrokubaterbaru;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Baca_Roti extends StringRequest {
    private static final String LIHAT_REQUEST_URL = "https://rokubaapps.000webhostapp.com/get_roti.php";
    private Map<String, String> params;

    public Baca_Roti(Response.Listener<String> listener){
        super(Request.Method.POST, LIHAT_REQUEST_URL, listener, null);
        params = new HashMap<>();
    }
    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
