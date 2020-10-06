package com.kt.std.gb_mvp_moxy.ui.image;

import android.widget.ImageView;

import com.kt.std.gb_mvp_moxy.mvp.model.image.IImageLoader;
import com.squareup.picasso.Picasso;

public class PicassoImageLoader implements IImageLoader<ImageView> {

    @Override
    public void loadInto(String url, ImageView container) {
        Picasso.get().load(url).into(container);
    }
}
