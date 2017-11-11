package com.example.arjun.myapplication.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.arjun.myapplication.R;

/**
 * Created by Arjun on 11-11-2017.
 */

public class AddReminderDialog extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button addReminder, cancelReminder;

    public AddReminderDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_add_reminder);
        addReminder = (Button) findViewById(R.id.addReminderButton);
        cancelReminder = (Button) findViewById(R.id.cancelReminderButton);
        addReminder.setOnClickListener(this);
        cancelReminder.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addReminderButton:
                //TODO:something
                break;
            case R.id.cancelReminderButton:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();

    }
}

