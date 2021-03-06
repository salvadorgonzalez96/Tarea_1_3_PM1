package com.example.Tarea_1_3_SQLite.configuracion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteConexion extends SQLiteOpenHelper
{
    // Constructor de la clase creacion de la base de datos en sqlite
    public SQLiteConexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, dbname, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creacion de la primera tabla de la base de datos
        db.execSQL(Transacciones.CreateTablePersonas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(Transacciones.DROPTablePersonas);
        onCreate(db);
    }
}
