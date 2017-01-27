package es.iesnervion.qa.Model;

/**
 * Created by adripol94 on 1/27/17.
 */

public class Answer {
    private int id;
    private String answer;
    private boolean correct;

    public Answer() {
    }

    public Answer(int id, String answer, boolean correct) {
        this.id = id;
        this.answer = answer;
        this.correct = correct;
    }

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return correct;
    }
}
