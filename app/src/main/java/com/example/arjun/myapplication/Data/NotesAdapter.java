package com.example.arjun.myapplication.Data;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import com.example.arjun.myapplication.MainActivity;
import com.example.arjun.myapplication.R;
import java.util.ArrayList;

/**
 * Created by Arjun on 11-11-2017.
 */

public class NotesAdapter extends ArrayAdapter<Note>  {
    private FloatingActionButton fab;
    public NotesAdapter(Activity context, ArrayList<Note> notes) {
        super(context, 0, notes);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item_notes, parent, false);
        }
        Note currentNote = getItem(position);
        TextView noteTitleTextView = (TextView) listItemView.findViewById(R.id.notesTitleTextView);
        TextView notesContentTextView = (TextView) listItemView.findViewById(R.id.notesContentTextView);
        TextView notesTimestampTextView = (TextView) listItemView.findViewById(R.id.notesTimestampTextView);
        noteTitleTextView.setText(currentNote.getNoteTitle());
        notesContentTextView.setText(currentNote.getNoteContent());
        notesTimestampTextView.setText(currentNote.getNoteDate().toString());
        return listItemView;
    }

}