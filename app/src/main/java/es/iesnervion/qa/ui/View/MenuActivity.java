package es.iesnervion.qa.ui.View;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import es.iesnervion.qa.R;
import es.iesnervion.qa.ui.Transitions.TransitionInActivity;

public class MenuActivity extends AppCompatActivity {

    public TextView juego;
    public TextView setting;
    public TextView friends;
    public TextView questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        juego = (TextView) findViewById(R.id.txtJuego);
        juego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                juego.startAnimation(AnimationUtils.loadAnimation(
                        v.getContext(), android.R.anim.fade_out));

                Intent it = new Intent(MenuActivity.this, CategoriesActivity.class);
                it.putExtra(TransitionInActivity.EXTRA_TRANSITION, TransitionInActivity.TRANSITION_EXPLODE);
                startActivityWithOptions(it);

             }
        });

        setting = (TextView) findViewById(R.id.txtSettings);

        friends = (TextView) findViewById(R.id.txtAmigos);

        questions = (TextView) findViewById(R.id.txtRealizarPreguntas);
    }

    private void startActivityWithOptions(Intent intent) {
        ActivityOptions transitionActivity =
                ActivityOptions.makeSceneTransitionAnimation(MenuActivity.this);
        startActivity(intent, transitionActivity.toBundle());
    }
}
