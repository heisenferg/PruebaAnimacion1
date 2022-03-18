package com.example.pruebaanimacion;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button botonAnimar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonAnimar = findViewById(R.id.buttonAnimar);
        botonAnimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animarBoton();
            }
        });

    }

    public void animarBoton(){
        AnimatorSet animadorBoton = new AnimatorSet();

        //1ª animación, trasladar desde la izquierda (800 pixeles menos hasta la posición
//inicial (0)
        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator trasladar = ObjectAnimator.ofFloat(botonAnimar, "tanslationX", -800,0);
        trasladar.setDuration(5000);

        //Fade in 8 segundos
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(botonAnimar, "alpha", 0f, 1f);
        fadeIn.setDuration(8000);

        //Visualizar las dos
        animadorBoton.play(trasladar).with(fadeIn);

        //Comenzar
        animadorBoton.start();
    }
}