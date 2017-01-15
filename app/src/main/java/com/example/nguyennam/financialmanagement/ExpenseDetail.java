package com.example.nguyennam.financialmanagement;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Created by NguyenNam on 1/10/2017.
 */

public class ExpenseDetail extends Fragment implements View.OnClickListener {

    Context context;
    Calendar myCalendar;
    TextView txtAmount;
    TextView txtExpenseType;
    TextView txtDescription;
    TextView txtAccountName;
    TextView txtExpenseTime;
    TextView txtExpenseEvent;
    final Calculator calculator = new Calculator();
    final Description description = new Description();
    final ExpenseEvent expenseEvent = new ExpenseEvent();
    final ListAccount listAccount = new ListAccount();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expense_detail, container, false);
        txtAmount = (TextView) view.findViewById(R.id.txtAmount);
        txtAmount.setOnClickListener(this);
        txtExpenseType = (TextView) view.findViewById(R.id.txtExpenseType);
        txtDescription = (TextView) view.findViewById(R.id.txtDescription);
        txtAccountName = (TextView) view.findViewById(R.id.txtAccountName);
        txtExpenseTime = (TextView) view.findViewById(R.id.txtExpenseTime);
        txtExpenseTime.setText(getDate());
        txtExpenseEvent = (TextView) view.findViewById(R.id.txtExpenseEvent);
        RelativeLayout rlSelectCategory = (RelativeLayout) view.findViewById(R.id.rlSelectCategory);
        rlSelectCategory.setOnClickListener(this);
        RelativeLayout rlDescription = (RelativeLayout) view.findViewById(R.id.rlDescription);
        rlDescription.setOnClickListener(this);
        RelativeLayout rlSelectAccount = (RelativeLayout) view.findViewById(R.id.rlSelectAccount);
        rlSelectAccount.setOnClickListener(this);
        RelativeLayout rlSelectTime = (RelativeLayout) view.findViewById(R.id.rlSelectTime);
        rlSelectTime.setOnClickListener(this);
        RelativeLayout rlExpenseEvent = (RelativeLayout) view.findViewById(R.id.rlExpenseEvent);
        rlExpenseEvent.setOnClickListener(this);
        return view;
    }

    String getDate(){
        myCalendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(myCalendar.getTime());
        return formattedDate;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if (bundle != null) {
            txtAmount.setText(bundle.getString(Constant.KEY_MONEY));
            txtExpenseType.setText(bundle.getString(Constant.KEY_CATEGORY));
            txtDescription.setText(bundle.getString(Constant.KEY_DIENGIAI));
            txtExpenseEvent.setText(bundle.getString(Constant.KEY_EVENT));
        }
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        txtExpenseTime.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtAmount:
                ((MoneyRecords) context).replaceFragment(calculator);
                break;
            case R.id.rlSelectCategory:
                ((MoneyRecords) context).startNewActivity(context, ExpenseCategory.class);
                break;
            case R.id.rlDescription:
                ((MoneyRecords) context).replaceFragment(description);
                break;
            case R.id.rlSelectAccount:
                ((MoneyRecords) context).replaceFragmentListAccount(listAccount);
                break;
            case R.id.rlSelectTime:
                new DatePickerDialog(context, date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.rlExpenseEvent:
                ((MoneyRecords) context).replaceFragment(expenseEvent);
                break;
        }
    }
}
