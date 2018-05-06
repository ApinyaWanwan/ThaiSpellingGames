package com.project.finalyear.thaispellinggame.controller;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.finalyear.thaispellinggame.R;
import com.project.finalyear.thaispellinggame.activity.GameActivity;
import com.project.finalyear.thaispellinggame.activity.GameFiveTutorialActivity;
import com.project.finalyear.thaispellinggame.activity.GameFourTutorialActivity;
import com.project.finalyear.thaispellinggame.activity.GameOneTutorialActivity;
import com.project.finalyear.thaispellinggame.activity.GameThreeTutorialActivity;
import com.project.finalyear.thaispellinggame.activity.SummaryActivity;
import com.project.finalyear.thaispellinggame.fragment.GameFiveTutorialFragment;
import com.project.finalyear.thaispellinggame.fragment.GameFourTutorialFragment;
import com.project.finalyear.thaispellinggame.fragment.GameOneTutorialFragment;
import com.project.finalyear.thaispellinggame.fragment.GameThreeTutorialFragment;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Namwan on 3/5/2018.
 */

public class RandomGame {

    private FirebaseAuth mAuth;
    private DatabaseReference mRefDatabase;
    private FirebaseUser mCurrentUser;
    private String current_uid;
    private ArrayList gameName = new ArrayList();

    public RandomGame(GameActivity gameActivity) {
        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        current_uid = mCurrentUser.getUid();
        mRefDatabase = FirebaseDatabase.getInstance().getReference();

        gameName.add("gameOne");
        gameName.add("gameThree");
        gameName.add("gameFour");
        gameName.add("gameFive");

        Random random = new Random();
        int number = random.nextInt(gameName.size());

        switch (number) {
            case 1:
                saveGameToDatabase("gameOne");
                loadFragment(gameActivity, new GameOneTutorialFragment());
                break;
            case 2:
                saveGameToDatabase("gameThree");
                loadFragment(gameActivity, new GameThreeTutorialFragment());
                break;
            case 3:
                saveGameToDatabase("gameFour");
                loadFragment(gameActivity, new GameFourTutorialFragment());
                break;
            default:
                saveGameToDatabase("gameFive");
                loadFragment(gameActivity, new GameFiveTutorialFragment());
                break;
        }
    }

    private void saveGameToDatabase(final String game){

        mRefDatabase = FirebaseDatabase.getInstance().getReference();
        mRefDatabase.child("players").child(current_uid).child("roomId").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final String roomId = dataSnapshot.getValue().toString();

                mRefDatabase.child("rooms").child(roomId).child("Game").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (!dataSnapshot.exists()) {
                            mRefDatabase.child("rooms").child(roomId).child("Game").child("round1").setValue(game);
                        }
//                        }else {
//
//                            if (dataSnapshot.hasChild("round1")){
//                                String gameRound1 = dataSnapshot.child("round1").getValue().toString();
//                                gameName.remove(gameRound1);
//                            }
//                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void loadFragment(Context context, Fragment fragment){

        ((AppCompatActivity) context).getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.game, fragment)
                //.addToBackStack(null)
                .commit();

    }




}
