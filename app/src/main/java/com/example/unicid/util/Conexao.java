package com.example.unicid.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Conexao extends SQLiteOpenHelper {
    private static final String NAME = "banco.db";
    private static final int VERSION = 1;

    public Conexao(Context context){
        super(context,NAME,null,VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE disciplina(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nome VARCHAR(30), a1 FLOAT(4) ,a2 FLOAT(4) ,af FLOAT(4) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS disciplina";
        db.execSQL(sql);
        onCreate(db);
    }
}
