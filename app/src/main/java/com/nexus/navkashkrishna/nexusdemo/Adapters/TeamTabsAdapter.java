package com.nexus.navkashkrishna.nexusdemo.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nexus.navkashkrishna.nexusdemo.fragments.AdministrationFragment;
import com.nexus.navkashkrishna.nexusdemo.fragments.CoreFragment;
import com.nexus.navkashkrishna.nexusdemo.fragments.DevelopersFragment;
import com.nexus.navkashkrishna.nexusdemo.fragments.JointCoreFragment;

public class TeamTabsAdapter extends FragmentPagerAdapter {

    public TeamTabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:
                AdministrationFragment administrationFragment=new AdministrationFragment();
                return administrationFragment;

            case 1:
                CoreFragment coreFragment=new CoreFragment();
                return coreFragment;

            case 2:
                JointCoreFragment jointCoreFragment=new JointCoreFragment();
                return jointCoreFragment;

            case 3:
                DevelopersFragment developersFragment =new DevelopersFragment();
                return developersFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Administration";

            case 1:
                return "Core";

            case 2:
                return "JointCore";

            case 3:
                return "Developers";

            default:
                return null;
        }
    }
}
