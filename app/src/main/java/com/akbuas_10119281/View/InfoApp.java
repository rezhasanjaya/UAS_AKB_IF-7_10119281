package com.akbuas_10119281.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.akbuas_10119281.R;

/**
 Rezha Satria SP
 10119281
 IF7
 **/
public class InfoApp extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup infoApp = (ViewGroup) inflater.inflate(R.layout.infoapp, container, false);
        return infoApp;
    }
}
