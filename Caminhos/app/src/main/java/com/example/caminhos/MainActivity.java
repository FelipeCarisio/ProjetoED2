package com.example.caminhos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.caminhos.Classes.ListaSimples;
import com.example.caminhos.Classes.Rota;

public class MainActivity extends AppCompatActivity {

    ImageView imagem;
    Button buscar, adcCidade, adcCaminho;
    TextView resultados;
    Spinner cidadeInicio, cidadeDestino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagem = (ImageView) findViewById(R.id.imageView);
        buscar = (Button) findViewById(R.id.btnBuscar);
        adcCidade = (Button) findViewById(R.id.btnBuscar6);
        adcCaminho = (Button) findViewById(R.id.btnBuscar2);
        resultados = (TextView) findViewById(R.id.textView5);
        cidadeDestino = (Spinner) findViewById(R.id.spinnerDestino);
        cidadeInicio = (Spinner) findViewById(R.id.spinnerSaida);
    }
}
