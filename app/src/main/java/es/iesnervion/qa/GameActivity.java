package es.iesnervion.qa;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    public TextView juego;
    public TextView setting;
    public TextView friends;
    public TextView questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        juego = (TextView) findViewById(R.id.txtJuego);
        juego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation disppear = AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_out);
                disppear.reset();
                juego.clearAnimation();
                setting.clearAnimation();
                setting.setAnimation(disppear);
                friends.clearAnimation();
                friends.setAnimation(disppear);
                questions.clearAnimation();
                questions.setAnimation(disppear);

             }
        });

        setting = (TextView) findViewById(R.id.txtSettings);

        friends = (TextView) findViewById(R.id.txtAmigos);

        questions = (TextView) findViewById(R.id.txtRealizarPreguntas);
    }

}
