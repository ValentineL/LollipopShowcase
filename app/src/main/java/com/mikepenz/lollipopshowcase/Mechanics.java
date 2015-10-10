package com.mikepenz.lollipopshowcase;

import com.google.gson.annotations.SerializedName;

public class Mechanics {
    @SerializedName("name")
    public String name;

    public Mechanics(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
