package com.project.finalyear.thaispellinggame.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.project.finalyear.thaispellinggame.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.finalyear.thaispellinggame.activity.GameActivity;
import com.project.finalyear.thaispellinggame.activity.RandomPlayersActivity;
import com.project.finalyear.thaispellinggame.model.MyBounceInterpolator;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment {

    // Android Layout
    private CircleImageView mDisplayImage;
    private TextView mName;
    private TextView tvRank, tvLevel;
    private TextView tvBestScore, tvScore;
    private ImageView progressBar;
    private Button btnPlayGame;

    private FirebaseAuth mAuth;
    private DatabaseReference mRefDatabase;
    private DatabaseReference mUserDatabase;
    private FirebaseUser mCurrentUser;
    private String current_uid;

    Context context;
    private RatingBar rbRating;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity().getApplicationContext();
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        current_uid = mCurrentUser.getUid();
        mRefDatabase = FirebaseDatabase.getInstance().getReference();

        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(current_uid);
        mUserDatabase.keepSynced(true);

        //Typeface font  = Typeface.createFromAsset(getActivity().getAssets(), "fonts/RSU_BOLD.ttf");

        btnPlayGame = (Button) view.findViewById(R.id.btn_play_game);

        final Animation animBounce = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        animBounce.setInterpolator(interpolator);

        btnPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckInternet();
                view.startAnimation(animBounce);

                DatabaseReference userRef = mRefDatabase.child("players").child(current_uid);
                userRef.child("status").setValue(true)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()){

                                    Intent intent = new Intent(getActivity(), RandomPlayersActivity.class);
                                    startActivity(intent);


                                }else
                                    Toast.makeText(context,"กรุณาลองใหม่อีกครั้ง", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });

        initInstances(view);


        return view;
    }

    private void initInstances(View view) {

        mName = (TextView) view.findViewById(R.id.tvProfile);
        mDisplayImage = (CircleImageView) view.findViewById(R.id.profilePic);
        tvRank = (TextView) view.findViewById(R.id.tvRank);
        tvLevel = (TextView) view.findViewById(R.id.tvLevel);
        tvScore = (TextView) view.findViewById(R.id.tv_score);
        tvBestScore = (TextView) view.findViewById(R.id.tv_best_score);
        progressBar = (ImageView) view.findViewById(R.id.progressBar);

        rbRating = (RatingBar) view.findViewById(R.id.rbRating);
        rbRating.setMax(100);
        checkLevel();


        mUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.child("name").getValue(String.class);
                String image = dataSnapshot.child("image").getValue(String.class);
                String level = dataSnapshot.child("level").getValue().toString();
                String rank = dataSnapshot.child("rank").getValue().toString();
                String score = dataSnapshot.child("score").getValue().toString();
                String bestScore = dataSnapshot.child("bestScore").getValue().toString();


                if (image.equals("default_profile_pic")) {
                    Picasso.with(context).load(R.drawable.default_profile_pic)
                            .error(context.getResources().getDrawable(R.drawable.default_profile_pic)).into(mDisplayImage);

                } else {
                    Picasso.with(getContext()).load(image).resize(150, 150)
                            .centerCrop().into(mDisplayImage);
                }

                int scoreUp = Integer.parseInt(score);
                Log.d("scoreUp", String.valueOf(scoreUp));
                if (scoreUp <= 50000) {
                    tvLevel.setText("1");
                    mUserDatabase.child(current_uid).child("level").setValue(1);
                } else if (scoreUp <= 100000) {
                    tvLevel.setText("2");
                    mUserDatabase.child(current_uid).child("level").setValue(2);
                } else if (scoreUp <= 150000) {
                    tvLevel.setText("3");
                    mUserDatabase.child(current_uid).child("level").setValue(3);
                } else if (scoreUp <= 200000) {
                    tvLevel.setText("4");
                    mUserDatabase.child(current_uid).child("level").setValue(4);
                } else if (scoreUp <= 250000) {
                    tvLevel.setText("5");
                    mUserDatabase.child(current_uid).child("level").setValue(5);
                } else if (scoreUp <= 300000) {
                    tvLevel.setText("6");
                    mUserDatabase.child(current_uid).child("level").setValue(6);
                } else if (scoreUp <= 350000) {
                    tvLevel.setText("7");
                    mUserDatabase.child(current_uid).child("level").setValue(7);
                } else if (scoreUp <= 400000) {
                    tvLevel.setText("8");
                    mUserDatabase.child(current_uid).child("level").setValue(8);
                } else if (scoreUp <= 450000) {
                    tvLevel.setText("9");
                    mUserDatabase.child(current_uid).child("level").setValue(9);
                } else {
                    tvLevel.setText("10");
                    mUserDatabase.child(current_uid).child("level").setValue(10);
                }


                mName.setText(name);
                tvRank.setText(rank);
                // tvLevel.setText(level);
                tvScore.setText(score);
                tvBestScore.setText(bestScore);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    public void checkLevel() {
        mUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
                String score = dataSnapshot.child("score").getValue().toString();
                int scoreRating = Integer.parseInt(score);
                String level = dataSnapshot.child("level").getValue().toString();
                int levelRating = Integer.parseInt(level);
                if (levelRating <= 1) {
                    checkRating(scoreRating);
                } else if (levelRating <= 2) {
                    scoreRating = scoreRating - 50000;
                    checkRating(scoreRating);

                } else if (levelRating <= 3) {
                    scoreRating = scoreRating - 50000;
                    checkRating(scoreRating);

                } else if (levelRating <= 4) {
                    scoreRating = scoreRating - 100000;
                    checkRating(scoreRating);

                } else if (levelRating <= 5) {
                    scoreRating = scoreRating - 150000;
                    checkRating(scoreRating);

                } else if (levelRating <= 6) {
                    scoreRating = scoreRating - 200000;
                    checkRating(scoreRating);

                } else if (levelRating <= 7) {
                    scoreRating = scoreRating - 250000;
                    checkRating(scoreRating);

                } else if (levelRating <= 8) {
                    scoreRating = scoreRating - 300000;
                    checkRating(scoreRating);

                } else if (levelRating <= 9) {
                    scoreRating = scoreRating - 350000;
                    checkRating(scoreRating);
                } else {
                    scoreRating = scoreRating - 400000;
                    checkRating(scoreRating);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void checkRating(int scoreRating) {
        final int scoreCheck = scoreRating;
        mUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (scoreCheck == 0) {
                    rbRating.setProgress(0);
                } else if (scoreCheck <= 5000) {
                    rbRating.setProgress(10);
                } else if (scoreCheck <= 10000) {
                    rbRating.setProgress(20);
                } else if (scoreCheck <= 15000) {
                    rbRating.setProgress(25);
                } else if (scoreCheck <= 20000) {
                    rbRating.setProgress(40);
                } else if (scoreCheck <= 25000) {
                    rbRating.setProgress(45);
                } else if (scoreCheck <= 30000) {
                    rbRating.setProgress(60);
                } else if (scoreCheck <= 35000) {
                    rbRating.setProgress(65);
                } else if (scoreCheck <= 40000) {
                    rbRating.setProgress(80);
                } else if (scoreCheck <= 45000) {
                    rbRating.setProgress(95);
                } else if (scoreCheck <= 50000) {
                    rbRating.setProgress(100);
                }
            }


        @Override
        public void onCancelled (DatabaseError databaseError){

        }
    });


}

    public void CheckInternet() {
        if (!isNetworkAvailable()) {
            Toast.makeText(getContext(), "กรุณาเชื่อมต่ออินเทอร์เน็ตด้วยค่ะ !", Toast.LENGTH_SHORT).show();

        }

    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

}
