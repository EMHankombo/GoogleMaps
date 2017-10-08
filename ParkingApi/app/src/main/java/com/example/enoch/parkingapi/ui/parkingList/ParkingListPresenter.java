package com.example.enoch.parkingapi.ui.parkingList;

import com.example.enoch.parkingapi.data.DataManager;
import com.example.enoch.parkingapi.model.ParkingModel;
import com.example.enoch.parkingapi.ui.base.BasePresenter;
import com.example.enoch.parkingapi.ui.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by mainza1992 on 08/10/2017.
 */

public class ParkingListPresenter <V extends IParkingListMvpView> extends BasePresenter<V> implements IParkingListMvpPresenter<V> {

    public ParkingListPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {

        getCompositeDisposable()
                .add(getDataManager().useCaseParkingList()
                        .observeOn(getSchedulerProvider().ui())
                        .subscribeOn(getSchedulerProvider().io())
                        .subscribe(new Consumer<List<ParkingModel>>() {
                                       @Override
                                       public void accept(@NonNull List<ParkingModel> parkingModels) throws Exception {
                                           getMvpView().onFetchDataCompleted(parkingModels);
                                       }
                                   },
                                new Consumer<Throwable>() {
                                    @Override
                                    public void accept(@NonNull Throwable throwable) throws Exception {
                                        getMvpView().onError(throwable.getMessage());
                                    }
                                }));

    }
}
