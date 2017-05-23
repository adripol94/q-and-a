package es.iesnervion.qa.ui.View;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

import es.iesnervion.qa.Model.Bearer;
import es.iesnervion.qa.R;
import es.iesnervion.qa.ui.Transitions.TransitionInActivity;

public class MenuActivity extends AppCompatActivity {

    public TextView juego;
    public TextView setting;
    public TextView friends;
    public TextView questions;
    public TextView salir;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        juego = (TextView) findViewById(R.id.txtJuego);
        juego.setOnClickListener(v -> {
            juego.startAnimation(AnimationUtils.loadAnimation(
                    v.getContext(), android.R.anim.fade_out));

            Intent it = new Intent(MenuActivity.this, CategoriesActivity.class);
            it.putExtra(TransitionInActivity.EXTRA_TRANSITION, TransitionInActivity.TRANSITION_EXPLODE);
            startActivityWithOptions(it);

         });

        salir = (TextView) findViewById(R.id.txtSalir);
        salir.setOnClickListener(v -> {
            Bearer.delDefaults(v.getContext());
            setResult(Activity.RESULT_OK);
            finishActivity(WelcomeActivity.RC_SIGN_OUT);
            finish();
        });

        setting = (TextView) findViewById(R.id.txtSettings);
        setting.setOnClickListener(v -> {

        });


        friends = (TextView) findViewById(R.id.txtAmigos);

        questions = (TextView) findViewById(R.id.txtRealizarPreguntas);
    }

    private void startActivityWithOptions(Intent intent) {
        ActivityOptions transitionActivity =
                ActivityOptions.makeSceneTransitionAnimation(MenuActivity.this);
        startActivity(intent, transitionActivity.toBundle());
    }
}
