package com.example.arjun.myapplication.Data;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.arjun.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Arjun on 11-11-2017.
 */

public class ExpenditureAdapter extends ArrayAdapter<Expenditure> {
    public ExpenditureAdapter(Activity context, ArrayList<Expenditure> expenditures) {
        super(context, 0, expenditures);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_reminder, parent, false);
        }
        Expenditure currentExpenditure = getItem(position);
        TextView expenditureTitleTextView = (TextView) listItemView.findViewById(R.id.expenditureTitleTextView);
        TextView expenditureAmountTextView = (TextView) listItemView.findViewById(R.id.expenditureAmountTextView);
        expenditureTitleTextView.setText(currentExpenditure.getExpenditureTitle());
        expenditureAmountTextView.setText(Double.toString(currentExpenditure.getAmount()));
        return listItemView;
    }
}
