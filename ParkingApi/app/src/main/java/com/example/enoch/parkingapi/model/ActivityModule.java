package com.example.enoch.parkingapi.model;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.example.enoch.parkingapi.MapsActivity;
import com.example.enoch.parkingapi.di.scope.ActivityContext;
import com.example.enoch.parkingapi.ui.parkingList.IParkingListMvpPresenter;
import com.example.enoch.parkingapi.ui.parkingList.IParkingListMvpView;
import com.example.enoch.parkingapi.ui.parkingList.ParkingListPresenter;
import com.example.enoch.parkingapi.ui.utils.rx.AppSchedulerProvider;
import com.example.enoch.parkingapi.ui.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by mainza1992 on 03/10/2017.
 */
@Module
public class ActivityModule {

    FragmentActivity appCompatActivity;

    public ActivityModule(MapsActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @ActivityContext
    Context getContext(){
        return appCompatActivity;
    }

    @Provides
    FragmentActivity getAppCompatActivity(){
        return appCompatActivity;
    }

    @Provides
    CompositeDisposable compositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider schedulerProvider(){
        return  new AppSchedulerProvider();
    }

    /**
     * presenter object
     */

    @Provides
    IParkingListMvpPresenter<IParkingListMvpView> iParkingListMvpPresenter (ParkingListPresenter<IParkingListMvpView> parkingListMvpViewParkingListPresenter){
        return parkingListMvpViewParkingListPresenter;
    }
}
