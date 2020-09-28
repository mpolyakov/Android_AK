package com.kt.std.gb_mvp_moxy;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Integer> list;

    public Model() {
        list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
    }

    int getElementValueAtIndex(int index){
        return list.get(index);
    }

    void setElementValueAtIndex(int index, int value){
        list.set(index, value);
    }

}
