package br.edu.fateczl.acervo.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.acervo.model.Disco;
import br.edu.fateczl.acervo.model.Livro;

public class DiscoDao implements ICRUDDao<Disco>, IDiscoDao{
    private final Context context;
    private GenericDao gD;
    private SQLiteDatabase db;

    public DiscoDao(Context context) {
        this.context = context;
    }

    @Override
    public DiscoDao open() throws SQLException {
        gD = new GenericDao(context);
        db = gD.getWritableDatabase();
        return this;
    }

    @Override
    public void close() {
        gD.close();
    }

    @Override
    public void insert(Disco disco) throws SQLException {
        ContentValues cv = getContentValues(disco);
        db.insert("disco", null, cv);
    }

    @Override
    public void delete(Disco disco) throws SQLException {
        db.delete("disco", "codigo = " + disco.getCodigo(), null);
    }

    @Override
    public int update(Disco disco) throws SQLException {
        ContentValues cv = getContentValues(disco);
        int ret = db.update("disco", cv, "codigo = " + disco.getCodigo(), null);
        return ret;
    }

    @SuppressLint("Range")
    @Override
    public Disco findOne(Disco disco) throws SQLException {
        String sql = "SELECT codigo, titulo, ano, prat, duracao FROM disco WHERE codigo = "+ disco.getCodigo();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null){
            cursor.moveToFirst();
        } if (!cursor.isAfterLast()){
            disco.setCodigo(cursor.getString(cursor.getColumnIndex("codigo")));
            disco.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            disco.setDuracao(cursor.getString(cursor.getColumnIndex("duracao")));
            disco.setAno(cursor.getInt(cursor.getColumnIndex("ano")));
            disco.setNumPrateleira(cursor.getInt(cursor.getColumnIndex("prat")));
        }
        cursor.close();
        return disco;
    }

    @SuppressLint("Range")
    @Override
    public List<Disco> findAll() throws SQLException {
        List<Disco> discos = new ArrayList<>();
        String sql = "SELECT codigo, titulo, ano, prat, duracao FROM disco";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null){
            cursor.moveToFirst();
        } while (!cursor.isAfterLast()){
            Disco disco = new Disco();
            disco.setCodigo(cursor.getString(cursor.getColumnIndex("codigo")));
            disco.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            disco.setDuracao(cursor.getString(cursor.getColumnIndex("duracao")));
            disco.setAno(cursor.getInt(cursor.getColumnIndex("ano")));
            disco.setNumPrateleira(cursor.getInt(cursor.getColumnIndex("prat")));
            discos.add(disco);
            cursor.moveToNext();
        }
        cursor.close();
        return discos;
    }

    private static ContentValues getContentValues(Disco disco) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo", disco.getCodigo());
        contentValues.put("titulo", disco.getTitulo());
        contentValues.put("ano", disco.getAno());
        contentValues.put("prat", disco.getNumPrateleira());
        contentValues.put("duracao", disco.getDuracao());

        return contentValues;
    }
}
