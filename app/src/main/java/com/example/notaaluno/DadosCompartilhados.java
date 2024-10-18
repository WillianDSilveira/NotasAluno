package com.example.notaaluno;

import java.util.ArrayList;
import java.util.List;

public class DadosCompartilhados {
    public static List<Aluno> listaNotas = new ArrayList<Aluno>();
    public static Integer idAluno = 0;

    public static Integer getProximoId(){
        idAluno = idAluno + 1;
        return idAluno;
    }
}
