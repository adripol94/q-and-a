package es.iesnervion.qa.ui.View;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import es.iesnervion.qa.Model.Category;
import es.iesnervion.qa.R;
import es.iesnervion.qa.ui.Adapter.CategoriaAdapter;

public class CategoriesActivity extends AppCompatActivity {

    private List<Category> categories;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_game);
        CategoriaAdapter mCategoryAdapter;
        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.rvCategorias);

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

        //Back TextView...
        TextView tx = (TextView) findViewById(R.id.backButton);
        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //TODO Dummy -> Replace that
        Category[] c = {
          new Category(1, "Ciencias")
        };

        mCategoryAdapter = new CategoriaAdapter(c);
        mRecyclerView.setAdapter(mCategoryAdapter);
    }
}