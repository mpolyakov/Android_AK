package com.kt.std.gb_mvp_moxy.mvp.presenter.list;

import com.kt.std.gb_mvp_moxy.mvp.view.list.CountryRowView;

import io.reactivex.subjects.PublishSubject;

public interface ICountryListPresenter {
    void bind(CountryRowView view);
    int getCount();
    PublishSubject<CountryRowView> getClickSubject();


}
