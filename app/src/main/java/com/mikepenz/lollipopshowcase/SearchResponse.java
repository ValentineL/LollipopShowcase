package com.mikepenz.lollipopshowcase;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class SearchResponse {

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
    private ArrayList<Mechanics> mechanics = new ArrayList<>();

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

    public List<Mechanics> getMechanics() {
        return mechanics;
    }

    public void setMechanics(ArrayList<Mechanics> mechanics) {
        this.mechanics = mechanics;
    }
}
