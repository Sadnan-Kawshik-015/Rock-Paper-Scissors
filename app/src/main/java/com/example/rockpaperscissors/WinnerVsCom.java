package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class WinnerVsCom extends AppCompatActivity {

    static int player_score=0;
    static int com_score=0;
    ImageView player_choice_iv;
    ImageView com_choice_iv;
    TextView score_2_tv;
    Button play_again_2;
    Button exit_result_2;
    String player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_vs_com);

        player_choice_iv=(ImageView)findViewById(R.id.player_final_choice_iv);
        score_2_tv=(TextView)findViewById(R.id.score_2_tv);
        play_again_2=(Button)findViewById(R.id.play_again_btn_2);

        exit_result_2=(Button)findViewById(R.id.exit_result_btn_2);
        com_choice_iv=(ImageView)findViewById(R.id.com_choice_iv);

        Bundle bundle=getIntent().getExtras();
        player=bundle.getString("Player Choice");
        String result="";
        String message="";
        result=playTurn(player);
        Toast.makeText(WinnerVsCom.this,result,Toast.LENGTH_SHORT).show();
        message+="Score- Player1 : "+player_score+" Player2 : "+com_score;
        score_2_tv.setText(message);
        play_again_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(OneVsCom.class);
                finish();
            }
        });
        exit_result_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_score=0;
                com_score=0;
                changeActivity(MainActivity.class);
                finish();
            }
        });


    }
    public String playTurn(String player)
    {
        Random r= new Random();
        int com_choice=r.nextInt(3)+1;
        String player2="";
        String result="";
        if(com_choice==1)
        {
            player2+="rock";
        }
        else if(com_choice==2)
        {
            player2+="paper";
        }
        else if(com_choice==3)
        {
            player2+="scissors";
        }
        if(player.equals("rock"))
        {
            player_choice_iv.setImageResource(R.drawable.rock);
            if(player2.equals("rock"))
            {
                com_choice_iv.setImageResource(R.drawable.rock);
                result+="It is a draw!!!";
            }
            else if(player2.equals("paper"))
            {
                com_choice_iv.setImageResource(R.drawable.paper);
                com_score++;
                result+="Player 2 Wins!!!";
            }
            else if(player2.equals("scissors"))
            {
                com_choice_iv.setImageResource(R.drawable.scissors);
                player_score++;
                result+="Player 1 Wins!!!";
            }
        }
        else if(player.equals("paper"))
        {
            player_choice_iv.setImageResource(R.drawable.paper);
            if(player2.equals("paper"))
            {
                com_choice_iv.setImageResource(R.drawable.paper);
                result+="It is a draw!!!";
            }
            else if(player2.equals("scissors"))
            {
                com_choice_iv.setImageResource(R.drawable.scissors);
                com_score++;
                result+="Player 2 Wins!!!";
            }
            else if(player2.equals("rock"))
            {
                com_choice_iv.setImageResource(R.drawable.rock);
                player_score++;
                result+="Player 1 Wins!!!";
            }
        }
        else if(player.equals("scissors"))
        {
            player_choice_iv.setImageResource(R.drawable.scissors);
            if(player2=="scissors")
            {
                com_choice_iv.setImageResource(R.drawable.scissors);
                result+="It is a draw!!!";
            }
            else if(player2.equals("rock"))
            {
                com_choice_iv.setImageResource(R.drawable.rock);
                com_score++;
                result+="Player 2 Wins!!!";
            }
            else if(player2.equals("paper"))
            {
                com_choice_iv.setImageResource(R.drawable.paper);
                player_score++;
                result+="Player 1 Wins!!!";
            }
        }
        return  result;
    }
    public void changeActivity(Class destination)
    {
        Intent intent=new Intent(this,destination);
        startActivity(intent);
    }

}
