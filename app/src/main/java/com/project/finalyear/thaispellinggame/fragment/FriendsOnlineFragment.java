package com.project.finalyear.thaispellinggame.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.finalyear.thaispellinggame.R;
import com.project.finalyear.thaispellinggame.adapter.UserAdapter;
import com.project.finalyear.thaispellinggame.model.UserModel;

import java.util.ArrayList;
import java.util.List;


public class FriendsOnlineFragment extends Fragment {

//    private List<UserModel> result;
//    private UserAdapter userAdapter;
//    private RecyclerView recyclerView;
//
//    private FirebaseDatabase database;
//    private DatabaseReference reference;
//
//    private FirebaseAuth mAuth;
//    private FirebaseUser currentUser;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.fragment_friends_online, container, false);
//        initInstance(view);
//
//        return view;
//    }
//
//    private void initInstance(View view){
//
//        mAuth = FirebaseAuth.getInstance();
//        currentUser = mAuth.getCurrentUser();
//
//        if (currentUser != null){
//            String online_user_id = mAuth.getCurrentUser().getUid();
//            reference = FirebaseDatabase.getInstance().getReference()
//                    .child("Users").child(online_user_id);
//
//            reference.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    reference.child("online").onDisconnect().setValue(false);
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });
//        }
//
//        database = FirebaseDatabase.getInstance();
//        reference = database.getReference("Users");
//
//        result = new ArrayList<>();
//
//        recyclerView = (RecyclerView) view.findViewById(R.id.user_list);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//
//        userAdapter = new UserAdapter(result);
//        recyclerView.setAdapter(userAdapter);
//
//        updateList();
//    }
//
//
//    private void updateList(){
//
//        reference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                result.add(dataSnapshot.getValue(UserModel.class));
//                userAdapter.notifyDataSetChanged();
//
//            }
//
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                UserModel model = dataSnapshot.getValue(UserModel.class);
//
//                int index = getItemIndex(model);
//
//                result.set(index, model);
//                userAdapter.notifyItemChanged(index);
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//                UserModel model = dataSnapshot.getValue(UserModel.class);
//
//                int index = getItemIndex(model);
//
//                result.remove(index);
//                userAdapter.notifyItemRemoved(index);
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//    private int getItemIndex(UserModel user){
//        int index = 0;
//
//        for (int i=0; i<result.size(); i++){
//            if (result.get(i).name.equals(user.name));
//        }
//
//        return index;
//
//    }
}
