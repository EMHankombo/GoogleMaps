package com.example.enoch.parkingapi.data.network;

import com.example.enoch.parkingapi.data.services.ConnectionService;
import com.example.enoch.parkingapi.data.services.IRequestInterface;
import com.example.enoch.parkingapi.model.ParkingModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by mainza1992 on 08/10/2017.
 */
@Singleton
public class AppApiHelper implements ApiHelper {

    private IRequestInterface requestInterface;

    @Inject
    public AppApiHelper() {
        this.requestInterface = ConnectionService.getConnectionService();
    }


    @Override
    public Observable<List<ParkingModel>> useCaseParkingList() {
        return requestInterface.getParkingList();
    }
}
