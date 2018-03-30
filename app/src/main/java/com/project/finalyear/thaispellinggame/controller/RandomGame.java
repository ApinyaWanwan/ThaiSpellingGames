package com.project.finalyear.thaispellinggame.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.project.finalyear.thaispellinggame.activity.GameFiveTutorialActivity;
import com.project.finalyear.thaispellinggame.activity.GameFourTutorialActivity;
import com.project.finalyear.thaispellinggame.activity.GameOneTutorialActivity;
import com.project.finalyear.thaispellinggame.activity.GameThreeTutorialActivity;

import java.util.Random;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Namwan on 3/5/2018.
 */

public class RandomGame {

    Context context;

    public Random rnd = new Random();

    public RandomGame(Context context) {
        this.context = context;
    }

    public void RandomGame(){

        int x = rnd.nextInt(4);

        Intent intent = new Intent();

        switch(x){
            case 1:
                intent.setClass(getApplicationContext(), GameOneTutorialActivity.class);
                break;
            case 2:
                intent.setClass(getApplicationContext(), GameThreeTutorialActivity.class);
                break;
            case 3:
                intent.setClass(getApplicationContext(), GameFourTutorialActivity.class);
                break;
            case 4:
                intent.setClass(getApplicationContext(), GameFiveTutorialActivity.class);
                break;
        }
    }

}
