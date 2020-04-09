package com.example.exemplesqllite.Utilities;

public class ConstantsBdd {
    public static final int VERSION = 1;
    public static final String NOM_BDD = "association.db";

    public static final String TABLE_SORTIES = "table_sorties";

    public static final String COL_ID_SORTIE = "IDSORTIE";
    public static final int NUM_COL_ID_SORTIE = 0;

    public static final String COL_NOM_SORTIE = "NOM";
    public static final int NUM_COL_NOM_SORTIE = 1;

    public static final String COL_DESCRIPTION_SORTIE = "DESCRIPTION";
    public static final int NUM_COL_DESCRIPTION_SORTIE = 2;

    public static final String CREATE_TABLE_SORTIES = "CREATE TABLE " + TABLE_SORTIES + " (" +
            COL_ID_SORTIE + " INTEGER PRIMARY KEY, " +
            COL_NOM_SORTIE + " TEXT NOT NULL, " +
            COL_DESCRIPTION_SORTIE + " TEXT NOT NULL);";
}
