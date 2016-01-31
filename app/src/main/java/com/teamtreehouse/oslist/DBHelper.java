package com.teamtreehouse.oslist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "limits.db";
    public static final String TBL_NAME = "chlimAuth";
/*    public static final String bankColumn = "bank";
    public static final String typeColumn = "type";
    public static final String cgColumn = "cardGroup";
    public static final String cntColumn = "count";
    public static final String summColumn = "summ";*/

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " + TBL_NAME + "(" +
                "date TEXT," +
                "bank TEXT," +
                "type TEXT," +
                "cardgroup TEXT," +
                "cnt INTEGER," +
                "summ DOUBLE" +
                ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
