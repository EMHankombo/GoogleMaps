package com.example.enoch.parkingapi.ui.parkingList;

import com.example.enoch.parkingapi.model.ParkingModel;
import com.example.enoch.parkingapi.ui.base.MvpView;

import java.util.List;

/**
 * Created by mainza1992 on 08/10/2017.
 */

public interface IParkingListMvpView extends MvpView {

    void onFetchDataCompleted(List<ParkingModel> parkingModels);
}
