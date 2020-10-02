package com.kt.std.gb_mvp_moxy.mvp.model.repo;

import com.kt.std.gb_mvp_moxy.mvp.model.api.DataSource;
import com.kt.std.gb_mvp_moxy.mvp.model.entity.Country;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class CountriesRepo {
    private DataSource dataSource;

    public CountriesRepo() {
        this.dataSource = new DataSource();
    }

    public Single<List<Country>> getCountries(){
        return Single.fromCallable(new Callable<List<Country>>() {
            @Override
            public List<Country> call() throws Exception {
                return dataSource.loadCountries();
            }
        }).subscribeOn(Schedulers.io());
    }
}
