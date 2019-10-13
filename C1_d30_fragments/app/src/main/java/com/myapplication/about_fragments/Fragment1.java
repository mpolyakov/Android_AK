package com.myapplication.about_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment1, container, false);


        Button button1 = rootView.findViewById(R.id.button1);
        Button button2 = rootView.findViewById(R.id.button2);
        Button button3 = rootView.findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


        return rootView;

    }

    public void onClick(View view) {
//        int buttonIndex = -1;
//        if (view.getId() == R.id.button1) buttonIndex = 1;
//        if (view.getId() == R.id.button2) buttonIndex = 2;
//        if (view.getId() == R.id.button3) buttonIndex = 3;
        int buttonIndex = translateIdToIndex(view.getId());
        OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
        listener.onButtonSelected(buttonIndex);
//        Toast.makeText(getActivity(), "Вы нажали на кнопку", Toast.LENGTH_SHORT).show();

    }

    int translateIdToIndex(int id){
        int index = -1;
        switch (id){
            case R.id.button1:
                index = 1;
                break;
            case R.id.button2:
                index = 2;
                break;
            case R.id.button3:
                index = 3;
                break;
        } return index;
    }

    public interface OnSelectedButtonListener {
        void onButtonSelected(int buttonIndex);
    }

}
