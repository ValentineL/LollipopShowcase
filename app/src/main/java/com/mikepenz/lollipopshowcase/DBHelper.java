package com.mikepenz.lollipopshowcase;


import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private String DB_PATH ;
    private static String DB_NAME = "CardsDB";
    private SQLiteDatabase myDataBase;
    private final Context myContext;
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
        DB_PATH=context.getApplicationInfo().dataDir + "/databases/";
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if(dbExist){

        }else{



            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }


    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){



        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;

    }


    private void copyDataBase() throws IOException{


        InputStream myInput = myContext.getAssets().open(DB_NAME);


        String outFileName = DB_PATH + DB_NAME;


        OutputStream myOutput = new FileOutputStream(outFileName);


        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }


        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertCard(String cardId, String name, String cardSet, String type, String faction, String rarity, int cost, int attack, int health, String text, String inPlayText, String flavor, String artist, Boolean collectible, Boolean elite, String img, String imgGold, String locale){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues card = new ContentValues();

        card.put("cardId", cardId);
        card.put("name", name);
        card.put("cardSet", cardSet);
        card.put("type", type);
        card.put("faction", faction);
        card.put("rarity", rarity);
        card.put("cost", cost);
        card.put("attack", attack);
        card.put("health", health);
        card.put("text", text);
        card.put("inPlayText", inPlayText);
        card.put("flavor", flavor);
        card.put("artist", artist);
        card.put("collectible", collectible);
        card.put("elite", elite);
        card.put("img", img);
        card.put("imgGold", imgGold);
        card.put("locale", locale);

        db.insert("Card", null, card);

    }

}
