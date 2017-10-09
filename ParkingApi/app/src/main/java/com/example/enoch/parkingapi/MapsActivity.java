package com.example.enoch.parkingapi;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.enoch.parkingapi.data.AppDataManager;
import com.example.enoch.parkingapi.model.ParkingModel;
import com.example.enoch.parkingapi.ui.parkingList.IParkingListMvpView;
import com.example.enoch.parkingapi.ui.parkingList.ParkingListPresenter;
import com.example.enoch.parkingapi.ui.utils.rx.AppSchedulerProvider;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, IParkingListMvpView {

    private GoogleMap mMap;

    private ParkingListPresenter<IParkingListMvpView> parkingListMvpViewParkingListPresenter;

    List<ParkingModel> parkingModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;






                //return v;


       /* // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        **/
        parkingListMvpViewParkingListPresenter = new ParkingListPresenter<>(new AppDataManager(), new AppSchedulerProvider(), new CompositeDisposable());
        parkingListMvpViewParkingListPresenter.onAttach(this);
        parkingListMvpViewParkingListPresenter.onViewPrepared();

    }

    @Override
    public void onFetchDataCompleted(List<ParkingModel> parkingModels) {


        mMap.setInfoWindowAdapter(new CustomInfoAdapter(parkingModels));


        for (int i = 0; i < parkingModels.size(); i++) {


            Log.i("test", parkingModels.get(i).getName());

            LatLng SanFran = new LatLng(Double.parseDouble(parkingModels.get(i).getLat()), Double.parseDouble(parkingModels.get(i).getLng()));

            if (parkingModels.get(i).getIsReserved() == true) {
                Marker marker = mMap.addMarker(new MarkerOptions()
                        .position(SanFran)
                        .title(String.valueOf(i))
                        .snippet("Maximum time : " +parkingModels.get(i).getMaxReserveTimeMins().toString())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SanFran, 11));
                // mMap.moveCamera(CameraUpdateFactory.newLatLng(SanFran));
            } else {
                Marker marker = mMap.addMarker(new MarkerOptions()
                        .position(SanFran).title(String.valueOf(i))
                        .snippet("Maximum time : " +parkingModels.get(i).getMaxReserveTimeMins().toString())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));


                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SanFran, 11));
                // mMap.moveCamera(CameraUpdateFactory.newLatLng(SanFran));

            }
        }


    }



    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }
}
