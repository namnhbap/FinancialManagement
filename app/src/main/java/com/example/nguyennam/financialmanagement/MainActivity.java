package com.example.nguyennam.financialmanagement;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements Calculator.DataPassListener{

    private static final String TAG = "Nam";
    private static final int REQUEST_CODE_EXAMPLE = 0x9345;
    TextView txtGotoCal;
    FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Tab1.."),
                ExpenseDetail.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Tab2."),
                IncomeDetail.class, null);

    }


    @Override
    public void passData(String data) {
        ExpenseDetail expenseDetail = new ExpenseDetail ();
        Bundle args = new Bundle();
        args.putString(ExpenseDetail.DATA_RECEIVE, data);
        expenseDetail.setArguments(args);
        getFragmentManager().beginTransaction()
                .replace(R.id.realtabcontent, expenseDetail)
                .commit();
    }
}
