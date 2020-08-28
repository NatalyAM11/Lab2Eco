package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private TextView titleA;
    private EditText answerA;
    private Button buttonA;
    private TextView puntajeA;
    private TextView contador;
    private Button BIntentar;

    private Pregunta preguntas;

    private int num1, num2, operacion;
    private int contadorsito;
    private int puntaje;
    private boolean activarContador,activarPuntaje, masPregunta, fail, cReinicio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleA = findViewById(R.id.titleA);
        answerA = findViewById(R.id.answerA);
        buttonA = findViewById(R.id.buttonA);
        puntajeA = findViewById(R.id.puntajeA);
        contador = findViewById(R.id.contador);
        BIntentar=findViewById(R.id.BIntentar);
        puntaje=0;
        contadorsito = 10;
        activarContador = true;
        activarPuntaje=false;
        cReinicio=true;


        BIntentar.setVisibility(View.GONE);

        BIntentar.setOnClickListener(

                (v)->{
                    activarContador=true;
                    contador.setText(" " + contadorsito);
                    nextQuestion();

                    BIntentar.setVisibility(View.GONE);

                }
        );


        //cronometro
        tiempo();

        // correcto();
        nextQuestion();


        //Confirmacion respuesta del usuario
        buttonA.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {

        String laRespuesta = answerA.getText().toString();

        //valido el  puntaje

            if (laRespuesta.equals(Integer.toString(preguntas.getSolucion()))) {
                puntaje+=10;
                //fail=false;

                //reinicio el contador
                contadorsito=21;
                activarContador=true;

                //le permito seguir a la otra pregunta
                masPregunta=true;

                if(masPregunta==true){
                nextQuestion();
                }


            }
            

        //edito puntaje
        puntajeA.setText("Puntaje: " + puntaje);
    }


    //este es el contador

        public void tiempo () {

            new Thread(

                    () -> {

                        while (activarContador) {
                            contadorsito--;
                            runOnUiThread( () ->contador.setText(" " + contadorsito));

                            if (contadorsito==0){
                                activarContador=false;

                                //Detengo que genere mas preguntas despues de que el tiempo acabe
                                masPregunta=false;
                                contadorsito=20;
                                puntaje=0;
                                //asi aparece el otro boton
                                runOnUiThread( () ->  BIntentar.setVisibility(View.VISIBLE));

                            }

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            ).start();

        }




    public void nextQuestion(){

        num1 = (int) Math.floor((Math.random() * 10 + 1));
        num2 = (int) Math.floor((Math.random() * 10 + 1));
        operacion = (int) Math.floor((Math.random() * 5 + 1));
        preguntas= new Pregunta(num1,num2,operacion);


            preguntas.preguntar();
            titleA.setText(preguntas.devolverPregunta()+" ");
        }



}



