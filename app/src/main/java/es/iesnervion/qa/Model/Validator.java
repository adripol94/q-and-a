package es.iesnervion.qa.Model;

/**
 * Created by adripol94 on 1/27/17.
 */

import android.content.Intent;

import java.sql.Time;
import java.util.HashMap;

/**
 * Clase principal para la validacion de las repuestas.
 */
public class Validator {
    private int idUser;
    private int idCategory;
    private Time time;
    private HashMap<Integer, Integer> questionAnswers;

    public Validator(int idUser, int idCategory,Time time) {
        this.idUser = idUser;
        this.idCategory = idCategory;
        this.time = time;
        questionAnswers = new HashMap<>();
    }

    public Validator(int idCategory, int idUser) {
        this.idCategory = idCategory;
        this.idUser = idUser;
    }

    public Validator(){}

    public void putAnswer(int idQuestion, int idAnswer) {
        questionAnswers.put(idQuestion, idCategory);
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
