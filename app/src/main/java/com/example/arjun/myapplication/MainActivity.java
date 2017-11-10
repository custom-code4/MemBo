package com.example.arjun.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.arjun.myapplication.Fragments.ExpenditureFragment;
import com.example.arjun.myapplication.Fragments.NotesFragment;
import com.example.arjun.myapplication.Fragments.ReminderFragment;


public class MainActivity extends AppCompatActivity {

    public static SectionsPagerAdapter mSectionsPagerAdapter;

    public static ViewPager mViewPager;
    public static TabLayout tabLayout;
    public static FrameLayout frameLayout;
    public static Fragment notesFragment;
    public static Fragment expenditureFragment;
    public static Fragment reminderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notesFragment = new NotesFragment();
        expenditureFragment = new ExpenditureFragment();
        reminderFragment = new ReminderFragment();
        frameLayout = (FrameLayout) findViewById(R.id.fragment);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return notesFragment;
                case 1:
                    return reminderFragment;
                case 2:
                    return expenditureFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "NOTES";
                case 1:
                    return "REMINDER";
                case 2:
                    return "EXPENDITURE";
            }
            return null;
        }
    }


}