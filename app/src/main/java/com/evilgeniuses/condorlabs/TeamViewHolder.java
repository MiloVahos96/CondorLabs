package com.evilgeniuses.condorlabs;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamViewHolder extends RecyclerView.ViewHolder {


    public TextView TEquipo;
    public TextView TEstadio;
    public ImageView IVTeamBadge;

    public TeamViewHolder(View view) {
        super(view);
        TEquipo     =   view.findViewById(R.id.TEquipo);
        TEstadio    =   view.findViewById(R.id.TEstadio);
        IVTeamBadge =   view.findViewById(R.id.IVTeamBadge);
    }

}
