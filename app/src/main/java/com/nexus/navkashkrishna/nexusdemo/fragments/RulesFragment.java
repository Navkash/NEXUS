package com.nexus.navkashkrishna.nexusdemo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nexus.navkashkrishna.nexusdemo.Adapters.TeamAdapter;
import com.nexus.navkashkrishna.nexusdemo.MainpageActivity;
import com.nexus.navkashkrishna.nexusdemo.R;
import com.nexus.navkashkrishna.nexusdemo.SubCompetitionActivity;

public class RulesFragment extends Fragment {
    View v;

    public RulesFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_rules, container, false);
        TextView t1=(TextView) v.findViewById(R.id.title_about);

        TextView t2=(TextView) v.findViewById(R.id.text_about);
        t2.setText(MainpageActivity.data.get(SubCompetitionActivity.position).getRules());
        return v;
    }
}
