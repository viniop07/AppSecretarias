package com.example.appsecretarias;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static int version=1;
    private static String name="Login_Registro_BaseDados.db";


    public DBHelper(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String str= "CREATE TABLE Utilizador(email TEXT PRIMARY KEY, senha TEXT)";
        db.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Ultilizador;");
        onCreate(db);
    }

    public long CriarUltilizador(String email, String senha){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("email",email);
        cv.put("senha",senha);
        long result = db.insert("Utilizador", null,cv);
        return result;
    }
    public String ValidarLogin(String email, String senha) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT*FROM Utilizador WHERE email=? AND senha=?", new String[]{email, senha});
        if (c.getCount() > 0){
            return "OK";
    }
    return "ERRO";
    }
}
