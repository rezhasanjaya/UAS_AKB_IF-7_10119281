package com.akbuas_10119281.Presenter;
import android.database.Cursor;
import com.akbuas_10119281.Model.Catatan;

/**
 Rezha Satria SP
 10119281
 IF7
 **/
public interface CatatanInterface {
    public Cursor read();
    public boolean save(Catatan catatan);
    public boolean update(Catatan catatan);
    public boolean delete(String id_catatan);

}
