package com.example.enoch.parkingapi.data.network;

import com.example.enoch.parkingapi.model.ParkingModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by mainza1992 on 08/10/2017.
 */

public interface ApiHelper {

    Observable<List<ParkingModel>> useCaseParkingList();
}
