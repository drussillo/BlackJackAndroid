package com.example.blackjackandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.io.IOException;

public class Cashier extends AppCompatActivity {

    private TextView change;
    private TextView dollarsCashier;
    private TextView chipsCashier;
    private Button backButtonCashier;
    private Button convert;
    private Button confirm;
    private ImageButton chipsToDollars;
    private ImageButton dollarsToChips;
    private ImageButton change5;
    private ImageButton change20;
    private ImageButton change50;
    private ImageButton change200;
    private ImageButton change1000;
    private ImageButton change50000;
    private ImageButton adbutton;
    private VideoView cashierToMain;
    private int changeAmount;
    private int changeResult;
    private int change5idChips;
    private int change20idChips;
    private int change50idChips;
    private int change200idChips;
    private int change1000idChips;
    private int change50000idChips;
    private int change5idDollars;
    private int change20idDollars;
    private int change50idDollars;
    private int change200idDollars;
    private int change1000idDollars;
    private int change50000idDollars;
    private boolean changeType; // true => dollar -> chips // false => chips -> dollars
//            10 >> /
//            10 ---> 100 50%
//            105 ---> 500 30%
//            505 ----> 1000 20%
//            1005 ----> 10000 10%
//            10005 << 5%

    PlayerCurrency player1 = new PlayerCurrency("Player 1", 0, 0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier);

        // Preparations
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        try {
            player1.readCurrency(getExternalFilesDir("/Currency")+"/Dollars.txt", getExternalFilesDir("/Currency")+"/Chips.txt", player1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TextViews
        change = (change) = findViewById(R.id.change);
        change.setVisibility(View.GONE);
        dollarsCashier = (dollarsCashier) = findViewById(R.id.dollarsCashier);
        dollarsCashier.setText("$"+player1.getDollars());
        chipsCashier = (chipsCashier) = findViewById(R.id.chipsChashier);
        chipsCashier.setText("₡"+player1.getChips());

        // Video
        cashierToMain = (cashierToMain) = findViewById(R.id.cashierToMain);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.casheirtomain;
        Uri uri = Uri.parse(videoPath);
        cashierToMain.setVideoURI(uri);
        cashierToMain.setVisibility(View.GONE);

        // ImageViews
        change5idChips = getResources().getIdentifier("c5set1", "mipmap", this.getPackageName());
        change20idChips = getResources().getIdentifier("c20set1", "mipmap", this.getPackageName());
        change50idChips = getResources().getIdentifier("c50set1", "mipmap", this.getPackageName());
        change200idChips = getResources().getIdentifier("c200set1", "mipmap", this.getPackageName());
        change1000idChips = getResources().getIdentifier("c1000set1", "mipmap", this.getPackageName());
        change50000idChips = getResources().getIdentifier("c50000set1", "mipmap", this.getPackageName());

        change5idDollars = getResources().getIdentifier("d5set1", "mipmap", this.getPackageName());
        change20idDollars = getResources().getIdentifier("d20set1", "mipmap", this.getPackageName());
        change50idDollars = getResources().getIdentifier("d50set1", "mipmap", this.getPackageName());
        change200idDollars = getResources().getIdentifier("d200set1", "mipmap", this.getPackageName());
        change1000idDollars = getResources().getIdentifier("d1000set1", "mipmap", this.getPackageName());
        change50000idDollars = getResources().getIdentifier("d50000set1", "mipmap", this.getPackageName());

        // Buttons
        backButtonCashier = (backButtonCashier) = findViewById(R.id.backButtonCashier);
        backButtonCashier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });

