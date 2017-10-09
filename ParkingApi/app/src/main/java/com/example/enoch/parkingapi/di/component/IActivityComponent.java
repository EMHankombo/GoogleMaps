package com.example.enoch.parkingapi.di.component;

import com.example.enoch.parkingapi.MapsActivity;
import com.example.enoch.parkingapi.model.ActivityModule;
import com.example.enoch.parkingapi.di.scope.PerActivity;

import dagger.Component;

/**
 * Created by mainza1992 on 03/10/2017.
 */

@PerActivity

@Component(dependencies = IApplicationComponent.class, modules = ActivityModule.class)
public interface IActivityComponent {
    void inject(MapsActivity activity);
}
