package com.myapplication.about_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    private TextView mInfoTextView = null;
    private ImageView mCatImageView = null;
    private String[] mCatDescriptionArray;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        mInfoTextView = rootView.findViewById(R.id.textView);
        mCatImageView = rootView.findViewById(R.id.imageView);
        mCatDescriptionArray = getResources().getStringArray(R.array.cats);

        return rootView;
    }

    public void setDescription(int buttonIndex){
        String catDescription = mCatDescriptionArray[buttonIndex];
        mInfoTextView.setText(catDescription);

        switch (buttonIndex){
            case 1:
                mCatImageView.setImageResource(R.drawable.flower);
                break;
            case 2:
                mCatImageView.setImageResource(R.drawable.ic_launcher_background);
                break;
            case 3:
                mCatImageView.setImageResource(R.drawable.ic_launcher_foreground);
                break;
            default:
                break;
        }
    }
}