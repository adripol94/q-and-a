package es.iesnervion.qa.Model;

import java.util.ArrayList;

/**
 * Clase Qestion, esta clase se encargará de guardar las preguntas y sus dichas respuestas
 * se utilizaran el posicionamiento como estrategia para conocer la respuesta correecta.
 * Created by apol on 24/01/17.
 */
// Tambien es posible con una matriz.
public class Question {
    private String question;
    private String correctAnswer;
    private String[] incorrectAnswer;

    public Question() {
    }

    public Question(String question, String correctAnswer, String[] incorrectAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswer = incorrectAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getIncorrectAnswer() {
        return incorrectAnswer;
    }
}
