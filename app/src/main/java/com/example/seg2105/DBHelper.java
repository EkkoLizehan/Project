package com.example.seg2105;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "User_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, SURNAME TEXT, MARKS TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String name, String surname, String marks){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);

        long res = db.insert(TABLE_NAME, null, contentValues);

        if(res == -1) {

            return false;

        }   else {

            return true;

        }

    }

    public Boolean checkusername(String username) {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});

        if(cursor.getCount() > 0) {

            return true;

        }   else {

            return false;

        }

    }

    public Boolean checkusernamepassword(String username, String password) {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});

        if(cursor.getCount() > 0) {

            return true;

        }   else {

            return false;

        }

    }

    public Boolean insertData_ins(String username, String password, Integer age, String email, String phoneNum) {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email", email);
        contentValues.put("age", age);
        contentValues.put("phoneNumber", phoneNum);

        long result = MyDB.insert("instructors", null, contentValues);

        if(result == -1) {

            return false;

        }   else {

            return true;

        }

    }

}
