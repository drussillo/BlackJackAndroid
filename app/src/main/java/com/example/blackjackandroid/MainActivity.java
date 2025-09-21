package com.example.blackjackandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.media.MediaPlayer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    PlayerCurrency player1 = new PlayerCurrency("Player 1", 0, 0);

    private Button button;
    private Button buttonMultiplayer;
    private ImageButton cashier;
    private TextView dollars;
    private TextView chips;
    private MediaPlayer backgroundmusic;
    private VideoView cashierTransition;



    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Preparation
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        backgroundmusic = MediaPlayer.create(this, R.raw.maintheme);
        backgroundmusic.setLooping(true);
        backgroundmusic.start();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        // Buttons
        button = (button) = findViewById(R.id.button2);
        button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSingleplayer();
            }
        });

        buttonMultiplayer = (buttonMultiplayer) = findViewById(R.id.buttonMultiplayer);
        buttonMultiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMuliplayer();
            }
        });

        cashier = (cashier) = findViewById(R.id.cashier);
        cashier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCashier();
            }
        });

        //Video

        cashierTransition = (cashierTransition) = findViewById(R.id.cashiertransition);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.cashiertransition;
        Uri uri = Uri.parse(videoPath);
        cashierTransition.setVideoURI(uri);
        cashierTransition.setVisibility(View.GONE);

        // Currency
        try {
            player1.generateDefaultCurrencry(getExternalFilesDir("/Currency")+"/Dollars.txt", 300, getExternalFilesDir("/Currency")+"/Chips.txt", 100);
            player1.readCurrency(getExternalFilesDir("/Currency")+"/Dollars.txt", getExternalFilesDir("/Currency")+"/Chips.txt", player1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TextViews
        dollars = (dollars) = findViewById(R.id.dollars);
        dollars.setText("$"+player1.getDollars());
        chips = (chips) = findViewById(R.id.chips);
        chips.setText("₡"+player1.getChips());
    }


    public void openSingleplayer() {
       Intent intent = new Intent(this, Singleplayer.class);
       startActivity(intent);
       finish();
       overridePendingTransition(0, 0);
    }
    public void openMuliplayer() {
        Intent intent2 = new Intent(this, Multiplayer.class);
        startActivity(intent2);
        finish();
        overridePendingTransition(0, 0);
    }
    public void openCashier() {

        cashierTransition.start();
        cashierTransition.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);
        buttonMultiplayer.setVisibility(View.GONE);
        cashier.setVisibility(View.GONE);
        chips.setVisibility(View.GONE);
        dollars.setVisibility(View.GONE);

        Intent intent = new Intent(this, Cashier.class);
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


        @Override
        public void onClick(View view) {

        }
    }