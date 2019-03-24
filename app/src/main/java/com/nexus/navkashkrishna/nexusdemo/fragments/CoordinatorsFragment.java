package com.nexus.navkashkrishna.nexusdemo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nexus.navkashkrishna.nexusdemo.R;

public class CoordinatorsFragment extends Fragment {

    View v;

    public CoordinatorsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_coordinators, container, false);
        return v;
    }

}
