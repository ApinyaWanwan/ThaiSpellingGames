package com.project.finalyear.thaispellinggame.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.finalyear.thaispellinggame.R;
import com.project.finalyear.thaispellinggame.activity.GameOneActivity;


public class LearningMainFragment extends Fragment{
    Button btnLearning;
    Button btnThreeLetterLearning;


    public LearningMainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_main,
                container, false);
        initInstances(view);
        return view;
    }

    private void initInstances(final View view){
        btnLearning = (Button) view.findViewById(R.id.btnLearning);
        btnLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentLearningMainSection();
            }
        });
        btnThreeLetterLearning = (Button) view.findViewById(R.id.btnThreeLetterLearning);
        btnThreeLetterLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentThreeLetter();
            }
        });
    }

//    public void FragmentLearningMain() {
//        Fragment fragment = new FrequentlyLearningFragment();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.content_main, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }

//    public void FragmentSectionMaekok() {
//        Fragment fragment = new LearningSectionMaekokFragment();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.content_main, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
    public void FragmentLearningMainSection() {
        Fragment fragment = new LearningMainSectionFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void FragmentThreeLetter() {
        Fragment fragment = new ThreeLettersFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
