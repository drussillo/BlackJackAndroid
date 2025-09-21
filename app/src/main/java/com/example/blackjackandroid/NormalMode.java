package com.example.blackjackandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class NormalMode extends AppCompatActivity {

    PlayerCurrency player1 = new PlayerCurrency("Player 1", 0, 0);

    private ArrayList<Card> cardArrayList = new ArrayList<>();
    private Button placeBet;
    private Button resetBet;
    private Button backButton;
    private Button clearTest;
    private Button standButton;
    private Button doubleButton;
    private Button splitButton;
    private Button hitButton;
    private Button hitButton2;
    private Button hitButton3;
    private Button hitButton4;
    private Button hitButton5;
    private Button hitButton6;
    private TextView loseMessage;
    private TextView loseMessageR;
    private TextView loseMessageL;
    private TextView winMessage;
    private TextView winMessageR;
    private TextView winMessageL;
    private TextView pushMessage;
    private TextView pushMessageR;
    private TextView pushMessageL;
    private TextView blackjackMessage;
    private TextView blackjackMessageR;
    private TextView blackjackMessageL;
    private TextView dealerCount;
    private TextView playerCount;
    private TextView playerCountR;
    private TextView playerCountL;
    private TextView dollarsNormalMode;
    private TextView chipsNormalMode;
    private TextView bet;
    private ImageButton c5;
    private ImageButton c20;
    private ImageButton c50;
    private ImageButton c200;
    private ImageButton c1000;
    private ImageButton c50000;
    private VideoView normalToSingleplayer;
    private int dealerPoints1;
    private int dealerPoints2;
    private int playerPoints1;
    private int playerPoints2;
    private int deckRvalue;
    private int deckRvalue2;
    private int deckLvalue;
    private int deckLvalue2;
    private int betMoney = 0;
    private int betMoneySplitR = 0;
    private int betMoneySplitL = 0;
    private int winState; // -1 = in progress, 0 = lose, 1 = win, 2 = Push, 3 = blackjack
    private boolean doubleddown = false; // Has the player doubled down?
    private int winStateR; // 0 = lose, 1 = win, 2 = Push, 3 = blackjack
    private int winStateL;
    private int durationdyn;
    private boolean third = false;
    private boolean fourth = false;
    private boolean fifth = false;
    private boolean sixth = false;
    private boolean seventh = false;
    private boolean eight = false;
    private String dealerPointsTemp1;
    private String dealerPointsTemp2;
    private String dealerPointsTemp3;
    private String dealerPointsTemp4;
    private String dealerPointsTemp5;
    private String dealerPointsTemp6;
    private boolean doubleddownR = false;
    private boolean doubleddownL = false;
    // Create all Card Objects
    Card clubsAce = new Card(1, 11, "aceclubs", "backgroundbasic");
    Card diamondsAce = new Card(1, 11, "acediamonds", "backgroundbasic");
    Card heartsAce = new Card(1, 11, "acehearts", "backgroundbasic");
    Card spadesAce = new Card(1, 11, "acespades", "backgroundbasic");

    Card clubsTwo = new Card(2, 0, "twoclubs", "backgroundbasic");
    Card diamondsTwo = new Card(2, 0, "twodiamonds", "backgroundbasic");
    Card heartsTwo = new Card(2,0,"twohearts", "backgroundbasic");
    Card spadesTwo = new Card(2, 0,"twospades","backgroudnbasic");

    Card clubsThree = new Card(3,0,"threeclubs","backgroundbasic");
    Card diamondsThree = new Card(3,0,"threediamonds","backgroundbasic");
    Card heartsThree = new Card(3,0,"threehearts","backgroundbasic");
    Card spadesThree = new Card(3,0,"threespades","backgroudnbasic");

    Card clubsFour = new Card(4,0,"fourclubs", "backgroundbasic");
    Card diamondsFour = new Card(4,0,"fourdiamonds","backgroundbasic");
    Card heartsFour = new Card(4,0,"fourhearts","backgroundbasic");
    Card spadesFour = new Card(4,0,"fourspades","backgroundbasic");

    Card clubsFive = new Card(5,0,"fiveclubs","backgroundbasic");
    Card diamondsFive = new Card(5,0,"fivediamonds","backgroundbasic");
    Card heartsFive = new Card(5,0,"fivehearts","backgroundbasic");
    Card spadesFive = new Card(5,0,"fivespades","backgroundsbasic");

    Card clubsSix = new Card(6,0,"sixclubs","backgroundbasic");
    Card diamondsSix = new Card(6,0,"sixdiamonds","backgroundbasic");
    Card heartsSix = new Card(6,0,"sixhearts","backgroundbasic");
    Card spadesSix = new Card(6,0,"sixspades","backgroundbasic");

    Card clubsSeven = new Card(7,0,"sevenclubs","backgroundbasic");
    Card diamondsSeven = new Card(7,0,"sevendiamonds","backgroundbasic");
    Card heartsSeven = new Card(7,0,"sevenhearts","backgroundbasic");
    Card spadesSeven = new Card(7,0,"sevenspades","backgroundbasic");

    Card clubsEight = new Card(8,0,"eightclubs","backgroundbasic");
    Card diamondsEight = new Card(8,0,"eightdiamonds","backgroundbasic");
    Card heartsEight = new Card(8,0,"eighthearts","backgroundbasic");
    Card spadesEight = new Card(8,0,"eightspades","backgroundbasic");

    Card clubsNine = new Card(9,0,"nineclubs","backgroundbasic");
    Card diamondsNine = new Card(9,0,"ninediamonds","backgroundbasic");
    Card heartsNine = new Card(9,0,"ninehearts","backgroundbasic");
    Card spadesNine = new Card(9,0,"ninespades","backgroundbasic");

    Card clubsTen = new Card(10,0,"tenclubs","backgroundbasic");
    Card diamondsTen = new Card(10,0,"tendiamonds","backgroundbasic");
    Card heartsTen = new Card(10,0,"tenhearts","backgroundbasic");
    Card spadesTen = new Card(10,0,"tenspades","backgroundbasic");

    Card clubsQueen = new Card(10,0,"queenclubs","backgroundbasic");
    Card diamondsQueen = new Card(10,0,"queendiamonds","backgroundbasic");
    Card heartsQueen = new Card(10,0,"queenhearts","backgroundbasic");
    Card spadesQueen = new Card(10,0,"queenspades","backgroundbasic");

    Card clubsJack = new Card(10,0,"jackclubs","backgroundbasic");
    Card diamondsJack = new Card(10,0,"jackdiamonds","backgroundbasic");
    Card heartsJack = new Card(10,0,"jackhearts","backgroundbasic");
    Card spadesJack = new Card(10,0,"jackspades","backgroundbasic");

    Card clubsKing = new Card(10,0,"kingclubs","backgroundbasic");
    Card diamondsKing = new Card(10,0,"kingdiamonds","backgroundbasic");
    Card heartsKing = new Card(10,0,"kinghearts","backgroundbasic");
    Card spadesKing = new Card(10,0,"kingspades","backgroundbasic");

    // TEMPLATE FOR NEW CARDS:      Card  = new Card(,,"","");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_mode);
        // Preparing...
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        buildDeck();
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // TextViews
        loseMessage = (loseMessage) = findViewById(R.id.loseMessage);
        loseMessageR = (loseMessageR) = findViewById(R.id.loseMessageR);
        loseMessageL = (loseMessageL) = findViewById(R.id.loseMessageL);
        winMessage = (winMessage) = findViewById(R.id.winMessage);
        winMessageR = (winMessageR) = findViewById(R.id.winMessageR);
        winMessageL = (winMessageL) = findViewById(R.id.winMessageL);
        pushMessage = (pushMessage) = findViewById(R.id.pushMessage);
        pushMessageR = (pushMessageR) = findViewById(R.id.pushMessageR);
        pushMessageL = (pushMessageL) = findViewById(R.id.pushMessageL);
        blackjackMessage = (blackjackMessage) = findViewById(R.id.blackjackMessage);
        blackjackMessageR = (blackjackMessageR) = findViewById(R.id.blackjackMessageR);
        blackjackMessageL = (blackjackMessageL) = findViewById(R.id.blackjackMessageL);
        dealerCount = (dealerCount) = findViewById(R.id.delaerCount);
        playerCount = (playerCount) = findViewById(R.id.playerCount);
        playerCountR = (playerCountR) = findViewById(R.id.playerCountR);
        playerCountL = (playerCountL) = findViewById(R.id.playerCountL);
        dollarsNormalMode = (dollarsNormalMode) = findViewById(R.id.dollarsNormalMode);
        chipsNormalMode = (chipsNormalMode) = findViewById(R.id.chipsNormalMode);
        bet = (bet) = findViewById(R.id.bet);

        loseMessage.setVisibility(View.GONE);
        loseMessageR.setVisibility(View.GONE);
        loseMessageL.setVisibility(View.GONE);
        winMessage.setVisibility(View.GONE);
        winMessageR.setVisibility(View.GONE);
        winMessageL.setVisibility(View.GONE);
        pushMessage.setVisibility(View.GONE);
        pushMessageR.setVisibility(View.GONE);
        pushMessageL.setVisibility(View.GONE);
        blackjackMessage.setVisibility(View.GONE);
        blackjackMessageR.setVisibility(View.GONE);
        blackjackMessageL.setVisibility(View.GONE);
        dealerCount.setVisibility(View.GONE);
        playerCount.setVisibility(View.GONE);
        playerCountR.setVisibility(View.GONE);
        playerCountL.setVisibility(View.GONE);
        bet.setText("₡"+betMoney);
        ImageView selected1 = (ImageView) findViewById(R.id.selectedR);
        selected1.setVisibility(View.GONE);
        ImageView selected2 = (ImageView) findViewById(R.id.selectedL);
        selected2.setVisibility(View.GONE);

        try {
            player1.readCurrency(getExternalFilesDir("/Currency")+"/Dollars.txt", getExternalFilesDir("/Currency")+"/Chips.txt", player1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        dollarsNormalMode.setText("$"+player1.getDollars());
        chipsNormalMode.setText("₡"+player1.getChips());

        // Video
        normalToSingleplayer = (normalToSingleplayer) = findViewById(R.id.normalToSingleplayer);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.normaltosingleplayer;
        Uri uri = Uri.parse(videoPath);
        normalToSingleplayer.setVideoURI(uri);
        normalToSingleplayer.setVisibility(View.GONE);

        // Buttons
        c5 = (c5) = findViewById(R.id.c5);
        c5.setVisibility(View.VISIBLE);
        c20 = (c20) = findViewById(R.id.c20);
        c20.setVisibility(View.VISIBLE);
        c50 = (c50) = findViewById(R.id.c50);
        c50.setVisibility(View.VISIBLE);
        c200 = (c200) = findViewById(R.id.c200);
        c200.setVisibility(View.VISIBLE);
        c1000 = (c1000) = findViewById(R.id.c1000);
        c1000.setVisibility(View.VISIBLE);
        c50000 = (c50000) = findViewById(R.id.c50000);
        c50000.setVisibility(View.VISIBLE);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player1.getChips() >= betMoney+5){
                    betMoney = betMoney + 5;
                    bet.setText("₡"+betMoney);
                }
            }
        });
        c20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player1.getChips() >= betMoney+20){
                    betMoney = betMoney + 20;
                    bet.setText("₡"+betMoney);
                }
            }
        });
        c50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player1.getChips() >= betMoney+50){
                    betMoney = betMoney + 50;
                    bet.setText("₡"+betMoney);
                }
            }
        });
        c200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player1.getChips() >= betMoney+200){
                    betMoney = betMoney + 200;
                    bet.setText("₡"+betMoney);
                }
            }
        });
        c1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player1.getChips() >= betMoney+1000){
                    betMoney = betMoney + 1000;
                    bet.setText("₡"+betMoney);
                }
            }
        });
        c50000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player1.getChips() >= betMoney+50000){
                    betMoney = betMoney + 50000;
                    bet.setText("₡"+betMoney);
                }
            }
        });


        placeBet = (placeBet) = findViewById(R.id.placeBet);
        placeBet.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (betMoney > 0) {
                    player1.setChips(player1.getChips() - betMoney);
                    try {
                        player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency") + "/Chips.txt");
                        chipsNormalMode.setText("₡" + player1.getChips());
                        placeBets();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        resetBet = (resetBet) = findViewById(R.id.resetBet);
        resetBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                betMoney = 0;
                bet.setText("₡"+betMoney);
            }
        });


        backButton = (backButton) = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToSinglePlayer();
            }
        });




        standButton = (standButton) = findViewById(R.id.standButton);
        doubleButton = (doubleButton) = findViewById(R.id.doubleButton);
        splitButton = (splitButton) = findViewById(R.id.splitButton);
        hitButton = (hitButton) = findViewById(R.id.hitButton);
        hitButton2 = (hitButton2) = findViewById(R.id.hitButton2);
        hitButton3 = (hitButton3) = findViewById(R.id.hitButton3);
        hitButton4 = (hitButton4) = findViewById(R.id.hitButton4);
        hitButton5 = (hitButton5) = findViewById(R.id.hitButton5);
        hitButton6 = (hitButton6) = findViewById(R.id.hitButton6);
        standButton.setVisibility(View.GONE);
        doubleButton.setVisibility(View.GONE);
        splitButton.setVisibility(View.GONE);
        hitButton.setVisibility(View.GONE);
        hitButton2.setVisibility(View.GONE);
        hitButton3.setVisibility(View.GONE);
        hitButton4.setVisibility(View.GONE);
        hitButton5.setVisibility(View.GONE);
        hitButton6.setVisibility(View.GONE);






        // Reset
        clearTest = (clearTest) = findViewById(R.id.cleartest);
        clearTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView card1player= (ImageView) findViewById(R.id.card1player);
                card1player.setImageResource(0);
                card1player.setY(0);
                ImageView card1dealer= (ImageView) findViewById(R.id.card1dealer);
                card1dealer.setImageResource(0);
                card1dealer.setY(0);
                ImageView card2player= (ImageView) findViewById(R.id.card2player);
                card2player.setImageResource(0);
                card2player.setY(0);
                ImageView card2dealer= (ImageView) findViewById(R.id.card2dealer);
                card2dealer.setImageResource(0);
                card2dealer.setY(0);
                ImageView card3dealer= (ImageView) findViewById(R.id.card3dealer);
                card3dealer.setImageResource(0);
                card3dealer.setY(0);
                ImageView card4dealer= (ImageView) findViewById(R.id.card4dealer);
                card4dealer.setImageResource(0);
                card4dealer.setY(0);
                ImageView card5dealer= (ImageView) findViewById(R.id.card5dealer);
                card5dealer.setImageResource(0);
                card5dealer.setY(0);
                ImageView card6dealer= (ImageView) findViewById(R.id.card6dealer);
                card6dealer.setImageResource(0);
                card6dealer.setY(0);
                ImageView card7dealer= (ImageView) findViewById(R.id.card7dealer);
                card7dealer.setImageResource(0);
                card7dealer.setY(0);
                ImageView card8dealer= (ImageView) findViewById(R.id.card8dealer);
                card8dealer.setImageResource(0);
                card8dealer.setY(0);
                ImageView card3player= (ImageView) findViewById(R.id.card3player);
                card3player.setImageResource(0);
                card3player.setY(0);
                ImageView card4player= (ImageView) findViewById(R.id.card4player);
                card4player.setImageResource(0);
                card4player.setY(0);
                ImageView card5player= (ImageView) findViewById(R.id.card5player);
                card5player.setImageResource(0);
                card5player.setY(0);
                ImageView card6player= (ImageView) findViewById(R.id.card6player);
                card6player.setImageResource(0);
                card6player.setY(0);
                ImageView card7player= (ImageView) findViewById(R.id.card7player);
                card7player.setImageResource(0);
                card7player.setY(0);
                ImageView card8player= (ImageView) findViewById(R.id.card8player);
                card8player.setImageResource(0);
                card8player.setY(0);
                ImageView card1splitR= (ImageView) findViewById(R.id.card1splitR);
                card1splitR.setImageResource(0);
                ImageView card2splitR= (ImageView) findViewById(R.id.card2splitR);
                card2splitR.setImageResource(0);
                ImageView card1splitL= (ImageView) findViewById(R.id.card1splitL);
                card1splitL.setImageResource(0);
                ImageView card2splitL= (ImageView) findViewById(R.id.card2splitL);
                card2splitL.setImageResource(0);
                ImageView card3splitR= (ImageView) findViewById(R.id.card3splitR);
                card3splitR.setImageResource(0);
                ImageView card4splitR= (ImageView) findViewById(R.id.card4splitR);
                card4splitR.setImageResource(0);
                ImageView card5splitR= (ImageView) findViewById(R.id.card5splitR);
                card5splitR.setImageResource(0);
                ImageView card6splitR= (ImageView) findViewById(R.id.card6splitR);
                card6splitR.setImageResource(0);
                ImageView selectedR = (ImageView) findViewById(R.id.selectedR);
                selectedR.setVisibility(View.GONE);
                ImageView selectedL = (ImageView) findViewById(R.id.selectedL);
                selectedL.setVisibility(View.GONE);
                placeBet.setVisibility(View.VISIBLE);
                loseMessage.setVisibility(View.GONE);
                loseMessageR.setVisibility(View.GONE);
                loseMessageL.setVisibility(View.GONE);
                winMessage.setVisibility(View.GONE);
                winMessageR.setVisibility(View.GONE);
                winMessageL.setVisibility(View.GONE);
                pushMessage.setVisibility(View.GONE);
                pushMessageR.setVisibility(View.GONE);
                pushMessageL.setVisibility(View.GONE);
                blackjackMessage.setVisibility(View.GONE);
                blackjackMessageR.setVisibility(View.GONE);
                blackjackMessageL.setVisibility(View.GONE);
                standButton.setVisibility(View.GONE);
                doubleButton.setVisibility(View.GONE);
                splitButton.setVisibility(View.GONE);
                hitButton.setVisibility(View.GONE);
                hitButton2.setVisibility(View.GONE);
                hitButton3.setVisibility(View.GONE);
                hitButton4.setVisibility(View.GONE);
                hitButton5.setVisibility(View.GONE);
                hitButton6.setVisibility(View.GONE);
                dealerCount.setVisibility(View.GONE);
                playerCount.setVisibility(View.GONE);
                playerCountL.setVisibility(View.GONE);
                playerCountR.setVisibility(View.GONE);
                betMoney = 0;
                bet.setVisibility(View.VISIBLE);
                resetBet.setVisibility(View.VISIBLE);
                bet.setText("₡"+betMoney);
                c5.setVisibility(View.VISIBLE);
                c20.setVisibility(View.VISIBLE);
                c50.setVisibility(View.VISIBLE);
                c200.setVisibility(View.VISIBLE);
                c1000.setVisibility(View.VISIBLE);
                c50000.setVisibility(View.VISIBLE);
                third = false;
                fourth = false;
                fifth = false;
                sixth = false;
                seventh = false;
                eight = false;
                durationdyn = 0;
            }
        });

    }

    // Start
    protected void placeBets() throws InterruptedException, IOException {
        // Prepare
        c5.setVisibility(View.GONE);
        c20.setVisibility(View.GONE);
        c50.setVisibility(View.GONE);
        c200.setVisibility(View.GONE);
        c1000.setVisibility(View.GONE);
        c50000.setVisibility(View.GONE);
        placeBet.setVisibility(View.GONE);
        resetBet.setVisibility(View.GONE);
        winState = -1;
        dealerPoints1 = 0;
        dealerPoints2 = 0;
        playerPoints1 = 0;
        playerPoints2 = 0;
        dealerCount.setText("00");
        playerCount.setText("00");
        if (cardArrayList.size() <= 18) {
            buildDeck();
        }
        // Place first four cards, initiate other potential cards & activate counters
        int duration = getResources().getInteger(android.R.integer.config_longAnimTime);
        int durationshrt = getResources().getInteger(android.R.integer.config_shortAnimTime);

        ImageView card1player = (ImageView) findViewById(R.id.card1player);
        card1player.setVisibility(View.VISIBLE);
        int card1playerid = getResources().getIdentifier(cardArrayList.get(0).getForeground(), "drawable", this.getPackageName());
        final Handler handler1 = new Handler();handler1.postDelayed(new Runnable() {@Override public void run() {
            ObjectAnimator animation1 = ObjectAnimator.ofFloat(card1player, "translationY", 1025);
            animation1.setDuration(500);
            animation1.start();
            card1player.setAlpha(0f);
            card1player.setImageResource(card1playerid);
            card1player.animate().alpha(1f).setDuration(duration).setListener(null);
        }}, 0);

        ImageView card1dealer = (ImageView) findViewById(R.id.card1dealer);
        card1dealer.setVisibility(View.VISIBLE);
        int card1dealerid = getResources().getIdentifier(cardArrayList.get(1).getForeground(), "drawable", this.getPackageName());
        final Handler handler2 = new Handler();handler2.postDelayed(new Runnable() {@Override public void run() {
            ObjectAnimator animation2 = ObjectAnimator.ofFloat(card1dealer, "translationY", 235);
            animation2.setDuration(500);
            animation2.start();
            card1dealer.setAlpha(0f);
            card1dealer.setImageResource(R.drawable.backgroundbasic);
            card1dealer.animate().alpha(1f).setDuration(duration).setListener(null);
        }}, 500);

        ImageView card2player = (ImageView) findViewById(R.id.card2player);
        card2player.setVisibility(View.VISIBLE);
        int card2playerid = getResources().getIdentifier(cardArrayList.get(2).getForeground(), "drawable", this.getPackageName());
        final Handler handler3 = new Handler();handler3.postDelayed(new Runnable() {@Override public void run() {
            ObjectAnimator animation3 = ObjectAnimator.ofFloat(card2player, "translationY", 1025);
            animation3.setDuration(500);
            animation3.start();
            card2player.setAlpha(0f);
            card2player.setImageResource(card2playerid);
            card2player.animate().alpha(1f).setDuration(duration).setListener(null);
        }}, 1000);

        ImageView card2dealer = (ImageView) findViewById(R.id.card2dealer);
        card2dealer.setVisibility(View.VISIBLE);
        int card2dealerid = getResources().getIdentifier(cardArrayList.get(3).getForeground(), "drawable", this.getPackageName());
        final Handler handler4 = new Handler();handler4.postDelayed(new Runnable() {@Override public void run() {
            ObjectAnimator animation4 = ObjectAnimator.ofFloat(card2dealer, "translationY", 235);
            animation4.setDuration(500);
            animation4.start();
            card2dealer.setAlpha(0f);
            card2dealer.setImageResource(card2dealerid);
            card2dealer.animate().alpha(1f).setDuration(duration).setListener(null);
        }}, 1500);

        ImageView card3dealer = (ImageView) findViewById(R.id.card3dealer);
        card3dealer.setVisibility(View.VISIBLE);
        int card3dealerid = getResources().getIdentifier(cardArrayList.get(4).getForeground(), "drawable", this.getPackageName());

        ImageView card4dealer = (ImageView) findViewById(R.id.card4dealer);
        card4dealer.setVisibility(View.VISIBLE);
        int card4dealerid = getResources().getIdentifier(cardArrayList.get(5).getForeground(), "drawable", this.getPackageName());

        ImageView card5dealer = (ImageView) findViewById(R.id.card5dealer);
        card5dealer.setVisibility(View.VISIBLE);
        int card5dealerid = getResources().getIdentifier(cardArrayList.get(6).getForeground(), "drawable", this.getPackageName());

        ImageView card6dealer = (ImageView) findViewById(R.id.card6dealer);
        card6dealer.setVisibility(View.VISIBLE);
        int card6dealerid = getResources().getIdentifier(cardArrayList.get(7).getForeground(), "drawable", this.getPackageName());

        ImageView card7dealer = (ImageView) findViewById(R.id.card7dealer);
        card7dealer.setVisibility(View.VISIBLE);
        int card7dealerid = getResources().getIdentifier(cardArrayList.get(8).getForeground(), "drawable", this.getPackageName());

        ImageView card8dealer = (ImageView) findViewById(R.id.card8dealer);
        card8dealer.setVisibility(View.VISIBLE);
        int card8dealerid = getResources().getIdentifier(cardArrayList.get(9).getForeground(), "drawable", this.getPackageName());

        ImageView card3player = (ImageView) findViewById(R.id.card3player);
        card3player.setVisibility(View.VISIBLE);
        int card3playerid = getResources().getIdentifier(cardArrayList.get(10).getForeground(), "drawable", this.getPackageName());

        ImageView card4player = (ImageView) findViewById(R.id.card4player);
        card4player.setVisibility(View.VISIBLE);
        int card4playerid = getResources().getIdentifier(cardArrayList.get(11).getForeground(), "drawable", this.getPackageName());

        ImageView card5player = (ImageView) findViewById(R.id.card5player);
        card5player.setVisibility(View.VISIBLE);
        int card5playerid = getResources().getIdentifier(cardArrayList.get(12).getForeground(), "drawable", this.getPackageName());

        ImageView card6player = (ImageView) findViewById(R.id.card6player);
        card6player.setVisibility(View.VISIBLE);
        int card6playerid = getResources().getIdentifier(cardArrayList.get(13).getForeground(), "drawable", this.getPackageName());

        ImageView card7player = (ImageView) findViewById(R.id.card7player);
        card7player.setVisibility(View.VISIBLE);
        int card7playerid = getResources().getIdentifier(cardArrayList.get(14).getForeground(), "drawable", this.getPackageName());

        ImageView card8player = (ImageView) findViewById(R.id.card8player);
        card8player.setVisibility(View.VISIBLE);
        int card8playerid = getResources().getIdentifier(cardArrayList.get(15).getForeground(), "drawable", this.getPackageName());

        // Split button cards
        ImageView card1splitR = (ImageView) findViewById(R.id.card1splitR);
        card1splitR.setVisibility(View.VISIBLE);
        int card1splitRid = card2playerid;

        ImageView card1splitL = (ImageView) findViewById(R.id.card1splitL);
        card1splitL.setVisibility(View.VISIBLE);
        int card1splitLid = card1playerid;

        ImageView card2splitR = (ImageView) findViewById(R.id.card2splitR);
        card2splitR.setVisibility(View.VISIBLE);
        int card2splitRid = card4playerid;

        ImageView card2splitL = (ImageView) findViewById(R.id.card2splitL);
        card2splitL.setVisibility(View.VISIBLE);
        int card2splitLid = card3playerid;

        ImageView card3splitR = (ImageView) findViewById(R.id.card3splitR);
        card3splitR.setVisibility(View.VISIBLE);
        int card3splitRid = card5playerid;

        ImageView card4splitR = (ImageView) findViewById(R.id.card4splitR);
        card4splitR.setVisibility(View.VISIBLE);
        int card4splitRid = card6playerid;

        ImageView card5splitR = (ImageView) findViewById(R.id.card5splitR);
        card4splitR.setVisibility(View.VISIBLE);
        int card5splitRid = card7playerid;

        ImageView card6splitR = (ImageView) findViewById(R.id.card6splitR);
        card4splitR.setVisibility(View.VISIBLE);
        int card6splitRid = card8playerid;

        // Put cards in generic Card objects & remove them from Arraylist
        Card drawnCard1 = cardArrayList.get(0);
        Card drawnCard2 = cardArrayList.get(1);
        Card drawnCard3 = cardArrayList.get(2);
        Card drawnCard4 = cardArrayList.get(3);
        Card drawnCard05 = cardArrayList.get(4);
        Card drawnCard06 = cardArrayList.get(5);
        Card drawnCard07 = cardArrayList.get(6);
        Card drawnCard08 = cardArrayList.get(7);
        Card drawnCard09 = cardArrayList.get(8);
        Card drawnCard010 = cardArrayList.get(9);
        Card drawnCard5 = cardArrayList.get(10);
        Card drawnCard6 = cardArrayList.get(11);
        Card drawnCard7 = cardArrayList.get(12);
        Card drawnCard8 = cardArrayList.get(13);
        Card drawnCard9 = cardArrayList.get(14);
        Card drawnCard10 = cardArrayList.get(15);
        // Extra for split
        Card drawnCard11 = cardArrayList.get(15);
        Card drawnCard12 = cardArrayList.get(16);
        Card drawnCard13 = cardArrayList.get(17);
        Card drawnCard14 = cardArrayList.get(18);
        cardArrayList.remove(0);
        cardArrayList.remove(1);
        cardArrayList.remove(2);
        cardArrayList.remove(3);

        final Handler handler01 = new Handler();handler01.postDelayed(new Runnable() {@Override public void run() {
            dealerCount.setAlpha(0f);
            playerCount.setAlpha(0f);
            dealerCount.setVisibility(View.VISIBLE);
            playerCount.setVisibility(View.VISIBLE);
            dealerCount.animate().alpha(1f).setDuration(duration).setListener(null);
            playerCount.animate().alpha(1f).setDuration(duration).setListener(null);


        // BlackJack!
        if ((drawnCard1.getValue() + drawnCard3.getValue2() == 21 || drawnCard1.getValue2() + drawnCard3.getValue() == 21) && !(drawnCard2.getValue() + drawnCard4.getValue2() == 21 || drawnCard2.getValue2() + drawnCard4.getValue() == 21)) {
            winState = 3;
            playerCount.setText("21");
            dealerCount.setText("//");
        }
        // Dealer Blackjack!
        else if ((drawnCard2.getValue() + drawnCard4.getValue2() == 21 || drawnCard2.getValue2() + drawnCard4.getValue() == 21) && !(drawnCard1.getValue() + drawnCard3.getValue2() == 21 || drawnCard1.getValue2() + drawnCard3.getValue() == 21)) {
            winState = 0;
            dealerCount.setText("21");
            playerCount.setText("//");
        }
        // Both Player and Dealer got BlackJack!
        else if ((drawnCard1.getValue() + drawnCard3.getValue2() == 21 || drawnCard1.getValue2() + drawnCard3.getValue() == 21) && (drawnCard2.getValue() + drawnCard4.getValue2() == 21 || drawnCard2.getValue2() + drawnCard4.getValue() == 21)) {
            winState = 2;
            playerCount.setText("21");
            dealerCount.setText("21");
        }

        standButton.setAlpha(0f);
        doubleButton.setAlpha(0f);
        hitButton.setAlpha(0f);
        standButton.setVisibility(View.VISIBLE);
        doubleButton.setVisibility(View.VISIBLE);
        hitButton.setVisibility(View.VISIBLE);
        standButton.animate().alpha(1f).setDuration(duration).setListener(null);
        doubleButton.animate().alpha(1f).setDuration(duration).setListener(null);
        hitButton.animate().alpha(1f).setDuration(duration).setListener(null);
        if (drawnCard1.getValue() == drawnCard3.getValue()) {
            splitButton.setAlpha(0f);
            splitButton.setVisibility(View.VISIBLE);
            splitButton.animate().alpha(1f).setDuration(duration).setListener(null);
        }


        // Results/Progression
        if (winState == 0) { // Lose
            card1dealer.animate().alpha(0f).setDuration(durationshrt).setListener(null);
            final Handler handler5 = new Handler();handler5.postDelayed(new Runnable() {@Override public void run() {
                card1dealer.setImageResource(card1dealerid);
                card1dealer.animate().alpha(1f).setDuration(durationshrt).setListener(null);
            }}, durationshrt);
            loseMessage.setAlpha(0f);
            loseMessage.setVisibility(View.VISIBLE);
            loseMessage.animate().alpha(1f).setDuration(duration).setListener(null);
            betMoney = 0;
        } else if (winState == 2) { // Push
            card1dealer.animate().alpha(0f).setDuration(durationshrt).setListener(null);
            final Handler handler5 = new Handler();handler5.postDelayed(new Runnable() {@Override public void run() {
                card1dealer.setImageResource(card1dealerid);
                card1dealer.animate().alpha(1f).setDuration(durationshrt).setListener(null);
            }}, durationshrt);
            pushMessage.setAlpha(0f);
            pushMessage.setVisibility(View.VISIBLE);
            pushMessage.animate().alpha(1f).setDuration(duration).setListener(null);
            player1.setChips(player1.getChips()+betMoney);
            try {
                player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency")+"/Chips.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            chipsNormalMode.setText("₡"+player1.getChips());
        } else if (winState == 3) { // BlackJack
            card1dealer.animate().alpha(0f).setDuration(durationshrt).setListener(null);
            final Handler handler5 = new Handler();handler5.postDelayed(new Runnable() {@Override public void run() {
                card1dealer.setImageResource(card1dealerid);
                card1dealer.animate().alpha(1f).setDuration(durationshrt).setListener(null);
            }}, durationshrt);
            blackjackMessage.setAlpha(0f);
            blackjackMessage.setVisibility(View.VISIBLE);
            blackjackMessage.animate().alpha(1f).setDuration(duration).setListener(null);
            if (betMoney/2 % 5 != 0){
                player1.setChips(player1.getChips()+betMoney*2);
                try {
                    player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency")+"/Chips.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                chipsNormalMode.setText("₡"+player1.getChips());
            }
            else {
                player1.setChips(player1.getChips()+betMoney*2+betMoney/2);
                try {
                    player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency")+"/Chips.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                chipsNormalMode.setText("₡"+player1.getChips());
            }
        } else if (winState == -1) { // In Progress

            // Delaers current number (Ace) calculation
            dealerPoints1 = drawnCard2.getValue() + drawnCard4.getValue();
            if (drawnCard2.getValue2() > 0) {
                dealerPoints2 = drawnCard2.getValue2() + drawnCard4.getValue();
            } else if (drawnCard2.getValue2() == 0 && drawnCard4.getValue2() > 0) {
                dealerPoints2 = drawnCard2.getValue() + drawnCard4.getValue2();
            }

            // Players current number (Ace) calculation
            playerPoints1 = drawnCard1.getValue() + drawnCard3.getValue();
            if (drawnCard1.getValue2() > 0) {
                playerPoints2 = drawnCard1.getValue2() + drawnCard3.getValue();
            } else if (drawnCard1.getValue2() == 0 && drawnCard3.getValue2() > 0) {
                playerPoints2 = drawnCard1.getValue() + drawnCard3.getValue2();
            }

            // Set counters & buttons
            if (drawnCard4.getValue2() > 0) {
                dealerCount.setText(drawnCard4.getValue() + "/" + drawnCard4.getValue2());
            } else {
                dealerCount.setText(drawnCard4.getValue() + "");
            }
            if (playerPoints2 > 0) {
                playerCount.setText(playerPoints1 + "/" + playerPoints2);
            } else {
                playerCount.setText(playerPoints1 + "");
            }

            // Split button
            splitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    standButton.setVisibility(View.GONE);
                    doubleButton.setVisibility(View.GONE);
                    splitButton.setVisibility(View.GONE);
                    hitButton.setVisibility(View.GONE);
                    playerCount.setVisibility(View.GONE);
                    playerCountR.setVisibility(View.VISIBLE);
                    playerCountL.setVisibility(View.VISIBLE);
                    card1player.setImageResource(0);
                    card2player.setImageResource(0);
                    // INSERT CARD IS SETTINGS 0 2 10 11
                    card1splitR.setImageResource(card1splitRid);
                    card1splitL.setImageResource(card1splitLid);
                    card2splitR.setImageResource(card2splitRid);
                    card2splitL.setImageResource(card2splitLid);
                    cardArrayList.remove(10);
                    cardArrayList.remove(11);
                    deckRvalue = 0;
                    deckRvalue2 = 0;
                    deckLvalue = 0;
                    deckLvalue2 = 0;
                    winStateR = -1;
                    winStateL = -1;
                    player1.setChips(player1.getChips() - betMoney);
                    chipsNormalMode.setText("₡" + player1.getChips());
                    betMoneySplitR = betMoneySplitL = betMoney;
                    bet.setText("₡" + (betMoneySplitR + betMoneySplitL));

                    deckRvalue = drawnCard1.getValue() + drawnCard6.getValue();
                    if (drawnCard1.getValue2() > 0) {
                        deckRvalue2 = drawnCard1.getValue2() + drawnCard6.getValue();
                        playerCountR.setText(deckRvalue + "/" + deckRvalue2);
                    } else if (drawnCard1.getValue2() == 0 && drawnCard6.getValue2() > 0) {
                        deckRvalue2 = drawnCard1.getValue() + drawnCard6.getValue2();
                        playerCountR.setText(deckRvalue + "/" + deckRvalue2);
                    } else {
                        playerCountR.setText(deckRvalue + "");
                    }

                    deckLvalue = drawnCard3.getValue() + drawnCard5.getValue();
                    if (drawnCard3.getValue2() > 0) {
                        deckLvalue2 = drawnCard3.getValue2() + drawnCard5.getValue();
                        playerCountL.setText(deckLvalue + "/" + deckLvalue2);
                    } else if (drawnCard3.getValue2() == 0 && drawnCard5.getValue2() > 0) {
                        deckLvalue2 = drawnCard3.getValue() + drawnCard5.getValue2();
                        playerCountL.setText(deckLvalue + "/" + deckLvalue2);
                    } else {
                        playerCountL.setText(deckLvalue + "");
                    }
                    if (deckLvalue2 == 21) {
                        playerCountL.setText(deckLvalue2 + "");
                    }

                    ImageView selectedR = (ImageView) findViewById(R.id.selectedR);
                    selectedR.setVisibility(View.VISIBLE);
                    hitButton.setVisibility(View.VISIBLE);
                    standButton.setVisibility(View.VISIBLE);
                    doubleButton.setVisibility(View.VISIBLE);
                    standButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            hitButton.setVisibility(View.GONE);
                            hitButton2.setVisibility(View.GONE);
                            hitButton3.setVisibility(View.GONE);
                            hitButton4.setVisibility(View.GONE);
                            hitButton5.setVisibility(View.GONE);
                            hitButton6.setVisibility(View.GONE);
                            standButton.setVisibility(View.GONE);
                            doubleButton.setVisibility(View.GONE);
                            selectedR.setVisibility(View.GONE);
                            bet.setText("₡" + (betMoneySplitR + betMoneySplitL));
                            if (deckRvalue2 > 0) {
                                playerCountR.setText(deckRvalue2 + "");
                            } else {
                                playerCountR.setText(deckRvalue + "");
                            }
                            if (deckRvalue > 21) {
                                winStateR = 0;
                            }
                            ImageView selectedL = (ImageView) findViewById(R.id.selectedL);
                            selectedL.setVisibility(View.VISIBLE);
                            doubleButton.setVisibility(View.VISIBLE);
                            hitButton.setVisibility(View.VISIBLE);
                            standButton.setVisibility(View.VISIBLE);
                            standButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    selectedL.setVisibility(View.GONE);
                                    standButton.setVisibility(View.GONE);
                                    doubleButton.setVisibility(View.GONE);
                                    hitButton.setVisibility(View.GONE);
                                    hitButton2.setVisibility(View.GONE);
                                    hitButton3.setVisibility(View.GONE);
                                    hitButton4.setVisibility(View.GONE);
                                    hitButton5.setVisibility(View.GONE);
                                    hitButton6.setVisibility(View.GONE);
                                    card1dealer.setImageResource(card1dealerid);
                                    if (dealerPoints2 > 0) {
                                        dealerCount.setText(dealerPoints2 + "");
                                    } else {
                                        dealerCount.setText(dealerPoints1 + "");
                                    }
                                    if (deckLvalue > 21) {
                                        winStateL = 0;
                                    } else {}

                                    // Comparison R
                                    if (winStateR != 3){
                                        if ((dealerPoints1 > 21 && deckRvalue <= 21) || (((deckRvalue <= 21) && (deckRvalue2 <= 21)) && ((dealerPoints1 <= 21) && (dealerPoints2 <= 21)) && (((deckRvalue > dealerPoints1) || (deckRvalue2 > dealerPoints1)) && ((deckRvalue > dealerPoints2) || (deckRvalue2 > dealerPoints2))))) {
                                            winStateR = 1;
                                        } else if (deckRvalue == dealerPoints1 || deckRvalue == dealerPoints2 || deckRvalue2 == dealerPoints1 || (deckRvalue2 == dealerPoints2 && deckRvalue2 > 0)) {
                                            winStateR = 2;
                                        } else {
                                            winStateR = 0;
                                        }
                                    }
                                    if (winStateR == 0) { // Lose
                                        loseMessageR.setVisibility(View.VISIBLE);
                                    } else if (winStateR == 1) { // Win
                                        winMessageR.setVisibility(View.VISIBLE);
                                        try {
                                            player1.setChips(player1.getChips() + betMoneySplitR * 2);
                                            player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency") + "/Chips.txt");
                                            chipsNormalMode.setText("₡" + player1.getChips());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    } else if (winStateR == 2) { // Push
                                        pushMessageR.setVisibility(View.VISIBLE);
                                        try {
                                            player1.setChips(player1.getChips() + betMoneySplitR);
                                            player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency") + "/Chips.txt");
                                            chipsNormalMode.setText("₡" + player1.getChips());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    } else if (winStateR == 3) { // BlackJack!
                                        if (betMoneySplitR/2 % 5 != 0){
                                            try {
                                                player1.setChips(player1.getChips()+betMoneySplitR*2);
                                                player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency")+"/Chips.txt");
                                                chipsNormalMode.setText("₡"+player1.getChips());
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        else {
                                            try {
                                                player1.setChips(player1.getChips()+betMoneySplitR*2+betMoneySplitR/2);
                                                player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency")+"/Chips.txt");
                                                chipsNormalMode.setText("₡"+player1.getChips());
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        betMoneySplitL = 0;
                                    }

                                    // Comparison L
                                    if (winStateL != 3){
                                        if ((dealerPoints1 > 21 && deckLvalue <= 21) || (((deckLvalue <= 21) && (deckLvalue2 <= 21)) && ((dealerPoints1 <= 21) && (dealerPoints2 <= 21)) && (((deckLvalue > dealerPoints1) || (deckLvalue2 > dealerPoints1)) && ((deckLvalue > dealerPoints2) || (deckLvalue2 > dealerPoints2))))) {
                                            winStateL = 1;
                                        } else if (deckLvalue == dealerPoints1 || deckLvalue == dealerPoints2 || deckLvalue2 == dealerPoints1 || (deckLvalue2 == dealerPoints2 && deckLvalue2 > 0)) {
                                            winStateL = 2;
                                        } else {
                                            winStateL = 0;
                                        }
                                    }
                                    if (winStateL == 0) { // Lose
                                        loseMessageL.setVisibility(View.VISIBLE);
                                    } else if (winStateL == 1) { // Win
                                        winMessageL.setVisibility(View.VISIBLE);
                                        try {
                                            player1.setChips(player1.getChips() + betMoneySplitL * 2);
                                            player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency") + "/Chips.txt");
                                            chipsNormalMode.setText("₡" + player1.getChips());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    } else if (winStateL == 2) { // Push
                                        pushMessageL.setVisibility(View.VISIBLE);
                                        try {
                                            player1.setChips(player1.getChips() + betMoneySplitL);
                                            player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency") + "/Chips.txt");
                                            chipsNormalMode.setText("₡" + player1.getChips());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    } else if (winStateL == 3) { // BlackJack!
                                        if (betMoneySplitL/2 % 5 != 0){
                                            try {
                                                player1.setChips(player1.getChips()+betMoneySplitL*2);
                                                player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency")+"/Chips.txt");
                                                chipsNormalMode.setText("₡"+player1.getChips());
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        else {
                                            try {
                                                player1.setChips(player1.getChips()+betMoneySplitL*2+betMoneySplitL/2);
                                                player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency")+"/Chips.txt");
                                                chipsNormalMode.setText("₡"+player1.getChips());
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        betMoneySplitL = 0;
                                    }
                                }
                            });
                            // BlackJack L
                            if ((drawnCard3.getValue() + drawnCard5.getValue2() == 21 || drawnCard3.getValue2() + drawnCard5.getValue() == 21)) {
                                winStateL = 3;
                                playerCountL.setText("21");
                                blackjackMessageL.setVisibility(View.VISIBLE);
                                standButton.callOnClick();
                            }
                        }
                    });

                    // BlackJack R
                    if ((drawnCard1.getValue() + drawnCard6.getValue2() == 21 || drawnCard1.getValue2() + drawnCard6.getValue() == 21)) {
                        winStateR = 3;
                        playerCountR.setText("21");
                        blackjackMessageR.setVisibility(View.VISIBLE);
                        standButton.callOnClick();
                    }

                    hitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            doubleButton.setVisibility(View.GONE);
                            hitButton.setVisibility(View.GONE);
                            deckRvalue2 = 0;
                            card3splitR.setImageResource(card3splitRid);
                            cardArrayList.remove(12);
                            if (drawnCard7.getValue2() > 0 && (drawnCard7.getValue2() + deckRvalue <= 21)) {
                                deckRvalue2 = deckRvalue + drawnCard7.getValue2();
                                deckRvalue = deckRvalue + drawnCard7.getValue();
                                playerCountR.setText(deckRvalue + "/" + deckRvalue2);
                            } else {
                                deckRvalue = deckRvalue + drawnCard7.getValue();
                                playerCountR.setText(deckRvalue + "");
                            }
                            if (deckRvalue >= 21 || deckRvalue2 == 21) {
                                standButton.callOnClick();
                            } else {
                                hitButton2.setVisibility(View.VISIBLE);
                                hitButton2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        hitButton2.setVisibility(View.GONE);
                                        deckRvalue2 = 0;
                                        card4splitR.setImageResource(card4splitRid);
                                        cardArrayList.remove(13);
                                        if (drawnCard8.getValue2() > 0 && (drawnCard8.getValue2() + deckRvalue <= 21)) {
                                            deckRvalue2 = deckRvalue + drawnCard8.getValue2();
                                            deckRvalue = deckRvalue + drawnCard8.getValue();
                                            playerCountR.setText(deckRvalue + "/" + deckRvalue2);
                                        } else {
                                            deckRvalue = deckRvalue + drawnCard8.getValue();
                                            playerCountR.setText(deckRvalue + "");
                                        }
                                        if (deckRvalue >= 21 || deckRvalue2 == 21) {
                                            standButton.callOnClick();
                                        } else {
                                            hitButton3.setVisibility(View.VISIBLE);
                                            hitButton3.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    hitButton3.setVisibility(View.GONE);
                                                    deckRvalue2 = 0;
                                                    card5splitR.setImageResource(card5splitRid);
                                                    cardArrayList.remove(14);
                                                    if (drawnCard9.getValue2() > 0 && (drawnCard9.getValue2() + deckRvalue <= 21)) {
                                                        deckRvalue2 = deckRvalue + drawnCard9.getValue2();
                                                        deckRvalue = deckRvalue + drawnCard9.getValue();
                                                        playerCountR.setText(deckRvalue + "/" + deckRvalue2);
                                                    } else {
                                                        deckRvalue = deckRvalue + drawnCard9.getValue();
                                                        playerCountR.setText(deckRvalue + "");
                                                    }
                                                    if (deckRvalue >= 21 || deckRvalue2 == 21) {
                                                        standButton.callOnClick();
                                                    } else {
                                                        hitButton4.setVisibility(View.VISIBLE);
                                                        hitButton4.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View view) {
                                                                hitButton4.setVisibility(View.GONE);
                                                                deckRvalue2 = 0;
                                                                card6splitR.setImageResource(card6splitRid);
                                                                cardArrayList.remove(15);
                                                                if (drawnCard10.getValue2() > 0 && (drawnCard10.getValue2() + deckRvalue <= 21)) {
                                                                    deckRvalue2 = deckRvalue + drawnCard10.getValue2();
                                                                    deckRvalue = deckRvalue + drawnCard10.getValue();
                                                                    playerCountR.setText(deckRvalue + "/" + deckRvalue2);
                                                                } else {
                                                                    deckRvalue = deckRvalue + drawnCard10.getValue();
                                                                    playerCountR.setText(deckRvalue + "");
                                                                }
                                                                standButton.callOnClick();
                                                            }
                                                        });
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });
                    doubleButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // double right if (right.isSelected()) left if(left.isSelected()) remember!
                            doubleddownR = true;
                            betMoneySplitR = betMoneySplitR + betMoney;
                            doubleButton.setVisibility(View.GONE);
                            standButton.setVisibility(View.GONE);
                            hitButton.setVisibility(View.GONE);
                            deckRvalue2 = 0;
                            card3splitR.setImageResource(card3splitRid);
                            cardArrayList.remove(12);
                            if (drawnCard7.getValue2() > 0 && (drawnCard7.getValue2() + deckRvalue <= 21)) {
                                deckRvalue2 = deckRvalue + drawnCard7.getValue2();
                                deckRvalue = deckRvalue + drawnCard7.getValue();
                                playerCountR.setText(deckRvalue + "/" + deckRvalue2);
                            } else {
                                deckRvalue = deckRvalue + drawnCard7.getValue();
                                playerCountR.setText(deckRvalue + "");
                            }
                            standButton.callOnClick();
                        }
                    });
                }
            });

            // Stand button
            standButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    standButton.setVisibility(View.GONE);
                    doubleButton.setVisibility(View.GONE);
                    hitButton.setVisibility(View.GONE);
                    hitButton2.setVisibility(View.GONE);
                    hitButton3.setVisibility(View.GONE);
                    hitButton4.setVisibility(View.GONE);
                    hitButton5.setVisibility(View.GONE);
                    hitButton6.setVisibility(View.GONE);
                    splitButton.setVisibility(View.GONE);

                    card1dealer.animate().alpha(0f).setDuration(durationshrt).setListener(null);
                    final Handler handler5 = new Handler();handler5.postDelayed(new Runnable() {@Override public void run() {
                        card1dealer.setImageResource(card1dealerid);
                        card1dealer.animate().alpha(1f).setDuration(durationshrt).setListener(null);
                    }}, durationshrt);

                    if (dealerPoints2 > 0) {
                        dealerCount.setText(dealerPoints2 + "");
                    } else {
                        dealerCount.setText(dealerPoints1 + "");
                    }
                    if (playerPoints2 > 0) {
                        playerCount.setText(playerPoints2 + "");
                    } else {
                        playerCount.setText(playerPoints1 + "");
                    }
                    if (playerPoints1 > 21) {
                        winState = 0;
                    } else {
                        final Handler handler4 = new Handler();handler4.postDelayed(new Runnable() {@Override public void run() {
                        if (dealerPoints1 < 17 && dealerPoints2 < 17) {
                            durationdyn = 500;
                            ObjectAnimator animation4 = ObjectAnimator.ofFloat(card3dealer, "translationY", 170);
                            animation4.setDuration(500);
                            animation4.start();
                            card3dealer.setAlpha(0f);
                            card3dealer.setImageResource(card3dealerid);
                            card3dealer.animate().alpha(1f).setDuration(duration).setListener(null);
                            cardArrayList.remove(4);
                            if (drawnCard05.getValue2() > 0 && (drawnCard05.getValue2() + dealerPoints1 < 21)) {
                                dealerPoints2 = dealerPoints1 + drawnCard05.getValue2();
                                dealerPoints1 = dealerPoints1 + drawnCard05.getValue();
                                dealerPointsTemp1 = dealerPoints1 + "/" + dealerPoints2;
                                final Handler handler4 = new Handler();handler4.postDelayed(new Runnable() {@Override public void run() {
                                dealerCount.setText(dealerPointsTemp1);
                                }}, 250);
                            } else {
                                dealerPoints1 = dealerPoints1 + drawnCard05.getValue();
                                dealerPointsTemp1 = dealerPoints1 + "";
                                final Handler handler4 = new Handler();handler4.postDelayed(new Runnable() {@Override public void run() {
                                dealerCount.setText(dealerPointsTemp1);
                                }}, 250);
                            }
                            if (dealerPoints1 < 17 && dealerPoints2 < 17) {
                                durationdyn = 1000;
                                final Handler handler4 = new Handler();
                                handler4.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ObjectAnimator animation4 = ObjectAnimator.ofFloat(card4dealer, "translationY", 210);
                                        animation4.setDuration(500);
                                        animation4.start();
                                        card4dealer.setAlpha(0f);
                                        card4dealer.setImageResource(card4dealerid);
                                        card4dealer.animate().alpha(1f).setDuration(duration).setListener(null);
                                        durationdyn = durationdyn + 500;
                                    }
                                }, 500);
                                cardArrayList.remove(5);
                                if (drawnCard06.getValue2() > 0 && (drawnCard06.getValue2() + dealerPoints1 <= 21)) {
                                    dealerPoints2 = dealerPoints1 + drawnCard06.getValue2();
                                    dealerPoints1 = dealerPoints1 + drawnCard06.getValue();
                                    dealerPointsTemp2 = dealerPoints1 + "/" + dealerPoints2;
                                    final Handler handler6 = new Handler();handler6.postDelayed(new Runnable() {@Override public void run() {
                                        dealerCount.setText(dealerPointsTemp2);
                                    }}, 750);
                                } else {
                                    dealerPoints1 = dealerPoints1 + drawnCard06.getValue();
                                    dealerPointsTemp2 = dealerPoints1 + "";
                                    final Handler handler6 = new Handler();handler6.postDelayed(new Runnable() {@Override public void run() {
                                        dealerCount.setText(dealerPointsTemp2);
                                    }}, 750);
                                }
                                if (dealerPoints1 < 17 && dealerPoints2 < 17) {
                                    durationdyn = 1500;
                                    final Handler handler8 = new Handler();
                                    handler8.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            ObjectAnimator animation6 = ObjectAnimator.ofFloat(card5dealer, "translationY", 255);
                                            animation6.setDuration(500);
                                            animation6.start();
                                            card5dealer.setAlpha(0f);
                                            card5dealer.setImageResource(card5dealerid);
                                            card5dealer.animate().alpha(1f).setDuration(duration).setListener(null);
                                            durationdyn = durationdyn + 500;
                                        }
                                    }, 1000);
                                    cardArrayList.remove(6);
                                    if (drawnCard07.getValue2() > 0 && (drawnCard07.getValue2() + dealerPoints1 <= 21)) {
                                        dealerPoints2 = dealerPoints1 + drawnCard07.getValue2();
                                        dealerPoints1 = dealerPoints1 + drawnCard07.getValue();
                                        dealerPointsTemp3 = dealerPoints1 + "/" + dealerPoints2;
                                        handler4.postDelayed(new Runnable() {@Override public void run() {
                                            dealerCount.setText(dealerPointsTemp3);
                                        }}, 1250);
                                    } else {
                                        dealerPoints1 = dealerPoints1 + drawnCard07.getValue();
                                        dealerPointsTemp3 = dealerPoints1 + "";
                                        handler4.postDelayed(new Runnable() {@Override public void run() {
                                            dealerCount.setText(dealerPointsTemp3);
                                        }}, 1250);
                                    }
                                    if (dealerPoints1 < 17 && dealerPoints2 < 17) {
                                        durationdyn = 2000;
                                        handler4.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                ObjectAnimator animation4 = ObjectAnimator.ofFloat(card6dealer, "translationY", 250);
                                                animation4.setDuration(500);
                                                animation4.start();
                                                card6dealer.setAlpha(0f);
                                                card6dealer.setImageResource(card6dealerid);
                                                card6dealer.animate().alpha(1f).setDuration(duration).setListener(null);
                                                durationdyn = durationdyn + 500;
                                            }
                                        }, 1500);
                                        cardArrayList.remove(7);
                                        if (drawnCard08.getValue2() > 0 && (drawnCard08.getValue2() + dealerPoints1 <= 21)) {
                                            dealerPoints2 = dealerPoints1 + drawnCard08.getValue2();
                                            dealerPoints1 = dealerPoints1 + drawnCard08.getValue();
                                            dealerPointsTemp4 = dealerPoints1 + "/" + dealerPoints2;
                                            handler4.postDelayed(new Runnable() {@Override public void run() {
                                                dealerCount.setText(dealerPointsTemp4);
                                            }}, 1750);
                                        } else {
                                            dealerPoints1 = dealerPoints1 + drawnCard08.getValue();
                                            dealerPointsTemp4 = dealerPoints1 + "";
                                            handler4.postDelayed(new Runnable() {@Override public void run() {
                                                dealerCount.setText(dealerPointsTemp4);
                                            }}, 1750);
                                        }
                                        if (dealerPoints1 < 17 && dealerPoints2 < 17) {
                                            durationdyn = 2500;
                                            handler4.postDelayed(new Runnable() {@Override public void run() {
                                                ObjectAnimator animation4 = ObjectAnimator.ofFloat(card7dealer, "translationY", 235);
                                                animation4.setDuration(500);
                                                animation4.start();
                                                card7dealer.setAlpha(0f);
                                                card7dealer.setImageResource(card7dealerid);
                                                card7dealer.animate().alpha(1f).setDuration(duration).setListener(null);
                                            }}, 2000);
                                            cardArrayList.remove(8);
                                            if (drawnCard09.getValue2() > 0 && (drawnCard09.getValue2() + dealerPoints1 <= 21)) {
                                                dealerPoints2 = dealerPoints1 + drawnCard09.getValue2();
                                                dealerPoints1 = dealerPoints1 + drawnCard09.getValue();
                                                dealerPointsTemp5 = dealerPoints1 + "/" + dealerPoints2;
                                                handler4.postDelayed(new Runnable() {@Override public void run() {
                                                    dealerCount.setText(dealerPointsTemp5);
                                                }}, 2250);
                                            } else {
                                                dealerPoints1 = dealerPoints1 + drawnCard09.getValue();
                                                dealerPointsTemp5 = dealerPoints1 + "";
                                                handler4.postDelayed(new Runnable() {@Override public void run() {
                                                    dealerCount.setText(dealerPointsTemp5);
                                                }}, 2250);
                                            }
                                            if (dealerPoints1 < 17 && dealerPoints2 < 17) {
                                                durationdyn = 3000;
                                                handler4.postDelayed(new Runnable() {@Override public void run() {
                                                    ObjectAnimator animation4 = ObjectAnimator.ofFloat(card8dealer, "translationY", 260);
                                                    animation4.setDuration(500);
                                                    animation4.start();
                                                    card8dealer.setAlpha(0f);
                                                    card8dealer.setImageResource(card8dealerid);
                                                    card8dealer.animate().alpha(1f).setDuration(duration).setListener(null);
                                                }}, 2500);
                                                cardArrayList.remove(9);
                                                if (drawnCard010.getValue2() > 0 && (drawnCard010.getValue2() + dealerPoints1 <= 21)) {
                                                    dealerPoints2 = dealerPoints1 + drawnCard010.getValue2();
                                                    dealerPoints1 = dealerPoints1 + drawnCard010.getValue();
                                                    dealerPointsTemp6 = dealerPoints1 + "/" + dealerPoints2;
                                                    handler4.postDelayed(new Runnable() {@Override public void run() {
                                                        dealerCount.setText(dealerPointsTemp6);
                                                    }}, 2750);
                                                } else {
                                                    dealerPoints1 = dealerPoints1 + drawnCard010.getValue();
                                                    dealerPointsTemp6 = dealerPoints1 + "";
                                                    handler4.postDelayed(new Runnable() {@Override public void run() {
                                                        dealerCount.setText(dealerPointsTemp6);
                                                    }}, 2750);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        }}, 500);
                    }
                    // Comparing Points with Dealer
                    handler4.postDelayed(new Runnable() {@Override public void run() {
                    handler4.postDelayed(new Runnable() {@Override public void run() {
                    if (dealerPoints2 < 22 && dealerPoints2 > 16){
                        dealerCount.setText(dealerPoints2+"");
                    }
                    if ((dealerPoints1 > 21 && playerPoints1 <= 21) || (((playerPoints1 <= 21) && (playerPoints2 <= 21)) && ((dealerPoints1 <= 21) && (dealerPoints2 <= 21)) && (((playerPoints1 > dealerPoints1) || (playerPoints2 > dealerPoints1)) && ((playerPoints1 > dealerPoints2) || (playerPoints2 > dealerPoints2))))) {
                        winState = 1;
                    } else if (playerPoints1 == dealerPoints1 || playerPoints1 == dealerPoints2 || playerPoints2 == dealerPoints1 || (playerPoints2 == dealerPoints2 && playerPoints2 > 0)) {
                        winState = 2;
                    } else {
                        winState = 0;
                    }
                    if (winState == 0) { // Lose
                        loseMessage.setAlpha(0f);
                        loseMessage.setVisibility(View.VISIBLE);
                        loseMessage.animate().alpha(1f).setDuration(duration).setListener(null);
                        betMoney = 0;
                    } else if (winState == 1) { // Win
                        winMessage.setAlpha(0f);
                        winMessage.setVisibility(View.VISIBLE);
                        winMessage.animate().alpha(1f).setDuration(duration).setListener(null);
                        try {
                            player1.setChips(player1.getChips() + betMoney * 2);
                            player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency") + "/Chips.txt");
                            chipsNormalMode.setText("₡" + player1.getChips());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (winState == 2) { // Push
                        pushMessage.setAlpha(0f);
                        pushMessage.setVisibility(View.VISIBLE);
                        pushMessage.animate().alpha(1f).setDuration(duration).setListener(null);
                        try {
                            player1.setChips(player1.getChips() + betMoney);
                            player1.writeChips(player1.getChips(), getExternalFilesDir("/Currency") + "/Chips.txt");
                            chipsNormalMode.setText("₡" + player1.getChips());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    }}, durationdyn);
                    }}, 500);
                }
            });
            // Hit button
            hitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doubleButton.setVisibility(View.GONE);
                    hitButton.setVisibility(View.GONE);
                    splitButton.setVisibility(View.GONE);
                    playerPoints2 = 0;
                    ObjectAnimator animation4 = ObjectAnimator.ofFloat(card3player, "translationY", 1050);
                    animation4.setDuration(500);
                    animation4.start();
                    card3player.setAlpha(0f);
                    card3player.setImageResource(card3dealerid);
                    card3player.animate().alpha(1f).setDuration(duration).setListener(null);
                    cardArrayList.remove(10);
                    if (drawnCard5.getValue2() > 0 && (drawnCard5.getValue2() + playerPoints1 <= 21)) {
                        playerPoints2 = playerPoints1 + drawnCard5.getValue2();
                        playerPoints1 = playerPoints1 + drawnCard5.getValue();
                        playerCount.setText(playerPoints1 + "/" + playerPoints2);
                    } else {
                        playerPoints1 = playerPoints1 + drawnCard5.getValue();
                        playerCount.setText(playerPoints1 + "");
                    }
                    if (playerPoints1 >= 21 || playerPoints2 == 21) {
                        standButton.callOnClick();
                    } else {
                        hitButton2.setVisibility(View.VISIBLE);
                    }
                    hitButton2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            hitButton2.setVisibility(View.GONE);
                            playerPoints2 = 0;
                            ObjectAnimator animation4 = ObjectAnimator.ofFloat(card4player, "translationY", 1050);
                            animation4.setDuration(500);
                            animation4.start();
                            card4player.setAlpha(0f);
                            card4player.setImageResource(card4dealerid);
                            card4player.animate().alpha(1f).setDuration(duration).setListener(null);
                            cardArrayList.remove(11);
                            if (drawnCard6.getValue2() > 0 && (drawnCard6.getValue2() + playerPoints1 <= 21)) {
                                playerPoints2 = playerPoints1 + drawnCard6.getValue2();
                                playerPoints1 = playerPoints1 + drawnCard6.getValue();
                                playerCount.setText(playerPoints1 + "/" + playerPoints2);
                            } else {
                                playerPoints1 = playerPoints1 + drawnCard6.getValue();
                                playerCount.setText(playerPoints1 + "");
                            }
                            if (playerPoints1 == 21 || playerPoints2 == 21 || playerPoints1 > 21) {
                                standButton.callOnClick();
                            } else {
                                hitButton3.setVisibility(View.VISIBLE);
                            }
                            hitButton3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    hitButton3.setVisibility(View.GONE);
                                    playerPoints2 = 0;
                                    ObjectAnimator animation4 = ObjectAnimator.ofFloat(card5player, "translationY", 1000);
                                    animation4.setDuration(500);
                                    animation4.start();
                                    card5player.setAlpha(0f);
                                    card5player.setImageResource(card5dealerid);
                                    card5player.animate().alpha(1f).setDuration(duration).setListener(null);
                                    cardArrayList.remove(12);
                                    if (drawnCard7.getValue2() > 0 && (drawnCard7.getValue2() + playerPoints1 <= 21)) {
                                        playerPoints2 = playerPoints1 + drawnCard7.getValue2();
                                        playerPoints1 = playerPoints1 + drawnCard7.getValue();
                                        playerCount.setText(playerPoints1 + "/" + playerPoints2);
                                    } else {
                                        playerPoints1 = playerPoints1 + drawnCard7.getValue();
                                        playerCount.setText(playerPoints1 + "");
                                    }
                                    if (playerPoints1 == 21 || playerPoints2 == 21 || playerPoints1 > 21) {
                                        standButton.callOnClick();
                                    } else {
                                        hitButton4.setVisibility(View.VISIBLE);
                                    }
                                    hitButton4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            hitButton4.setVisibility(View.GONE);
                                            playerPoints2 = 0;
                                            ObjectAnimator animation4 = ObjectAnimator.ofFloat(card6player, "translationY", 1000);
                                            animation4.setDuration(500);
                                            animation4.start();
                                            card6player.setAlpha(0f);
                                            card6player.setImageResource(card6dealerid);
                                            card6player.animate().alpha(1f).setDuration(duration).setListener(null);
                                            cardArrayList.remove(13);
                                            if (drawnCard8.getValue2() > 0 && (drawnCard8.getValue2() + playerPoints1 <= 21)) {
                                                playerPoints2 = playerPoints1 + drawnCard8.getValue2();
                                                playerPoints1 = playerPoints1 + drawnCard8.getValue();
                                                playerCount.setText(playerPoints1 + "/" + playerPoints2);
                                            } else {
                                                playerPoints1 = playerPoints1 + drawnCard8.getValue();
                                                playerCount.setText(playerPoints1 + "");
                                            }
                                            if (playerPoints1 == 21 || playerPoints2 == 21 || playerPoints1 > 21) {
                                                standButton.callOnClick();
                                            } else {
                                                hitButton5.setVisibility(View.VISIBLE);
                                            }
                                            hitButton5.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    hitButton5.setVisibility(View.GONE);
                                                    playerPoints2 = 0;
                                                    ObjectAnimator animation4 = ObjectAnimator.ofFloat(card7player, "translationY", 1005);
                                                    animation4.setDuration(500);
                                                    animation4.start();
                                                    card7player.setAlpha(0f);
                                                    card7player.setImageResource(card7dealerid);
                                                    card7player.animate().alpha(1f).setDuration(duration).setListener(null);
                                                    cardArrayList.remove(14);
                                                    if (drawnCard9.getValue2() > 0 && (drawnCard9.getValue2() + playerPoints1 <= 21)) {
                                                        playerPoints2 = playerPoints1 + drawnCard9.getValue2();
                                                        playerPoints1 = playerPoints1 + drawnCard9.getValue();
                                                        playerCount.setText(playerPoints1 + "/" + playerPoints2);
                                                    } else {
                                                        playerPoints1 = playerPoints1 + drawnCard9.getValue();
                                                        playerCount.setText(playerPoints1 + "");
                                                    }
                                                    if (playerPoints1 == 21 || playerPoints2 == 21 || playerPoints1 > 21) {
                                                        standButton.callOnClick();
                                                    } else {
                                                        hitButton6.setVisibility(View.VISIBLE);
                                                    }
                                                    hitButton6.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View view) {
                                                            hitButton6.setVisibility(View.GONE);
                                                            playerPoints2 = 0;
                                                            ObjectAnimator animation4 = ObjectAnimator.ofFloat(card8player, "translationY", 1100);
                                                            animation4.setDuration(500);
                                                            animation4.start();
                                                            card8player.setAlpha(0f);
                                                            card8player.setImageResource(card8dealerid);
                                                            card8player.animate().alpha(1f).setDuration(duration).setListener(null);
                                                            cardArrayList.remove(15);
                                                            if (drawnCard10.getValue2() > 0 && (drawnCard10.getValue2() + playerPoints1 <= 21)) {
                                                                playerPoints2 = playerPoints1 + drawnCard10.getValue2();
                                                                playerPoints1 = playerPoints1 + drawnCard10.getValue();
                                                                playerCount.setText(playerPoints1 + "/" + playerPoints2);
                                                            } else {
                                                                playerPoints1 = playerPoints1 + drawnCard10.getValue();
                                                                playerCount.setText(playerPoints1 + "");
                                                            }
                                                            hitButton6.setVisibility(View.GONE);
                                                            standButton.callOnClick();
                                                        }
                                                    });
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
            // Doubled down button
            doubleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (player1.getChips() - betMoney >= 0) {
                        doubleddown = true;
                        doubleButton.setVisibility(View.GONE);
                        player1.setChips(player1.getChips() - betMoney);
                        chipsNormalMode.setText("₡" + player1.getChips());
                        betMoney = betMoney * 2;
                        bet.setText("₡"+betMoney);
                        hitButton.setVisibility(View.GONE);
                        standButton.setVisibility(View.GONE);
                        playerPoints2 = 0;
                        ObjectAnimator animation4 = ObjectAnimator.ofFloat(card3player, "translationY", 1050);
                        animation4.setDuration(500);
                        animation4.start();
                        card3player.setAlpha(0f);
                        card3player.setImageResource(card3dealerid);
                        card3player.animate().alpha(1f).setDuration(duration).setListener(null);
                        cardArrayList.remove(10);
                        if (drawnCard5.getValue2() > 0 && (drawnCard5.getValue2() + playerPoints1 <= 21)) {
                            playerPoints2 = playerPoints1 + drawnCard5.getValue2();
                            playerPoints1 = playerPoints1 + drawnCard5.getValue();
                            playerCount.setText(playerPoints1 + "/" + playerPoints2);
                        } else {
                            playerPoints1 = playerPoints1 + drawnCard5.getValue();
                            playerCount.setText(playerPoints1 + "");
                        }
                        standButton.callOnClick();
                    }
                }
            });
        } else {
            System.out.println("Something went Wrong.");
        }
        }}, 2000);
    }


    public void backToSinglePlayer() {
        normalToSingleplayer.start();
        normalToSingleplayer.setVisibility(View.VISIBLE);
        backButton.setVisibility(View.GONE);
        placeBet.setVisibility(View.GONE);
        resetBet.setVisibility(View.GONE);
        clearTest.setVisibility(View.GONE);

        Intent intent = new Intent(this, Singleplayer.class);
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

    public void buildDeck() {
        // Add a deck(s) to emptied Arraylist and shuffle it
        cardArrayList.clear();

        cardArrayList.add(clubsAce);
        cardArrayList.add(diamondsAce);
        cardArrayList.add(heartsAce);
        cardArrayList.add(spadesAce);

        cardArrayList.add(clubsTwo);
        cardArrayList.add(diamondsTwo);
        cardArrayList.add(heartsTwo);
        cardArrayList.add(spadesTwo);
        
        cardArrayList.add(clubsThree);
        cardArrayList.add(diamondsThree);
        cardArrayList.add(heartsThree);
        cardArrayList.add(spadesThree);

        cardArrayList.add(clubsFour);
        cardArrayList.add(diamondsFour);
        cardArrayList.add(heartsFour);
        cardArrayList.add(spadesFour);

        cardArrayList.add(clubsFive);
        cardArrayList.add(diamondsFive);
        cardArrayList.add(heartsFive);
        cardArrayList.add(spadesFive);

        cardArrayList.add(clubsSix);
        cardArrayList.add(diamondsSix);
        cardArrayList.add(heartsSix);
        cardArrayList.add(spadesSix);

        cardArrayList.add(clubsSeven);
        cardArrayList.add(diamondsSeven);
        cardArrayList.add(heartsSeven);
        cardArrayList.add(spadesSeven);

        cardArrayList.add(clubsEight);
        cardArrayList.add(diamondsEight);
        cardArrayList.add(heartsEight);
        cardArrayList.add(spadesEight);

        cardArrayList.add(clubsNine);
        cardArrayList.add(diamondsNine);
        cardArrayList.add(heartsNine);
        cardArrayList.add(spadesNine);

        cardArrayList.add(clubsTen);
        cardArrayList.add(diamondsTen);
        cardArrayList.add(heartsTen);
        cardArrayList.add(spadesTen);

        cardArrayList.add(clubsQueen);
        cardArrayList.add(diamondsQueen);
        cardArrayList.add(heartsQueen);
        cardArrayList.add(spadesQueen);

        cardArrayList.add(clubsJack);
        cardArrayList.add(diamondsJack);
        cardArrayList.add(heartsJack);
        cardArrayList.add(spadesJack);

        cardArrayList.add(clubsKing);
        cardArrayList.add(diamondsKing);
        cardArrayList.add(heartsKing);
        cardArrayList.add(spadesKing);

        cardArrayList.add(clubsAce);
        cardArrayList.add(diamondsAce);
        cardArrayList.add(heartsAce);
        cardArrayList.add(spadesAce);

        cardArrayList.add(clubsTwo);
        cardArrayList.add(diamondsTwo);
        cardArrayList.add(heartsTwo);
        cardArrayList.add(spadesTwo);

        cardArrayList.add(clubsThree);
        cardArrayList.add(diamondsThree);
        cardArrayList.add(heartsThree);
        cardArrayList.add(spadesThree);

        cardArrayList.add(clubsFour);
        cardArrayList.add(diamondsFour);
        cardArrayList.add(heartsFour);
        cardArrayList.add(spadesFour);

        cardArrayList.add(clubsFive);
        cardArrayList.add(diamondsFive);
        cardArrayList.add(heartsFive);
        cardArrayList.add(spadesFive);

        cardArrayList.add(clubsSix);
        cardArrayList.add(diamondsSix);
        cardArrayList.add(heartsSix);
        cardArrayList.add(spadesSix);

        cardArrayList.add(clubsSeven);
        cardArrayList.add(diamondsSeven);
        cardArrayList.add(heartsSeven);
        cardArrayList.add(spadesSeven);

        cardArrayList.add(clubsEight);
        cardArrayList.add(diamondsEight);
        cardArrayList.add(heartsEight);
        cardArrayList.add(spadesEight);

        cardArrayList.add(clubsNine);
        cardArrayList.add(diamondsNine);
        cardArrayList.add(heartsNine);
        cardArrayList.add(spadesNine);

        cardArrayList.add(clubsTen);
        cardArrayList.add(diamondsTen);
        cardArrayList.add(heartsTen);
        cardArrayList.add(spadesTen);

        cardArrayList.add(clubsQueen);
        cardArrayList.add(diamondsQueen);
        cardArrayList.add(heartsQueen);
        cardArrayList.add(spadesQueen);

        cardArrayList.add(clubsJack);
        cardArrayList.add(diamondsJack);
        cardArrayList.add(heartsJack);
        cardArrayList.add(spadesJack);

        cardArrayList.add(clubsKing);
        cardArrayList.add(diamondsKing);
        cardArrayList.add(heartsKing);
        cardArrayList.add(spadesKing);

        Collections.shuffle(cardArrayList);
    }
}