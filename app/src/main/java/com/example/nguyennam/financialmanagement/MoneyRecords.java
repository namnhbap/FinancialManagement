package com.example.nguyennam.financialmanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NguyenNam on 1/14/2017.
 */

public class MoneyRecords extends FragmentActivity implements AdapterView.OnItemSelectedListener, Calculator.DataPassListener {
    private static final int REQUEST_CODE = 123;
    private Bundle bundle = new Bundle();

//    Context context;
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        this.context = context;
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money_records);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add(getResources().getString(R.string.Expense));
        categories.add(getResources().getString(R.string.Income));

        // Creating adapter for spinner this, android.R.layout.simple_spinner_item, categories
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        ExpenseDetail expenseDetail = new ExpenseDetail();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.formInputMoney, expenseDetail);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void passData(String data) {
        ExpenseDetail expenseDetail = new ExpenseDetail();
//        Bundle args = new Bundle();
        bundle.putString(Constant.KEY_MONEY, data);
        expenseDetail.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.formInputMoney, expenseDetail);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.formInputMoney, someFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        ExpenseDetail expenseDetail = new ExpenseDetail();
        IncomeDetail incomeDetail = new IncomeDetail();

        if (position == 0) {
            replaceFragment(expenseDetail);
        } else {
            replaceFragment(incomeDetail);
        }

        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void startNewActivity(Context context, Class<ExpenseCategory> expenseCategoryClass) {
        Intent intent = new Intent(context, expenseCategoryClass);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            String category = data.getStringExtra(Constant.KEY_CATEGORY);
            ExpenseDetail expenseDetail = new ExpenseDetail();
//            Bundle args = new Bundle();
            bundle.putString(Constant.KEY_CATEGORY, category);
            expenseDetail.setArguments(bundle);

        }
    }
}
