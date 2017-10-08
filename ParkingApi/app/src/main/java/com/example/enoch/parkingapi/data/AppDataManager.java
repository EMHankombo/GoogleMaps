package com.example.enoch.parkingapi.data;

import com.example.enoch.parkingapi.data.network.ApiHelper;
import com.example.enoch.parkingapi.data.network.AppApiHelper;
import com.example.enoch.parkingapi.model.ParkingModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by mainza1992 on 08/10/2017.
 */

public class AppDataManager implements DataManager {

    private ApiHelper apiHelper;


    //empty constructor
    public AppDataManager() {
        this.apiHelper = new AppApiHelper();
    }


    @Override
    public Observable<List<ParkingModel>> useCaseParkingList() {
        return apiHelper.useCaseParkingList();
    }
}
