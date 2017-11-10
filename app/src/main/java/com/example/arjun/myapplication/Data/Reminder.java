package com.example.arjun.myapplication.Data;

import java.util.Date;

/**
 * Created by Arjun on 11-11-2017.
 */

public class Reminder {
    String reminderTitle;
    Date date;

    public Reminder(String reminderTitle, Date date) {
        this.reminderTitle = reminderTitle;
        this.date = date;
    }

    public Reminder() {
    }

    public String getReminderTitle() {
        return reminderTitle;
    }

    public void setReminderTitle(String reminderTitle) {
        this.reminderTitle = reminderTitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
