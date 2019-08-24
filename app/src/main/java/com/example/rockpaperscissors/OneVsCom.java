package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OneVsCom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_vs_com);
        Button rock_btn=(Button)findViewById(R.id.rock_btn);
        Button paper_btn=(Button)findViewById(R.id.paper_btn);
        Button scissors_btn=(Button)findViewById(R.id.scissors_btn);

        rock_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(WinnerVsCom.class,"rock");
                finish();
            }
        });
        paper_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(WinnerVsCom.class,"paper");
                finish();
            }
        });
        scissors_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(WinnerVsCom.class,"scissors");
                finish();
            }
        });
    }

    public void changeActivity(Class destination,String result)
    {
        Intent intent=new Intent(this,destination);
        intent.putExtra("Player Choice",result);
        startActivity(intent);
    }
}

