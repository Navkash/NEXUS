package com.nexus.navkashkrishna.nexusdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.nexus.navkashkrishna.nexusdemo.Adapters.SubCompetitionAdapter;
import com.nexus.navkashkrishna.nexusdemo.Adapters.TeamTabsAdapter;
import com.nexus.navkashkrishna.nexusdemo.fragments.AboutFragment;

public class SubCompetitionActivity extends AppCompatActivity {

    private Toolbar mtoolBar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private SubCompetitionAdapter subCompetitionAdapter;
    private TextView textViewtitle;
    public static String actionBarTitle;
    public static int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_competition);

        actionBarTitle = getIntent().getExtras().getString("title");
        getPostion();

        textViewtitle=(TextView)findViewById(R.id.title_toolbar);
        textViewtitle.setText(actionBarTitle);
        mViewPager=(ViewPager) findViewById(R.id.teamPager);
        mTabLayout=(TabLayout)findViewById(R.id.teamTabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
        subCompetitionAdapter=new SubCompetitionAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(subCompetitionAdapter);

        findViewById(R.id.ib_back_events).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

//    private void changeFragment(Fragment fragment) {
//        //    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        //    fragmentTransaction.replace(R.id.container,fragment).commit();
//
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        FragmentTransactionExtended fragmentTransactionExtended = new FragmentTransactionExtended(this, fragmentTransaction,
//                new AboutFragment(), fragment, R.id.container);
//        fragmentTransactionExtended.addTransition(FragmentTransactionExtended.GLIDE);
//        fragmentTransactionExtended.commit();
//    }

    public void getPostion() {

        switch (actionBarTitle) {

            case "Analogous":
                position = 0;
                break;
            case "Circuitrix":
                position = 1;
                break;
            case "Matrix":
                position = 2;
                break;
            case "IPwars":
                position = 3;
                break;
            case "Line Of Sight":
                position = 4;
                break;
            case "utech":
                position = 5;
                break;
            case "Codewise":
                position = 6;
                break;
            case "uCraft":
                position = 7;
                break;
            case "Robotrek":
                position = 8;
                break;
            case "Techvista":
                position = 9;
                break;
            case "Quizzard":
                position = 10;
                break;
            case "Aviskar":
                position = 11;
                break;
            case "Gameon":
                position = 12;
                break;
            case "Wordwar":
                position = 13;
                break;

        }
    }


}
