package com.example.arjun.myapplication.Data;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.arjun.myapplication.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Arjun on 11-11-2017.
 */

public class ReminderAdapter extends ArrayAdapter<Reminder>{
    public ReminderAdapter(Activity context, ArrayList<Reminder> reminders) {
        super(context, 0, reminders);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_reminder, parent, false);
        }
        Reminder currentReminder = getItem(position);
        TextView reminderTitleTextView = (TextView) listItemView.findViewById(R.id.reminderTitleTextView);
        TextView reminderTimeTextView = (TextView) listItemView.findViewById(R.id.reminderTimeTextView);
        reminderTitleTextView.setText(currentReminder.getReminderTitle());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        reminderTimeTextView.setText((dateFormat.format(currentReminder.getDate())).toString());
        return listItemView;
    }
}
