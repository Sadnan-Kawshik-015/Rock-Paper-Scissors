package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OneVsOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_vs_one);
        Button rock1_btn=(Button)findViewById(R.id.rock1_btn);
        Button paper1_btn=(Button)findViewById(R.id.paper1_btn);
        Button scissors1_btn=(Button)findViewById(R.id.scissors1_btn);

        rock1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(Player2Choice.class,"rock");
                finish();
            }
        });
        paper1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(Player2Choice.class,"paper");
                finish();
            }
        });
        scissors1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(Player2Choice.class,"scissors");
                finish();
            }
        });
    }

    public void changeActivity(Class destination,String result)
    {
        Intent intent=new Intent(this,destination);
        intent.putExtra("Player 1 Choice",result);
        startActivity(intent);
    }
}
