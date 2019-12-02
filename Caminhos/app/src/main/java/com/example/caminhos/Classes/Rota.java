package com.example.caminhos.Classes;

public class Rota implements Comparable<Rota> {
    String origem ;
    String destino ;
    int distancia;
    Tempo tempo;

    public Rota(int dis, Tempo t, String o, String d)
    {
        this.origem = o;
        this.destino = d;
        this.distancia = dis;
        this.tempo = t;
    }

    public String toStrng()
    {
        String ret;
        ret = String.format("|%15s|", origem);
        ret += String.format("|%15s|", destino);
        ret += String.format("|%4d|", distancia);
        ret += String.format("|%5d|", tempo.emMinutos());

        return ret;
    }

    public int getDistancia()
    {
        return this.distancia;
    }

    public Tempo getTempo()
    {
        return this.tempo;
    }

    @Override
    public int compareTo(Rota o) {
        if(this.distancia == o.distancia && this.tempo.compareTo(o.tempo) == 0)
        {
            if (this.destino == o.destino && this.origem == o.origem)
                return 0;
            else {
                if (this.origem != o.origem)
                    return this.origem.compareTo(o.origem);
                else
                    return  this.destino.compareTo(o.destino);
            }
        }
        else
            if(this.distancia != o.distancia)
                return this.distancia - o.distancia;
            else
                return this.tempo.compareTo(o.tempo);
    }
}
