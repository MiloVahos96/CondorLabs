package com.evilgeniuses.condorlabs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomRVAdapter extends RecyclerView.Adapter<TeamViewHolder> {

    private ArrayList<TeamModel> Teams;
    private Context context;

    public CustomRVAdapter(Context c ,ArrayList<TeamModel> myDataset) {
        Teams   =   myDataset;
        context =   c;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.general_cardview, parent, false);
        return new TeamViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder teamViewHolder, int i) {
        teamViewHolder.TEquipo.setText(Teams.get(i).getStrTeam());
        teamViewHolder.TEstadio.setText(Teams.get(i).getStrStadium());
        String URLBadge =  Teams.get(i).getStrTeamBadge();
        Picasso.get().load(URLBadge).into(teamViewHolder.IVTeamBadge);

    }

    @Override
    public int getItemCount() {
        return Teams.size();
    }
}
