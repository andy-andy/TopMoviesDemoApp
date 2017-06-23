package com.andreytarasenko.topmoviesdemoapp;


import com.andreytarasenko.topmoviesdemoapp.api.model.Result;

import rx.Observable;

public interface MovieDetailsActivityMVP {

    interface View {

        void updateData(Result result);

        void showSnackbar(String s);

    }

    interface Presenter {

        void loadData();

        void rxUnsubscribe();

        void setView(TopMoviesActivityMVP.View view);

    }

    interface Model {

        Observable<Result> result();

    }

}
