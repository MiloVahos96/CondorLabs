package com.evilgeniuses.condorlabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // Componentes de la vista
    private Toolbar TMain;
    private RecyclerView RVMain;
    private RecyclerView.Adapter RVAdapter;
    private RecyclerView.LayoutManager RVLManager;

    private ArrayList<TeamModel> Teams;

    String API_BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaración de componentes de la vista
        TMain = findViewById(R.id.TMain);
        RVMain  =   findViewById(R.id.RVMain);

        setSupportActionBar(TMain);//Se cambia el Action bar por nuestra toolbar
        TMain.setTitle(R.string.app_name);
        TMain.setTitleTextColor(getResources().getColor(R.color.white));

        RVMain.setHasFixedSize(true);

        RVLManager = new LinearLayoutManager(this);
        RVMain.setLayoutManager(RVLManager);



        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit = builder.client(httpClient.build()).build();

        TeamsClient client =  retrofit.create(TeamsClient.class);

        Call<TeamListModel> call = client.getTeams();

        call.enqueue(new Callback<TeamListModel>() {
            @Override
            public void onResponse(Call<TeamListModel> call, Response<TeamListModel> response) {
                TeamListModel   teamListModel   =   response.body();
                Teams   = (ArrayList<TeamModel>) teamListModel.getTeams();
                RVAdapter = new CustomRVAdapter(getApplicationContext(),Teams);
                RVMain.setAdapter(RVAdapter);
                RVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TeamListModel> call, Throwable t) {
                Log.e("RESPUESTA",t.getMessage());
            }
        });
    }

}