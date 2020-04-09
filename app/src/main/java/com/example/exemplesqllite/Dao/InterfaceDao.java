package com.example.exemplesqllite.Dao;

import java.util.ArrayList;

public interface InterfaceDao<T> {
    void insert(T entity);
    void update(T entity);
    void delete(int id);
    T get(int id);
    ArrayList<T> getAll();
}
