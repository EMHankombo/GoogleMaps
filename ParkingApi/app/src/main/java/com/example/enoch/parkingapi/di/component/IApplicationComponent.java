package com.example.enoch.parkingapi.di.component;

import android.app.Application;

import com.example.enoch.parkingapi.MyApp;
import com.example.enoch.parkingapi.data.DataManager;
import com.example.enoch.parkingapi.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mainza1992 on 03/10/2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface IApplicationComponent {

    void inject(MyApp myApp);

    Application getApplication();
    DataManager getDataManger();

}
