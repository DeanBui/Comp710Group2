package com.example.duyqu.comp710group2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class ProfileDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ProfileDB.db";
    private static final String TABLE_CONTENT = "Profile";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_OCCUPATION = "occupation";
    public static final String COLUMN_AGE = "userAge";
    public static final String COLUMN_GROUP = "groupNumber";
    public static final String COLUMN_NAME = "fullName";



    public ProfileDB(Context context, String name,
                   SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_CONTENT + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_EMAIL
                + " TEXT," + COLUMN_OCCUPATION + " TEXT," + COLUMN_AGE + " INT(20)," + COLUMN_GROUP + " INT(20), "+ COLUMN_NAME +" TEXT" + ")";

        db.execSQL(CREATE_PRODUCTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTENT);
        onCreate(db);
    }
    public void addProfile(Profile profileRec) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, profileRec.getEmail());
        values.put(COLUMN_OCCUPATION, profileRec.getOccupation());
        values.put(COLUMN_AGE, profileRec.getAge());
        values.put(COLUMN_GROUP, profileRec.getGroup());
        values.put(COLUMN_NAME,profileRec.getName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CONTENT, null, values);
        db.close();
    }

    public ArrayList<Profile> findMatch(int group){
        String query = "Select * FROM " + TABLE_CONTENT + " WHERE " + COLUMN_GROUP + " = " + group ;
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<Profile> profiles = new ArrayList<Profile>();

        int count = 0;
        Profile profile = new Profile();
        while (count < 10){
            if(cursor.moveToFirst()) {
                cursor.moveToFirst();

                profile.setEmail(cursor.getString(1));
                profile.setOccupation(cursor.getString(2));
                profile.setAge(Integer.parseInt(cursor.getString(3)));
                profile.setGroup(Integer.parseInt(cursor.getString(4)));
                profile.setName(cursor.getString(5));

                profiles.add(profile);
                count++;
            }
            else{
                count++;
            }
        }

        cursor.close();
        db.close();
        return profiles;
    }
    }

