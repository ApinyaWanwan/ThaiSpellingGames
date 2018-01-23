package com.project.finalyear.thaispellinggame.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.project.finalyear.thaispellinggame.R;


public class LearningSectionMaekokFragment extends Fragment {
    ImageView imgBack;
    ImageView imgNext;
    MediaPlayer mediaPlayer;


    public LearningSectionMaekokFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_section_maekok, container, false);
        initInstance(view);
        PlaySound();
        return view;
    }

    private void initInstance(View view) {
        imgNext = (ImageView) view.findViewById(R.id.imgNext);
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentLearningMain();
            }
        });
        imgBack = (ImageView) view.findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentLearningMainSection();
            }
        });

    }

    public void FragmentLearningMain() {
        Fragment fragment = new FrequentlyLearningFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void FragmentLearningMainSection() {
        Fragment fragment = new LearningMainSectionFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void PlaySound() {
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.maekok);
        mediaPlayer.start();


    }

    // ทำงานเมื่อเปิด app เข้ามา
    public void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    // ทำงานเมื่อแอปหยุดทำงานชั่วคราว
    public void onPause() {
        super.onPause();
        mediaPlayer.pause();
        mediaPlayer.release();

    }

    // ทำงานเมื่อแอปถูปิดลง
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
