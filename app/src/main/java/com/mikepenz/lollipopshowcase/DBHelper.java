package com.mikepenz.lollipopshowcase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private String DB_PATH;
    private static String DB_NAME = "CardsDB";
    private SQLiteDatabase myDataBase;
    private final Context myContext;
    private static final int DATABASE_VERSION = 1;


    public DBHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     */
    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if (dbExist) {

        } else {


            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }


    private boolean checkDataBase() {

        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {


        }

        if (checkDB != null) {

            checkDB.close();

        }

        return checkDB != null ? true : false;

    }


    private void copyDataBase() throws IOException {


        InputStream myInput = myContext.getAssets().open(DB_NAME);


        String outFileName = DB_PATH + DB_NAME;


        OutputStream myOutput = new FileOutputStream(outFileName);


        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
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

        if (myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS\"Card\" (\n" +
                "\t`id`\tINTEGER primary key AUTOINCREMENT,\n" +
                "\t`cardId`\tTEXT,\n" +
                "\t`name`\tTEXT,\n" +
                "\t`cardSet`\tTEXT,\n" +
                "\t`type`\tTEXT,\n" +
                "\t`faction`\tTEXT,\n" +
                "\t`rarity`\tTEXT,\n" +
                "\t`cost`\tINTEGER,\n" +
                "\t`attack`\tINTEGER,\n" +
                "\t`health`\tINTEGER,\n" +
                "\t`text`\tTEXT,\n" +
                "\t`inPlayText`\tTEXT,\n" +
                "\t`flavor`\tTEXT,\n" +
                "\t`artist`\tTEXT,\n" +
                "\t`collectible`\tBLOB,\n" +
                "\t`elite`\tBLOB,\n" +
                "\t`img`\tTEXT,\n" +
                "\t`imgGold`\tTEXT,\n" +
                "\t`locale`\tTEXT\n" +
                ")");

        db.execSQL("CREATE TABLE IF NOT EXISTS\"Mechanic\" (\n" +
                "\t`mechanicId`\tinteger PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`name`\ttext,\n" +
                "\t`parentId`\tINTEGER,\n" +
                "\tFOREIGN KEY(`parentId`) REFERENCES Card ( Id )\n" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Card");
        db.execSQL("DROP TABLE IF EXISTS Mechanic");

        onCreate(db);

    }




    public void insertCard(String cardId, String name, String cardSet, String type, String faction, String rarity, int cost, int attack, int health, String text, String inPlayText, String flavor, String artist, Boolean collectible, Boolean elite, String img, String imgGold, String locale, ArrayList<String> mechanics) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues card = new ContentValues();

        card.put("cardId", cardId);
        card.put("name",name);
        card.put("cardSet", cardSet);
        card.put("type", type);
        card.put("faction", faction);
        card.put("rarity", rarity);
        card.put("cost", cost);
        card.put("attack",attack);
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
        db.close();


    }

    public Cursor getCardId() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id"};
        String sqlTables = "Card";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);

        c.moveToFirst();

        return c;

    }



    public void insertMechanic(SearchResponse srchrsp) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues mechanic = new ContentValues();


        for (int i=0; i<srchrsp.getMechanics().size(); i++) {
            mechanic.put("name", srchrsp.getMechanics().get(i).getName());
        }
        mechanic.put("parentId", getCardId().getColumnIndex("id"));

        db.insert("Mechanic", null, mechanic);
        db.close();

    }

    public Cursor getCard()
    {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("Select * from Card, Mechanic where Mechanic.parentId = Card.id", null);

        c.moveToFirst();

        return c;

    }


}




