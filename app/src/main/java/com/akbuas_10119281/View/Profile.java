package com.akbuas_10119281.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.akbuas_10119281.Presenter.MainActivity;
import com.akbuas_10119281.R;


/**
 Rezha Satria SP
 10119281
 IF7
 **/
public class Profile extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup profile = (ViewGroup) inflater.inflate(R.layout.profile, container, false);
        return profile;
    }
}
