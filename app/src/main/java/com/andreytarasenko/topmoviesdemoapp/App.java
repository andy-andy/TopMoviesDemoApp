package com.andreytarasenko.topmoviesdemoapp;

import android.app.Application;

import com.andreytarasenko.topmoviesdemoapp.di.ApplicationComponent;
import com.andreytarasenko.topmoviesdemoapp.di.ApplicationModule;
import com.andreytarasenko.topmoviesdemoapp.di.DaggerApplicationComponent;

public class App extends Application {

    protected ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
