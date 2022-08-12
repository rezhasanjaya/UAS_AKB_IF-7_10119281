package com.akbuas_10119281.Presenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.akbuas_10119281.Data.CatatanImp;
import com.akbuas_10119281.Model.Catatan;
import com.akbuas_10119281.R;


import java.util.Date;
/**
 Rezha Satria SP
 10119281
 IF7
 **/
public class InputActivity extends AppCompatActivity {

    ImageButton button;
    EditText editTitle;
    EditText editCategory;
    EditText editDesc;
    Button addButton;
    Button deleteButton;
    TextView titleAdd;

    private CatatanInterface catatanInterface;
    Catatan catatan = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        getSupportActionBar().hide();
        catatan = (Catatan) getIntent().getSerializableExtra("Catat");
        button = findViewById(R.id.kembali);
        editTitle = findViewById(R.id.input_judul);
        editCategory = findViewById(R.id.input_kategori);
        editDesc = findViewById(R.id.input_isi);
        addButton = findViewById(R.id.btn_simpan);
        deleteButton = findViewById(R.id.btn_apus);
        titleAdd = findViewById(R.id.addMyNotes);
        catatanInterface = new CatatanImp(this);

        button.setOnClickListener(v -> {
            finish();
        });

        if (catatan == null){
            deleteButton.setVisibility(View.GONE);

            addButton.setOnClickListener(v -> {
                if (editTitle.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Judul Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editCategory.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Kategori Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editDesc.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Isi Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }
                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMM yyyy HH:mm", d.getTime());
                Catatan c = new Catatan(
                        d.getTime() + "",
                        editTitle.getText().toString(),
                        editCategory.getText().toString(),
                        editDesc.getText().toString(),
                        "" + date + ""
                );

                catatanInterface.save(c);
                finish();
                Toast.makeText(this, "Catatan berhasil di tambah", Toast.LENGTH_SHORT).show();
            });
        } else {
            catatan.getId_catatan();
            editTitle.setText(catatan.getJudul());
            editCategory.setText(catatan.getKategori());
            editDesc.setText(catatan.getIsicatatan());
            deleteButton.setVisibility(View.VISIBLE);
            titleAdd.setText("Sunting Catatan");

            addButton.setOnClickListener(v -> {
                if (editTitle.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Judul Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editCategory.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Kategori Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editDesc.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Isi Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }

                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMMM yyyy HH:mm",d.getTime());

                catatan.setJudul(editTitle.getText().toString());
                catatan.setKategori(editCategory.getText().toString());
                catatan.setIsicatatan(editDesc.getText().toString());
                catatan.setTanggal("" + date + "");

                catatanInterface.update(catatan);
                finish();
                Toast.makeText(this, "Catatan berhasil di edit", Toast.LENGTH_SHORT).show();
            });
        }

        deleteButton.setOnClickListener(v-> {
            catatanInterface.delete(catatan.getId_catatan());
            finish();
            Toast.makeText(this, "Catatan berhasil di hapus", Toast.LENGTH_SHORT).show();
        });
    }
}