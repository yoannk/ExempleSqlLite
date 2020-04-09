package com.example.exemplesqllite.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.exemplesqllite.Utilities.ConstantsBdd;

public class SqliteDao extends SQLiteOpenHelper {
    public SqliteDao(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.e("SQLITE", "Création dbb et table");
            db.execSQL(ConstantsBdd.CREATE_TABLE_SORTIES);
        } catch (Exception ex) {
            Log.e("SQLITE", ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
