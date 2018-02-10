package com.project.finalyear.thaispellinggame.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.finalyear.thaispellinggame.R;
import com.project.finalyear.thaispellinggame.adapter.RankAdapter;
import com.project.finalyear.thaispellinggame.model.RankData;
import com.project.finalyear.thaispellinggame.model.RankModel;

import java.util.ArrayList;
import java.util.List;


public class RankFragment extends Fragment {

    private DatabaseReference mUserDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    List<RankData> rankData;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rank, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewRank);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        mUserDatabase = FirebaseDatabase.getInstance().getReference();
        Query query = mUserDatabase.child("Users").orderByChild("score").limitToFirst(50);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                rankData = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    RankData listData = new RankData();

                    RankModel rankModel = dataSnapshot1.getValue(RankModel.class);

                    String name = rankModel.getName();
                    String score = rankModel.getScore();
                    String rank = rankModel.getRank();
                    String level = rankModel.getLevel();
                    String image = rankModel.getImage();

                    listData.setName(name);
                    listData.setScore(score);
                    listData.setRank(rank);
                    listData.setLevel(level);
                    listData.setImage(image);

                    rankData.add(listData);
                }

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                RankAdapter rankAdapter = new RankAdapter(rankData);
                recyclerView.setAdapter(rankAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }
}
