package com.project.finalyear.thaispellinggame.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.project.finalyear.thaispellinggame.R;
import com.project.finalyear.thaispellinggame.activity.GameLearnActivity;


public class LearningMainSectionFragment extends Fragment {

ImageView btnMaekok;
    ImageView btnMaekom;
    ImageView btnMaekong;
    ImageView btnMaekon;
    ImageView btnMaekod;
    ImageView btnMaekob;
    ImageView btnMaekery;
    ImageView btnMaeguew;
    Button btnBackLeaning;
    Button btnGameLearn;

    public LearningMainSectionFragment() {
        // Required empty public constructor
    }


    public static LearningMainSectionFragment newInstance(String param1, String param2) {
        LearningMainSectionFragment fragment = new LearningMainSectionFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_main_section,
                container, false);
        initInstances(view);
        return view;
    }

    private void initInstances(View view) {
        final Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.scale);
        btnMaeguew = (ImageView) view.findViewById(R.id.btnMaeguew);
        btnMaekon = (ImageView) view.findViewById(R.id.btnMaekon);
        btnMaekom = (ImageView) view.findViewById(R.id.btnMaekom);
        btnMaekod = (ImageView) view.findViewById(R.id.btnMaekod);
        btnMaekob = (ImageView) view.findViewById(R.id.btnMaekob);
        btnMaekok = (ImageView) view.findViewById(R.id.btnMaekok);
        btnMaekery = (ImageView) view.findViewById(R.id.btnMaekery);
        btnMaekong = (ImageView) view.findViewById(R.id.btnMaekong);
        btnBackLeaning = (Button) view.findViewById(R.id.btnBackLeaning);
        btnGameLearn = (Button) view.findViewById(R.id.btnGameLearn);


        btnMaeguew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//            view.startAnimation(animation);
                FragmentLearningMaeGuew();
            }
        });
        btnMaekom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentLearningMaeKom();
            }
        });
        btnMaekod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentLearningMaeKod();
            }
        });
        btnMaekob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentLearningMaeKob();
            }
        });
        btnMaekok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentLearningMaeKok();
            }
        });
        btnMaekery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentLearningMaeKery();
            }
        });
        btnMaekong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentLearningMaeKong();
            }
        });
        btnMaekon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentLearningMaeKon();
            }
        });
        btnBackLeaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentLearningMain();
            }
        });

        btnGameLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),GameLearnActivity.class);
                startActivity(intent);
            }
        });

    }

    public void FragmentLearningMaeGuew() {
        Fragment fragment = new LearningSectionMaegewFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void FragmentLearningMaeKok() {
        Fragment fragment = new LearningSectionMaekokFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void FragmentLearningMaeKon() {
        Fragment fragment = new LearningSectionMaekonFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void FragmentLearningMaeKom() {
        Fragment fragment = new LearningSectionMaekomFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void FragmentLearningMaeKod() {
        Fragment fragment = new LearningSectionMaekodFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void FragmentLearningMaeKob() {
        Fragment fragment = new LearningSectionMaekobFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void FragmentLearningMaeKery() {
        Fragment fragment = new LearningSectionMaekeryFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void FragmentLearningMaeKong() {
        Fragment fragment = new LearningSectionMeakongFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void FragmentLearningMain() {
        Fragment fragment = new LearningMainFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
