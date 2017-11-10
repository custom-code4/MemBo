package com.example.arjun.myapplication.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arjun.myapplication.Data.Expenditure;
import com.example.arjun.myapplication.Data.ExpenditureAdapter;
import com.example.arjun.myapplication.Data.Reminder;
import com.example.arjun.myapplication.Data.ReminderAdapter;
import com.example.arjun.myapplication.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReminderFragment extends Fragment {

    ReminderAdapter reminderAdapter;
    ListView listView;
    static final String[] numbers = new String[] {
            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    View view;
    public ReminderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_reminder, container, false);



        listView = (ListView) view.findViewById(R.id.reminder_list_view);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(),
                       "blah blah", Toast.LENGTH_SHORT).show();
            }
        });
        setuplist();
        return view;
    }
    void setuplist() {

        ArrayList<Reminder> reminderArrayList = new ArrayList<Reminder>();
        reminderArrayList.add(new Reminder("Irudhi Suttru", new Date()));
        reminderArrayList.add(new Reminder("Iruxcvdhxci Sutxzvxctru", new Date()));
        reminderArrayList.add(new Reminder("IruddhiczxSuttru", new Date()));
        reminderArrayList.add(new Reminder("Irudhi Suttru", new Date()));
        reminderArrayList.add(new Reminder("Iruddhi dsdsadSuttru", new Date()));
        reminderArrayList.add(new Reminder("Irudhxzczxai Suttru", new Date()));
        reminderArrayList.add(new Reminder("Irudhi  Ssdsauttru", new Date()));
        reminderArrayList.add(new Reminder("Irudhi Suttru", new Date()));
        reminderArrayList.add(new Reminder("Irudhi Suttru", new Date()));


        reminderAdapter = new ReminderAdapter(getActivity(), reminderArrayList);
        listView.setAdapter(reminderAdapter);
    }
}
