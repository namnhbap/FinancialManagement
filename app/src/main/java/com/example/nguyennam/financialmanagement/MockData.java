package com.example.nguyennam.financialmanagement;

import com.example.nguyennam.financialmanagement.bean.AccountRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NguyenNam on 1/4/2017.
 */

public class MockData {
    public static ArrayList<AccountRecyclerView> getData(){
        ArrayList<AccountRecyclerView> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(new AccountRecyclerView("Subject", i*100000));
//        }
        list.add(new AccountRecyclerView(1, "Ví", 10000000));
        list.add(new AccountRecyclerView(2, "ATM", 90000000));
        list.add(new AccountRecyclerView(3, "Tiết kiệm", 1000000000));
        return list;
    }

    public static AccountRecyclerView getAccountById(int id, List<AccountRecyclerView> list){
        return list.get(id);
    }
}
