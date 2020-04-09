package com.example.exemplesqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.exemplesqllite.Dao.SortieDao;
import com.example.exemplesqllite.Entities.Sortie;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;



        Sortie sortie = new Sortie();
        sortie.setIdSortie(1);
        sortie.setNom("Sortie équitation");
        sortie.setDescription("Sortie apprentissage de l'équitation");

        SortieDao sortieDao = new SortieDao(context);
        sortieDao.openForWrite();
        sortieDao.insert(sortie);

        Sortie sortieBis = sortieDao.get(1);

        sortieDao.close();

        Log.e("GET SORTIE", sortieBis.getNom());
    }
}
