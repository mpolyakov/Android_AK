package com.kt.std.ipartnertest.model.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListNotes {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<List<Note>> data = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<List<Note>> getData() {
        return data;
    }

    public void setData(List<List<Note>> data) {
        this.data = data;
    }

}

//{
//        "status": 1,
//        "Data":[
//        [
//        {"id": "4klJeiCKTs", "body": "Вторая запись", "da": "1442236233", "dm": "1442236233"},
//        {"id": "2rRwFT9HOk", "body": "Первая запись", "da": "1442236206", "dm": "1442236206"}
//        ]
//        ]
//        }
