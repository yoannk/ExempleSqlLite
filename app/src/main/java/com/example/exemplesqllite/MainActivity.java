package com.example.exemplesqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

        // Je récupère la liste des sorties
        Sorties sorties = sortieDao.getAll();

        sortieDao.close();

        ArrayList<String> nomSorties = new ArrayList<>();
        for (Sortie item : sorties) {
            nomSorties.add(item.getNom());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, nomSorties);
        lswSorties.setAdapter(adapter);

        Button btnSorties = findViewById(R.id.btnSorties);
        btnSorties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SortiesActivity.class);
                startActivity(intent);
            }
        });
    }
}
