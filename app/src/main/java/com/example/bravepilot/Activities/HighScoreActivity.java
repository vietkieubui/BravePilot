package com.example.bravepilot.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bravepilot.R;

public class HighScoreActivity extends AppCompatActivity {
    private boolean isMute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_high_score);
        findViewById(R.id.replay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HighScoreActivity.this, GameActivity.class));
            }
        });

        final SharedPreferences prefs = getSharedPreferences("game", MODE_PRIVATE);
        TextView highScoreTxt1 = findViewById(R.id.highScoreTxt1);
        TextView highScoreTxt2 = findViewById(R.id.highScoreTxt2);
        TextView highScoreTxt3 = findViewById(R.id.highScoreTxt3);
        TextView highScoreTxt4 = findViewById(R.id.highScoreTxt4);
        TextView highScoreTxt5 = findViewById(R.id.highScoreTxt5);

        highScoreTxt1.setText("Top 1: " + prefs.getInt("highscore1", 0));
        highScoreTxt2.setText("Top 2: " + prefs.getInt("highscore2", 0));
        highScoreTxt3.setText("Top 3: " + prefs.getInt("highscore3", 0));
        highScoreTxt4.setText("Top 4: " + prefs.getInt("highscore4", 0));
        highScoreTxt5.setText("Top 5: " + prefs.getInt("highscore5", 0));


        isMute = prefs.getBoolean("isMute", false);

        final ImageView volumeCtrl = findViewById(R.id.volumeCtrl);

        if (isMute)
            volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
        else
            volumeCtrl.setImageResource(R.drawable.ic_volume_up_black_24dp);

        volumeCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isMute = !isMute;
                if (isMute)
                    volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
                else
                    volumeCtrl.setImageResource(R.drawable.ic_volume_up_black_24dp);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute", isMute);
                editor.apply();

            }
        });
    }
}