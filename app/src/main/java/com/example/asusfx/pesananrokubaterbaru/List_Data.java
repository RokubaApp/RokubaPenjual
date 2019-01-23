package com.example.asusfx.pesananrokubaterbaru;

public class List_Data {
    String namaRoti;
    int harga;
    String jenisRoti;
    String kubaRoti;
    String gambar;

    public List_Data(){

    }

    public List_Data(String namaRoti, int harga , String jenisRoti , String kubaRoti, String gambar){
        this.namaRoti=namaRoti;
        this.harga=harga;
        this.jenisRoti=jenisRoti;
        this.kubaRoti=kubaRoti;
        this.gambar=gambar;
    }
    public String getNamaRoti() {
        return namaRoti;
    }

    public int getHarga() {
        return harga;
    }

    public String getJenisRoti() {
        return jenisRoti;
    }

    public String getKubaRoti() {
        return kubaRoti;
    }

    public String getGambar() {
        return gambar;
    }
}
