package com.evilgeniuses.condorlabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter  extends ArrayAdapter<EventModel> {

    public CustomListAdapter(Context context, ArrayList<EventModel> events) {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EventModel event = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.events_layout, parent, false);
        }
        TextView TEvent = convertView.findViewById(R.id.TEvent);
        TextView TDate = convertView.findViewById(R.id.TDate);
        TEvent.setText(event.getStrEvent());
        TDate.setText(event.getDateEvent());
        return convertView;
    }
}
