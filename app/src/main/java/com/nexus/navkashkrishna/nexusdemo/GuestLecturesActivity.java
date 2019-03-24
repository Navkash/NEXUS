package com.nexus.navkashkrishna.nexusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class GuestLecturesActivity extends AppCompatActivity {

    ImageView NexusIcon;
    ImageButton profileIcon,notificationIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guestlecture);

        NexusIcon = (ImageView) findViewById(R.id.iv_nexus_icon);
        profileIcon = (ImageButton) findViewById(R.id.profile);
        notificationIcon = (ImageButton) findViewById(R.id.notification);

        NexusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent = new Intent(GuestLecturesActivity.this, AboutUsActivity.class);
                startActivity(CompetitionIntent);
            }
        });

        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent=new Intent(GuestLecturesActivity.this,NotificationActivity.class);
                startActivity(ProfileIntent);
            }
        });

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent = new Intent(GuestLecturesActivity.this, ProfileActivity.class);
                startActivity(ProfileIntent);
            }
        });
    }
}
