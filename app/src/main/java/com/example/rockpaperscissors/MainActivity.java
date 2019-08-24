package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button one_vs_one_btn=(Button)findViewById(R.id.one_vs_one_btn);

        Button one_vs_com_btn=(Button)findViewById(R.id.one_vs_com_btn);


        Button exit_btn=(Button)findViewById(R.id.exit_btn);

        one_vs_com_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(OneVsCom.class);
                finish();
            }
        });

        one_vs_one_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(OneVsOne.class);
                finish();
            }
        });
        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void changeActivity(Class destination)
    {
        Intent intent=new Intent(MainActivity.this,destination);
        startActivity(intent);
    }
}
