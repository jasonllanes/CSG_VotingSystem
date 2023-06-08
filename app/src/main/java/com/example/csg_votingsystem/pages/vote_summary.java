package com.example.csg_votingsystem.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csg_votingsystem.R;
import com.example.csg_votingsystem.back.firebase_crud;

public class vote_summary extends AppCompatActivity {
    Button btnSubmit;
    TextView tvName,tvPresident,tvVice,tvSecretary,tvTreasurer,tvAuditor,tvInternal,tvExternal,tvFirst,tvSecond,tvThird,tvFourth,tvAmbassador;
    TextView tvvName,tvvPresident,tvvVice,tvvSecretary,tvvTreasurer,tvvAuditor,tvvInternal,tvvExternal,tvvFirst,tvvSecond,tvvThird,tvvFourth,tvvAmbassador;

    firebase_crud fd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_summary);

        fd = new firebase_crud();
        btnSubmit = findViewById(R.id.btnSubmit);

        tvName = findViewById(R.id.tvName);
        tvPresident = findViewById(R.id.tvPresident);
        tvVice = findViewById(R.id.tvVice);
        tvSecretary = findViewById(R.id.tvSecretary);
        tvTreasurer = findViewById(R.id.tvTreasurer);
        tvAuditor = findViewById(R.id.tvAuditor);
        tvInternal = findViewById(R.id.tvInternal);
        tvExternal = findViewById(R.id.tvExternal);

        tvSecond = findViewById(R.id.tvSecond);
        tvThird = findViewById(R.id.tvThird);
        tvFourth = findViewById(R.id.tvFourth);
        tvAmbassador = findViewById(R.id.tvAmbassador);



        tvvPresident = findViewById(R.id.tvvPresident);
        tvvVice = findViewById(R.id.tvvVice);
        tvvSecretary = findViewById(R.id.tvvSecretary);
        tvvTreasurer = findViewById(R.id.tvvTreasurer);
        tvvAuditor = findViewById(R.id.tvvAuditor);
        tvvInternal = findViewById(R.id.tvvInternal);
        tvvExternal = findViewById(R.id.tvvExternal);

        tvvSecond = findViewById(R.id.tvvSecond);
        tvvThird = findViewById(R.id.tvvThird);
        tvvFourth = findViewById(R.id.tvvFourth);
        tvvAmbassador = findViewById(R.id.tvvAmbassador);


        String name = getIntent().getStringExtra("name");
        String president = getIntent().getStringExtra("president");
        String vice = getIntent().getStringExtra("vice");
        String secretary = getIntent().getStringExtra("secretary");
        String treasurer = getIntent().getStringExtra("treasurer");
        String auditor = getIntent().getStringExtra("auditor");
        String internal = getIntent().getStringExtra("internal");
        String external = getIntent().getStringExtra("external");

        String second = getIntent().getStringExtra("second");
        String third = getIntent().getStringExtra("third");
        String fourth = getIntent().getStringExtra("fourth");
        String ambassador = getIntent().getStringExtra("ambassador");

        tvName.setText(name);
        tvPresident.setText(president);
        tvVice.setText(vice);
        tvSecretary.setText(secretary);
        tvTreasurer.setText(treasurer);
        tvAuditor.setText(auditor);
        tvInternal.setText(internal);
        tvExternal.setText(external);

        tvSecond.setText(second);
        tvThird.setText(third);
        tvFourth.setText(fourth);
        tvAmbassador.setText(ambassador);



        fd.retrieveVotes(president,tvvPresident,
                vice,tvvVice,
                secretary,tvvSecretary,
                treasurer,tvvTreasurer,
                auditor,tvvAuditor,
                internal,tvvInternal,
                external,tvvExternal,
                second,tvvSecond,
                third,tvvThird,
                fourth,tvvFourth,
                ambassador,tvvAmbassador
        );

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(vote_summary.this, "Successfully voted.", Toast.LENGTH_SHORT).show();
                int presidentVotes = Integer.parseInt(tvvPresident.getText().toString()) + 1;
                int viceVotes = Integer.parseInt(tvvVice.getText().toString()) + 1;
                int secretaryVotes = Integer.parseInt(tvvSecretary.getText().toString()) + 1;
                int treasurerVotes = Integer.parseInt(tvvTreasurer.getText().toString()) + 1;
                int auditorVotes = Integer.parseInt(tvvAuditor.getText().toString()) + 1;
                int internalVotes = Integer.parseInt(tvvInternal.getText().toString()) + 1;
                int externalVotes = Integer.parseInt(tvvExternal.getText().toString()) + 1;
                int secondVotes = Integer.parseInt(tvvSecond.getText().toString()) + 1;
                int thirdVotes = Integer.parseInt(tvvThird.getText().toString()) + 1;
                int fourthVotes = Integer.parseInt(tvvFourth.getText().toString()) + 1;
                int ambassadorVotes = Integer.parseInt(tvvAmbassador.getText().toString()) + 1;

                fd.addVoter(name);

                fd.addVote(president,String.valueOf(presidentVotes),
                        vice,String.valueOf(viceVotes),
                        secretary,String.valueOf(secretaryVotes),
                        treasurer,String.valueOf(treasurerVotes),
                        auditor,String.valueOf(auditorVotes),
                        internal,String.valueOf(internalVotes),
                        external,String.valueOf(externalVotes),
                        second,String.valueOf(secondVotes),
                        third,String.valueOf(thirdVotes),
                        fourth,String.valueOf(fourthVotes),
                        ambassador,String.valueOf(ambassadorVotes)
                        );
            }
        });





    }

    public void solveTali(){

    }


}