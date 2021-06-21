package com.example.reclocality;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class LocalDAO {

    private Helper helper;
    private SQLiteDatabase banco;

    public LocalDAO (Context context){
        helper = new Helper(context);
        banco = helper.getWritableDatabase();
    }

    public void inserir(Local local){
        ContentValues valor = new ContentValues();
        valor.put("latitude", local.getLatitude());
        valor.put("longitude", local.getLongitude());
        banco.insert("locais", null, valor);
    }

    public List<Local> retornarLista(){
        List<Local> lista = new ArrayList<>();
        Cursor cursor = banco.query("locais", new String[]{"id","latitude","longitude"},
                null, null, null,null, null);

        while(cursor.moveToNext()){
            Local local = new Local();
            local.setId(cursor.getInt(0));
            local.setLatitude(cursor.getString(1));
            local.setLongitude(cursor.getString(2));

            lista.add(local);
        }

        return lista;
    }

    public void excluir(Local local){
        banco.delete("locais", "id = ?", new String[]{local.getId()});
    }
}
