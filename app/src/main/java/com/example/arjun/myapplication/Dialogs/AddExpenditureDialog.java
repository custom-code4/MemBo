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

public class AddExpenditureDialog extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button addExpense, cancelExpense;

    public AddExpenditureDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_add_expenditure);
        addExpense = (Button) findViewById(R.id.addExpenseButton);
        cancelExpense = (Button) findViewById(R.id.cancelExpenseButton);
        addExpense.setOnClickListener(this);
        cancelExpense.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addExpenseButton:
                //TODO:something
                break;
            case R.id.cancelExpenseButton:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();

    }
}

