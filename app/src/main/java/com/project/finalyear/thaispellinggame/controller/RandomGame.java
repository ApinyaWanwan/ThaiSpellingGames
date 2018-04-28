package com.project.finalyear.thaispellinggame.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.finalyear.thaispellinggame.activity.GameFiveTutorialActivity;
import com.project.finalyear.thaispellinggame.activity.GameFourTutorialActivity;
import com.project.finalyear.thaispellinggame.activity.GameOneTutorialActivity;
import com.project.finalyear.thaispellinggame.activity.GameThreeTutorialActivity;
import com.project.finalyear.thaispellinggame.activity.SummaryActivity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Namwan on 3/5/2018.
 */

public class RandomGame {

    public void randomGame(final Context context) {

        final ArrayList<Class> activityList = new ArrayList<>();
        activityList.add(GameOneTutorialActivity.class);
        activityList.add(GameThreeTutorialActivity.class);
        activityList.add(GameFourTutorialActivity.class);
        activityList.add(GameFiveTutorialActivity.class);


        Log.d("myActivityList", activityList.toString());

        Random generator = new Random();
        int number = generator.nextInt(activityList.size()) + 1;

        Class activity = null;

        switch (number){
            case 1:
                activity = GameOneTutorialActivity.class;
                break;
            case 2:
                activity = GameThreeTutorialActivity.class;
                break;
            case 3:
                activity = GameFourTutorialActivity.class;
                break;
            default:
                activity = GameFiveTutorialActivity.class;
                break;
        }

        Log.d("myActivity", activity.toString());

        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
        ((Activity)context).finish();
    }


}
