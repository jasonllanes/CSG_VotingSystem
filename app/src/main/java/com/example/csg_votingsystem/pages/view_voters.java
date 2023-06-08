package com.example.csg_votingsystem.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csg_votingsystem.R;
import com.example.csg_votingsystem.data.voter_data;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class view_voters extends AppCompatActivity {
    FirebaseListAdapter listAdapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    ListView lvContributions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_voters);


        lvContributions = findViewById(R.id.lvContributions);

        retrieveContributions(this,"name",lvContributions);


    }
    public void retrieveContributions(Activity activity, String name, ListView contributionList){


        Query query = FirebaseDatabase.getInstance().getReference().child( "Voted");
        FirebaseListOptions<voter_data> o = new FirebaseListOptions.Builder<voter_data>()
                .setLayout(R.layout.voter_list)
                .setQuery(query,voter_data.class)
                .build();
        listAdapter = new FirebaseListAdapter(o) {
            @Override
            protected void populateView(View v, Object model, int position) {
                String name;
                TextView voter_name = v.findViewById(R.id.tvName);

                voter_data vd = (voter_data) model;
                name = ((voter_data) model).getName();
                voter_name.setText(((voter_data) model).getName());

                contributionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(view_voters.this, "Basta naka butar na ni siya", Toast.LENGTH_SHORT).show();
                    }
                });

//                contributionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        TextView tvID = view.findViewById(R.id.tvID);
//                        String contribution_id = tvID.getText().toString();
//                        Intent intent = new Intent(activity, edit_contribution.class);
//                        intent.putExtra("id",id);
//                        intent.putExtra("contribution_id",contribution_id);
//                        intent.putExtra("barangay",barangay);
//                        activity.startActivity(intent);
//
//                    }
//                });

            }
        };
        contributionList.setAdapter(listAdapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        listAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        listAdapter.stopListening();
    }
}