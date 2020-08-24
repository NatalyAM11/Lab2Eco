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
    private TextView contador;

    private ArrayList <Pregunta> preguntas;

    private int num1,num2,operacion;
    private int contadorsito;
    private int puntaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleA= findViewById(R.id.titleA);
        answerA= findViewById(R.id.answerA);
        buttonA= findViewById(R.id.buttonA);
        puntajeA= findViewById(R.id.puntajeA);
        contador=findViewById(R.id.contador);
        preguntas= new ArrayList<>();
        num1= (int) (Math.random ()*25+1);
        num2= (int) (Math.random ()*25+1);
        operacion= (int) (Math.random ()*4+1);

        titleA.setText(num1+" "+ preguntas+" "+ num2);


        //este es el contador pero no se donde ponerlo aun
        /*contadorsito--;
        contador.setText(" "+ contadorsito);*/


        buttonA.setOnClickListener(
                (v)->{
                    String laRespuesta = answerA.getText().toString();

                }

              /*  if (laRespuesta== preguntas.get(solucion)){
                        puntaje+=15;
        }*/
        );
    }



    public void preguntar(){

        for (int i = 0; i < preguntas.size(); i++) {
               preguntas. get(i).preguntar();
        }

        preguntas.add(new Pregunta(num1,num2,operacion));
    }


    }


