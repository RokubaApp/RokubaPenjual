package com.example.asusfx.pesananrokubaterbaru;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<List_Data> list_data;
    private Context context;
    private LayoutInflater inflater;

    public Adapter(Context context, List<List_Data> list_data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List_Data listRoti = list_data.get(position);
        Glide.with(context).load(listRoti.getGambar()).into(holder.image);
        holder.t_Nama.setText(listRoti.getNamaRoti());
        holder.t_Harga.setText(listRoti.getHarga() + "");
        holder.t_Jenis.setText(listRoti.getJenisRoti());
        holder.t_Kuba.setText(listRoti.getKubaRoti());
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView t_Nama, t_Harga, t_Jenis,t_Kuba;
        private ImageView image,img_hapus;

        public ViewHolder(View itemView) {
            super(itemView);
            t_Nama  =  itemView.findViewById(R.id.t_Nama);
            t_Harga =  itemView.findViewById(R.id.t_Harga);
            t_Jenis =  itemView.findViewById(R.id.t_Jenis);
            t_Kuba  =  itemView.findViewById(R.id.t_Kuba);
            image   =  itemView.findViewById(R.id.image);
            img_hapus = itemView.findViewById(R.id.img_hapus);
            img_hapus.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

        }
    }
}
