package com.example.arjun.myapplication.Data;

import java.util.Date;

/**
 * Created by Arjun on 11-11-2017.
 */

public class Expenditure {
    String expenditureTitle;
    Double amount;
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Expenditure(String expenditureTitle, Double amount, Date date) {
        this.expenditureTitle = expenditureTitle;
        this.amount = amount;
        this.date = date;
    }

    public String getExpenditureTitle() {
        return expenditureTitle;
    }

    public void setExpenditureTitle(String expenditureTitle) {
        this.expenditureTitle = expenditureTitle;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
