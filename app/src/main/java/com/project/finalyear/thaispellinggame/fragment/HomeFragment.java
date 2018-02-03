package com.project.finalyear.thaispellinggame.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.finalyear.thaispellinggame.R;
import com.project.finalyear.thaispellinggame.activity.GameOneActivity;
import com.project.finalyear.thaispellinggame.activity.RandomPlayerActivity;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mUserDatabase;
    private FirebaseUser mCurrentUser;

    // Android Layout
    private CircleImageView mDisplayImage;
    private TextView mName;
    private TextView tvRank, tvLevel;
    private ImageView progressBar;
    private Button btnPlayGame,btnBestScore,btnScore;

    public final String img_profile_default_url = "https://firebasestorage.googleapis.com/v0/b/thaispellinggame-28cfe.appspot.com/o/Profile_Images%2Fdefault_profile_pic.png?alt=media&token=e7b8453d-82dd-431a-a93f-fb793081359b";
    Context context;


    public HomeFragment() {

    }


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

        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();

        final String current_uid = mCurrentUser.getUid();

        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(current_uid);
        mUserDatabase.keepSynced(true);

        //Typeface font  = Typeface.createFromAsset(getActivity().getAssets(), "fonts/RSU_BOLD.ttf");

        btnPlayGame = (Button) view.findViewById(R.id.btnPlayGame);

        final Animation anim = AnimationUtils.loadAnimation(context, R.anim.scale);

        btnPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view.startAnimation(anim);

                mUserDatabase = FirebaseDatabase.getInstance().getReference();

                mUserDatabase.child("Players").child(current_uid).child("name").setValue(mName.getText())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()){

                                    mUserDatabase.child("Players").child(current_uid).child("state").setValue(true);
                                    mUserDatabase.child("Players").child(current_uid).child("roomID").setValue("");

                                    Intent intent = new Intent(getActivity(), RandomPlayerActivity.class);
                                    startActivity(intent);
                                    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                    FragmentManager fragmentManager = getFragmentManager();
//                                    fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                                    //getActivity().finish();

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
        btnScore = (Button) view.findViewById(R.id.btn_score);
        btnBestScore = (Button) view.findViewById(R.id.btn_best_score);
        progressBar = (ImageView) view.findViewById(R.id.progressBar);

//        progressBar.setMax(100);
//        progressBar.setProgress(45);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
//        }


        mUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.child("name").getValue().toString();
                String image = dataSnapshot.child("image").getValue().toString();
                String level = dataSnapshot.child("level").getValue().toString();
                String rank = dataSnapshot.child("rank").getValue().toString();
                String score = dataSnapshot.child("score").getValue().toString();
                String bestScore = dataSnapshot.child("bestScore").getValue().toString();


                if (image.equals("default_profile_pic")) {
                    Picasso.with(context).load(img_profile_default_url)
                            .placeholder(context.getResources().getDrawable(R.drawable.default_profile_pic))
                            .error(context.getResources().getDrawable(R.drawable.default_profile_pic)).into(mDisplayImage);

                } else {
                    Picasso.with(getContext()).load(image).resize(150, 150)
                            .centerCrop().into(mDisplayImage);
                }

                mName.setText(name);
                tvRank.setText(rank);
                tvLevel.setText(level);
                btnScore.setText(score);
                btnBestScore.setText(bestScore);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();

        if (mCurrentUser != null) {

            mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(mCurrentUser.getUid());
            mUserDatabase.child("online").setValue(true);
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        if (mCurrentUser != null){

            mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(mCurrentUser.getUid());
            mUserDatabase.child("online").setValue(false);
        }

        //mAuth.removeAuthStateListener(mAuthListener);
    }
}
