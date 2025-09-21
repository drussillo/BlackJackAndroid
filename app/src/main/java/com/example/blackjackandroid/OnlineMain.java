package com.example.blackjackandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OnlineMain extends AppCompatActivity {
    public Button backToMulti;
    public Button createOnline;
    public Button joinOnline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    backToMulti = (backToMulti) = findViewById(R.id.backToMulti);
    backToMulti.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            backToMulti();
        }
    });
    createOnline = (createOnline) = findViewById(R.id.createOnline);
    createOnline.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            createOnline();
        }
    });
    joinOnline = (joinOnline) = findViewById(R.id.joinOnline);
    joinOnline.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) { joinOnline(); }
    });
    }
    public void backToMulti(){
        Intent intent = new Intent(this, Multiplayer.class);
        startActivity(intent);
        finish();
        overridePendingTransition(0,0);
    }
    public void createOnline(){
        Intent intent = new Intent(this, CreateOnline.class);
        startActivity(intent);
        finish();
        overridePendingTransition(0,0);
    }
    public void joinOnline(){
        Intent intent = new Intent(this, JoinOnline.class);
        startActivity(intent);
        finish();
        overridePendingTransition(0,0);
    }
}