package com.kt.std.gb_mvp_moxy.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.rxbinding2.view.RxView;
import com.kt.std.gb_mvp_moxy.R;
import com.kt.std.gb_mvp_moxy.mvp.presenter.list.ICountryListPresenter;
import com.kt.std.gb_mvp_moxy.mvp.view.list.CountryRowView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountriesRvAdapter extends RecyclerView.Adapter<CountriesRvAdapter.ViewHolder> {
    private ICountryListPresenter presenter;

    public CountriesRvAdapter(ICountryListPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.pos = position;
        presenter.bind(holder);
        RxView.clicks(holder.itemView).map(o -> holder).subscribe(presenter.getClickSubject());
    }

    @Override
    public int getItemCount() {
        return presenter.getCount();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements CountryRowView {
        int pos = 0;

        @BindView(R.id.tv_title)
        TextView titleTextView;
        @BindView(R.id.tv_code)
        TextView codeTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public int getPos() {
            return pos;
        }

        @Override
        public void setTitle(String title) {
            titleTextView.setText(title);
        }

        @Override
        public void setCode(String code) {
            codeTextView.setText(code);
        }
    }
}
