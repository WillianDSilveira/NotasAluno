package com.example.notaaluno;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CadastroActivity extends AppCompatActivity {
    ArrayList<Aluno> listaNotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        setTitle("Cadastro Alunos");

    }

    public void salvar(View view) {
        EditText conteudoNome = findViewById(R.id.editTextNome);
        EditText conteudoNota = findViewById(R.id.editTextNota);

        String nome = conteudoNome.getText().toString();
        String nota = conteudoNota.getText().toString();

        if(nome.isEmpty() || nota.isEmpty()){
            Toast.makeText(this, "Preencha os Campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Aluno aluno = new Aluno();
        aluno.nome = nome;
        aluno.nota = nota;
        aluno.id = DadosCompartilhados.getProximoId();

        DadosCompartilhados.listaNotas.add(aluno);
        Toast.makeText(this, "Aluno e Notas cadastrados com sucesso!! "+ nome +": " + nota , Toast.LENGTH_SHORT).show();

        DadosCompartilhados.listaNotas.add(aluno);

//        Bundle bundle = new Bundle();
//        bundle.putSerializable("lista_aluno", listaNotas);
        Intent listagem = new Intent(this, ListagemActivity.class);
//        listagem.putExtras(listagem);
        startActivity(listagem);



    }
}