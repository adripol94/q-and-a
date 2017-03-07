package es.iesnervion.qa.Model;

/**
 * Created by adripol94 on 1/27/17.
 */

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase principal para la validacion de las repuestas.
 */
public class Validator implements Parcelable {
    private int idUser;
    private int idCategory;
    private int time;
    private int points;
    private ArrayList<String> questionAnswers;

    public Validator(int idUser, int idCategory,int time) {
        this.idUser = idUser;
        this.idCategory = idCategory;
        this.time = time;

    }

    public Validator(int idCategory, int idUser) {
        this.idCategory = idCategory;
        this.idUser = idUser;
    }

    public Validator(){}

    public void putAnswer(ArrayList<String> resp) {
        questionAnswers = resp;
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

    public int getTime() {
        return time;
    }

    public int getPoints() {return points;}

    public void setPoints(int points) {
        this.points = points;
    }

    public void setTime(int time) {
        this.time = time;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idUser);
        dest.writeInt(this.idCategory);
        dest.writeInt(this.time);
        dest.writeStringList(this.questionAnswers);
    }

    protected Validator(Parcel in) {
        this.idUser = in.readInt();
        this.idCategory = in.readInt();
        this.time = in.readInt();
        this.questionAnswers = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Validator> CREATOR = new Parcelable.Creator<Validator>() {
        @Override
        public Validator createFromParcel(Parcel source) {
            return new Validator(source);
        }

        @Override
        public Validator[] newArray(int size) {
            return new Validator[size];
        }
    };
}
