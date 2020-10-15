package com.kt.std.ipartnertest.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private IdEntity idEntity;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public IdEntity getIdEntity() {
        return idEntity;
    }

    public void setIdEntity(IdEntity idEntity) {
        this.idEntity = idEntity;
    }
}