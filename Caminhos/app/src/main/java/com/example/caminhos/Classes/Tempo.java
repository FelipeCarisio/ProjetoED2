package com.example.caminhos.Classes;

public class Tempo implements Comparable<Tempo> {
    int minutos;
    int horas;

    public Tempo(int h, int m)
    {
        this.minutos = m;
        this.horas = h;
    }

    public  int getMinutos()
    {
        return  this.minutos;
    }

    public int getHoras()
    {
        return  this.horas;
    }

    public int emMinutos()
    {
        int aux = this.horas*60 + this.minutos;
        return  aux;
    }

    public void somar(Tempo adcionado)
    {
        int aux;
        aux = (adcionado.minutos + this.minutos);
        this.minutos = aux%60;
        this.horas = adcionado.horas + this.horas + aux/60;

    }

    public String toString()
    {
        String ret = "tempo: " +this.horas +"h" + this.minutos + "min";
        return ret;
    }

    @Override
    public int compareTo(Tempo o) {
        int ret = this.horas - o.horas;
        if(ret == 0)
        {
            ret = this.minutos - o.minutos;
            return ret;
        }
        else
            return ret;
    }
}
