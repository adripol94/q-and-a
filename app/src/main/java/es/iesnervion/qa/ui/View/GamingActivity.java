package es.iesnervion.qa.ui.View;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import es.iesnervion.qa.Controller.RetrofitControler;
import es.iesnervion.qa.Model.Answer;
import es.iesnervion.qa.Model.CallBackProgress;
import es.iesnervion.qa.Model.Category;
import es.iesnervion.qa.Model.Question;
import es.iesnervion.qa.Model.Responser;
import es.iesnervion.qa.Model.ResponserAnswer;
import es.iesnervion.qa.R;
import es.iesnervion.qa.ui.Adapter.AnswerAdapter;
import retrofit2.Call;

public class GamingActivity extends AppCompatActivity implements Responser<List<Question>>, ResponserAnswer{
    private MediaPlayer mediaPlayer;
    private int iClicks = 0;
    private static final String CLICK_VALUE = "click_value";
    private TextView txtClicks;
    private View mProgressView;
    private List<Question> questions;
    private int contadorPreguntas;
    private HashMap<Integer, Integer> respuestas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);

        Category category = getIntent().getParcelableExtra(Category.CATEGORY_KEY);

        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        txtClicks = (TextView) findViewById(R.id.clock_gaming_tv);
        mProgressView = findViewById(R.id.login_progress);
        contadorPreguntas = 0;
        respuestas = new HashMap<>();


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        // task to be done every 100 milliseconds
                        iClicks += 1;
                        txtClicks.setText(String.valueOf(iClicks));
                    }
                });
            }
        }, 0, 100);

        RetrofitControler retrofitControler = new RetrofitControler();
        //TODO use here user object token.
        try {
            Call<List<Question>> listCall = retrofitControler.getListQuestionByCategory("Basic YWRyaXBvbDk0QGdtYWlsLmNvbToxMjM=",
                    String.valueOf(category.getId()));
            listCall.enqueue(new CallBackProgress<List<Question>>(this));
        } catch (Exception e) {
            //TODO for depure
            e.printStackTrace();
        }


    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(GamingActivity.CLICK_VALUE, iClicks);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }

    @Override
    public void onFinish(List<Question> obj, String bearer) {
        questions = obj;
        setQuestions(questions.get(contadorPreguntas));
    }

    @Override
    public void onFailure(Throwable t) {

    }

    private void setQuestions(Question q) {
        ((TextView)findViewById(R.id.clock_gaming_tv)).setText(q.getName());

        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.answers_gaming_lv);
        AnswerAdapter mCategoryAdapter = new AnswerAdapter(questions.get(1).getAnswer(), this);
        mRecyclerView.setAdapter(mCategoryAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        if (!mediaPlayer.isPlaying())
            mediaPlayer.start();
    }

    @Override
    public void onAnswerSelected(Answer answer) {
        if (contadorPreguntas < questions.size()) {
            respuestas.put(questions.get(contadorPreguntas).getId(), answer.getId());
            contadorPreguntas++;
            setQuestions(questions.get(contadorPreguntas));
        } else {
            Toast.makeText(this, "Terminado", Toast.LENGTH_LONG);
        }
    }
}
