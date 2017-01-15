package com.example.nguyennam.financialmanagement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by NguyenNam on 1/15/2017.
 */

public class ExpenseEvent extends Fragment implements View.OnClickListener {
    EventDescription mCallback;
    EditText editText;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (EventDescription)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement DataPassListener");
        }
    }


    public interface EventDescription {
        public void passEvent(String data);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event, container, false);
        editText = (EditText) view.findViewById(R.id.event);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lnDoneEvent);
        linearLayout.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lnDoneEvent:
                String message = String.valueOf(editText.getText());
                mCallback.passEvent(message);
                break;
        }
    }
}
