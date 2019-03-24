package com.nexus.navkashkrishna.nexusdemo.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.nexus.navkashkrishna.nexusdemo.Adapters.TeamAdapter;
import com.nexus.navkashkrishna.nexusdemo.Modals.Team;
import com.nexus.navkashkrishna.nexusdemo.ProfileActivity;
import com.nexus.navkashkrishna.nexusdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DevelopersFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Team> teamdata;
    View v;

    public DevelopersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_developers, container, false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        TeamAdapter customAdapter = new TeamAdapter(getContext(),teamdata);
        recyclerView.setAdapter(customAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        teamdata =new ArrayList<>();
        teamdata.add(new Team("Navkash","3rd year","979-8-8-999",R.drawable.mypass,"7367049350"));

    }

}
