package com.example.nguyennam.financialmanagement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguyennam.financialmanagement.adapter.MyRecyclerviewAdapter;
import com.example.nguyennam.financialmanagement.bean.AccountRecyclerView;

import java.util.ArrayList;

/**
 * Created by NguyenNam on 1/16/2017.
 */

public class ListAccount extends Fragment implements MyRecyclerviewAdapter.MyOnClickListener {
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_recyclerview, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

//        List<MyEmail> data = MockData.getData();
        ArrayList<AccountRecyclerView> data = (ArrayList<AccountRecyclerView>) getArguments().getSerializable("account");
        MyRecyclerviewAdapter myAdapter = new MyRecyclerviewAdapter(context, data);
        myAdapter.setMyOnClickListener(this);
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onClick(int position) {
        ((MoneyRecords) context).selectAccount(position);
    }
}
