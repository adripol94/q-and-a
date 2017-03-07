package es.iesnervion.qa.Model;

/**
 * Created by adripol94 on 1/27/17.
 */

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase principal para la validacion de las repuestas.
 */
public class Validator implements Parcelable {
    @SerializedName("idUser")
    private int idUser;
    @SerializedName("idCategory")
    private int idCategory;
    @SerializedName("time")
    private int time;
    @SerializedName("points")
    private int points;
    @SerializedName("answers")
    private ArrayList<QuestionAnswer> answers;

    public Validator(int idUser, int idCategory,int time) {
        this.idUser = idUser;
        this.idCategory = idCategory;
        this.time = time;
        answers = new ArrayList<>();
    }

    public Validator(int idCategory, int idUser) {
        this.idCategory = idCategory;
        this.idUser = idUser;
        answers = new ArrayList<>();
    }

    public Validator(){}

    public void putAnswer(QuestionAnswer qa) {
        answers.add(qa);
    }

    public void putAnswers(ArrayList<QuestionAnswer> resp) {
        answers = resp;
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
        dest.writeInt(this.points);
        dest.writeList(this.answers);
    }

    protected Validator(Parcel in) {
        this.idUser = in.readInt();
        this.idCategory = in.readInt();
        this.time = in.readInt();
        this.points = in.readInt();
        this.answers = new ArrayList<QuestionAnswer>();
        in.readList(this.answers, QuestionAnswer.class.getClassLoader());
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
