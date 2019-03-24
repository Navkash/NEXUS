package com.nexus.navkashkrishna.nexusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.nexus.navkashkrishna.nexusdemo.Adapters.CompetitionAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class CompetitionActivity extends AppCompatActivity {

    ImageView NexusIcon;
    ImageButton profileIcon,notificationIcon;
    public static ArrayList<String> competitionNames ;
//    competitionNames.add()
//    new ArrayList<String>(Arrays.asList("Analogous",
//            "Circuitrix", "Matrix",
//            "IPwars", "Line Of Sight",
//            "utech", "Codewise",
//            "uCraft", "Robotrek",
//            "Techvista", "Quizzard",
//            "Aviskar", "Gameon", "Wordwar"));
    ArrayList competitionImages = new ArrayList<>(Arrays.asList(R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp
            , R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp
            , R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp
            , R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);

        NexusIcon = (ImageView) findViewById(R.id.iv_nexus_icon);
        profileIcon = (ImageButton) findViewById(R.id.profile);
        notificationIcon = (ImageButton) findViewById(R.id.notification);

        NexusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent=new Intent(CompetitionActivity.this,AboutUsActivity.class);
                startActivity(CompetitionIntent);
            }
        });

        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent=new Intent(CompetitionActivity.this,NotificationActivity.class);
                startActivity(ProfileIntent);
            }
        });

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent=new Intent(CompetitionActivity.this,ProfileActivity.class);
                startActivity(ProfileIntent);
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        CompetitionAdapter customAdapter = new CompetitionAdapter(CompetitionActivity.this, competitionNames,competitionImages);
        recyclerView.setAdapter(customAdapter);
        eventStuff();
    }

    private void eventStuff() {
        competitionNames=new ArrayList<>();
        competitionNames.add("Analogous");
        competitionNames.add("Circuitrix");
        competitionNames.add("Matrix");
        competitionNames.add("IPwars");
        competitionNames.add("Line Of Sight");
        competitionNames.add("utech");
        competitionNames.add("Codewise");
        competitionNames.add("uCraft");
        competitionNames.add("Robotrek");
        competitionNames.add("Techvista");
        competitionNames.add("Quizzard");
        competitionNames.add("Aviskar");
        competitionNames.add("Gameon");
        competitionNames.add("Wordwar");
    }
}
