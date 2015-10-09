package com.mikepenz.lollipopshowcase;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Result {

    @SerializedName("cardId")
    public String cardId;
    @SerializedName("name")
    public String name;
    @SerializedName("cardSet")
    public String cardSet;
    @SerializedName("type")
    public String type;
    @SerializedName("faction")
    public String faction;
    @SerializedName("rarity")
    public String rarity;
    @SerializedName("cost")
    public int cost;
    @SerializedName("attack")
    public int attack;
    @SerializedName("health")
    public int health;
    @SerializedName("text")
    public String text;
    @SerializedName("inPlayText")
    public String inPlayText;
    @SerializedName("flavor")
    public String flavor;
    @SerializedName("artist")
    public String artist;
    @SerializedName("collectible")
    public Boolean collectible;
    @SerializedName("elite")
    public Boolean elite;
    @SerializedName("img")
    public String img;
    @SerializedName("imgGold")
    public String imgGold;
    @SerializedName("locale")
    public String locale;
    @SerializedName("mechanics")
    private List<Mechanics> mechanics = new ArrayList<Mechanics>();

}
