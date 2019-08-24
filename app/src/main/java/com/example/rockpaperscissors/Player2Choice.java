package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Player2Choice extends AppCompatActivity {


    String choice1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2_choice);
        Button rock2_btn=(Button)findViewById(R.id.rock2_btn);
        Button paper2_btn=(Button)findViewById(R.id.paper2_btn);
        Button scissors2_btn=(Button)findViewById(R.id.scissors2_btn);

        Bundle bundle=getIntent().getExtras();
        choice1=bundle.getString("Player 1 Choice");
        //Toast.makeText(this,choice1,Toast.LENGTH_SHORT).show();

        rock2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(WinnerDetermination.class,"rock",choice1);
                finish();
            }
        });

        paper2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(WinnerDetermination.class,"paper",choice1);
                finish();
            }
        });
        scissors2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(WinnerDetermination.class,"scissors",choice1);
                finish();
            }
        });
    }
    public void changeActivity(Class destination,String result1,String result2)
    {
        Intent intent=new Intent(this,destination);
        intent.putExtra("Player 2 Choice",result1);
        intent.putExtra("Player 1 Choice",result2);
        startActivity(intent);
    }
}
