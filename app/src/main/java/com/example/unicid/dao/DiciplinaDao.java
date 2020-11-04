package com.example.unicid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.unicid.model.Disciplina;
import com.example.unicid.util.Conexao;

import java.util.ArrayList;
import java.util.List;

public class DiciplinaDao {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public DiciplinaDao(Context context){
        //abrindo a conexao com db
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }
   public long insert(Disciplina disciplina){
       ContentValues values = new ContentValues();
        values.put("nome", disciplina.getNome());
       return(banco.insert("disciplina",null,values));
   }

    public long insert2(Disciplina disciplina){
        ContentValues values = new ContentValues();

        values.put("a1",disciplina.getA1());
        values.put("a2",disciplina.getA2());
        values.put("af",disciplina.getAf());
        return(banco.insert("disciplina",null,values));
    }

   /* public long insert3(Disciplina disciplina){
        ContentValues values = new ContentValues();
      //  values.put("disciplina",disciplina.getDiciplina());
        //values.put("a1",disciplina.getA1());
        //values.put("a2",disciplina.getA2());
        //values.put("af",disciplina.getAf());
        return(banco.insert("disciplina",null,values));
    }*/

    public long insert4(Disciplina disciplina){
        ContentValues values = new ContentValues();

        values.put("af",disciplina.getAf());
        return(banco.insert("disciplina",null,values));
    }

    public List<Disciplina> obterDiciplinas(){
        List<Disciplina> disciplina = new ArrayList<>();
        Cursor cursor = banco.query("disciplina", new String[]{"id","nome","a1","a2","af"},
                null,null,null,null,null);
        while (cursor.moveToNext()){
            Disciplina d = new Disciplina();
            d.setId(cursor.getInt(0));
            d.setNome(cursor.getString(1));
            d.setA1(cursor.getDouble(2));
            d.setA2(cursor.getDouble(3));
            d.setAf(cursor.getDouble(4));
            disciplina.add(d);
        }
        return disciplina;
    }

    public Disciplina read(Integer id){
        String args [] = {String.valueOf(id)};
        Disciplina d = new Disciplina();
        Cursor cursor = banco.query("disciplina", new String[]{"id","nome","a1","a2","af"},
                "id=?",args,null,null,null);
        if (cursor.moveToFirst()){
            d.setId(cursor.getInt(0));
            d.setNome(cursor.getString(1));
            d.setA1(cursor.getDouble(2));
            d.setA2(cursor.getDouble(3));
            d.setAf(cursor.getDouble(4));
        }
        return d;
    }

    public void update(Disciplina disciplina){
        ContentValues values = new ContentValues();
        values.put("a1",disciplina.getA1());
        values.put("a2",disciplina.getA2());
        //values.put("af",disciplina.getAf());
        String args[] = {String.valueOf(disciplina.getId())};
        banco.update("disciplina",values,"id=?",args);

    }

    public void delete(Disciplina disciplina){

        String args[] = {String.valueOf(disciplina.getId())};
        banco.delete("disciplina","id=?",args);

    }
}
