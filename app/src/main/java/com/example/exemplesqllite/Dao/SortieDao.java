package com.example.exemplesqllite.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.exemplesqllite.Entities.Sortie;
import com.example.exemplesqllite.Entities.Sorties;
import com.example.exemplesqllite.Utilities.ConstantsBdd;

import java.util.ArrayList;

public class SortieDao extends BaseDao implements InterfaceDao<Sortie> {

    public SortieDao(Context context) {
        super(context);
    }

    @Override
    public void insert(Sortie sortie) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantsBdd.COL_ID_SORTIE, sortie.getIdSortie());
            contentValues.put(ConstantsBdd.COL_NOM_SORTIE, sortie.getNom());
            contentValues.put(ConstantsBdd.COL_DESCRIPTION_SORTIE, sortie.getDescription());

            sqLiteDatabase.insert(ConstantsBdd.TABLE_SORTIES, null, contentValues);
        } catch (Exception ex) {
            Log.e("Erreur insert sortie", ex.getMessage());
        }
    }

    @Override
    public int update(Sortie sortie) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsBdd.COL_NOM_SORTIE, sortie.getNom());
        contentValues.put(ConstantsBdd.COL_DESCRIPTION_SORTIE, sortie.getDescription());

        return sqLiteDatabase.update(
                ConstantsBdd.TABLE_SORTIES,
                contentValues,
                ConstantsBdd.COL_ID_SORTIE + " = " + sortie.getIdSortie(),
                null
        );
    }

    @Override
    public int delete(int id) {
        return sqLiteDatabase.delete(
                ConstantsBdd.TABLE_SORTIES,
                ConstantsBdd.COL_ID_SORTIE + " = " + id,
                null
        );
    }

    @Override
    public Sortie get(int id) {
        Cursor c = sqLiteDatabase.query(
                ConstantsBdd.TABLE_SORTIES,
                new String[]{
                        ConstantsBdd.COL_ID_SORTIE,
                        ConstantsBdd.COL_NOM_SORTIE,
                        ConstantsBdd.COL_DESCRIPTION_SORTIE
                },
                ConstantsBdd.COL_ID_SORTIE + " = " + id,
                null,
                null,
                null,
                ConstantsBdd.COL_NOM_SORTIE
        );

        c.moveToFirst();
        Sortie sortie = cursorToSortie(c);
        c.close();

        return sortie;
    }

    @Override
    public ArrayList<Sortie> getAll() {
        Cursor c = sqLiteDatabase.query(
                ConstantsBdd.TABLE_SORTIES,
                new String[]{
                        ConstantsBdd.COL_ID_SORTIE,
                        ConstantsBdd.COL_NOM_SORTIE,
                        ConstantsBdd.COL_DESCRIPTION_SORTIE
                },
                null,
                null,
                null,
                null,
                ConstantsBdd.COL_NOM_SORTIE
        );

        Sorties sorties = new Sorties();

        if (c.getCount() > 0) {
            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                Sortie sortie = cursorToSortie(c);
                sorties.add(sortie);
            }
        }

        c.close();

        return sorties;
    }

    private Sortie cursorToSortie(Cursor c) {
        Sortie sortie = null;

        if (c.getCount() > 0) {
            sortie = new Sortie();
            sortie.setIdSortie(c.getInt(ConstantsBdd.NUM_COL_ID_SORTIE));
            sortie.setNom(c.getString(ConstantsBdd.NUM_COL_NOM_SORTIE));
            sortie.setDescription(c.getString(ConstantsBdd.NUM_COL_DESCRIPTION_SORTIE));
        }

        return sortie;
    }
}
