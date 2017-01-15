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
        bundle.putSerializable("data", data);
        listFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.frameAccount, listFragment, "F1");
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void replaceFragment(int position) {
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        DetailFragment fragmentDetail = new DetailFragment();
//        Bundle bundle = new Bundle();
//        MyEmail myEmail = MockData.getEmailById(position, data);
//        bundle.putParcelable("myEmail", myEmail);
//        fragmentDetail.setArguments(bundle);
//        ft.replace(R.id.frame1, fragmentDetail, "F2");
//        ft.addToBackStack(null);
//        ft.commit();
    }
}
