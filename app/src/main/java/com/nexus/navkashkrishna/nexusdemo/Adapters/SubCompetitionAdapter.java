package com.nexus.navkashkrishna.nexusdemo.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nexus.navkashkrishna.nexusdemo.fragments.AboutFragment;
import com.nexus.navkashkrishna.nexusdemo.fragments.AdministrationFragment;
import com.nexus.navkashkrishna.nexusdemo.fragments.CoordinatorsFragment;
import com.nexus.navkashkrishna.nexusdemo.fragments.CoreFragment;
import com.nexus.navkashkrishna.nexusdemo.fragments.DevelopersFragment;
import com.nexus.navkashkrishna.nexusdemo.fragments.JointCoreFragment;
import com.nexus.navkashkrishna.nexusdemo.fragments.RulesFragment;

public class SubCompetitionAdapter extends FragmentPagerAdapter {
    public SubCompetitionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                AboutFragment aboutFragment=new AboutFragment();
                return aboutFragment;

            case 1:
                RulesFragment rulesFragment=new RulesFragment();
                return rulesFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "About";

            case 1:
                return "Rules";

            default:
                return null;
        }
    }
}
