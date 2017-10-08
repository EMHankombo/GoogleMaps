package com.example.enoch.parkingapi.ui.utils.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mainza1992 on 08/10/2017.
 */

public class AppSchedulerProvider implements com.example.enoch.parkingapi.ui.utils.rx.SchedulerProvider {
    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler computation() {
        return  Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }
}
