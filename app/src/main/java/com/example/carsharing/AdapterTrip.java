package com.example.carsharing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterTrip {
    private LayoutInflater inflater;
    private int layout;
    private List<Trip_a> trips;

    public AdapterTrip(Context context, int resource, List<Trip_a> trips) {
        this.trips = trips;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView modelView = (TextView) view.findViewById(R.id.modeltextView);
        TextView timeView = (TextView) view.findViewById(R.id.timetextView);
        TextView sumView = (TextView) view.findViewById(R.id.manytextView);

        Trip_a trip = trips.get(position);

        modelView.setText(trip.getModel());
        timeView.setText(trip.getTime());
        sumView.setText(trip.getSum());

        return view;
    }
}
