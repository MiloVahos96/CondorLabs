package com.evilgeniuses.condorlabs;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeamDetailActivity extends AppCompatActivity {

    private String Id, Name, Description, FYear, Badge, Jersey, Website, Facebook, Instagram;

    private TextView TEquipo, TFYear, TDescription, TWeb;
    private ImageView   IVBadge,IVJersey;
    private ImageButton BFace, BInst;
    private ListView LEvents;

    private CustomListAdapter listAdapter;

    String API_BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";

    private ArrayList<EventModel> Events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        TEquipo =   findViewById(R.id.TEquipo);
        TFYear  =   findViewById(R.id.TFYear);
        TDescription    =   findViewById(R.id.TDescription);
        TWeb    =   findViewById(R.id.TWeb);
        IVBadge =   findViewById(R.id.IVTeamBadge);
        IVJersey    =   findViewById(R.id.IVTeamJersey);
        BFace   =   findViewById(R.id.BFacebookLink);
        BInst   =   findViewById(R.id.BInstagramLink);
        LEvents =   findViewById(R.id.LEvents);
        setListViewHeightBasedOnChildren(LEvents);
        LEvents.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Id      =   extras.getString("ID");
            Name    =   extras.getString("NAME");
            FYear   =   extras.getString("YEAR");
            Description =   extras.getString("DESC");
            Badge   =   extras.getString("BADGE");
            Jersey  =   extras.getString("JERSEY");
            Website =   extras.getString("WEB");
            Facebook    =   extras.getString("FACEBOOK");
            Instagram   =   extras.getString("INSTAGRAM");

            TEquipo.setText(Name);
            TFYear.setText(FYear);
            TDescription.setText(Description);
            Picasso.get().load(Badge).into(IVBadge);
            Picasso.get().load(Jersey).into(IVJersey);

            if( !Website.equals("") ) {
                TWeb.setVisibility(View.VISIBLE);
                TWeb.setText(Website);
            }
            if ( !Facebook.equals("") ) {
                BFace.setVisibility(View.VISIBLE);
            }
            if ( !Instagram.equals("") ) {
                BInst.setVisibility(View.VISIBLE);
            }

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            Retrofit.Builder builder =
                    new Retrofit.Builder()
                            .baseUrl(API_BASE_URL)
                            .addConverterFactory(
                                    GsonConverterFactory.create()
                            );

            Retrofit retrofit = builder.client(httpClient.build()).build();

            EventClient client =  retrofit.create(EventClient.class);

            Call<EventListModel> call = client.getEvents(Id);

            call.enqueue(new Callback<EventListModel>() {
                @Override
                public void onResponse(Call<EventListModel> call, Response<EventListModel> response) {
                    EventListModel   eventListModel   =   response.body();
                    Events   = (ArrayList<EventModel>) eventListModel.getEvents();

                    listAdapter =   new CustomListAdapter(getApplicationContext(),Events);
                    LEvents.setAdapter(listAdapter);

                }

                @Override
                public void onFailure(Call<EventListModel> call, Throwable t) {
                    Log.e("RESPUESTA",t.getMessage());
                }
            });


        }

        BFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(Facebook);
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
                likeIng.setPackage("com.facebook.katana");
                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/" )));
                }
            }
        });

        BInst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(Instagram);
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
                likeIng.setPackage("com.instagram.android");
                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/")));
                }
            }
        });

    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
