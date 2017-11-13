package com.example.arjun.myapplication.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Arjun on 12-11-2017.
 */

public class NotesDatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "notesManager";

    // Contacts table name
    private static final String TABLE_NOTES = "notes";

    // Contacts Table Columns names
    private static final String KEY_NOTE_ID = "noteID";
    private static final String KEY_NOTE_TITLE = "noteTitle";
    private static final String KEY_NOTE_CONTENT = "noteContent";
    private static final String KEY_NOTE_DATE = "noteDate";
    private static final String TAG = "NotesDatabaseHandler";

    public NotesDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NOTES + "( "
                + KEY_NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NOTE_TITLE + " TEXT, "
                + KEY_NOTE_CONTENT + " TEXT," + KEY_NOTE_DATE + " TEXT);";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);

        // Create tables again
        onCreate(db);
    }

    // Adding new note
    public void addNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOTE_TITLE, note.getNoteTitle()); // Note Title
        values.put(KEY_NOTE_CONTENT, note.getNoteContent()); // Note Content
        values.put(KEY_NOTE_DATE, note.getNoteDate().toString());

        // Inserting Row
        db.insert(TABLE_NOTES, null, values);
        db.close(); // Closing database connection
    }

    // Getting single note
    public Note getNotes(int id) {
        Note note;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NOTES, new String[] { KEY_NOTE_ID,
                        KEY_NOTE_TITLE, KEY_NOTE_CONTENT, KEY_NOTE_DATE }, KEY_NOTE_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        note = new Note(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        return note;
    }

    // Getting All Notes
    public ArrayList<Note> getAllNotes() {
        ArrayList<Note> noteList = new ArrayList<Note>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NOTES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                try{
                    Note note = new Note();
                    note.setNoteID(Integer.parseInt(cursor.getString(0)));
                    note.setNoteTitle(cursor.getString(1));
                    note.setNoteContent(cursor.getString(2));
                    note = new Note(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                    // Adding contact to list
                    noteList.add(note);
                } catch (Exception e)
                {
                    Log.e("catch", "database error " + e.getMessage());
                }
            } while (cursor.moveToNext());
        }

        // return notes list
        Log.d(TAG, "noteList size " + noteList.size());
        return noteList;
    }

    // Getting notes Count
    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NOTES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single note
    public int updateNotes(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOTE_TITLE, note.getNoteTitle());
        values.put(KEY_NOTE_CONTENT, note.getNoteContent());

        // updating row
        return db.update(TABLE_NOTES, values, KEY_NOTE_ID + " = ?",
                new String[] { String.valueOf(note.getNoteID()) });
    }

    // Deleting single note
    public void deleteNotes(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTES, KEY_NOTE_ID + " = ?",
                new String[] { String.valueOf(note.getNoteID()) });
        db.close();
    }
}