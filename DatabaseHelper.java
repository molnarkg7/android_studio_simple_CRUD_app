package com.example.kolokvijum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "knjiga.db";
    private static final String TABLE_NAME = "KNJIGE";
    private static final String COL_AUTOR = "AUTOR";
    private static final String COL_NASLOV = "NASLOV";
    private static final String COL_GODINA = "GODINA";
    private static final String ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "knjige.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_AUTOR + " TEXT, "
                + COL_NASLOV + " TEXT, "
                + COL_GODINA + " INT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //dodaj knjigu

    public boolean dodajKnjigu(Knjiga knjiga){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COL_AUTOR, knjiga.getAutor());
        cv.put(COL_NASLOV, knjiga.getNaslov());
        cv.put(COL_GODINA, knjiga.getGodina());

        long insert = db.insert(TABLE_NAME, null, cv);

        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //prikazi sve knjige

    public List<Knjiga> citajKnjige() {

        List<Knjiga> knjige = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do{
                int id = cursor.getInt(0);
                String autor = cursor.getString(1);
                String naslov = cursor.getString(2);
                int godina = cursor.getInt(3);

                Knjiga knjiga = new Knjiga(id, autor, naslov, godina);
                knjige.add(knjiga);
            } while (cursor.moveToNext());

        }

        cursor.close();
        db.close();
        return knjige;
    }

    //brisanje knjige

    public Integer obrisiKnjigu(String id) {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});

    }

    //azuriranje knjige

    public void azurirajKnjigu(Knjiga knjiga) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        String autor = knjiga.getAutor();
        String naslov = knjiga.getNaslov();
        int godina = knjiga.getGodina();
        String id = String.valueOf(knjiga.getId());

        cv.put(COL_AUTOR, autor);
        cv.put(COL_NASLOV, naslov);
        cv.put(COL_GODINA, godina);

        long result = db.update(TABLE_NAME, cv, "ID=?", new String[]{id});
    }

    // citanje samo naslova

    public List<String> citajNaslove() {

        List<String> knjige = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do{
                int id = cursor.getInt(0);
                String autor = cursor.getString(1);
                String naslov = cursor.getString(2);
                int godina = cursor.getInt(3);

                Knjiga knjiga = new Knjiga(id, autor,naslov,godina);
                knjige.add(knjiga.getNaslov());
            } while (cursor.moveToNext());

        }

        cursor.close();
        db.close();
        return knjige;
    }

    //brisanje svega

    public Integer obrisiSve() {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME, null, null);

    }
}
