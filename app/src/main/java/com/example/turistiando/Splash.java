package com.example.turistiando;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    // Atributos
    MediaPlayer cancion;

    // Metodos
    // Bundle(Clase), savedInstanceState(Objeto)
    // Clases, Puede ser el codigo en Mayuscula en su inicial
    // Objetos, Puede ser el codigo en Minuscula en su inicial
    // R(Resource).layout.activity_splash
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // Es la Ruta de carpetas donde se encuentra el contenido

        // Oculte el action bar
        ActionBar barra = getSupportActionBar();
        barra.hide();

        // Lanzar la cancion
        cancion = MediaPlayer.create(this,R.raw.cancion);
        cancion.start();

        // Temporizar la duración del slash
        TimerTask inicioapp = new TimerTask() {
            @Override // Sobreescribir Un Metodo
            public void run() {
                // Lanzar una nueva actividad
                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(inicioapp,10000);
    }
}