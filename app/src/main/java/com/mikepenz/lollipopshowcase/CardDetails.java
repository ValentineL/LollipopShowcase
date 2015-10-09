package com.mikepenz.lollipopshowcase;

import java.util.ArrayList;

public class CardDetails {
    private String cardId;
    private String name;
    private String cardSet;
    private String type;
    private String faction;
    private String rarity;
    private int cost;
    private int attack;
    private int health;
    private String text;
    private String inPlayText;
    private String flavor;
    private String artist;
    private Boolean collectible;
    private Boolean elite;
    private String img;
    private String imgGold;
    private String locale;
    private ArrayList<String> mechanics;

    public CardDetails(String cardId, String name, String cardSet, String type, String faction, String rarity, int cost, int attack, int health, String text, String inPlayText, String flavor, String artist, Boolean collectible, Boolean elite, String img, String imgGold, String locale, ArrayList<String> mechanics) {
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
    }
}
