package com.example.arjun.myapplication.Data;

import java.util.Date;

/**
 * Created by Arjun on 11-11-2017.
 */

public class Note {
    int noteID;
    String noteTitle;

    public Note() {
    }

    String noteContent;
    Date noteDate;

    public Note(int noteID, String noteTitle, String noteContent, Date noteDate) {
        this.noteID = noteID;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.noteDate = noteDate;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }
}
