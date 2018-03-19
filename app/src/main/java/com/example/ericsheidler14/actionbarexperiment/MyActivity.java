package com.example.ericsheidler14.actionbarexperiment;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MyActivity extends AppCompatActivity {

    private static final String TAB_KEY_INDEX = "tab_key";
    private Fragment breakfastFragment;
    private Fragment lunchFragment;
    private Fragment snackFragment;
    private Fragment dinnerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        /*ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        }*/

        ActionBar.Tab breakfastTab = actionBar.newTab().setText(getString(R.string.ui_tabname_breakfast));
        ActionBar.Tab lunchTab = actionBar.newTab().setText(getString(R.string.ui_tabname_lunch));
        ActionBar.Tab dinnerTab = actionBar.newTab().setText(getString(R.string.ui_tabname_dinner));
        ActionBar.Tab snackTab = actionBar.newTab().setText(getString(R.string.ui_tabname_snack));

        breakfastFragment = new BreakfastFragment();
        lunchFragment = new LunchFragment();
        dinnerFragment = new DinnerFragment();
        snackFragment = new SnackFragment();

        breakfastTab.setTabListener(new MyTabsListener(breakfastFragment, getApplicationContext()));
        snackTab.setTabListener(new MyTabsListener(snackFragment, getApplicationContext()));
        dinnerTab.setTabListener(new MyTabsListener(dinnerFragment, getApplicationContext()));
        lunchTab.setTabListener(new MyTabsListener(lunchFragment, getApplicationContext()));

        actionBar.addTab(breakfastTab);
        actionBar.addTab(lunchTab);
        actionBar.addTab(dinnerTab);
        actionBar.addTab(snackTab);

        if (savedInstanceState != null) {
            actionBar.setSelectedNavigationItem(savedInstanceState.getInt(TAB_KEY_INDEX, 0));
        }
    }

    class MyTabsListener implements ActionBar.TabListener {

        public Fragment fragment;

        public MyTabsListener(Fragment f, Context context) {
            fragment = f;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft)  {}

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)    {
            ft.replace(R.id.fragment_container, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)  {
            ft.remove(fragment);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu)   {
            getMenuInflater().inflate(R.menu.menu_my, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }
}
