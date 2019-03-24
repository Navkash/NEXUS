package com.nexus.navkashkrishna.nexusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SponsorsActivity extends AppCompatActivity {

    ImageView NexusIcon;
    ImageButton profileIcon,notificationIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);

        NexusIcon = (ImageView) findViewById(R.id.iv_nexus_icon);
        profileIcon = (ImageButton) findViewById(R.id.profile);
        notificationIcon = (ImageButton) findViewById(R.id.notification);

        NexusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent = new Intent(SponsorsActivity.this, AboutUsActivity.class);
                startActivity(CompetitionIntent);
            }
        });

        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent=new Intent(SponsorsActivity.this,NotificationActivity.class);
                startActivity(ProfileIntent);
            }
        });

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent = new Intent(SponsorsActivity.this, ProfileActivity.class);
                startActivity(ProfileIntent);
            }
        });
    }
}
