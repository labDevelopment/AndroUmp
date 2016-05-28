package com.example.mrbuknahsty.androump;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button plusHS, minusHS, plusAS, minusAS, plusInning, minusInning, plusBall, minusBall, plusStrinke, minusStrike, plusOut, minusOut;
    TextView HS, AS, innings, balls, strikes, outs;

    int MAX_VALUE_BALL = 4;
    int MAX_VALUE_STRIKE = 3;
    int MAX_VALUE_OUT = 3;

    int ball = 0;
    int strike = 0;
    int out = 0;
    float inning = 1;
    int homeScore = 0;
    int awayScore = 0;
    int outCounter = 0;

    boolean up;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SET BUTTONS
        plusHS = (Button)findViewById(R.id.plusHomeScoreBtn);
        minusHS = (Button)findViewById(R.id.minusHomeScoreBtn);
        plusAS = (Button)findViewById(R.id.plusAwayScoreBtn);
        minusAS = (Button)findViewById(R.id.minusAwayScoreBtn);
        plusInning = (Button)findViewById(R.id.plusInningBtn);
        minusInning = (Button)findViewById(R.id.minusInningBtn);
        plusBall = (Button)findViewById(R.id.plusBallsBtn);
        minusBall = (Button)findViewById(R.id.minusBallsBtn);
        plusStrinke = (Button)findViewById(R.id.plusStrikeBtn);
        minusStrike = (Button)findViewById(R.id.minusStrikeBtn);
        plusOut = (Button)findViewById(R.id.plusOutsBtn);
        minusOut = (Button)findViewById(R.id.minusOutsBtn);

        //SETS TEXTVIEWS
        HS = (TextView)findViewById(R.id.homeScoreTV);
        AS = (TextView)findViewById(R.id.awayScoreTV);
        innings = (TextView)findViewById(R.id.inningNumTV);
        balls = (TextView)findViewById(R.id.ballsNumTV);
        strikes = (TextView)findViewById(R.id.strikesNumTV);
        outs = (TextView)findViewById(R.id.outsNumTV);

        HS.setText(String.valueOf(homeScore));
        AS.setText(String.valueOf(awayScore));
        balls.setText("0");
        strikes.setText("0");
        outs.setText("0");

        innings.setText(String.valueOf(inning));


        addToHomeScore();
        minusToHomeScore();
        addToAwayScore();
        minusToAwayScore();
        addInning();
        minusInning();
        addToBalls();
        minusBall();
        addToStrikes();
        minusStrike();

        plusInning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInning();
            }
        });

        minusInning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minusInning();
            }
        });

        plusOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOut();
            }
        });

        minusOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minusOut();
            }
        });



    }

    public void addToHomeScore()
    {
        plusHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeScore += 1;
                HS.setText(homeScore + "");
            }
        });
    }

    public void minusToHomeScore()
    {
        minusHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(homeScore > 0) {
                    homeScore -= 1;
                    HS.setText(homeScore + "");
                }
            }
        });
    }

    public void addToAwayScore()
    {
        plusAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                awayScore += 1;
                AS.setText(awayScore + "");
            }
        });
    }

    public void minusToAwayScore()
    {
        minusAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(awayScore > 0) {
                    awayScore -= 1;
                    AS.setText(awayScore + "");
                }
            }
        });
    }

    public void addInning()
    {
        inning += 0.5;
        innings.setText(inning + "");
        if(inning % 1 != 0)
        {
            HS.setBackgroundColor(Color.DKGRAY);
            HS.setTextColor(0xFFFFFFFF);
            AS.setBackgroundColor(0xFFFFFFFF);
            AS.setTextColor(0xFF000000);
        }
        else{
            AS.setBackgroundColor(Color.DKGRAY);
            AS.setTextColor(0xFFFFFFFF);
            HS.setBackgroundColor(0xFFFFFFFF);//white
            HS.setTextColor(0xFF000000);//black
        }
    }

    public void minusInning()
    {
        if(inning > 1) {
            inning -= 0.5;
            innings.setText(inning + "");
        }
        if(inning % 1 != 0)
        {
            HS.setBackgroundColor(Color.DKGRAY);
            HS.setTextColor(0xFFFFFFFF);
            AS.setBackgroundColor(0xFFFFFFFF);
            AS.setTextColor(0xFF000000);
        }
        else{
            AS.setBackgroundColor(Color.DKGRAY);
            AS.setTextColor(0xFFFFFFFF);
            HS.setBackgroundColor(0xFFFFFFFF);//white
            HS.setTextColor(0xFF000000);//black
        }
    }

    public void addToBalls()
    {
        plusBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ball < 4) {
                    ball += 1;
                    balls.setText(ball + "");
                        if(ball == 4)
                        {
                            ball = 0;
                            balls.setText("0");
                            strike = 0;
                            strikes.setText("0");
                        }
                }
            }
        });
    }

    public void minusBall()
    {
        minusBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ball > 0) {
                    ball -= 1;
                    balls.setText(ball + "");
                }
            }
        });
    }

    public void addToStrikes()
    {
        plusStrinke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(strike < 3) {
                    strike += 1;
                    strikes.setText(strike + "");
                        if(strike == 3)
                        {
                            addOut();
                            ball = 0;
                            balls.setText("0");
                            strike = 0;
                            strikes.setText("0");

                        }
                }
            }
        });
    }

    public void minusStrike()
    {
        minusStrike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(strike > 0) {
                    strike -= 1;
                    strikes.setText(strike + "");
                }
            }
        });
    }

    public void addOut()
    {
        outCounter +=1;
        if(out < 3) {
            out += 1;
            outs.setText(out + "");
                if(out == 3)
                {
                    addInning();
                    ball = 0;
                    balls.setText("0");
                    strike = 0;
                    strikes.setText("0");
                    out = 0;
                    outs.setText("0");
                }
        }
    }

    public void minusOut()
    {
        outCounter-=1;
        if(out > 0) {
            out -= 1;
            outs.setText(out + "");
        }

    }

    public void changeDisplay()
    {
        if(outCounter%3 == 0)
        {
            HS.setBackgroundColor(Color.DKGRAY);
            HS.setTextColor(0xFFFFFFFF);
            AS.setBackgroundColor(0xFFFFFFFF);
            AS.setTextColor(0xFF000000);
        }
        else{
            AS.setBackgroundColor(Color.DKGRAY);
            AS.setTextColor(0xFFFFFFFF);
            HS.setBackgroundColor(0xFFFFFFFF);//white
            HS.setTextColor(0xFF000000);//black
        }
    }
}
