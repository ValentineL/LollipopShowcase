package com.mikepenz.lollipopshowcase;

import com.google.gson.annotations.SerializedName;



public class Mechanic {
    @SerializedName("name")
    private String name;

    private long mechanicId;

    private long parentId;

    public Mechanic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(long mechanicId) {
        this.mechanicId = mechanicId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
