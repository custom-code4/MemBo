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
import com.example.arjun.myapplication.Data.NotesAdapter;
import com.example.arjun.myapplication.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExpenditureFragment extends Fragment {

    ExpenditureAdapter expenditureAdapter;
    View view;
    ListView listView;

    public ExpenditureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_expenditure, container, false);


        listView = (ListView) view.findViewById(R.id.expenditure_list_view);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(),
                       "Hello", Toast.LENGTH_SHORT).show();
            }
        });

        setuplist();
        return view;
    }

    void setuplist() {

        ArrayList<Expenditure> expenditureArrayList = new ArrayList<>();
        expenditureArrayList.add(new Expenditure("petrol", 100.55d,new Date()));
        expenditureArrayList.add(new Expenditure("petrol", 100.55d,new Date()));
        expenditureArrayList.add(new Expenditure("petrol", 1050.55d,new Date()));
        expenditureArrayList.add(new Expenditure("petrol", 1090.55d,new Date()));
        expenditureArrayList.add(new Expenditure("petrol", 1000.55d,new Date()));
        expenditureArrayList.add(new Expenditure("petrol", 100.55d,new Date()));
        expenditureArrayList.add(new Expenditure("petrol", 1000.55d,new Date()));
        expenditureArrayList.add(new Expenditure("petrol", 10000.55d,new Date()));
        expenditureArrayList.add(new Expenditure("petrol", 100.55d,new Date()));
        expenditureArrayList.add(new Expenditure("petrol", 100.55d,new Date()));
        expenditureArrayList.add(new Expenditure("petrol", 100.55d,new Date()));

        expenditureAdapter = new ExpenditureAdapter(getActivity(), expenditureArrayList);
        listView.setAdapter(expenditureAdapter);
    }
}

