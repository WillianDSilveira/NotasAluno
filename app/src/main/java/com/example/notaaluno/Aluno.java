package com.example.notaaluno;

public class Aluno {
    public Integer id;
    public String nome;
    public String nota;

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", nota='" + nota + '\'' +
                '}';
    }
}
