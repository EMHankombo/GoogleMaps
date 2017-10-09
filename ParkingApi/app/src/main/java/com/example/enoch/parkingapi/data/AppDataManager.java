package com.example.enoch.parkingapi.data;

import android.content.Context;

import com.example.enoch.parkingapi.data.network.ApiHelper;
import com.example.enoch.parkingapi.data.network.AppApiHelper;
import com.example.enoch.parkingapi.di.scope.ApplicationContext;
import com.example.enoch.parkingapi.model.ParkingModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by mainza1992 on 08/10/2017.
 */
@Singleton
public class AppDataManager implements DataManager {

    private ApiHelper apiHelper;


    //empty constructor
    @Inject
    public AppDataManager(@ApplicationContext Context context, ApiHelper apiHelper) {
        this.apiHelper = new AppApiHelper();
    }


    @Override
    public Observable<List<ParkingModel>> useCaseParkingList() {
        return apiHelper.useCaseParkingList();
    }
}
