package com.nexus.navkashkrishna.nexusdemo.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nexus.navkashkrishna.nexusdemo.Adapters.TeamAdapter;
import com.nexus.navkashkrishna.nexusdemo.Modals.Team;
import com.nexus.navkashkrishna.nexusdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JointCoreFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Team> teamdata;
    private int[] images = {R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp,
            R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp
            , R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp
            , R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp
            , R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp};
    private String[] text = {"Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7", "Person 8",
            "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"};
    View v;

    public JointCoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_joint_core, container, false);
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
        teamdata.add(new Team("Navkash","Apphead","979-8-8-999",R.drawable.ic_notifications_black_24dp,"7367049350"));
    }
}
