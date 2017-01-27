package es.iesnervion.qa.Model;

import java.util.ArrayList;

/**
 * Clase Qestion, esta clase se encargará de guardar las preguntas y sus dichas respuestas
 * se utilizaran el posicionamiento como estrategia para conocer la respuesta correecta.
 * Created by apol on 24/01/17.
 */
//TODO Preguntar a Miguel si es mejor con un Objeto de atributo o que herede de este...
public class Question extends Categoria {
    private String question;
    private ArrayList<Answer> answers;

    public Question() {
    }

    public Question(String question, ArrayList<Answer> answer) {
        this.question = question;
        this.answers = answer;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<Answer> getAnswer() {
        return answers;
    }
}
