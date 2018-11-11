package com.evilgeniuses.condorlabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    private ListView list;

    ArrayList<String> TeamsNames = new ArrayList<>();

    String API_BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaración de componentes de la vista
        TMain = findViewById(R.id.TMain);
        list = findViewById(R.id.list);
        //RVMain  =   findViewById(R.id.RVMain);

        setSupportActionBar(TMain);//Se cambia el Action bar por nuestra toolbar
        TMain.setTitle(R.string.app_name);
        TMain.setTitleTextColor(getResources().getColor(R.color.white));

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
                List<TeamModel> teams   =   teamListModel.getTeams();
                for ( TeamModel model : teams ) {
                    TeamsNames.add(model.getStrTeam());
                }
            }

            @Override
            public void onFailure(Call<TeamListModel> call, Throwable t) {
                Log.e("RESPUESTA",t.getMessage());
            }
        });

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, TeamsNames);

        list.setAdapter(itemsAdapter);
        itemsAdapter.notifyDataSetChanged();

    }

}