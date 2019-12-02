package com.example.caminhos.Classes;

public class Cidade implements Comparable<Cidade> {
    int codCidade;
    String nome;
    String cordX;
    String cordY;

    public Cidade(int cod, String nomeCidade, String coordenadaX, String coordenadaY)
    {
        this.codCidade = cod;
        this.nome = nomeCidade;
        this.cordX = coordenadaX;
        this.cordY = coordenadaY;
    }


    @Override
    public int compareTo(Cidade o) {
        return this.codCidade - o.codCidade;
    }

    public String toString()
    {
        String retorno;

        retorno = "Código: " + this.codCidade + ", nome: " + this.nome + ", coordenadaX: " + this.cordX + ", coordenadaY: " + this.cordY;

        return retorno;
    }
}
