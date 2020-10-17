package com.kt.std.ipartnertest.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.rxbinding2.view.RxView;
import com.kt.std.ipartnertest.R;
import com.kt.std.ipartnertest.model.DateFormatter;
import com.kt.std.ipartnertest.presenter.INoteListPresenter;
import com.kt.std.ipartnertest.ui.format.DateFormatterImpl;
import com.kt.std.ipartnertest.view.NoteRowView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesRVAdapter extends RecyclerView.Adapter<NotesRVAdapter.ViewHolder> {
    private INoteListPresenter presenter;

    public NotesRVAdapter(INoteListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.pos = position;
        presenter.bind(holder);
        RxView.clicks(holder.itemView).map(o -> {
            return holder;
        }).subscribe(presenter.getClickSubject());
    }

    @Override
    public int getItemCount() {
        return presenter.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements NoteRowView {
        int pos = 0;
        private DateFormatter dateFormatter;

        @BindView(R.id.tv_body)
        TextView bodyTextView;
        @BindView(R.id.tv_da)
        TextView daTextView;
        @BindView(R.id.tv_dm)
        TextView dmTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            this.dateFormatter = new DateFormatterImpl();
            ButterKnife.bind(this, itemView);
        }

        @Override
        public int getPos() {
            return pos;
        }

        @Override
        public void setBody(String body) {
            body = body.substring(0, Math.min(body.length(), 200));
            bodyTextView.setText(body);
        }

        @Override
        public void setDa(String da) {
            daTextView.setText("Created on: " + dateFormatter.fullDate(da));
        }

        @Override
        public void setDm(String dm) {
            dmTextView.setText("Modified on: " + dateFormatter.fullDate(dm));
        }
    }
}