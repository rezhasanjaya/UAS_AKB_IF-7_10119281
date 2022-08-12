package com.akbuas_10119281.Model;
import java.io.Serializable;

/**
Rezha Satria SP
10119281
 IF7
**/


public class Catatan implements Serializable{
    String id_catatan;
    String judul;
    String kategori;
    String isicatatan;
    String tanggal;


    public Catatan(String id_catatan, String judul, String kategori, String isicatatan, String tanggal) {
        this.id_catatan = id_catatan;
        this.judul = judul;
        this.kategori = kategori;
        this.isicatatan = isicatatan;
        this.tanggal = tanggal;
    }

    public String getId_catatan() {
        return id_catatan;
    }

    public void setId(String id_catatan) {
        this.id_catatan = id_catatan;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getIsicatatan() {
        return isicatatan;
    }

    public void setIsicatatan(String isicatatan) {
        this.isicatatan = isicatatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }





}
