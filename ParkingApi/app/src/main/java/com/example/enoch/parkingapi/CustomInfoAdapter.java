package com.example.enoch.parkingapi;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.enoch.parkingapi.model.ParkingModel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.List;

/**
 * Created by mainza1992 on 09/10/2017.
 */

public class CustomInfoAdapter implements GoogleMap.InfoWindowAdapter{

    List<ParkingModel> parkingModels;

    public View view;

    public CustomInfoAdapter(List<ParkingModel> parkingModels) {

        view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.info_window,null);
        this.parkingModels = parkingModels;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        TextView name = (TextView)view.findViewById(R.id.name);
        TextView minTime = (TextView)view.findViewById(R.id.minTime);
        TextView maxTime = (TextView)view.findViewById(R.id.maxTime);
        TextView cost = (TextView)view.findViewById(R.id.cost);
        TextView isReserved = (TextView)view.findViewById(R.id.reserved);

         name.setText(parkingModels.get(Integer.parseInt(marker.getTitle())).getName());
         minTime.setText("Min: " +parkingModels.get(Integer.parseInt(marker.getTitle())).getMinReserveTimeMins().toString() +" Minutes");
        maxTime.setText("Max: " +parkingModels.get(Integer.parseInt(marker.getTitle())).getMaxReserveTimeMins().toString() + " Minutes");
        cost.setText("Cost : " +parkingModels.get(Integer.parseInt(marker.getTitle())).getCostPerMinute() + " /min");

        if(parkingModels.get(Integer.parseInt(marker.getTitle())).getIsReserved()==true){
            isReserved.setText("Reserved");
        } else { isReserved.setText("Not Reserved");}

        return view;
    }
}
