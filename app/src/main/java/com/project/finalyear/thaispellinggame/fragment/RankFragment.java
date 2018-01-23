package com.project.finalyear.thaispellinggame.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.Firebase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.finalyear.thaispellinggame.R;
import com.project.finalyear.thaispellinggame.adapter.RankAdapter;
import com.project.finalyear.thaispellinggame.model.RankModel;
import com.project.finalyear.thaispellinggame.model.RoundOneModel;

import java.util.ArrayList;
import java.util.List;


public class RankFragment extends Fragment {
    private static final String URL_Firebase = "https://thaispellinggame-28cfe.firebaseio.com/Users";
    private Firebase firebase;
    RecyclerView recyclerViewRank;
    private RankAdapter adapter;
    private List<RankModel> rankModels;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    public RankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rank, container, false);
        //initInstance(view);
        return view;
    }

//    private void initInstance(View view) {
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference("Users");
//        Firebase.setAndroidContext(getContext());
//        rankModels = new ArrayList<>();
//        recyclerViewRank = (RecyclerView) view.findViewById(R.id.recyclerViewRank);
//        recyclerViewRank.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        recyclerViewRank.setLayoutManager(linearLayoutManager);
////        createResult();
//        adapter = new RankAdapter(rankModels);
//        recyclerViewRank.setAdapter(adapter);
//        updateList();
//    }
//
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case 0:
//                break;
////            case 1:
////                break;
////            case 2:
////                break;
////            case 3:
////                break;
//        }
//        return super.onContextItemSelected(item);
//    }
////
////    private void createResult() {
////        rankModels.add(new RankModel("", "", "", ""));
////    }
//
//    private void updateList() {
//        databaseReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                rankModels.add(dataSnapshot.getValue(RankModel.class));
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                RankModel model = dataSnapshot.getValue(RankModel.class);
//                int index = getItemIndex(model);
//                rankModels.remove(index);
//                adapter.notifyItemRemoved(index);
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                RankModel model = dataSnapshot.getValue(RankModel.class);
//                int index = getItemIndex(model);
//                rankModels.set(index, model);
//                adapter.notifyItemChanged(index);
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
//    private int getItemIndex(RankModel mRank) {
//        int index = -1;
//        for (int i = 1; i < rankModels.size(); i++) {
//
//        }
//        return index;
//    }
}
