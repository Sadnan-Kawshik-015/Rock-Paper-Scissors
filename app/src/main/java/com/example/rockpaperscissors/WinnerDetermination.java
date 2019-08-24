package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WinnerDetermination extends AppCompatActivity {

    static int player_1_score=0;
    static int player_2_score=0;
    ImageView player1_choice_iv;
    ImageView player2_choice_iv;
    TextView score_tv;
    Button play_again;
    Button exit_result;
    Intent intent;
    String player1,player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_determination);
        player1_choice_iv=(ImageView)findViewById(R.id.player_1_final_choice_iv);
        player2_choice_iv=(ImageView)findViewById(R.id.player_2_final_choice_iv);
        score_tv=(TextView)findViewById(R.id.score_tv);
        play_again=(Button)findViewById(R.id.play_again_btn);
        exit_result=(Button)findViewById(R.id.exit_result_btn);

        Bundle bundle=getIntent().getExtras();
        player1=bundle.getString("Player 1 Choice");
        player2=bundle.getString("Player 2 Choice");
        //7Toast.makeText(this,player2,Toast.LENGTH_SHORT).show();
        String result="";
        String message="";

        if(player1.equals("rock"))
        {
            player1_choice_iv.setImageResource(R.drawable.rock);
            if(player2.equals("rock"))
            {
                player2_choice_iv.setImageResource(R.drawable.rock);
                result+="It is a draw!!!";
            }
            else if(player2.equals("paper"))
            {
                player2_choice_iv.setImageResource(R.drawable.paper);
                player_2_score++;
                result+="Player 2 Wins!!!";
            }
            else if(player2.equals("scissors"))
            {
                player2_choice_iv.setImageResource(R.drawable.scissors);
                player_1_score++;
                result+="Player 1 Wins!!!";
            }
        }
        else if(player1.equals("paper"))
        {
            player1_choice_iv.setImageResource(R.drawable.paper);
            if(player2.equals("paper"))
            {
                player2_choice_iv.setImageResource(R.drawable.paper);
                result+="It is a draw!!!";
            }
            else if(player2.equals("scissors"))
            {
                player2_choice_iv.setImageResource(R.drawable.scissors);
                player_2_score++;
                result+="Player 2 Wins!!!";
            }
            else if(player2.equals("rock"))
            {
                player2_choice_iv.setImageResource(R.drawable.rock);
                player_1_score++;
                result+="Player 1 Wins!!!";
            }
        }
        else if(player1.equals("scissors"))
        {
            player1_choice_iv.setImageResource(R.drawable.scissors);
            if(player2=="scissors")
            {
                player2_choice_iv.setImageResource(R.drawable.scissors);
                result+="It is a draw!!!";
            }
            else if(player2.equals("rock"))
            {
                player2_choice_iv.setImageResource(R.drawable.rock);
                player_2_score++;
                result+="Player 2 Wins!!!";
            }
            else if(player2.equals("paper"))
            {
                player2_choice_iv.setImageResource(R.drawable.paper);
                player_1_score++;
                result+="Player 1 Wins!!!";
            }
        }
        Toast.makeText(WinnerDetermination.this,result,Toast.LENGTH_SHORT).show();
        message+="Score- Player1 : "+player_1_score+" Player2 : "+player_2_score;
        score_tv.setText(message);
        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(OneVsOne.class);
                finish();
            }
        });
        exit_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_1_score=0;
                player_2_score=0;
                changeActivity(MainActivity.class);
                finish();
            }
        });


    }

    public void changeActivity(Class destination)
    {
        Intent intent=new Intent(this,destination);
        startActivity(intent);
    }

}
