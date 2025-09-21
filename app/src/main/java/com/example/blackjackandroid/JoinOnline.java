package com.example.blackjackandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JoinOnline extends AppCompatActivity {
    public Button backToOnline2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_online);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        backToOnline2 = (backToOnline2) = findViewById(R.id.backToOnline2);
        backToOnline2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToOnline();
            }
        });
    }
    public void backToOnline(){
        Intent intent = new Intent(this, OnlineMain.class);
        startActivity(intent);
        finish();
        overridePendingTransition(0,0);
    }
}