package com.example.nguyennam.financialmanagement.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nguyennam.financialmanagement.R;
import com.example.nguyennam.financialmanagement.bean.ExpenseBEAN;

import java.util.List;

/**
 * Created by NguyenNam on 1/17/2017.
 */

public class MyHistoryAdapter extends RecyclerView.Adapter<MyHistoryAdapter.HolderHistory> {
    Context context;
    List<ExpenseBEAN> data;
    MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }

    public MyHistoryAdapter(Context context, List<ExpenseBEAN> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public HolderHistory onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_expense_income, parent, false);
        return new HolderHistory(view);
    }

    @Override
    public void onBindViewHolder(HolderHistory holder, int position) {
            ExpenseBEAN expenseBEAN = data.get(position);
        holder.tvCategory.setText(expenseBEAN.get_expenseCategory());
        holder.tvMoney.setText(expenseBEAN.get_amountMoney());
        holder.tvTypeAccount.setText(expenseBEAN.get_fromAccount());
        holder.tvDate.setText(expenseBEAN.get_expenseDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class HolderHistory extends RecyclerView.ViewHolder{
        TextView tvCategory;
        TextView tvMoney;
        TextView tvTypeAccount;
        TextView tvDate;
        public HolderHistory(View itemView) {
            super(itemView);
            tvCategory = (TextView) itemView.findViewById(R.id.tvCategory);
            tvMoney = (TextView) itemView.findViewById(R.id.tvMoney);
            tvTypeAccount = (TextView) itemView.findViewById(R.id.tvTypeAccount);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myOnClick.onClick(data.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface MyOnClick{
        void onClick(ExpenseBEAN expenseBEAN);
    }
}
