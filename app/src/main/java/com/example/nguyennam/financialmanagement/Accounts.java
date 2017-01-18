package com.example.nguyennam.financialmanagement;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.nguyennam.financialmanagement.bean.AccountRecyclerView;

import java.util.ArrayList;

public class Accounts extends AppCompatActivity {
    ArrayList<AccountRecyclerView> data = MockData.getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ListAccount listFragment = new ListAccount();
        Bundle bundle = new Bundle();
        bundle.putSerializable("account", data);
        listFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.frameAccount, listFragment, "F1");
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
