package com.example.arjun.myapplication.Data;

/**
 * Created by Arjun on 11-11-2017.
 */

public class Expenditure {
    String expenditureTitle;
    Double amount;

    public Expenditure(String expenditureTitle, Double amount) {
        this.expenditureTitle = expenditureTitle;
        this.amount = amount;
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
