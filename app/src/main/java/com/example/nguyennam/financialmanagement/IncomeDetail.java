package com.example.nguyennam.financialmanagement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by NguyenNam on 1/10/2017.
 */

public class IncomeDetail extends Fragment {

    Context context;
    TextView txtAmount;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.income_detail, container, false);
        final Calculator calculator = new Calculator();
        txtAmount = (TextView) view.findViewById(R.id.txtAmount);
        txtAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MoneyRecords) context).replaceFragment(calculator);
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if (bundle != null) {
            txtAmount.setText(bundle.getString("data"));
        }
    }
}
