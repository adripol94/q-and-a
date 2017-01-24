package es.iesnervion.qa.Model;

import java.util.ArrayList;

/**
 * Clase Qestion, esta clase se encargará de guardar las preguntas y sus dichas respuestas
 * se utilizaran el posicionamiento como estrategia para conocer la respuesta correecta.
 * Created by apol on 24/01/17.
 */
// Tambien es posible con una matriz.
public class Question {
    private String pregunta;
    private ArrayList<String> respuestas;
    int posRespuestaCorrecta;

    public Question() {

    }

    public Question(String pregunta, ArrayList<String> respuestas, int posRespuestaCorrecta) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.posRespuestaCorrecta = posRespuestaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public ArrayList<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }

    public int getPosRespuestaCorrecta() {
        return posRespuestaCorrecta;
    }

    public void setPosRespuestaCorrecta(int posRespuestaCorrecta) {
        this.posRespuestaCorrecta = posRespuestaCorrecta;
    }
}
