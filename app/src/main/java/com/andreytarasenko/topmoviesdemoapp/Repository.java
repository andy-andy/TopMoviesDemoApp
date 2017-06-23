package com.andreytarasenko.topmoviesdemoapp;

import com.andreytarasenko.topmoviesdemoapp.api.model.Result;

import rx.Observable;

public interface Repository {

    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    Observable<Result> getResultData();

}
