package com.akbuas_10119281.View;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akbuas_10119281.Data.CatatanImp;
import com.akbuas_10119281.Model.Catatan;
import com.akbuas_10119281.Presenter.CatatanAdapter;
import com.akbuas_10119281.Presenter.CatatanInterface;
import com.akbuas_10119281.Presenter.InputActivity;
import com.akbuas_10119281.Presenter.MainActivity;
import com.akbuas_10119281.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 Rezha Satria SP
 10119281
 IF7
 **/
public class CatatanView extends Fragment {
    private MainActivity mAct;
    private CatatanAdapter catatanAdapter;
    private CatatanInterface catatanInterface;
    private List<Catatan> catat;
    private RecyclerView recyclerView;
    private FloatingActionButton floatBtn;


    @Nullable
    @Override
    public  View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        View mView =  inflater.inflate(R.layout.list_catatan, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        mAct = (MainActivity) getActivity();
        mAct.getSupportActionBar().hide();

        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.catatan);
        floatBtn = view.findViewById(R.id.floatBtn);
        floatBtn.setOnClickListener(v ->{
            startActivity(new Intent(getContext(), InputActivity.class));
        });

        read();
    }
    private void read(){
        catat=new ArrayList<Catatan>();
        catatanInterface = new CatatanImp(getContext());
        Cursor cursor = catatanInterface.read();
        if(cursor.moveToFirst()){
            do{
                Catatan c = new Catatan(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)

                );
                catat.add(c);
            }while (cursor.moveToNext());
        }
        catatanAdapter = new CatatanAdapter(catat);
        recyclerView.setAdapter(catatanAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }

}
