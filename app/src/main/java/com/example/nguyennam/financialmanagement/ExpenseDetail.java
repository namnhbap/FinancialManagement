package com.example.nguyennam.financialmanagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by NguyenNam on 1/10/2017.
 */

public class ExpenseDetail extends Fragment {

    public static final String DATA_RECEIVE = "data_receive";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expense_detail, container, false);
        return view;
    }
}
