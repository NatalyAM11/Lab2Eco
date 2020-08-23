package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView titleA;
    private EditText answerA;
    private Button buttonA;
    private TextView puntajeA;

    private ArrayList <Pregunta> preguntas;

    private int num1,num2,operacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleA= findViewById(R.id.titleA);
        answerA= findViewById(R.id.answerA);
        buttonA= findViewById(R.id.buttonA);
        puntajeA= findViewById(R.id.puntajeA);
        preguntas= new ArrayList<>();
       /* num1= (int) Math.random (1,5);
        num2= (int) Math.random (1,5);
        operacion= (int) Math.random (1,5);*/


    }

    public void preguntar(){
        for (int i = 0; i < 20; i++) {
            preguntas.add(new Pregunta(num1,num2,operacion));
        }
    }
    }


