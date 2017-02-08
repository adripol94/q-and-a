
package es.iesnervion.qa.ui.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.lzyzsd.circleprogress.CircleProgress;

import es.iesnervion.qa.R;

public class Finish_Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish__game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int i = getIntent().getIntExtra(GamingActivity.BACK_ACTIVITY, 0);


        if (i == 1) {
            cancellGamming();
        } else {
            createRating();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void cancellGamming() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.finishGameRelativeLayout);
        TextView tv = new TextView(this);
        tv.setText("Has salido de la partida");

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(500,200);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        relativeLayout.addView(tv,params);
    }

    private void createRating() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.finishGameRelativeLayout);

        ArcProgress ratting = new ArcProgress(this);
        ratting.setProgress(50);
        ratting.setBottomText("Luis");
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(200,200);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        relativeLayout.addView(ratting,params);

    }

}
