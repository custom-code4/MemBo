package com.example.arjun.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.arjun.myapplication.Dialogs.AddExpenditureDialog;
import com.example.arjun.myapplication.Dialogs.AddNoteDialog;
import com.example.arjun.myapplication.Dialogs.AddReminderDialog;
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
    FloatingActionButton fab;

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
        fab = (FloatingActionButton) findViewById(R.id.fab);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        addnotes();
                        break;
                    case 1:
                        addreminder();
                        break;
                    case 2:
                        addexpenditure();
                        break;
                    default:
                        fab.hide();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    void addnotes(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNoteDialog addNoteDialog = new AddNoteDialog(MainActivity.this);
                addNoteDialog.show();
            }
        });
    }

    void addreminder(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddReminderDialog addReminderDialog = new AddReminderDialog(MainActivity.this);
                addReminderDialog.show();
            }
        });
    }


    void addexpenditure(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddExpenditureDialog addExpenditureDialog = new AddExpenditureDialog(MainActivity.this);
                addExpenditureDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
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
                    return "NOTE";
                case 1:
                    return "REMINDER";
                case 2:
                    return "EXPENDITURE";
            }
            return null;
        }
    }


}