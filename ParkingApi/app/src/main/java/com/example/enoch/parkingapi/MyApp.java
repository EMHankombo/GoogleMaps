package com.example.enoch.parkingapi;

import android.app.Application;
import android.content.Context;

import com.example.enoch.parkingapi.di.component.DaggerIApplicationComponent;
import com.example.enoch.parkingapi.di.component.IApplicationComponent;
import com.example.enoch.parkingapi.di.module.ApplicationModule;

/**
 * Created by mainza1992 on 08/10/2017.
 */

public class MyApp extends Application {

    IApplicationComponent iApplicationComponent;

    public IApplicationComponent getiApplicationComponent() {
        return iApplicationComponent;
    }

    public static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;

        iApplicationComponent = DaggerIApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        getiApplicationComponent().inject(this);
    }

}

