package com.example.nguyennam.financialmanagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.nguyennam.financialmanagement.adapter.MyHistoryAdapter;
import com.example.nguyennam.financialmanagement.bean.ExpenseBEAN;
import com.example.nguyennam.financialmanagement.database.ExpenseDAO;

import java.util.List;

/**
 * Created by NguyenNam on 1/17/2017.
 */

public class HistoryExpenseIncome extends AppCompatActivity implements MyHistoryAdapter.MyOnClick {

    List<ExpenseBEAN> data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_expense_income);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerviewHistory);
        ExpenseDAO expenseDAO = new ExpenseDAO(this);
//        expenseDAO.addExpense(new ExpenseBEAN(1,"100000","Ăn uống", "ac1", "Ví", "12/1/2017", "ok"));
//        expenseDAO.addExpense(new ExpenseBEAN(2,"200000","Đi lại", "ac2", "Ví", "12/1/2017", "ok"));
//        expenseDAO.addExpense(new ExpenseBEAN(3,"350000","Điện nước", "ac3", "ATM", "13/1/2017", "ok"));
        data = expenseDAO.getAllExpense();
        MyHistoryAdapter myAdapter = new MyHistoryAdapter(this, data);
        myAdapter.setMyOnClick(this);
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Log.d(Constant.TAG, "onCreate: " + data);
    }

    @Override
    public void onClick(ExpenseBEAN expenseBEAN) {

    }
}
