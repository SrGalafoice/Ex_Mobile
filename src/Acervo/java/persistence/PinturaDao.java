package br.edu.fateczl.acervo.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.acervo.model.Pintura;

public class PinturaDao implements IPinturaDao, ICRUDDao<Pintura>{
    private final Context context;
    private GenericDao gD;
    private SQLiteDatabase db;


    public PinturaDao(Context context) {
            this.context = context;
        }

        @Override
        public PinturaDao open() throws SQLException {
            gD = new GenericDao(context);
            db = gD.getWritableDatabase();
            return this;
        }
        @Override
        public void close() {
            gD.close();
        }

        @Override
        public void insert(Pintura pintura) throws SQLException {
            ContentValues cv = getContentValues(pintura);
            db.insert("pintura", null, cv);
        }

        @Override
        public void delete(Pintura pintura) throws SQLException {
            db.delete("pintura", "codigo = " + pintura.getCodigo(), null);
        }

        @Override
        public int update(Pintura pintura) throws SQLException {
            ContentValues cv = getContentValues(pintura);
            int ret = db.update("pintura", cv, "codigo = " + pintura.getCodigo(), null);
            return ret;
        }

        @SuppressLint("Range")
        @Override
        public Pintura findOne(Pintura pintura) throws SQLException {
            String sql = "SELECT codigo, titulo, ano, prat, artista FROM pintura WHERE codigo = "+ pintura.getCodigo();
            Cursor cursor = db.rawQuery(sql, null);
            if (cursor != null){
                cursor.moveToFirst();
            }
            if (!cursor.isAfterLast()){
                pintura.setCodigo(cursor.getString(cursor.getColumnIndex("codigo")));
                pintura.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
                pintura.setArtista(cursor.getString(cursor.getColumnIndex("artista")));
                pintura.setAno(cursor.getInt(cursor.getColumnIndex("ano")));
                pintura.setNumPrateleira(cursor.getInt(cursor.getColumnIndex("prat")));
            }
            cursor.close();
            return pintura;
        }

        @SuppressLint("Range")
        @Override
        public List<Pintura> findAll() throws SQLException {
            List<Pintura> pinturas = new ArrayList<>();
            String sql = "SELECT codigo, titulo, ano, prat, artista FROM pintura";
            Cursor cursor = db.rawQuery(sql, null);
            if (cursor != null){
                cursor.moveToFirst();
            }
            while (!cursor.isAfterLast()){
                Pintura pintura = new Pintura();
                pintura.setCodigo(cursor.getString(cursor.getColumnIndex("codigo")));
                pintura.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
                pintura.setArtista(cursor.getString(cursor.getColumnIndex("artista")));
                pintura.setAno(cursor.getInt(cursor.getColumnIndex("ano")));
                pintura.setNumPrateleira(cursor.getInt(cursor.getColumnIndex("prat")));
                pinturas.add(pintura);
                cursor.moveToNext();
            }
           cursor.close();
            return pinturas;
        }

        private static ContentValues getContentValues(Pintura pintura) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("codigo", pintura.getCodigo());
            contentValues.put("titulo", pintura.getTitulo());
            contentValues.put("ano", pintura.getAno());
            contentValues.put("prat", pintura.getNumPrateleira());
            contentValues.put("artista", pintura.getArtista());

            return contentValues;
        }
    }


