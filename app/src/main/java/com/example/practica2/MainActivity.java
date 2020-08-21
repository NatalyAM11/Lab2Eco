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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleA= findViewById(R.id.titleA);
        answerA= findViewById(R.id.answerA);
        buttonA= findViewById(R.id.buttonA);
        puntajeA= findViewById(R.id.puntajeA);
        preguntas= new ArrayList<>();




    }
    public void hacerPregunta(){

        //for (int i=0, i<10,i++){

        }
    }


