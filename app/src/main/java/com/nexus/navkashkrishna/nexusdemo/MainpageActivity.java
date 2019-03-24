package com.nexus.navkashkrishna.nexusdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nexus.navkashkrishna.nexusdemo.Modals.EventModel;
import com.nexus.navkashkrishna.nexusdemo.Modals.QueryModal;

import java.util.ArrayList;

public class MainpageActivity extends AppCompatActivity {

    LinearLayout l1,l2;
    Button day1Button,day2Button,day3Button,competitionButton,guestLectureButton,SponsorsButton,TeamButton,QueryButton,AboutButton;
    Animation uptodown,downtoup;
    ImageView NexusIcon;
    ImageButton profileIcon,notificationIcon;
    public static ArrayList<EventModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        l1 = (LinearLayout) findViewById(R.id.daysLayout);
        l2 = (LinearLayout) findViewById(R.id.descriptionsLayout);
        day1Button = (Button)findViewById(R.id.day1_button);
        day2Button = (Button)findViewById(R.id.day2_button);
        day3Button = (Button)findViewById(R.id.day3_button);
        competitionButton = (Button)findViewById(R.id.Competition);
        guestLectureButton = (Button)findViewById(R.id.guestLecture);
        SponsorsButton = (Button)findViewById(R.id.Sponsors);
        TeamButton = (Button)findViewById(R.id.Team);
        QueryButton= (Button)findViewById(R.id.Query);
        AboutButton = (Button)findViewById(R.id.About);
        NexusIcon=(ImageView)findViewById(R.id.iv_nexus_icon);
        profileIcon=(ImageButton)findViewById(R.id.profile);
        notificationIcon = (ImageButton) findViewById(R.id.notification);


        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);
//        day1Button.setAnimation(uptodown);day2Button.setAnimation(uptodown);day3Button.setAnimation(uptodown);
//        competitionButton.setAnimation(downtoup);guestLectureButton.setAnimation(downtoup);
//                                    SponsorsButton.setAnimation(downtoup);TeamButton.setAnimation(downtoup);
//                                    QueryButton.setAnimation(downtoup);AboutButton.setAnimation(downtoup);

        competitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent=new Intent(MainpageActivity.this,CompetitionActivity.class);
                startActivity(CompetitionIntent);

            }
        });

        AboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent=new Intent(MainpageActivity.this,AboutUsActivity.class);
                startActivity(CompetitionIntent);

            }
        });

        TeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent=new Intent(MainpageActivity.this,TeamActivity.class);
                startActivity(CompetitionIntent);

            }
        });

        guestLectureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent=new Intent(MainpageActivity.this,GuestLecturesActivity.class);
                startActivity(CompetitionIntent);

            }
        });

        QueryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent=new Intent(MainpageActivity.this,QueryActivity.class);
                startActivity(CompetitionIntent);

            }
        });

        SponsorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent=new Intent(MainpageActivity.this,SponsorsActivity.class);
                startActivity(CompetitionIntent);

            }
        });

        NexusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompetitionIntent=new Intent(MainpageActivity.this,AboutUsActivity.class);
                startActivity(CompetitionIntent);
            }
        });

        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent=new Intent(MainpageActivity.this,NotificationActivity.class);
                startActivity(ProfileIntent);
            }
        });

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfileIntent=new Intent(MainpageActivity.this,ProfileActivity.class);
                startActivity(ProfileIntent);
            }
        });


        ImageButton fb = (ImageButton) findViewById(R.id.fb);
        ImageButton insta = (ImageButton) findViewById(R.id.insta);
        ImageButton webpage = (ImageButton) findViewById(R.id.web);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/secenitjsr/"));
                startActivity(intent);
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/secenitjsr/"));
                startActivity(intent);
            }
        });

        webpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://nitjsr.ac.in/sece/"));
                startActivity(intent);
            }
        });

        eventStuff();

    }

    private void eventStuff() {
        data=new ArrayList<>();
        data.add(new EventModel("What is Nexus","iijp","Nexus, the annual Techno-Management fest of SECE. It will span for 3 days: March somethig . The spirit of Nexus lies in encouraging sound practice, making precision engineering a way of life,effectively bringing about a paradigm shift from classroom to path-breaking innovation"));
        data.add(new EventModel(" Nexus","isnbonboenbowebpiewpnbwpenbpweibwpijp"," The spirit of Nexus lies in encouraging sound practice, making precision engineering a way of life,effectively bringing about a paradigm shift from classroom to path-breaking innovation"));
        data.add(new EventModel(" Nexus2","isnbonboenbowebpiewpnbwpenbpweibwpijp","  path-breaking innovation"));
        data.add(new EventModel(" Nexus3","isnbonboenbowebpiewpnbwpenbpweibwpijp","  path-breaking innovation"));
        data.add(new EventModel(" Nexus23","isnbonboenbowebpiewpnbwpenbpweibwpijp","  path-breaking innovation"));
        data.add(new EventModel(" Nexus4","isnbonboenbowebpiewpnbwpenbpweibwpijp","  path-breaking innovation"));
        data.add(new EventModel(" Nexuswq","isnbonboenbowebpiewpnbwpenbpweibwpijp","  path-breaking innovation"));
        data.add(new EventModel(" Nexusqw","isnbonboenbowebpiewpnbwpenbpweibwpijp","  path-breaking innovation"));
        data.add(new EventModel(" Nexus","isnbonboenbowebpiewpnbwpenbpweibwpijp","  path-breaking innovation"));
        data.add(new EventModel(" Nexus","isnbonboenbowebpiewpnbwpenbpweibwpijp","  path-breaking innovation"));
        data.add(new EventModel(" Nexus","isnbonboenbowebpiewpnbwpenbpweibwpijp","  path-breaking innovation"));
        data.add(new EventModel(" Nexus","isnbonboenbowebpiewpnbwpenbpweibwpijp","  path-breaking innovation"));
        data.add(new EventModel(" Nexus","isnbonboenbowebpiewpnbwpenbpweibwpijp","  path-breaking innovation"));
        data.add(new EventModel(" Nexus","isnbonboenbowebpiewpnbwpenbpweibwpijp","  path-breaking innovation"));
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
