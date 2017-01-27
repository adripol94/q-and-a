package es.iesnervion.qa.ui.View;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import es.iesnervion.qa.R;

public class GamingActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private int iClicks = 0;
    private static final String CLICK_VALUE = "click_value";
    private TextView txtClicks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);

        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        txtClicks = (TextView) findViewById(R.id.clock_gaming_tv);

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
