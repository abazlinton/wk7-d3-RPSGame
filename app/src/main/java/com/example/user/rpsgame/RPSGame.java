package com.example.user.rpsgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 09/11/2016.
 */

public class RPSGame extends AppCompatActivity {

    Button mRockButton;
    Button mPaperButton;
    Button mScissorsButton;
    String mPlayerMove;
    TextView mPlayerMoveTextView;
    String mPlayerMoveText;
    TextView mTrumpMoveTextView;
    String mTrumpMoveText;
    TextView mResultTextView;
    String mResultText;
    ImageView mTrump;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRockButton = (Button) findViewById(R.id.rock_button);
        mPaperButton = (Button) findViewById(R.id.paper_button);
        mScissorsButton = (Button) findViewById(R.id.scissors_button);
        mPlayerMoveTextView = (TextView) findViewById(R.id.player_move);
        mTrumpMoveTextView = (TextView) findViewById(R.id.trump_move);
        mResultTextView = (TextView) findViewById(R.id.result);
        mTrump = (ImageView) findViewById(R.id.trump);


        mRockButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){

               mPlayerMove = "rock";
               mPlayerMoveText = "Rock!";
               processPlayerMove();
           }
        });

        mPaperButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mPlayerMove = "paper";
                mPlayerMoveText = "Paper";
                processPlayerMove();
            }
        });

        mScissorsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mPlayerMove = "scissors";
                mPlayerMoveText = "Scissors";
                processPlayerMove();
            }
        });

    }

    protected void processPlayerMove(){
        mTrump.setVisibility(View.INVISIBLE);
        String newText = "Player move: " + mPlayerMoveText;
        mPlayerMoveTextView.setText(newText);
        processResult();
    }

    protected void processResult(){
        Log.d("RPSGAME", mPlayerMove);
        String[] results;
        int i =0;
        GameLogic gameLogic = new GameLogic(mPlayerMove);
        results = gameLogic.getResult();


        mTrumpMoveText = "Return Move";
        mTrumpMoveText = results[0].substring(0, 1).toUpperCase() + results[0].substring(1);
        String newTrumpMoveText = "Trump move: " + mTrumpMoveText;
        mTrumpMoveTextView.setText(newTrumpMoveText);

        //Todo: Get result back from Jo
        mResultText = "Return Result";
        String newResultMoveText = results[1];
        mResultTextView.setText(newResultMoveText);

        if (newResultMoveText.charAt(0) == 'T'){
            mTrump.setImageResource(R.drawable.trump_win);
            mTrump.setVisibility(View.VISIBLE);
        }

        if (newResultMoveText.charAt(0) == 'P'){
            mTrump.setImageResource(R.drawable.sad_trump);
            mTrump.setVisibility(View.VISIBLE);
        }





    }

}
