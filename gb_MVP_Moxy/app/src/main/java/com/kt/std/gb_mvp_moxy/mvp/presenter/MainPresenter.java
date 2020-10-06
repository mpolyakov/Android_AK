package com.kt.std.gb_mvp_moxy.mvp.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.kt.std.gb_mvp_moxy.mvp.model.entity.Country;
import com.kt.std.gb_mvp_moxy.mvp.model.repo.CountriesRepo;
import com.kt.std.gb_mvp_moxy.mvp.model.repo.UsersRepo;
import com.kt.std.gb_mvp_moxy.mvp.presenter.list.ICountryListPresenter;
import com.kt.std.gb_mvp_moxy.mvp.view.MainView;
import com.kt.std.gb_mvp_moxy.mvp.view.list.CountryRowView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import timber.log.Timber;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    class CountriesListPresenter implements ICountryListPresenter {
        PublishSubject<CountryRowView> clickSubject = PublishSubject.create();
        List<Country> countries = new ArrayList<>();

        @Override
        public void bind(CountryRowView view) {
            Country country = countries.get(view.getPos());
            view.setTitle(country.getName());
            view.setCode(country.getCode());
        }

        @Override
        public int getCount() {
            return countries.size();
        }

        @Override
        public PublishSubject<CountryRowView> getClickSubject() {
            return clickSubject;
        }
    }

    private Scheduler mainThreadScheduler;
    private CountriesRepo countriesRepo;
    private UsersRepo usersRepo;
    private CountriesListPresenter countriesListPresenter;

    public MainPresenter(Scheduler scheduler) {
        this.mainThreadScheduler = scheduler;
        this.countriesRepo = new CountriesRepo();
        this.usersRepo = new UsersRepo();
        this.countriesListPresenter = new CountriesListPresenter();
    }

    @SuppressLint("CheckResult")
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().init();
        loadCountries();
        loadUser();

        //loadDataWithOkHttp();

        countriesListPresenter.getClickSubject().subscribe(countryRowView -> {
            Country country = countriesListPresenter.countries.get(countryRowView.getPos());
            getViewState().showMessage(country.getName() + " " + country.getCode());
        });
    }

    public ICountryListPresenter getCountriesListPresenter() {
        return countriesListPresenter;
    }

    @SuppressLint("CheckResult")
    private void loadCountries() {
        getViewState().showLoading();
        countriesRepo.getCountries()
                .observeOn(mainThreadScheduler)
                .subscribe(countries -> {
                    countriesListPresenter.countries.clear();
                    countriesListPresenter.countries.addAll(countries);
                    getViewState().updateList();
                    getViewState().hideLoading();

                }, t -> Timber.e(t));
    }

    @SuppressLint("CheckResult")
    private void loadUser() {
        getViewState().showLoading();
        usersRepo.getUser("googlesamples")
                .observeOn(mainThreadScheduler)
                .subscribe(user -> {
                    getViewState().hideLoading();
                    getViewState().setUsername(user.getLogin());
                    getViewState().loadImage(user.getAvatarUrl());
                }, t -> {
                    getViewState().hideLoading();
                    getViewState().showMessage(t.getMessage());
                    Timber.e(t);
                });
    }

    @SuppressLint("CheckResult")
    private void loadDataWithOkHttp(){
        Single<String> single = Single.fromCallable(() -> {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/users/googlesamples")
                    .build();
            return client.newCall(request).execute().body().string();
        });

        single.subscribeOn(Schedulers.io()).subscribe(s -> {
            Timber.d(s);
        });
    }

}

