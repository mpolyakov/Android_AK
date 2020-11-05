package com.kt.std.zaycevtest2;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] price = {5, 100, 20, 66, 16};
        int discount = 50;
        int offset = 2;
        int readLength = 3;

        Log.d("resZay", Arrays.toString(decryptData(price, discount, offset, readLength)));
        Toast.makeText(this, Arrays.toString(decryptData(price, discount, offset, readLength)), Toast.LENGTH_SHORT).show();

    }

    public @Nullable
    int[] decryptData(@NonNull int[] price,
                      @IntRange(from = 1) int discount,
                      @IntRange(from = 0) int offset,
                      @IntRange(from = 1) int readLength) {
        List<Integer> resultList = new ArrayList<>();
        if ((offset >= price.length) || ((offset + readLength) > price.length)){
            Log.d("resZay", "Выберите меньшие значения offset и readLength");
            Toast.makeText(this, "Выберите меньшие значения offset и readLength", Toast.LENGTH_SHORT).show();
            return null;
        }
        for (int i = offset; i < (offset + readLength); i++) {
            resultList.add((int) (price[i] * (1 - (double) discount / 100)));
        }

        return resultList.stream().mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer i) {
                return i;
            }
        }).toArray();
    }
}