package com.akbuas_10119281.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.akbuas_10119281.Presenter.ListFragmentAdapter;
import com.akbuas_10119281.Presenter.MainActivity;
import com.akbuas_10119281.R;

import java.util.ArrayList;
import java.util.List;

/**
 Rezha Satria SP
 10119281
 IF7
 **/
public class FragmentBase extends Fragment {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private MainActivity mAct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_base, container, false);

        viewPager = root.findViewById(R.id.view_pager);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mAct = (MainActivity) getActivity();
        mAct.getSupportActionBar().hide();

        List<Fragment> list = new ArrayList<>();
        list.add(new InfoApp());
        list.add(new InfoApp2());

        pagerAdapter = new ListFragmentAdapter(requireActivity().getSupportFragmentManager(), list);

        viewPager.setAdapter(pagerAdapter);
    }
}