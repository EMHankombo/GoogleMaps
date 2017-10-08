package com.example.enoch.parkingapi.ui.parkingList;

import com.example.enoch.parkingapi.ui.base.MvpPresenter;

/**
 * Created by mainza1992 on 08/10/2017.
 */

public interface IParkingListMvpPresenter < V extends  IParkingListMvpView> extends MvpPresenter<V> {

    void onViewPrepared();
}
