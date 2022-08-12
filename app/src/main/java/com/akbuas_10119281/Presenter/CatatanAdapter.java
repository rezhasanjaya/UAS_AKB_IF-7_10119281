package com.akbuas_10119281.Presenter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akbuas_10119281.Model.Catatan;
import com.akbuas_10119281.R;


import java.util.List;

/**
 Rezha Satria SP
 10119281
 IF7
 **/
public class CatatanAdapter extends RecyclerView.Adapter<CatatanAdapter.CatatanViewHolder> {
    private List<Catatan> catatList;


    public CatatanAdapter(List<Catatan> catatList) {
        this.catatList = catatList;
    }

    @NonNull
    @Override
    public CatatanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cardnya,null, false);
        return new CatatanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatatanViewHolder holder, int position) {
        holder.judul.setText(catatList.get(position).getJudul());
        holder.kategori.setText(catatList.get(position).getKategori());
        holder.isicatatan.setText(catatList.get(position).getIsicatatan());
        holder.tanggal.setText(catatList.get(position).getTanggal());

    holder.itemView.setOnClickListener( i -> {
        Intent intent = new Intent(holder.itemView.getContext(), InputActivity.class);
        intent.putExtra("Catat", catatList.get(position));
        holder.itemView.getContext().startActivity(intent);
    });

    }

    @Override
    public int getItemCount() {
        return catatList.size();
    }

    public interface CatatanOnClickListener {

    }

    public class CatatanViewHolder extends RecyclerView.ViewHolder{

        TextView judul;
        TextView kategori;
        TextView isicatatan;
        TextView tanggal;
        
        public CatatanViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul);
            kategori = itemView.findViewById(R.id.kategori);
            isicatatan = itemView.findViewById(R.id.isicatatn);
            tanggal = itemView.findViewById(R.id.tanggal);


        }
    }
}
