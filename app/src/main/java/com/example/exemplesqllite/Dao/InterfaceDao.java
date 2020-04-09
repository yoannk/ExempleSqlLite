package com.example.exemplesqllite.Dao;

import java.util.ArrayList;

public interface InterfaceDao<T> {
    void insert(T entity);
    int update(T entity);
    int delete(int id);
    T get(int id);
    ArrayList<T> getAll();
}
