package com.example.reclocality;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {

    private static final String nome_db = "Banco_recLoc";
    private static final int version = 1;

    public Helper(Context context){
        super(context,nome_db,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table locais(id integer primary key autoincrement, latitude varchar(50), longitude varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
