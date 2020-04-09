package com.example.exemplesqllite.Dao;

import android.content.Context;

import com.example.exemplesqllite.Entities.Sortie;

import java.util.ArrayList;

public class SortieDao extends BaseDao implements InterfaceDao<Sortie> {

    public SortieDao(Context context) {
        super(context);
    }

    @Override
    public void insert(Sortie entity) {

    }

    @Override
    public void update(Sortie entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Sortie get(int id) {
        return null;
    }

    @Override
    public ArrayList<Sortie> getAll() {
        return null;
    }
}
