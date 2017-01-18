package com.example.nguyennam.financialmanagement.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nguyennam.financialmanagement.bean.ExpenseBEAN;
import static com.example.nguyennam.financialmanagement.database.DatabaseHandler.ExpenseColumn.KEY_AMOUNTMONEY;
import static com.example.nguyennam.financialmanagement.database.DatabaseHandler.ExpenseColumn.KEY_DESCRIPTION;
import static com.example.nguyennam.financialmanagement.database.DatabaseHandler.ExpenseColumn.KEY_EXPENSECATEGORY;
import static com.example.nguyennam.financialmanagement.database.DatabaseHandler.ExpenseColumn.KEY_EXPENSEDATE;
import static com.example.nguyennam.financialmanagement.database.DatabaseHandler.ExpenseColumn.KEY_FROMACCOUNT;
import static com.example.nguyennam.financialmanagement.database.DatabaseHandler.ExpenseColumn.KEY_EXPENSEEVENT;
import static com.example.nguyennam.financialmanagement.database.DatabaseHandler.TABLE_EXPENSE;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NguyenNam on 1/16/2017.
 */

public class ExpenseDAO {

    Context context;
    DatabaseHandler databaseHandler;

    public ExpenseDAO(Context context) {
        this.context = context;
        databaseHandler = new DatabaseHandler(context);
    }

    public void addExpense(ExpenseBEAN expenseBEAN) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_AMOUNTMONEY, expenseBEAN.get_amountMoney());
        values.put(KEY_EXPENSECATEGORY, expenseBEAN.get_expenseCategory());
        values.put(KEY_DESCRIPTION, expenseBEAN.get_description());
        values.put(KEY_FROMACCOUNT, expenseBEAN.get_fromAccount());
        values.put(KEY_EXPENSEDATE, expenseBEAN.get_expenseDate());
        values.put(KEY_EXPENSEEVENT, expenseBEAN.get_expenseEvent());
        // Inserting Row
        db.insert(TABLE_EXPENSE, null, values);
        db.close(); // Closing database connection
    }

    public ExpenseBEAN getExpense(int id) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EXPENSE, new String[] { DatabaseHandler.ExpenseColumn._ID,
                        KEY_AMOUNTMONEY, KEY_EXPENSECATEGORY, KEY_DESCRIPTION,
                KEY_FROMACCOUNT, KEY_EXPENSEDATE, KEY_EXPENSEEVENT }, DatabaseHandler.ExpenseColumn._ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        ExpenseBEAN expenseBEAN = new ExpenseBEAN(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getString(5), cursor.getString(6));
        // return expense
        return expenseBEAN;
    }

    public List<ExpenseBEAN> getAllExpense() {
        List<ExpenseBEAN> expenseList = new ArrayList<ExpenseBEAN>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EXPENSE;
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ExpenseBEAN expenseBEAN = new ExpenseBEAN();
                expenseBEAN.set_id(Integer.parseInt(cursor.getString(0)));
                expenseBEAN.set_amountMoney(cursor.getString(1));
                expenseBEAN.set_expenseCategory(cursor.getString(2));
                expenseBEAN.set_description(cursor.getString(3));
                expenseBEAN.set_fromAccount(cursor.getString(4));
                expenseBEAN.set_expenseDate(cursor.getString(5));
                expenseBEAN.set_expenseEvent(cursor.getString(6));
                // Adding contact to list
                expenseList.add(expenseBEAN);
            } while (cursor.moveToNext());
        }
        // return contact list
        return expenseList;
    }

    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_EXPENSE;
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        // return count
        return cursor.getCount();
    }

    public int updateContact(ExpenseBEAN expenseBEAN) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_AMOUNTMONEY, expenseBEAN.get_amountMoney());
        values.put(KEY_EXPENSECATEGORY, expenseBEAN.get_expenseCategory());
        values.put(KEY_DESCRIPTION, expenseBEAN.get_description());
        values.put(KEY_FROMACCOUNT, expenseBEAN.get_fromAccount());
        values.put(KEY_EXPENSEDATE, expenseBEAN.get_expenseDate());
        values.put(KEY_EXPENSEEVENT, expenseBEAN.get_expenseEvent());
        // updating row
        return db.update(TABLE_EXPENSE, values, DatabaseHandler.ExpenseColumn._ID + " = ?",
                new String[] { String.valueOf(expenseBEAN.get_id()) });
    }

    public void deleteContact(ExpenseBEAN expenseBEAN) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        db.delete(TABLE_EXPENSE, DatabaseHandler.ExpenseColumn._ID + " = ?",
                new String[] { String.valueOf(expenseBEAN.get_id()) });
        db.close();
    }
}
