package com.example.arjun.myapplication.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.arjun.myapplication.Data.Note;
import com.example.arjun.myapplication.Data.NotesAdapter;
import com.example.arjun.myapplication.Data.NotesDatabaseHandler;
import com.example.arjun.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotesFragment extends Fragment {


    ArrayList<Note> notesList = new ArrayList<>();
    NotesAdapter notesAdapter;
    GridView gridView;
    NotesDatabaseHandler notesDatabaseHandler;

    static final String[] numbers = new String[]{
            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    View view;

    public NotesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_notes, container, false);


        gridView = (GridView) view.findViewById(R.id.notesGridView);

        notesDatabaseHandler = new NotesDatabaseHandler(getContext());


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(),
                        Integer.toString(position), Toast.LENGTH_SHORT).show();
            }
        });
        setuplist();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setuplist();
    }

    void setuplist() {

        notesList = notesDatabaseHandler.getAllNotes();
        notesAdapter = new NotesAdapter(getActivity(), notesList);
        gridView.setAdapter(notesAdapter);

        Toast toast = Toast.makeText(getActivity(), "SETTING UP LIST", Toast.LENGTH_SHORT);
        toast.show();
    }

}
