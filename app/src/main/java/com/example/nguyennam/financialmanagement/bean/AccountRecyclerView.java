package com.example.nguyennam.financialmanagement.bean;

/**
 * Created by NguyenNam on 1/16/2017.
 */

public class AccountRecyclerView {
    private int id;
    private String accountType;
    private long amountMoney;

    public AccountRecyclerView(int id, String accountType, long amountMoney) {
        this.id = id;
        this.accountType = accountType;
        this.amountMoney = amountMoney;
    }

    public AccountRecyclerView(String accountType, long amountMoney) {
        this.accountType = accountType;
        this.amountMoney = amountMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(long amountMoney) {
        this.amountMoney = amountMoney;
    }
}
