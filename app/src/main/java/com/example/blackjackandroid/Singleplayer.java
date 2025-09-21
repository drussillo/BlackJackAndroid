package com.example.blackjackandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Singleplayer extends AppCompatActivity {

    PlayerCurrency player1 = new PlayerCurrency("Player 1", 0, 0);

    private Button button;
    private Button button2;
    private TextView dollarsSingleplayer;
    private TextView chipsSingleplayer;
    private VideoView normalModeTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        // Buttons

        button = (button) = findViewById(R.id.Normal);
        button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNormal();
            }
        });
        button2 = (button2) = findViewById(R.id.BackToMain);
        button2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // Video

        normalModeTransition = (normalModeTransition) = findViewById(R.id.normalModeTransition);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.normalmodetransition;
        Uri uri = Uri.parse(videoPath);
        normalModeTransition.setVideoURI(uri);
        normalModeTransition.setVisibility(View.GONE);

        try {
            player1.readCurrency(getExternalFilesDir("/Currency")+"/Dollars.txt", getExternalFilesDir("/Currency")+"/Chips.txt", player1);
        } catch (IOException e) {
            e.printStackTrace();
        }


        dollarsSingleplayer = (dollarsSingleplayer) = findViewById(R.id.dollarsSingleplayer);
        dollarsSingleplayer.setText("$"+player1.getDollars());
        chipsSingleplayer = (chipsSingleplayer) = findViewById(R.id.chipsSingleplayer);
        chipsSingleplayer.setText("₡"+player1.getChips());
    }

    public void openNormal() {
        normalModeTransition.start();
        normalModeTransition.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        dollarsSingleplayer.setVisibility(View.GONE);
        chipsSingleplayer.setVisibility(View.GONE);

        Intent intent = new Intent(this, NormalMode.class);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
            }
        }, 2000);
    }

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }
}