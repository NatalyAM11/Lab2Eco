package com.example.practica2;

public class Pregunta {

    String preguntas;
    String respuestas;

    public Pregunta(String preguntas, String respuestas) {
        this.preguntas = preguntas;
        this.respuestas = respuestas;
    }





    //getters and setters
    public String getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public String getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String respuestas) {
        this.respuestas = respuestas;
    }
}
