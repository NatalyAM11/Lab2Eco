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

    private ArrayList<Pregunta> preguntas;

    private int num1, num2, operacion;
    private int contadorsito;
    private int puntaje;
    private boolean activarContador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleA = findViewById(R.id.titleA);
        answerA = findViewById(R.id.answerA);
        buttonA = findViewById(R.id.buttonA);
        puntajeA = findViewById(R.id.puntajeA);
        contador = findViewById(R.id.contador);
        preguntas = new ArrayList<Pregunta>();

        contadorsito = 20;
        activarContador = true;
        puntaje = 0;

        nextQuestion();

        //cronometro
        tiempo();




        //Confirmacion respuesta del usuario
        buttonA.setOnClickListener(this);

    }

        //este es el contador pero no se donde ponerlo aun, y no funciona bien :/

        public void tiempo () {

            new Thread(

                    () -> {
                        while (activarContador) {
                            contadorsito--;
                            runOnUiThread( () ->contador.setText(" " + contadorsito));
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            ).start();

        }

        

    @Override
    public void onClick(View view) {

        String laRespuesta = answerA.getText().toString();
        puntajeA.setText("Puntaje:" + puntaje);

        for (int i = 0; i < preguntas.size(); i++) {

            if (laRespuesta.equals(Integer.toString(preguntas.get(i).getSolucion()))) {

                puntaje += 15;
                nextQuestion();


            } else {

                puntaje -= 2;


            }


            Log.e("prueba" , ""+preguntas.get(i).getSolucion());
        }
    }



    public void nextQuestion(){

        num1 = (int) (Math.random() * 10 + 1);
        num2 = (int) (Math.random() * 10 + 1);
        operacion = (int) (Math.random() * 4 + 1);
        preguntas.add(new Pregunta(num1, num2, operacion));

        for (int i = 0; i < preguntas.size(); i++) {
            preguntas.get(i).preguntar();
            titleA.setText(preguntas.get(i).devolverPregunta()+" ");
        }

    }



}



