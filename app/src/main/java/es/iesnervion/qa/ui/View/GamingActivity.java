package es.iesnervion.qa.ui.View;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import es.iesnervion.qa.Model.Category;
import es.iesnervion.qa.Model.ListQuestionFragment;
import es.iesnervion.qa.Model.Question;
import es.iesnervion.qa.Model.RetrofitControler;
import es.iesnervion.qa.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GamingActivity extends FragmentActivity {
    private MediaPlayer mediaPlayer;
    private int iClicks = 0;
    private static final String CLICK_VALUE = "click_value";
    private TextView txtClicks;
    private View mProgressView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);

        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        txtClicks = (TextView) findViewById(R.id.clock_gaming_tv);
        mProgressView = findViewById(R.id.login_progress);



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

        //Adapter for answer
        //https://github.com/adripol94/Android/blob/master/Ejercicio5.2/app/src/main/java/es/iesnervion/ejercicio52/MainActivity.java
        //TODO get Questions

        Question[] q = new Question[5];

        try {
            //IDEA rellenar con la capa DAL el array de Questions y inflar el fragment tantas preguntas tenga el array.
            // para ello hasta que el usuario no haga click no se volverá a calgar el otro layout.
            //TODO Puede que se tenga que hacer en hilos.

            for (int i = 0; i < q.length; i++) {
                ListQuestionFragment list = new ListQuestionFragment().newInstance(q[i]);

                // Hereda setArguments desde Fragment
                list.setArguments(getIntent().getExtras());

                // Con FragmentManager podremos interactuar entre el fragment_movil y la clase list
                // gracias a esto pondremos todos las propiedades preparada de ese
                // fragment en el fragment
                getSupportFragmentManager().beginTransaction().add(R.id.frame_gammingActivity, list)
                        .commit();
            }
        } catch (ClassCastException e) {
            //TODO change that
            e.printStackTrace();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(GamingActivity.CLICK_VALUE, iClicks);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}
