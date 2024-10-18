package com.example.notaaluno;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListagemActivity extends AppCompatActivity {
    ArrayList<Aluno> listaAlunos = new ArrayList<>(DadosCompartilhados.listaNotas);
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listagem);
        setTitle("Listagem Alunos");

        ListView listView = findViewById(R.id.listAlunos);
        String [] dados = new String[DadosCompartilhados.listaNotas.size()];

        for (int i=0; i < DadosCompartilhados.listaNotas.size(); i++){
            dados[i] = DadosCompartilhados.listaNotas.get(i).nome + "" +
                    DadosCompartilhados.listaNotas.get(i).nota;
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dados);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        listaAlunos.clear();
        listaAlunos.addAll(DadosCompartilhados.listaNotas);
    }
}