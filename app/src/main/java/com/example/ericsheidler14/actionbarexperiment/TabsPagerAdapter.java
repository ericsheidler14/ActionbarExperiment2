package com.example.ericsheidler14.actionbarexperiment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ericsheidler14 on 3/19/2018.
 */

public class TabsPagerAdapter extends FragmentStatePagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index)  {
        switch(index)   {
            case 0:
                return new new com.example.ericsheidler14.actionbarexperiment.BreakfastFragment;
            case 1:
                return new new com.example.ericsheidler14.actionbarexperiment.LunchFragment;
            case 2:
                return new com.example.ericsheidler14.actionbarexperiment.DinnerFragment;
            case 3:
                return new com.example.ericsheidler14.actionbarexperiment.SnackFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
