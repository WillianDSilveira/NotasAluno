package com.example.notaaluno;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAluno extends SQLiteOpenHelper {


    public RepositorioAluno(@Nullable Context context) {
        super(context, "log", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE ALUNO(id INTEGER NOT NULL PRIMARY KEY, nome TEXT, nota TEXT)";
        sqLiteDatabase.execSQL(sql);
        Log.i("LOG", "Criado com sucesso a tabela LOG");

    }

    public void adicionarAluno(Aluno aluno){
        String sql = "INSERT INTO ALUNO VALUES(null,'" + aluno.nome + "','" + aluno.nota + "')";
        Log.i("log", "SQL insert log: "+ sql);
        super.getWritableDatabase().execSQL(sql);
        Log.i("LOG", "SALVO COM SUCESSO");
    }

    public List<Aluno> listarAluno(){
        ArrayList<Aluno> lista = new ArrayList<>();
        String sql = "select * from ALUNO";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Aluno aluno = new Aluno();
            aluno.id = cursor.getInt(0); // coluna 0
            aluno.nome = cursor.getString(1); // coluna 1
            aluno.nota = cursor.getString(2); // coluna 2
            lista.add(aluno);
            cursor.moveToNext();
        }
        cursor.close();
        return lista;
    }

    public List<Aluno> buscarNota(String nota1, String nota2){
        List<Aluno> listaAluno = new ArrayList<>();
        String sql = "SELECT * FROM ALUNO WHERE nota >= " + nota1 + " AND nota <= " + nota2 ;
        Log.i("LOG", "sql buscarNota "+ sql);

        Cursor cursor = getReadableDatabase()
                .rawQuery(sql,null);
        cursor.moveToFirst();

        for(int i=0; i < cursor.getCount(); i++){
            Aluno aluno = new Aluno();
            aluno.id = cursor.getInt(0); // coluna 0
            aluno.nome = cursor.getString(1); // coluna 1
            aluno.nota = cursor.getString(2);// coluna 2
            cursor.moveToNext();
            listaAluno.add(aluno);
        }
        cursor.close();
        Log.i("LOG", "buscarNota com sucesso "+ sql);
        return listaAluno;
    }





    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
