package com.andreytarasenko.topmoviesdemoapp.di;

import com.andreytarasenko.topmoviesdemoapp.TopMoviesActivity;
import com.andreytarasenko.topmoviesdemoapp.TopMoviesModule;
import com.andreytarasenko.topmoviesdemoapp.api.ApiModuleForName;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModuleForName.class, TopMoviesModule.class})
public interface ApplicationComponent {

    void inject (TopMoviesActivity target);

}