        adbutton = (adbutton) = findViewById(R.id.adbutton);
        adbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    player1.writeDollars(player1.getDollars() + 30, getExternalFilesDir("/Currency")+"/Dollars.txt");
                    player1.readDollars(getExternalFilesDir("/Currency")+"/Dollars.txt", player1);
                    dollarsCashier.setText("$"+player1.getDollars());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chipsToDollars = (chipsToDollars) = findViewById(R.id.chipsToDollars);
        chipsToDollars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeType = false;
                changeAmount = 0;
                change.setTextSize(30);
                change.setText("₡0");
                dollarsCashier.setText("$"+player1.getDollars());
                chipsCashier.setText("₡"+player1.getChips());
                change.setVisibility(View.VISIBLE);
                change5.setImageResource(change5idChips);
                change5.setVisibility(View.VISIBLE);
                change20.setImageResource(change20idChips);
                change20.setVisibility(View.VISIBLE);
                change50.setImageResource(change50idChips);
                change50.setVisibility(View.VISIBLE);
                change200.setImageResource(change200idChips);
                change200.setVisibility(View.VISIBLE);
                change1000.setImageResource(change1000idChips);
                change1000.setVisibility(View.VISIBLE);
                change50000.setImageResource(change50000idChips);
                change50000.setVisibility(View.VISIBLE);
                convert.setVisibility(View.VISIBLE);
                confirm.setVisibility(View.GONE);
            }
        });

        dollarsToChips = (dollarsToChips) = findViewById(R.id.dollarsToChips);
        dollarsToChips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeType = true;
                changeAmount = 0;
                change.setTextSize(30);
                change.setText("$0");
                chipsCashier.setText("₡"+player1.getChips());
                dollarsCashier.setText("$"+player1.getDollars());
                change.setVisibility(View.VISIBLE);
                change5.setImageResource(change5idDollars);
                change5.setVisibility(View.VISIBLE);
                change20.setImageResource(change20idDollars);
                change20.setVisibility(View.VISIBLE);
                change50.setImageResource(change50idDollars);
                change50.setVisibility(View.VISIBLE);
                change200.setImageResource(change200idDollars);
                change200.setVisibility(View.VISIBLE);
                change1000.setImageResource(change1000idDollars);
                change1000.setVisibility(View.VISIBLE);
                change50000.setImageResource(change50000idDollars);
                change50000.setVisibility(View.VISIBLE);
                convert.setVisibility(View.VISIBLE);
                confirm.setVisibility(View.GONE);
            }
        });

        convert = (convert) = findViewById(R.id.convert);
        convert.setVisibility(View.GONE);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeType == true && changeAmount > 0) {
                    if (changeAmount >= 10 && changeAmount <= 100 && changeAmount % 2 == 0) {
                        changeResult = changeAmount / 2;
                        change.setTextSize(15);
                        change.setText("$" + changeAmount + " => ₡" + changeResult + "\n 50% tax");
                        dollarsCashier.setText("$"+(player1.getDollars() - changeAmount));
                        chipsCashier.setText("₡"+(player1.getChips()+changeResult));
                        convert.setVisibility(View.GONE);
                        confirm.setVisibility(View.VISIBLE);
                        change5.setVisibility(View.GONE);
                        change20.setVisibility(View.GONE);
                        change50.setVisibility(View.GONE);
                        change200.setVisibility(View.GONE);
                        change1000.setVisibility(View.GONE);
                        change50000.setVisibility(View.GONE);
                    } else if (changeAmount >= 105 && changeAmount <= 500 && changeAmount * 0.3 % 5 == 0) {
                        changeResult = (int) (changeAmount * 0.7);
                        change.setTextSize(15);
                        change.setText("$" + changeAmount + " => ₡" + changeResult + "\n 30% tax");
                        dollarsCashier.setText("$"+(player1.getDollars() - changeAmount));
                        chipsCashier.setText("₡"+(player1.getChips()+changeResult));
                        convert.setVisibility(View.GONE);
                        confirm.setVisibility(View.VISIBLE);
                        change5.setVisibility(View.GONE);
                        change20.setVisibility(View.GONE);
                        change50.setVisibility(View.GONE);
                        change200.setVisibility(View.GONE);
                        change1000.setVisibility(View.GONE);
                        change50000.setVisibility(View.GONE);
                    } else if (changeAmount >= 505 && changeAmount <= 1000 && changeAmount * 0.2 % 5 == 0) {
                        changeResult = (int) (changeAmount * 0.8);
                        change.setTextSize(15);
                        change.setText("$" + changeAmount + " => ₡" + changeResult + "\n 20% tax");
                        dollarsCashier.setText("$"+(player1.getDollars() - changeAmount));
                        chipsCashier.setText("₡"+(player1.getChips()+changeResult));
                        convert.setVisibility(View.GONE);
                        confirm.setVisibility(View.VISIBLE);
                        change5.setVisibility(View.GONE);
                        change20.setVisibility(View.GONE);
                        change50.setVisibility(View.GONE);
                        change200.setVisibility(View.GONE);
                        change1000.setVisibility(View.GONE);
                        change50000.setVisibility(View.GONE);
                    } else if (changeAmount >= 1005 && changeAmount <= 10000 && changeAmount * 0.1 % 5 == 0) {
                        changeResult = (int) (changeAmount * 0.9);
                        change.setTextSize(15);
                        change.setText("$" + changeAmount + " => ₡" + changeResult + "\n 10% tax");
                        dollarsCashier.setText("$"+(player1.getDollars() - changeAmount));
                        chipsCashier.setText("₡"+(player1.getChips()+changeResult));
                        convert.setVisibility(View.GONE);
                        confirm.setVisibility(View.VISIBLE);
                        change5.setVisibility(View.GONE);
                        change20.setVisibility(View.GONE);
                        change50.setVisibility(View.GONE);
                        change200.setVisibility(View.GONE);
                        change1000.setVisibility(View.GONE);
                        change50000.setVisibility(View.GONE);
                    } else if (changeAmount >= 10005 && changeAmount * 0.05 % 5 == 0) {
                        changeResult = (int) (changeAmount * 0.95);
                        change.setTextSize(15);
                        change.setText("$" + changeAmount + " => ₡" + changeResult + "\n 5% tax");
                        dollarsCashier.setText("$"+(player1.getDollars() - changeAmount));
                        chipsCashier.setText("₡"+(player1.getChips()+changeResult));
                        convert.setVisibility(View.GONE);
                        confirm.setVisibility(View.VISIBLE);
                        change5.setVisibility(View.GONE);
                        change20.setVisibility(View.GONE);
                        change50.setVisibility(View.GONE);
                        change200.setVisibility(View.GONE);
                        change1000.setVisibility(View.GONE);
                        change50000.setVisibility(View.GONE);
                    } else {
                        change.setTextSize(20);
                        change.setText("Invalid Change");
                    }
                } else if (changeType == false && changeAmount > 0) {
                    if (changeAmount >= 10 && changeAmount <= 100 && changeAmount % 2 == 0) {
                        changeResult = changeAmount / 2;
                        change.setTextSize(15);
                        change.setText("₡" + changeAmount + " => $" + changeResult + "\n 50% tax");
                        chipsCashier.setText("₡"+(player1.getChips() - changeAmount));
                        dollarsCashier.setText("$"+(player1.getDollars()+changeResult));
                        convert.setVisibility(View.GONE);
                        confirm.setVisibility(View.VISIBLE);
                        change5.setVisibility(View.GONE);
                        change20.setVisibility(View.GONE);
                        change50.setVisibility(View.GONE);
                        change200.setVisibility(View.GONE);
                        change1000.setVisibility(View.GONE);
                        change50000.setVisibility(View.GONE);
                    } else if (changeAmount >= 105 && changeAmount <= 500 && changeAmount * 0.3 % 5 == 0) {
                        changeResult = (int) (changeAmount * 0.7);
                        change.setTextSize(15);
                        change.setText("₡" + changeAmount + " => $" + changeResult + "\n 30% tax");
                        chipsCashier.setText("₡"+(player1.getChips() - changeAmount));
                        dollarsCashier.setText("$"+(player1.getDollars()+changeResult));
                        convert.setVisibility(View.GONE);
                        confirm.setVisibility(View.VISIBLE);
                        change5.setVisibility(View.GONE);
                        change20.setVisibility(View.GONE);
                        change50.setVisibility(View.GONE);
                        change200.setVisibility(View.GONE);
                        change1000.setVisibility(View.GONE);
                        change50000.setVisibility(View.GONE);
                    } else if (changeAmount >= 505 && changeAmount <= 1000 && changeAmount * 0.2 % 5 == 0) {
                        changeResult = (int) (changeAmount * 0.8);
                        change.setTextSize(15);
                        change.setText("₡" + changeAmount + " => $" + changeResult + "\n 20% tax");
                        chipsCashier.setText("₡"+(player1.getChips() - changeAmount));
                        dollarsCashier.setText("$"+(player1.getDollars()+changeResult));
                        convert.setVisibility(View.GONE);
                        confirm.setVisibility(View.VISIBLE);
                        change5.setVisibility(View.GONE);
                        change20.setVisibility(View.GONE);
                        change50.setVisibility(View.GONE);
                        change200.setVisibility(View.GONE);
                        change1000.setVisibility(View.GONE);
                        change50000.setVisibility(View.GONE);
                    } else if (changeAmount >= 1005 && changeAmount <= 10000 && changeAmount * 0.1 % 5 == 0) {
                        changeResult = (int) (changeAmount * 0.9);
                        change.setTextSize(15);
                        change.setText("₡" + changeAmount + " => $" + changeResult + "\n 10% tax");
                        chipsCashier.setText("₡"+(player1.getChips() - changeAmount));
                        dollarsCashier.setText("$"+(player1.getDollars()+changeResult));
                        convert.setVisibility(View.GONE);
                        confirm.setVisibility(View.VISIBLE);
                        change5.setVisibility(View.GONE);
                        change20.setVisibility(View.GONE);
                        change50.setVisibility(View.GONE);
                        change200.setVisibility(View.GONE);
                        change1000.setVisibility(View.GONE);
                        change50000.setVisibility(View.GONE);
                    } else if (changeAmount >= 10005 && changeAmount * 0.05 % 5 == 0) {
                        changeResult = (int) (changeAmount * 0.95);
                        change.setTextSize(15);
                        change.setText("₡" + changeAmount + " => $" + changeResult + "\n 5% tax");
                        chipsCashier.setText("₡"+(player1.getChips() - changeAmount));
                        dollarsCashier.setText("$"+(player1.getDollars()+changeResult));
                        convert.setVisibility(View.GONE);
                        confirm.setVisibility(View.VISIBLE);
                        change5.setVisibility(View.GONE);
                        change20.setVisibility(View.GONE);
                        change50.setVisibility(View.GONE);
                        change200.setVisibility(View.GONE);
                        change1000.setVisibility(View.GONE);
                        change50000.setVisibility(View.GONE);
                    } else {
                        change.setTextSize(20);
                        change.setText("Invalid Change");
                    }
                }
            }
        });

        confirm = (confirm) = findViewById(R.id.confirm);
        confirm.setVisibility(View.GONE);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeType == true) {
                    try {
                        change.setVisibility(View.GONE);
                        confirm.setVisibility(View.GONE);
                        player1.writeDollars(player1.getDollars() - changeAmount, getExternalFilesDir("/Currency")+"/Dollars.txt");
                        player1.writeChips(player1.getChips() + changeResult, getExternalFilesDir("/Currency")+"/Chips.txt");
                        player1.readCurrency(getExternalFilesDir("/Currency")+"/Dollars.txt", getExternalFilesDir("/Currency")+"/Chips.txt", player1);
                        dollarsCashier.setText("$"+player1.getDollars());
                        chipsCashier.setText("₡"+player1.getChips());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        change.setVisibility(View.GONE);
                        confirm.setVisibility(View.GONE);
                        player1.writeChips(player1.getChips() - changeAmount, getExternalFilesDir("/Currency")+"/Chips.txt");
                        player1.writeDollars(player1.getDollars() + changeResult, getExternalFilesDir("/Currency")+"/Dollars.txt");
                        player1.readCurrency(getExternalFilesDir("/Currency")+"/Dollars.txt", getExternalFilesDir("/Currency")+"/Chips.txt", player1);
                        chipsCashier.setText("₡"+player1.getChips());
                        dollarsCashier.setText("$"+player1.getDollars());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        change5 = (change5) = findViewById(R.id.change5);
        change5.setVisibility(View.GONE);
        change5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeType == true) {
                    if (changeAmount + 5 <= player1.getDollars()) {
                        changeAmount = changeAmount + 5;
                        change.setText("$" + changeAmount);
                    }
                } else {
                    if (changeAmount + 5 <= player1.getChips()) {
                        changeAmount = changeAmount + 5;
                        change.setText("₡" + changeAmount);
                    }
                }
            }
        });

        change20 = (change20) = findViewById(R.id.change20);
        change20.setVisibility(View.GONE);
        change20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeType == true) {
                    if (changeAmount + 20 <= player1.getDollars()){
                        changeAmount = changeAmount + 20;
                        change.setText("$"+changeAmount);
                    }
                } else {
                    if (changeAmount + 20 <= player1.getChips()){
                        changeAmount = changeAmount + 20;
                        change.setText("₡"+changeAmount);
                    }
                }
            }
        });

        change50 = (change50) = findViewById(R.id.change50);
        change50.setVisibility(View.GONE);
        change50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeType == true) {
                    if (changeAmount + 50 <= player1.getDollars()){
                        changeAmount = changeAmount + 50;
                        change.setText("$"+changeAmount);
                    }
                } else {
                    if (player1.getChips() > 50 && changeAmount + 50 <= player1.getChips()){
                        changeAmount = changeAmount + 50;
                        change.setText("₡"+changeAmount);
                    }
                }


            }
        });

        change200 = (change200) = findViewById(R.id.change200);
        change200.setVisibility(View.GONE);
        change200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeType == true) {
                    if (changeAmount + 200 <= player1.getDollars()){
                        changeAmount = changeAmount + 200;
                        change.setText("$"+changeAmount);
                    }
                } else {
                    if (player1.getChips() > 200 && changeAmount + 200 <= player1.getChips()){
                        changeAmount = changeAmount + 200;
                        change.setText("₡"+changeAmount);
                    }
                }


            }
        });

        change1000 = (change1000) = findViewById(R.id.change1000);
        change1000.setVisibility(View.GONE);
        change1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeType == true) {
                    if (changeAmount + 1000 <= player1.getDollars()){
                        changeAmount = changeAmount + 1000;
                        change.setText("$"+changeAmount);
                    }
                } else {
                    if (player1.getChips() > 1000 && changeAmount + 1000 <= player1.getChips()){
                        changeAmount = changeAmount + 1000;
                        change.setText("₡"+changeAmount);
                    }
                }


            }
        });

        change50000 = (change50000) = findViewById(R.id.change50000);
        change50000.setVisibility(View.GONE);
        change50000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changeType == true) {
                    if (changeAmount + 50000 <= player1.getDollars()){
                        changeAmount = changeAmount + 50000;
                        change.setText("$"+changeAmount);
                    }
                } else {
                    if (player1.getChips() > 50000 && changeAmount + 50000 <= player1.getChips()){
                        changeAmount = changeAmount + 50000;
                        change.setText("₡"+changeAmount);
                    }
                }
            }
        });
    }

    public void backToMain() {
        cashierToMain.start();
        cashierToMain.setVisibility(View.VISIBLE);
        backButtonCashier.setVisibility(View.GONE);
        dollarsCashier.setVisibility(View.GONE);
        chipsCashier.setVisibility(View.GONE);
        dollarsToChips.setVisibility(View.GONE);
        chipsToDollars.setVisibility(View.GONE);
        adbutton.setVisibility(View.GONE);
        convert.setVisibility(View.GONE);

        ImageView chipsIconCashier = (chipsIconCashier) = findViewById(R.id.chipsIconCashier);
        chipsIconCashier.setVisibility(View.GONE);

        Intent intent = new Intent(this, MainActivity.class);
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
}