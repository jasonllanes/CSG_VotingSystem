package com.example.csg_votingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.csg_votingsystem.pages.view_voters;
import com.example.csg_votingsystem.pages.voting_pane;

public class home_activity extends AppCompatActivity {

    Button btnStart,btnVoters,btnVotes,btnQuit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home_activity.this, voting_pane.class);
                startActivity(i);
            }
        });

        btnVoters = findViewById(R.id.btnVoters);

        btnVoters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home_activity.this, view_voters.class);
                startActivity(i);
            }
        });

        btnVotes = findViewById(R.id.btnVotes);
        btnVotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(home_activity.this, "Wala pa nako na add hehe", Toast.LENGTH_SHORT).show();

            }
        });

        btnQuit = findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(home_activity.this, "I close ra ang app uy kapoy na code  HWAHWHAHWHA", Toast.LENGTH_SHORT).show();
            }
        });


    }


}