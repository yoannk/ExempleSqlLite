package com.example.exemplesqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.exemplesqllite.Dao.SortieDao;
import com.example.exemplesqllite.Entities.Sortie;
import com.example.exemplesqllite.Entities.Sorties;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        ListView lswSorties = findViewById(R.id.lswSorties);

        SortieDao sortieDao = new SortieDao(context);

        sortieDao.openForWrite();

        Sortie sortie1 = new Sortie();
        sortie1.setIdSortie(1);
        sortie1.setNom("Sortie équitation");
        sortie1.setDescription("Sortie apprentissage de l'équitation");

        Sortie sortie2 = new Sortie();
        sortie2.setIdSortie(2);
        sortie2.setNom("Sortie bowling");
        sortie2.setDescription("Sortie apprentissage du bowling");

        Sortie sortie3 = new Sortie();
        sortie3.setIdSortie(3);
        sortie3.setNom("Sortie randonnée");
        sortie3.setDescription("Sortie apprentissage de la randonnée");

        sortieDao.insert(sortie1);
        sortieDao.insert(sortie2);
        sortieDao.insert(sortie3);


        // Je récupère la liste des sorties
        Sorties sorties = sortieDao.getAll();

        sortieDao.close();

        ArrayList<String> nomSorties = new ArrayList<>();
        for (Sortie item : sorties) {
            nomSorties.add(item.getNom());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, nomSorties);
        lswSorties.setAdapter(adapter);
    }
}
