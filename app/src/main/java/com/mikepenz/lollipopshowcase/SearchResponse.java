package com.mikepenz.lollipopshowcase;

import android.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class SearchResponse {
    public long id;

    @SerializedName("cardId")
    private String cardId;
    @SerializedName("name")
    private String name;
    @SerializedName("cardSet")
    private String cardSet;
    @SerializedName("type")
    private String type;
    @SerializedName("faction")
    private String faction;
    @SerializedName("rarity")
    private String rarity;
    @SerializedName("cost")
    private int cost;
    @SerializedName("attack")
    private int attack;
    @SerializedName("health")
    private int health;
    @SerializedName("text")
    private String text;
    @SerializedName("inPlayText")
    private String inPlayText;
    @SerializedName("flavor")
    private String flavor;
    @SerializedName("artist")
    private String artist;
    @SerializedName("collectible")
    private Boolean collectible;
    @SerializedName("elite")
    private Boolean elite;
    @SerializedName("img")
    private String img;
    @SerializedName("imgGold")
    private String imgGold;
    @SerializedName("locale")
    private String locale;
    @SerializedName("mechanics")
    private ArrayList<Mechanic> mechanics = new ArrayList<>();

    /*public SearchResponse(long id, String cardId, String name, String cardSet, String type, String faction, String rarity, int cost, int attack, int health, String text, String inPlayText, String flavor, String artist, Boolean collectible, Boolean elite, String img, String imgGold, String locale, ArrayList<Mechanic> mechanics) {
        this.id = id;
        this.cardId = cardId;
        this.name = name;
        this.cardSet = cardSet;
        this.type = type;
        this.faction = faction;
        this.rarity = rarity;
        this.cost = cost;
        this.attack = attack;
        this.health = health;
        this.text = text;
        this.inPlayText = inPlayText;
        this.flavor = flavor;
        this.artist = artist;
        this.collectible = collectible;
        this.elite = elite;
        this.img = img;
        this.imgGold = imgGold;
        this.locale = locale;
        this.mechanics = mechanics;
    }*/

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardSet() {
        return cardSet;
    }

    public void setCardSet(String cardSet) {
        this.cardSet = cardSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInPlayText() {
        return inPlayText;
    }

    public void setInPlayText(String inPlayText) {
        this.inPlayText = inPlayText;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Boolean getCollectible() {
        return collectible;
    }

    public void setCollectible(Boolean collectible) {
        this.collectible = collectible;
    }

    public Boolean getElite() {
        return elite;
    }

    public void setElite(Boolean elite) {
        this.elite = elite;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgGold() {
        return imgGold;
    }

    public void setImgGold(String imgGold) {
        this.imgGold = imgGold;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(ArrayList<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }
}
