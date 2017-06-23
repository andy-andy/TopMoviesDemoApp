package com.andreytarasenko.topmoviesdemoapp;


import com.andreytarasenko.topmoviesdemoapp.api.model.Result;

import rx.Observable;

public class TopMoviesModel implements TopMoviesActivityMVP.Model {

    private Repository repository;

    public TopMoviesModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Result> result() {
        return repository.getResultData();
    }

}
