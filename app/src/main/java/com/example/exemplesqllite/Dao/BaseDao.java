package com.example.exemplesqllite.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.exemplesqllite.Utilities.ConstantsBdd;

public class BaseDao {
    SqliteDao sqliteDao;
    SQLiteDatabase sqLiteDatabase;

    public BaseDao(Context context) {
        sqliteDao = new SqliteDao(context, ConstantsBdd.NOM_BDD, null, ConstantsBdd.VERSION);

    }

    public void openForWrite() {
        sqLiteDatabase = sqliteDao.getWritableDatabase();
    }

    public void close() {
        sqLiteDatabase.close();
    }
}
