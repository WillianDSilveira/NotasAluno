package com.example.notaaluno;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListagemActivity extends AppCompatActivity {

    ArrayList<Aluno> listaAlunos = new ArrayList<>(DadosCompartilhados.listaNotas);
    ArrayAdapter<String> adapter;
    RepositorioAluno repositorioAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listagem);
        setTitle("Listagem Alunos");

        listaAlunos = (ArrayList<Aluno>) getIntent()
                .getSerializableExtra("lista_aluno");
        Log.i("aluno", "Carregado Listagem aluno com Sucesso");

        repositorioAluno = new RepositorioAluno(this);

        ListView listView = findViewById(R.id.listAlunos);

        // pegando a lista do banco
        List<Aluno> listaDB = repositorioAluno.listarAluno();
        String[] dados = new  String[listaDB.size()];

        for(int i=0; i < listaDB.size(); i++){
            Aluno aluno = listaDB.get(i);
            dados[i] = aluno.nome + " - " + aluno.nota;
            // dados[i] = DadosCompartilhados.lista.get(i).nome;
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        dados);

        listView.setAdapter(adapter);


       /* *//*ListView listView = findViewById(R.id.listAlunos);
        String [] dados = new String[DadosCompartilhados.listaNotas.size()];*//*

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dados);

        *//*for (int i=0; i < DadosCompartilhados.listaNotas.size(); i++){
            dados[i] = DadosCompartilhados.listaNotas.get(i).nome + "" +
                    DadosCompartilhados.listaNotas.get(i).nota;

            Log.d("Nota", dados[i].toString());
        }*/

    }

    public void pesquisar(View view) {

        EditText editTextNota1 = findViewById(R.id.editTextNota1);
        String nota1 = editTextNota1.getText().toString();
        EditText editTextNota2 = findViewById(R.id.editTextNota2);
        String nota2 = editTextNota2.getText().toString();

        // ***** estudar metodo EQUALS
        try {

            // validacao das notas se e de 0-10

            List<Aluno> listaAluno = repositorioAluno.buscarNota(nota1,nota2);

            String[] dados = new String[listaAluno.size()];
            // passando da lista para o vetor.
            for(int i=0; i < listaAluno.size();i++){
                Aluno aluno = listaAluno.get(i);
                dados[i] = aluno.nome + "\n" + aluno.nota ;
            }
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<>(this,
                            android.R.layout.simple_list_item_1,
                            dados);
            ListView listView = findViewById(R.id.listAlunos);
            listView.setAdapter(adapter);

        }catch (Exception e){
            Toast.makeText(this, "Digite somente numeros", Toast.LENGTH_SHORT).show();
        }

    }




//    @Override
//    protected void onResume() {
//        super.onResume();
//        listaAlunos.addAll(DadosCompartilhados.listaNotas);
//    }
}