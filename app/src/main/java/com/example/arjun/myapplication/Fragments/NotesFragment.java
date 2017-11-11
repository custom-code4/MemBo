package com.example.arjun.myapplication.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.arjun.myapplication.Data.Note;
import com.example.arjun.myapplication.Data.NotesAdapter;
import com.example.arjun.myapplication.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotesFragment extends Fragment {


    private FloatingActionButton fab;
    NotesAdapter notesAdapter;
    GridView gridView;

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

    void setuplist() {
        ArrayList<Note> notesList = new ArrayList<>();
        notesList.add(new Note("HELLO", "mmm", new Date()));
        notesList.add(new Note("HELLO", "Thothan", new Date()));
        notesList.add(new Note("Hi", "yyy", new Date()));
        notesList.add(new Note("HELLO", "Thothan", new Date()));
        notesList.add(new Note("how", "llkkasdjkghdkasgdkasgdhgsadjajhdbkjasdhbkjabcxbnmvbxcnvbksdfhjkdvhxjxbnjkdsnlkcnx,mvnljkdnvlknlvkxdfssssssssssssssssssssssssssssssjkfhsdhlskjdfhljksdsdfjlskdjflksdjflksjdlfsjdlfjsldfjlksdjfsdjahgdjasgdkjsadvcbvcbcbvc", new Date()));
        notesList.add(new Note("HELLO", "ggfggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg", new Date()));
        notesList.add(new Note("HELLO", "mmm", new Date()));
        notesList.add(new Note("HELLO", "Thothan", new Date()));
        notesList.add(new Note("Hi", "yyy", new Date()));
        notesList.add(new Note("HELLO", "Thothan", new Date()));
        notesList.add(new Note("how", "llkk", new Date()));
        notesList.add(new Note("HELLO", "ggg", new Date()));
        notesList.add(new Note("HELLO", "mmm", new Date()));
        notesList.add(new Note("HELLO", "Thothan", new Date()));
        notesList.add(new Note("Hi", "yyy", new Date()));
        notesList.add(new Note("HELLO", "Thothan", new Date()));
        notesList.add(new Note("how", "llkk", new Date()));
        notesList.add(new Note("HELLO", "ggg", new Date()));

        notesAdapter = new NotesAdapter(getActivity(), notesList);
        gridView.setAdapter(notesAdapter);
    }

}
