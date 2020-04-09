package com.example.exemplesqllite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.exemplesqllite.Dao.SortieDao;
import com.example.exemplesqllite.Entities.Sortie;
import com.example.exemplesqllite.Entities.Sorties;
import com.example.exemplesqllite.Utilities.Functions;
import com.example.exemplesqllite.Utilities.ServiceWeb;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SortiesActivity extends AppCompatActivity {
    Context context;
    RecyclerView rcwSorties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorties);
        context = this;

        rcwSorties = findViewById(R.id.rcwSorties);

        callGetSorties(8);
    }

    public void callGetSorties(int idAssociation) {
        ServiceWeb.callGetSorties(idAssociation, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                final String retourServiceWeb = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!response.isSuccessful()) {
                            Functions.getToast(context, "Erreur service web (code " + response.code() + ")");
                            return;
                        }

                        try {
                            Gson gson = new Gson();

                            //Matching du flux json qui vient du service web en objet Sorties
                            Sorties sorties = gson.fromJson(retourServiceWeb, Sorties.class);
                            SortieDao sortieDao = new SortieDao(context);
                            sortieDao.openForWrite();

                            for (Sortie sortie : sorties) {
                                sortieDao.insert(sortie);
                            }

                            sortieDao.close();

                            Toast.makeText(context, sorties.size() + " sorties ajoutées en bdd", Toast.LENGTH_SHORT).show();

                            // TODO : affichage des sorties dans rcwSorties

                        } catch (Exception ex) {
                            Log.e("Erreur callGetSorties", ex.getMessage());
                        }
                    }
                });
            }
        });
    }
}
