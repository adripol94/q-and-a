package es.iesnervion.qa.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Clase Qestion, esta clase se encargará de guardar las preguntas y sus dichas respuestas
 * se utilizaran el posicionamiento como estrategia para conocer la respuesta correecta.
 * Created by apol on 24/01/17.
 */
//TODO Preguntar a Miguel si es mejor con un Objeto de atributo o que herede de este...
public class Question extends Category implements Parcelable {
    private String question;
    private ArrayList<Answer> answers;
    public static final String CATEGORY_KEY = "category";

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.question);
        dest.writeList(this.answers);
    }

    protected Question(Parcel in) {
        this.question = in.readString();
        this.answers = new ArrayList<Answer>();
        in.readList(this.answers, Answer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel source) {
            return new Question(source);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}
