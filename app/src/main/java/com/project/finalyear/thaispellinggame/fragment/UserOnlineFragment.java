package com.project.finalyear.thaispellinggame.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.finalyear.thaispellinggame.R;
import com.project.finalyear.thaispellinggame.adapter.UserAdapter;
import com.project.finalyear.thaispellinggame.model.UserData;
import com.project.finalyear.thaispellinggame.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Namwan on 2/4/2018.
 */

public class UserOnlineFragment extends Fragment{

    private DatabaseReference mUserDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    List<UserData> list;
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_users_online, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.user_list);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        mUserDatabase = FirebaseDatabase.getInstance().getReference();
        Query query = mUserDatabase.child("Users").orderByChild("online").equalTo(true);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    UserData listdata = new UserData();

                    UserModel userModel = dataSnapshot1.getValue(UserModel.class);

                    String name = userModel.getName();
                    String image = userModel.getImage();
                    listdata.setName(name);
                    listdata.setImage(image);

                    list.add(listdata);

                }

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                UserAdapter userAdapter = new UserAdapter(list);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return view;
    }

}
