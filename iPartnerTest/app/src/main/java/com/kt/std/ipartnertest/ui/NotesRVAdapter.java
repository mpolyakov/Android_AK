package com.kt.std.ipartnertest.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.rxbinding2.view.RxView;
import com.kt.std.ipartnertest.R;
import com.kt.std.ipartnertest.presenter.INoteListPresenter;
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

        @BindView(R.id.tv_body)
        TextView bodyTextView;
        @BindView(R.id.tv_da)
        TextView daTextView;
        @BindView(R.id.tv_dm)
        TextView dmTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public int getPos() {
            return pos;
        }

        @Override
        public void setBody(String body) {
            bodyTextView.setText(body);
        }

        @Override
        public void setDa(String da) {
            daTextView.setText("Created on: " + da);
        }

        @Override
        public void setDm(String dm) {
            dmTextView.setText("Modified on: " + dm);
        }
    }
}