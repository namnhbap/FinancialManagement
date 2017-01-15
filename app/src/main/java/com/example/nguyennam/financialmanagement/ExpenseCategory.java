package com.example.nguyennam.financialmanagement;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguyennam.financialmanagement.adapter.MyListAdapter;
import com.example.nguyennam.financialmanagement.bean.CategoryChild;
import com.example.nguyennam.financialmanagement.bean.CategoryGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by NguyenNam on 1/14/2017.
 */

public class ExpenseCategory extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    private SearchView search;
    private MyListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<CategoryGroup> categoryGroupList = new ArrayList<CategoryGroup>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expense_category);

//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        search = (SearchView) findViewById(R.id.search);
//        search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        search.setIconifiedByDefault(false);
//        search.setOnQueryTextListener(this);
//        search.setOnCloseListener(this);

        //display the list
        displayList();
        //expand all Groups
        expandAll();

        myList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                TextView textView = (TextView) v.findViewById(R.id.groupname);
                String groupname = (String) textView.getText();
                Toast.makeText(getApplicationContext(), "child clicked " + groupname , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra(Constant.KEY_CATEGORY, groupname);
                setResult(RESULT_OK, intent);
                finish();
                return false;
            }
        });

        myList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                TextView textView = (TextView) v.findViewById(R.id.childrow);
                String childrow = (String) textView.getText();
                Toast.makeText(getApplicationContext(), "child clicked " + childrow , Toast.LENGTH_SHORT).show();
                return false;
            }
        });

//        Intent intent = new Intent();
//        intent.putExtra("mockdata", String.valueOf("abc"));
//        setResult(RESULT_OK, intent);
//        finish();

    }


    //method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            myList.expandGroup(i);
        }
    }

    //method to expand all groups
    private void displayList() {

        //display the list
        loadSomeData();

        //get reference to the ExpandableListView
        myList = (ExpandableListView) findViewById(R.id.expandableCategory);
        //create the adapter by passing your ArrayList data
        listAdapter = new MyListAdapter(ExpenseCategory.this, categoryGroupList);
        //attach the adapter to the list
        myList.setAdapter(listAdapter);

    }

    private void loadSomeData() {
        List<String> myGroupList = Arrays.asList(getResources().getStringArray(R.array.group_row_category));
        List<String> listAnUong = Arrays.asList(getResources().getStringArray(R.array.child_row_anuong));
        List<String> listConCai = Arrays.asList(getResources().getStringArray(R.array.child_row_concai));
        List<String> listDichVuSH = Arrays.asList(getResources().getStringArray(R.array.child_row_dichvusinhhoat));
        List<String> listDiLai = Arrays.asList(getResources().getStringArray(R.array.child_row_dilai));
        List<String> listHieuHi = Arrays.asList(getResources().getStringArray(R.array.child_row_hieuhi));
        List<String> listHuongThu = Arrays.asList(getResources().getStringArray(R.array.child_row_huongthu));
        List<String> listNhaCua = Arrays.asList(getResources().getStringArray(R.array.child_row_nhacua));
        List<String> listPhatTrien = Arrays.asList(getResources().getStringArray(R.array.child_row_phattrienbanthan));
        List<String> listSucKhoe = Arrays.asList(getResources().getStringArray(R.array.child_row_suckhoe));
        List<String> listTrangPhuc = Arrays.asList(getResources().getStringArray(R.array.child_row_trangphuc));

        CategoryGroup categoryGroup;

        categoryGroup = new CategoryGroup(myGroupList.get(0), getChildList(listAnUong));
        categoryGroupList.add(categoryGroup);
        categoryGroup = new CategoryGroup(myGroupList.get(1), getChildList(listConCai));
        categoryGroupList.add(categoryGroup);
        categoryGroup = new CategoryGroup(myGroupList.get(2), getChildList(listDichVuSH));
        categoryGroupList.add(categoryGroup);
        categoryGroup = new CategoryGroup(myGroupList.get(3), getChildList(listDiLai));
        categoryGroupList.add(categoryGroup);
        categoryGroup = new CategoryGroup(myGroupList.get(4), getChildList(listHieuHi));
        categoryGroupList.add(categoryGroup);
        categoryGroup = new CategoryGroup(myGroupList.get(5), getChildList(listHuongThu));
        categoryGroupList.add(categoryGroup);
        categoryGroup = new CategoryGroup(myGroupList.get(6), getChildList(listNhaCua));
        categoryGroupList.add(categoryGroup);
        categoryGroup = new CategoryGroup(myGroupList.get(7), getChildList(listPhatTrien));
        categoryGroupList.add(categoryGroup);
        categoryGroup = new CategoryGroup(myGroupList.get(8), getChildList(listSucKhoe));
        categoryGroupList.add(categoryGroup);
        categoryGroup = new CategoryGroup(myGroupList.get(9), getChildList(listTrangPhuc));
        categoryGroupList.add(categoryGroup);
    }

    private ArrayList<CategoryChild> getChildList(List<String> list){
        ArrayList<CategoryChild> categoryChildList = new ArrayList<CategoryChild>();
        for (int i = 0; i < list.size(); i++) {
            CategoryChild categoryChild = new CategoryChild(list.get(i));
            categoryChildList.add(categoryChild);
        }
        return categoryChildList;
    }

    @Override
    public boolean onClose() {
        listAdapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }
}