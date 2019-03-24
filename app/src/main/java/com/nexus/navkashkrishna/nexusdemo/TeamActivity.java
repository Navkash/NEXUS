package com.nexus.navkashkrishna.nexusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.nexus.navkashkrishna.nexusdemo.Adapters.TeamTabsAdapter;

public class TeamActivity extends AppCompatActivity {
    private Toolbar mtoolBar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TeamTabsAdapter teamTabsAdapter;
    ImageView NexusIcon;
    ImageButton profileIcon,notificationIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        NexusIcon = (ImageView) findViewById(R.id.iv_nexus_icon);
        profileIcon = (ImageButton) findViewById(R.id.profile);
        mViewPager=(ViewPager) findViewById(R.id.teamPager);
        teamTabsAdapter=new TeamTabsAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(teamTabsAdapter);
        notificationIcon = (ImageButton) findViewById(R.id.notification);

        mTabLayout=(TabLayout)findViewById(R.id.teamTabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

        NexusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent=new Intent(TeamActivity.this,AboutUsActivity.class);
                startActivity(CompetitionIntent);
            }
        });

        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent=new Intent(TeamActivity.this,NotificationActivity.class);
                startActivity(ProfileIntent);
            }
        });

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent=new Intent(TeamActivity.this,ProfileActivity.class);
                startActivity(ProfileIntent);
            }
        });

    }

}
