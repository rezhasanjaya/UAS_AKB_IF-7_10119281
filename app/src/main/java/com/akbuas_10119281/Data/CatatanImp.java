package com.akbuas_10119281.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.akbuas_10119281.Model.Catatan;
import com.akbuas_10119281.Presenter.CatatanInterface;


/**
 Rezha Satria SP
 10119281
 IF7
 **/

public class CatatanImp extends SQLiteOpenHelper implements CatatanInterface {
    public CatatanImp(@Nullable Context context) {
        super(context, "catatDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sql) {
        sql.execSQL("CREATE TABLE catatanDb (id_catatan TEXT, judul TEXT, kategori TEXT,isi_catatan TEXT, tanggal TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sql, int oldVersion, int newVersion) {
        sql.execSQL("DROP TABLE catatanDb");
    }

    @Override
    public Cursor read() {
        SQLiteDatabase sql = getReadableDatabase();
        return sql.rawQuery("SELECT * FROM catatanDb",null);
    }

    @Override
    public boolean save(Catatan catatan) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("INSERT INTO catatanDb VALUES ('"+catatan.getId_catatan()+"','"+catatan.getJudul()+"','"+catatan.getKategori()+"','"+catatan.getIsicatatan()+"','"+catatan.getTanggal()+"')");
        return true;
    }

    @Override
    public boolean update (Catatan catatan){
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("UPDATE catatanDb SET judul='"+catatan.getJudul()+"', kategori='"+catatan.getKategori()+"', isi_catatan='"+catatan.getIsicatatan()+"', tanggal='"+catatan.getTanggal()+"' WHERE id_catatan='"+catatan.getId_catatan()+"'");
        return true;
    }

    @Override
    public boolean delete(String id_catatan) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("DELETE FROM catatanDb WHERE id_catatan='"+id_catatan+"'");
        return true;
    }
}
