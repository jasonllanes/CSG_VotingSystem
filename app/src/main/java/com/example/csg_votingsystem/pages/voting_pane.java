package com.example.csg_votingsystem.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.csg_votingsystem.R;

public class voting_pane extends AppCompatActivity {

    Button btnSummary;

    EditText etName;
    RadioGroup rgPresident,rgVice,rgSecretary,rgTreasurer,rgAuditor,rgInternal,rgExternal,rgFirst,rgSecond,rgThird,rgFourth,rgAmbassador;
    RadioButton rbPresident,rbVice,rbSecretary,rbTreasurer,rbAuditor,rbInternal,rbExternal,rbFirst,rbSecond,rbThird,rbFourth,rbAmbassador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_pane);

        etName = findViewById(R.id.etName);

        btnSummary = findViewById(R.id.btnSummary);

        rgPresident = findViewById(R.id.rgPresident);
        rgVice = findViewById(R.id.rgVice);
        rgSecretary = findViewById(R.id.rgSecretary);
        rgTreasurer = findViewById(R.id.rgTreasurer);
        rgAuditor = findViewById(R.id.rgAuditor);
        rgInternal = findViewById(R.id.rgInternal);
        rgExternal = findViewById(R.id.rgExternal);

        rgSecond = findViewById(R.id.rgSecond);
        rgThird = findViewById(R.id.rgThird);
        rgFourth = findViewById(R.id.rgFourth);
        rgAmbassador = findViewById(R.id.rgAmbassador);



        btnSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int president = rgPresident.getCheckedRadioButtonId();
                int vice = rgVice.getCheckedRadioButtonId();
                int secretary = rgSecretary.getCheckedRadioButtonId();
                int treasurer = rgTreasurer.getCheckedRadioButtonId();
                int auditor = rgAuditor.getCheckedRadioButtonId();
                int internal = rgInternal.getCheckedRadioButtonId();
                int external = rgExternal.getCheckedRadioButtonId();

                int second = rgSecond.getCheckedRadioButtonId();
                int third = rgThird.getCheckedRadioButtonId();
                int fourth = rgFourth.getCheckedRadioButtonId();
                int ambassador = rgAmbassador.getCheckedRadioButtonId();


                rbPresident = findViewById(president);
                rbVice = findViewById(vice);
                rbSecretary = findViewById(secretary);
                rbTreasurer = findViewById(treasurer);
                rbAuditor = findViewById(auditor);
                rbInternal = findViewById(internal);
                rbExternal = findViewById(external);

                rbSecond = findViewById(second);
                rbThird = findViewById(third);
                rbFourth = findViewById(fourth);
                rbAmbassador = findViewById(ambassador);



                Toast.makeText(voting_pane.this, rbPresident.getText(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(voting_pane.this,vote_summary.class);
                i.putExtra("name",etName.getText().toString());
                i.putExtra("president",rbPresident.getText().toString());
                i.putExtra("vice",rbVice.getText().toString());
                i.putExtra("secretary",rbSecretary.getText().toString());
                i.putExtra("treasurer",rbTreasurer.getText().toString());
                i.putExtra("auditor",rbAuditor.getText().toString());
                i.putExtra("internal",rbInternal.getText().toString());
                i.putExtra("external",rbExternal.getText().toString());

                i.putExtra("second",rbSecond.getText().toString());
                i.putExtra("third",rbThird.getText().toString());
                i.putExtra("fourth",rbFourth.getText().toString());
                i.putExtra("ambassador",rbAmbassador.getText().toString());
                startActivity(i);
            }
        });

    }
}