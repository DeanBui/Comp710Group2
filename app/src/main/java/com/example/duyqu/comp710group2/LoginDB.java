package com.example.duyqu.comp710group2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by duyqu on 2/28/2018.
 */


public class LoginDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "LoginDB.db";
    private static final String TABLE_CONTENT = "Login";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_ID = "id";

    public static final String COLUMN_PSWD = "password";

    public LoginDB(Context context, String name,
                   SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_CONTENT + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_USERNAME
                + " TEXT," + COLUMN_PSWD + " TEXT" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTENT);
        onCreate(db);
    }
    public void addPassword(Account passwordRec) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, passwordRec.getUserName());
        values.put(COLUMN_PSWD, passwordRec.getPassword());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CONTENT, null, values);
        db.close();
    }

    public boolean loginCheck (String userName, String password) {
        String query = "Select * FROM " + TABLE_CONTENT + " WHERE " + COLUMN_PSWD +
                " = \"" + password + "\"" + " AND " + COLUMN_USERNAME + " = \"" + userName + "\"";
        String query1 = "Select * FROM " + TABLE_CONTENT;
        SQLiteDatabase db;
        System.out.print("Check");
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query1, null);
        System.out.print("Check");


        Account account = new Account();
        if (cursor.moveToFirst()) {
            System.out.println("in loop");
            cursor.moveToFirst();
            account.setId(Integer.parseInt(cursor.getString(0)));
            account.setUserName(cursor.getString(1));
            account.setPassword(cursor.getString(2));
            db.close();
            cursor.close();
            return true;
        } else {
            cursor.close();
            db.close();
            return false;
        }


    }}