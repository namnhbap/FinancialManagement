package com.example.nguyennam.financialmanagement;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity{

    private static final String TAG = "Nam";
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        addCustomTab(getApplicationContext(), getResources().getString(R.string.Records), getResources().getDrawable(R.drawable.note_selected), MoneyRecords.class, tabHost);
        addCustomTab(getApplicationContext(), getResources().getString(R.string.Accounts), getResources().getDrawable(R.drawable.wallet), Accounts.class, tabHost);
        addCustomTab(getApplicationContext(), getResources().getString(R.string.Budget), getResources().getDrawable(R.drawable.tab_budget), Budget.class, tabHost);
        addCustomTab(getApplicationContext(), getResources().getString(R.string.Reports), getResources().getDrawable(R.drawable.pie_chart), Reports.class, tabHost);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
//                View selectedTab = tabHost.getCurrentTabView();
                int selectedIndex = tabHost.getCurrentTab();
                for (int i = 0; i < tabHost.getTabWidget().getTabCount(); i++) {
                    ImageView image = (ImageView) tabHost.getTabWidget().getChildAt(i).findViewById(R.id.img_icon1);
                    TextView iconTitle = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(R.id.text_icon1);
                    Log.d(TAG, "onTabChanged: " + iconTitle.getText());
                    if (i != selectedIndex) {
                        switch (i){
                            case 0:
                                image.setImageDrawable(getResources().getDrawable(R.drawable.note));
                                iconTitle.setTextColor(getResources().getColor(R.color.darkBlack));
                                break;
                            case 1:
                                image.setImageDrawable(getResources().getDrawable(R.drawable.wallet));
                                iconTitle.setTextColor(getResources().getColor(R.color.darkBlack));
                                break;
                            case 2:
                                image.setImageDrawable(getResources().getDrawable(R.drawable.tab_budget));
                                iconTitle.setTextColor(getResources().getColor(R.color.darkBlack));
                                break;
                            case 3:
                                image.setImageDrawable(getResources().getDrawable(R.drawable.pie_chart));
                                iconTitle.setTextColor(getResources().getColor(R.color.darkBlack));
                                break;
                        }
                    } else {
                        switch (i) {
                            case 0:
                                image.setImageDrawable(getResources().getDrawable(R.drawable.note_selected));
                                iconTitle.setTextColor(getResources().getColor(R.color.niceBlue));
                                break;
                            case 1:
                                image.setImageDrawable(getResources().getDrawable(R.drawable.wallet_selected));
                                iconTitle.setTextColor(getResources().getColor(R.color.niceBlue));
                                break;
                            case 2:
                                image.setImageDrawable(getResources().getDrawable(R.drawable.tab_budget_selected));
                                iconTitle.setTextColor(getResources().getColor(R.color.niceBlue));
                                break;
                            case 3:
                                image.setImageDrawable(getResources().getDrawable(R.drawable.pie_chart_selected));
                                iconTitle.setTextColor(getResources().getColor(R.color.niceBlue));
                                break;
                        }
                    }
                }
            }
        });
    }

    private void addCustomTab(Context context, String labelId, Drawable drawable, Class<?> c, TabHost fth ) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_icon1, null);
        ImageView image = (ImageView) view.findViewById(R.id.img_icon1);
        TextView text = (TextView) view.findViewById(R.id.text_icon1);
        image.setImageDrawable(drawable);
        text.setText(labelId);
        TabHost.TabSpec spec = fth.newTabSpec(labelId);
        spec.setIndicator(view);
        spec.setContent(new Intent(this, c));
        fth.addTab(spec);
    }


}
