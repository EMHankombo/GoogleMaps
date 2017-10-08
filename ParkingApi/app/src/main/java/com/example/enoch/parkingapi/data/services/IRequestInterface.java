package com.example.enoch.parkingapi.data.services;

import com.example.enoch.parkingapi.model.ParkingModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by mainza1992 on 08/10/2017.
 */

public interface IRequestInterface {

@GET(API_CONSTANTS.SANFRAN_API)
    Observable<List<ParkingModel>> getParkingList();


}
