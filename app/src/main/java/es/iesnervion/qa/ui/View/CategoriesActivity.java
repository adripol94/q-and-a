package es.iesnervion.qa.ui.View;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import es.iesnervion.qa.Controller.RetrofitControler;
import es.iesnervion.qa.Model.CallBackProgress;
import es.iesnervion.qa.Model.Category;
import es.iesnervion.qa.Model.Responser;
import es.iesnervion.qa.R;
import es.iesnervion.qa.ui.Adapter.CategoriaAdapter;
import retrofit2.Call;

public class CategoriesActivity extends AppCompatActivity implements Responser<List<Category>> {

    private List<Category> categories;
    private RetrofitControler retrofitControler;
    private RecyclerView mRecyclerView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_game);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Start Flating button...
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorQuestions)));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CategoriesActivity.this, GamingActivity.class);
                startActivity(it);
            }
        });

        mRecyclerView = (RecyclerView)findViewById(R.id.rvCategorias);

        retrofitControler = new RetrofitControler();
        Call<List<Category>> categCall = retrofitControler.getListCategory("Basic YWRyaXBvbDk0QGdtYWlsLmNvbToxMjM=");
        categCall.enqueue(new CallBackProgress<List<Category>>(this));

    }

    @Override
    public void onFinish(List<Category> obj, String bearer) {
        categories = obj;

        (findViewById(R.id.progressBarCategory)).setVisibility(View.GONE);
        (findViewById(R.id.cargando_content_tv)).setVisibility(View.GONE);

        CategoriaAdapter mCategoryAdapter = new CategoriaAdapter(categories);
        mRecyclerView.setAdapter(mCategoryAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
