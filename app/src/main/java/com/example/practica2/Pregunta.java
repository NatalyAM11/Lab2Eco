package com.example.practica2;

public class Pregunta {

    int num1;
    int num2;
    int operacion;
    int solucion;
    String pregunta;


    public Pregunta(int num1, int num2, int operacion) {

        this.num1=num1;
        this.num2=num2;
        this.operacion= operacion;

    }

    public void preguntar () {

        switch (operacion){

            //sumar
            case 1:
                pregunta=num1+"+"+num2;
                solucion=num1+num2;
            break;
            //resta
            case 2:
                pregunta=num1+"-"+num2;
                solucion=num1-num2;
            break;
            //multiplicacion
            case 3:
                pregunta=num1+"*"+num2;
                solucion=num1*num2;
            break;
            //division
            case 4:
                pregunta=num1+"/"+num2;
                solucion=num1/num2;
            break;
        }
    }

    String devolverPregunta(){
        return pregunta;
    }


    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }

    public int getSolucion() {
        return solucion;
    }

    public void setSolucion(int solucion) {
        this.solucion = solucion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}

