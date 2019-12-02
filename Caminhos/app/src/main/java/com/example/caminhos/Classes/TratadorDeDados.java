package com.example.caminhos.Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TratadorDeDados {
    ListaSimples<Rota> rotas;
    ListaSimples<Cidade> cidades;
    BufferedReader leitor;
    BufferedWriter escritor;

    int tamanhoInicialRotas, tamanhoInicialCidades;

    public TratadorDeDados()
    {
        this.rotas = new ListaSimples<Rota>();
        this.cidades = new ListaSimples<Cidade>();
    }



    public void leCaminhos(String s) throws Exception
    {
        File arq = new File(s);
        leitor = new BufferedReader(new FileReader(arq));
        String linha;
        while((linha = leitor.readLine()) != null)
        {
            Rota nova;
            String CidadeInicio = linha.substring(0,14);
            String CidadeDestino = linha.substring(15,29);
            int dis = Integer.parseInt(linha.substring(30,33));
            int aux = Integer.parseInt(linha.substring(34, 38));
            Tempo t = new Tempo(aux/60, aux%60);
            nova = new Rota(dis,t,CidadeInicio,CidadeDestino);
            rotas.inserirAposFim(nova);
            tamanhoInicialRotas++;
        }
        leitor.close();

    }
    public void adcionaCidade(Cidade c)
    {

    }

    public void salvarRotas(String s) throws Exception
    {
        Path p = Paths.get(s);
        escritor = Files.newBufferedWriter(p, StandardOpenOption.APPEND);
        for(int i = tamanhoInicialRotas; i< rotas.tamanho; i++)
        {
            String saida = System.lineSeparator() + rotas.get(i - 1);
            escritor.write(saida);
        }
    }

    public void adcionaRota(Rota r)
    {
        rotas.inserirAposFim(r);

    }
}
