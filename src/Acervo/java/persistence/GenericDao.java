package br.edu.fateczl.acervo.persistence;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GenericDao extends SQLiteOpenHelper{
    private static final String DATABASE = "Acervo.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_LIV = "CREATE TABLE livro ( " +
            "codigo VARCHAR(100) NOT NULL PRIMARY KEY,"+
            "titulo VARCHAR(100) NOT NULL, " +
            "ano INT NOT NULL, "+
            "prat INT NOT NULL, "+
            "edicao VARCHAR(100) NOT NULL);";
    private static final String CREATE_TABLE_DIS = "CREATE TABLE Disco ( " +
            "codigo VARCHAR(100) NOT NULL PRIMARY KEY,"+
            "titulo VARCHAR(100) NOT NULL, " +
            "ano INT NOT NULL, "+
            "prat INT NOT NULL, "+
            "duracao VARCHAR(100) NOT NULL);";
    private static final String CREATE_TABLE_PIN = "CREATE TABLE Pintura ( " +
            "codigo VARCHAR(100) NOT NULL PRIMARY KEY,"+
            "titulo VARCHAR(100) NOT NULL, " +
            "ano INT NOT NULL, "+
            "prat INT NOT NULL, "+
            "artista VARCHAR(100) NOT NULL);";

    public GenericDao(Context context){
        super(context, DATABASE, null, DATABASE_VERSION);
    }

    public GenericDao(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LIV);
        db.execSQL(CREATE_TABLE_DIS);
        db.execSQL(CREATE_TABLE_PIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion){
            db.execSQL("DROP TABLE IF EXISTS livro");
            db.execSQL("DROP TABLE IF EXISTS disco");
            db.execSQL("DROP TABLE IF EXISTS pintura");
            onCreate(db);
        }
    }
}
