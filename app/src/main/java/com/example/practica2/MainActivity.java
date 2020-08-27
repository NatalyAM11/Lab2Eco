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

    private ArrayList<Pregunta> preguntas;

    private int num1, num2, operacion;
    private int contadorsito;
    private int puntaje;
    private boolean activarContador,activarPuntaje, masPregunta, correcto;



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
        preguntas = new ArrayList<Pregunta>();
        puntaje=0;
        contadorsito = 10;
        activarContador = true;
        activarPuntaje=false;
        masPregunta=false;

        BIntentar.setVisibility(View.GONE);

        correcto=false;


        nextQuestion();

     /*   if (activarContador==false){
            puntaje-=2;
        }*/

        //cronometro
        tiempo();


        if(correcto=true){
            puntaje+=10;
        } /*else{
            puntaje-=2;
        }*/



        //Confirmacion respuesta del usuario
        buttonA.setOnClickListener(this);

        BIntentar.setOnClickListener(
                (v)->{

                    nextQuestion();
                    contadorsito=50;


                    BIntentar.setVisibility(View.GONE);


                }
        );


    }


    @Override
    public void onClick(View view) {

       // puntajeA.setText("Puntaje: " + puntaje);
        String laRespuesta = answerA.getText().toString();

        //edito puntaje
        puntajeA.setText("Puntaje: " + puntaje);

        for (int i = 0; i < preguntas.size(); i++) {

            if (laRespuesta.equals(Integer.toString(preguntas.get(i).getSolucion()))) {
                //puntaje += 10;
                masPregunta=true;

                if(masPregunta==true){
                nextQuestion();
                }
                correcto=true;

            }
            /*else {
                puntaje -= 2;
            }*/


            //Log.e("prueba" , ""+preguntas.get(i).getSolucion());
            Log.e("prueba" , ""+puntaje);
        }
    }


    //este es el contador pero no se donde ponerlo aun, y no funciona bien :/

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
        preguntas.add(new Pregunta(num1, num2, operacion));


        for (int i = 0; i < preguntas.size(); i++) {
            preguntas.get(i).preguntar();
            titleA.setText(preguntas.get(i).devolverPregunta()+" ");
        }

    }






}



