package es.iesnervion.qa.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.iesnervion.qa.R;

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
                Intent it = new Intent(GameActivity.this, GameList.class);
                startActivity(it);
             }
        });

        setting = (TextView) findViewById(R.id.txtSettings);

        friends = (TextView) findViewById(R.id.txtAmigos);

        questions = (TextView) findViewById(R.id.txtRealizarPreguntas);
    }
}
