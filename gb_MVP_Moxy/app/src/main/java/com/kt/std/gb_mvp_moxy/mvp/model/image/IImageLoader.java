package com.kt.std.gb_mvp_moxy.mvp.model.image;

public interface IImageLoader<T> {
    void loadInto(String url, T container);
}
