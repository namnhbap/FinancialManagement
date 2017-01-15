package com.example.nguyennam.financialmanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by NguyenNam on 1/15/2017.
 */

public class Description extends Fragment implements View.OnClickListener {
    DataDescription mCallback;
    EditText editText;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (DataDescription)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement DataPassListener");
        }
    }


    public interface DataDescription{
        public void passDescription(String data);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.description, container, false);
        editText = (EditText) view.findViewById(R.id.description);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lnDoneDescription);
        linearLayout.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lnDoneDescription:
                String message = String.valueOf(editText.getText());
                mCallback.passDescription(message);
                break;
        }
    }

}
