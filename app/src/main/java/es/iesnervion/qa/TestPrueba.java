package es.iesnervion.qa;

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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestPrueba extends AppCompatActivity implements Responser {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_prueba);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        RetrofitControler r = new RetrofitControler("http://api.qanda.dev/");
        Call<List<Question>> listQuestion = r.getListQuestion("Basic YWRyaXBvbDk0QGdtYWlsLmNvbToxMjM=");
        listQuestion.enqueue(new CallBackProgress(this));

        progressBar.animate().start();
    }


    @Override
    public void terminado() {
        Snackbar.make(getCurrentFocus(), "asd", Snackbar.LENGTH_LONG).show();
    }
}
