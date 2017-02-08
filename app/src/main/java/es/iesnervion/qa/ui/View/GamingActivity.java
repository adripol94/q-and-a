package es.iesnervion.qa.ui.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.lzyzsd.circleprogress.CircleProgress;

import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import es.iesnervion.qa.Controller.RetrofitControler;
import es.iesnervion.qa.Model.Answer;
import es.iesnervion.qa.Model.Bearer;
import es.iesnervion.qa.Model.CallBackProgress;
import es.iesnervion.qa.Model.Category;
import es.iesnervion.qa.Model.Question;
import es.iesnervion.qa.Model.Responser;
import es.iesnervion.qa.Model.ResponserAnswer;
import es.iesnervion.qa.Model.TimerEndGamming;
import es.iesnervion.qa.R;
import es.iesnervion.qa.ui.Adapter.AnswerAdapter;
import retrofit2.Call;

/**
 * IMPORTANTE: Ir al Manifest, esta actividad no se guarda en la pila de actividades
 */
public class GamingActivity extends AppCompatActivity implements Responser<List<Question>>, ResponserAnswer, TimerEndGamming{
    private MediaPlayer mediaPlayer;
    private int iClicks = 0;
    private static final String CLICK_VALUE = "click_value";
    private CircleProgress arcClicks;
    private View mProgressView;
    private List<Question> questions;
    private int contadorPreguntas;
    private HashMap<Integer, Integer> respuestas;
    private TextView questionGaming;
    private Timer timer;
    public final static String BACK_ACTIVITY = "isBacked";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);

        Category category = getIntent().getParcelableExtra(Category.CATEGORY_KEY);

        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        arcClicks = (CircleProgress) findViewById(R.id.clock_gaming_pb);
        mProgressView = findViewById(R.id.login_progress);
        questionGaming = (TextView)findViewById(R.id.question_gaming_tv);
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.stackPanel_clockGamming);
        contadorPreguntas = 0;
        respuestas = new HashMap<>();
        timer = new Timer();

        rl.setBackground(new BitmapDrawable(getResources(), category.getImgBitMap()));

        questionGaming.setText("Preparando las respuestas...");

        String token = Bearer.getDefaults(Bearer.BEARER_KEY, this);

        RetrofitControler retrofitControler = new RetrofitControler();
        try {
            Call<List<Question>> listCall = retrofitControler.getListQuestionByCategory(token,
                    String.valueOf(category.getId()));
            listCall.enqueue(new CallBackProgress<List<Question>>(this, this));
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
        if (!mediaPlayer.isPlaying())
            mediaPlayer.start();

        setQuestions(questions.get(contadorPreguntas));
    }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        Intent it = new Intent(this, Finish_Game.class);
        it.putExtra(BACK_ACTIVITY, 1);
        startActivity(it);
    }

    @Override
    public void onFailure(Throwable t) {

    }

    private void setQuestions(Question q) {
        if (contadorPreguntas == 0)
            timer.schedule(new RunClock(this), 0, 1000);

        questionGaming.setText("Pregunta " + (contadorPreguntas + 1) +
                ": " + q.getQuestion());
        (findViewById(R.id.question_progress)).setVisibility(View.GONE);

        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.answers_gaming_lv);
        AnswerAdapter mCategoryAdapter = new AnswerAdapter(questions.get(contadorPreguntas).getAnswer(), this);
        mRecyclerView.setAdapter(mCategoryAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

    }

    @Override
    public void onAnswerSelected(Answer answer) {
        respuestas.put(questions.get(contadorPreguntas).getId(), answer.getId());

        if (contadorPreguntas < questions.size() -1) {
            contadorPreguntas++;
            setQuestions(questions.get(contadorPreguntas));
        } else {
            timer.cancel();
            mediaPlayer.stop();
            isFinish(false);
        }
    }

    @Override
    public void isFinish(boolean timeOut) {
        Toast.makeText(this, "Juego acabado", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(this, Finish_Game.class);
        startActivity(it);
    }

    /**
     * Clase para el reloj!
     */
    public class RunClock extends TimerTask {
        private Context c;

        public RunClock(Context c) {
            this.c = c;
        }

        @Override
        public boolean cancel() {
            ((TimerEndGamming) c).isFinish(true);


            return super.cancel();
        }

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // task to be done every 100 milliseconds
                    //TODO error aqui cuando click corre mas rapido.
                    iClicks += 1;
                    if (iClicks > 100)
                        cancel();

                    arcClicks.setProgress(iClicks);
                }
            });


        }
    }
}
