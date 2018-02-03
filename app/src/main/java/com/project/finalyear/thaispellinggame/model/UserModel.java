package com.project.finalyear.thaispellinggame.model;

/**
 * Created by Namwan on 11/20/2017.
 */
import android.view.View;

import com.project.finalyear.thaispellinggame.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserModel {

    public String name;
//    public String score;
//    public String rank;
//    public String level;
    //public String image;
    //public boolean online;

    public UserModel() {

    }

    public UserModel(String name) {
        this.name = name;
//        this.score = score;
//        this.rank = rank;
        //this.image = image;
        //this.online = online;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getScore() {
//        return score;
//    }
//
//    public void setScore(String score) {
//        this.score = score;
//    }
//
//    public String getRank() {
//        return rank;
//    }
//
//    public void setRank(String rank) {
//        this.rank = rank;
//    }
//
//    public String getLevel() {
//        return level;
//    }
//
//    public void setLevel(String level) {
//        this.level = level;
//    }

    //    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

//    public boolean isOnline() {
//        return online;
//    }
//
//    public void setOnline(boolean online) {
//        this.online = online;
//    }
}
