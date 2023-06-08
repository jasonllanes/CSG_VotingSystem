package com.example.csg_votingsystem.back;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.csg_votingsystem.data.voted_records;
import com.example.csg_votingsystem.data.voter_data;
import com.example.csg_votingsystem.home_activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class firebase_crud {

    FirebaseDatabase database = FirebaseDatabase.getInstance();


    public void addVoter(String name){
        DatabaseReference voterRef = database.getReference("Voted");

        voter_data voter = new voter_data(name);

        voterRef.child(name).setValue(voter).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });
    }

    public void addVote(Activity activity,Context context,
                        String president_name,String president_vote,
                        String vice_president_name,String vice_president_vote,
                        String secretary_name,String secretary_vote,
                        String treasurer_name,String treasurer_vote,
                        String auditor_name,String auditor_vote,
                        String internal_name,String internal_vote,
                        String external_name,String external_vote,
                        String second_name,String second_vote,
                        String third_name,String third_vote,
                        String fourth_name,String fourth_vote,
                        String ambassador_name,String ambassador_vote
    ){
        DatabaseReference president = database.getReference("President");
        DatabaseReference vice_president = database.getReference("Vice President");
        DatabaseReference secretary = database.getReference("Secretary");
        DatabaseReference treasurer = database.getReference("Treasurer");
        DatabaseReference auditor = database.getReference("Auditor");
        DatabaseReference internal = database.getReference("Internal PIO");
        DatabaseReference external  = database.getReference("External PIO");
        DatabaseReference second  = database.getReference("2nd Year Representative");
        DatabaseReference third = database.getReference("3rd Year Representative");
        DatabaseReference fourth = database.getReference("4th Year Representative");
        DatabaseReference ambassador = database.getReference("Ambassador");


        voted_records vPres = new voted_records(president_name,president_vote);
        voted_records vVice = new voted_records(vice_president_name,vice_president_vote);
        voted_records vSec = new voted_records(secretary_name,secretary_vote);
        voted_records vTre = new voted_records(treasurer_name,treasurer_vote);
        voted_records vAud = new voted_records(auditor_name,auditor_vote);
        voted_records vInt = new voted_records(internal_name,internal_vote);
        voted_records vExt = new voted_records(external_name,external_vote);
        voted_records vSeco = new voted_records(second_name,second_vote);
        voted_records vThi = new voted_records(third_name,third_vote);
        voted_records vFour = new voted_records(fourth_name,fourth_vote);
        voted_records vAmba = new voted_records(ambassador_name,ambassador_vote);


        president.child(president_name).setValue(vPres).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                vice_president.child(vice_president_name).setValue(vVice).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        secretary.child(secretary_name).setValue(vSec).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                treasurer.child(treasurer_name).setValue(vTre).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        auditor.child(auditor_name).setValue(vAud).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                internal.child(internal_name).setValue(vInt).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        external.child(external_name).setValue(vExt).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                second.child(second_name).setValue(vSeco).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                    @Override
                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                        third.child(third_name).setValue(vThi).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                            @Override
                                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                                fourth.child(fourth_name).setValue(vFour).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                    @Override
                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                        ambassador.child(ambassador_name).setValue(vAmba).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                            @Override
                                                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                                                Toast.makeText(context, "Successfully voted.", Toast.LENGTH_SHORT).show();
                                                                                                Intent i = new Intent(context, home_activity.class)
                                                                                                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); ;
                                                                                                context.startActivity(i);
                                                                                                activity.finish();
                                                                                            }
                                                                                        });
                                                                                    }
                                                                                });
                                                                            }
                                                                        });
                                                                    }
                                                                });
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });









            }
        });
    }

    public void retrieveVotes(String president_name, TextView president_vote,
                              String vice_president_name, TextView vice_president_vote,
                              String secretary_name, TextView secretary_vote,
                              String treasurer_name, TextView treasurer_vote,
                              String auditor_name, TextView auditor_vote,
                              String internal_name, TextView internal_vote,
                              String external_name, TextView external_vote,
                              String second_name, TextView second_vote,
                              String third_name, TextView third_vote,
                              String fourth_name, TextView fourth_vote,
                              String ambassador_name, TextView ambassador_vote
    ){

        DatabaseReference president = database.getReference("President");
        DatabaseReference vice_president = database.getReference("Vice President");
        DatabaseReference secretary = database.getReference("Secretary");
        DatabaseReference treasurer = database.getReference("Treasurer");
        DatabaseReference auditor = database.getReference("Auditor");
        DatabaseReference internal = database.getReference("Internal PIO");
        DatabaseReference external  = database.getReference("External PIO");
        DatabaseReference second  = database.getReference("2nd Year Representative");
        DatabaseReference third = database.getReference("3rd Year Representative");
        DatabaseReference fourth = database.getReference("4th Year Representative");
        DatabaseReference ambassador = database.getReference("Ambassador");

        president.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                president_vote.setText(snapshot.child(president_name).child("votes").getValue(String.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        vice_president.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                vice_president_vote.setText(snapshot.child(vice_president_name).child("votes").getValue(String.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        secretary.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                secretary_vote.setText(snapshot.child(secretary_name).child("votes").getValue(String.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        treasurer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                treasurer_vote.setText(snapshot.child(treasurer_name).child("votes").getValue(String.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        auditor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                auditor_vote.setText(snapshot.child(auditor_name).child("votes").getValue(String.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        internal.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                internal_vote.setText(snapshot.child(internal_name).child("votes").getValue(String.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        external.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                external_vote.setText(snapshot.child(external_name).child("votes").getValue(String.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        second.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                second_vote.setText(snapshot.child(second_name).child("votes").getValue(String.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        third.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                third_vote.setText(snapshot.child(third_name).child("votes").getValue(String.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        fourth.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                fourth_vote.setText(snapshot.child(fourth_name).child("votes").getValue(String.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ambassador.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ambassador_vote.setText(snapshot.child(ambassador_name).child("votes").getValue(String.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


    }



}
