package com.kt.std.gb_mvp_moxy.mvp.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.kt.std.gb_mvp_moxy.mvp.model.entity.Country;
import com.kt.std.gb_mvp_moxy.mvp.model.repo.CountriesRepo;
import com.kt.std.gb_mvp_moxy.mvp.presenter.list.ICountryListPresenter;
import com.kt.std.gb_mvp_moxy.mvp.view.MainView;
import com.kt.std.gb_mvp_moxy.mvp.model.Model;
import com.kt.std.gb_mvp_moxy.mvp.view.list.CountryRowView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
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
    private CountriesRepo repo;
    private CountriesListPresenter countriesListPresenter;

    public MainPresenter(Scheduler scheduler){
        this.mainThreadScheduler = scheduler;
        this.repo = new CountriesRepo();
        this.countriesListPresenter = new CountriesListPresenter();
    }


    @SuppressLint("CheckResult")
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().init();
        getViewState().showLoading();

//        mainThreadScheduler.scheduleDirect(() -> {
//
//        });

        repo.getCountries()
                .observeOn(mainThreadScheduler)
                .subscribe(new Consumer<List<Country>>() {
                    @Override
                    public void accept(List<Country> countries) throws Exception {
                        countriesListPresenter.countries.clear();
                        countriesListPresenter.countries.addAll(countries);
                        MainPresenter.this.getViewState().updateList();
                        MainPresenter.this.getViewState().hideLoading();
                    }
                }, t -> Timber.e(t));

        countriesListPresenter.getClickSubject().subscribe(new Consumer<CountryRowView>() {
            @Override
            public void accept(CountryRowView countryRowView) throws Exception {
                Country country = countriesListPresenter.countries.get(countryRowView.getPos());
                getViewState().showMessage(country.getName() + " " + country.getCode());
            }
        });
    }


    public ICountryListPresenter getCountriesListPresenter(){
        return countriesListPresenter;
    }
}
