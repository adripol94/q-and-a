package es.iesnervion.qa;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.List;

import es.iesnervion.qa.Model.CallBackProgress;
import es.iesnervion.qa.Model.Question;
import es.iesnervion.qa.Model.Responser;
import es.iesnervion.qa.Model.RetrofitControler;
import es.iesnervion.qa.ui.View.GamingActivity;
import retrofit2.Call;


public class TestPrueba extends AppCompatActivity implements Responser<Question> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_prueba);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);




        RetrofitControler r = new RetrofitControler("https://api.apol.ciclo.iesnervion.es/index.php/");

        Call<Question> listQuestion = r.getListQuestion("Basic YWRyaXBvbDk0QGdtYWlsLmNvbToxMjM=");
        try {
            listQuestion.enqueue(new CallBackProgress(this));
        } catch (Exception e) {
            e.printStackTrace();
        }

        progressBar.animate().start();
    }


    @Override
    public void terminado(Question obj, String bearer) {
        Intent it = new Intent(TestPrueba.this, GamingActivity.class);
        it.putExtra(Question.CATEGORY_KEY, obj);
        startActivity(it);
    }
}
