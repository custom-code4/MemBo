package com.example.arjun.myapplication.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.arjun.myapplication.Data.Note;
import com.example.arjun.myapplication.Data.NotesDatabaseHandler;
import com.example.arjun.myapplication.R;

import java.util.Date;

/**
 * Created by Arjun on 11-11-2017.
 */

public class AddNoteDialog extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button addNote, cancelNote;
    EditText noteTitle,noteContent;

    public AddNoteDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_add_note);
        addNote = (Button) findViewById(R.id.addNoteButton);
        cancelNote = (Button) findViewById(R.id.cancelNoteButton);
        addNote.setOnClickListener(this);
        cancelNote.setOnClickListener(this);
        noteTitle = (EditText) findViewById(R.id.noteTitleEditText);
        noteContent = (EditText) findViewById(R.id.noteContentEditText);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addNoteButton:
                Note note = new Note();
                note.setNoteTitle(noteTitle.getText().toString());
                note.setNoteContent(noteContent.getText().toString());
                note.setNoteDate(new Date());
                NotesDatabaseHandler notesDatabaseHandler = new NotesDatabaseHandler(getContext());
                notesDatabaseHandler.addNote(note);
                break;
            case R.id.cancelNoteButton:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();

    }
}
