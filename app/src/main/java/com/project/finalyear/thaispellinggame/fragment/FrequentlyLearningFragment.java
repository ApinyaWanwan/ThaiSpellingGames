package com.project.finalyear.thaispellinggame.fragment;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.project.finalyear.thaispellinggame.R;



import java.util.Map;

public class FrequentlyLearningFragment extends Fragment {
    TextView tvLearningWrong, tvLearningRight;
    private Firebase firebase;
    Button btnTrickLeaning, btnOkTrick;
    Context context;
    ImageView imgBack;
    ImageView imgNext;

    public FrequentlyLearningFragment() {
        // Required empty public constructor
    }

    public static FrequentlyLearningFragment newInstance(String param1, String param2) {
        FrequentlyLearningFragment fragment = new FrequentlyLearningFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frequently_learning,
                container, false);
        Firebase.setAndroidContext(getContext());
//        initInstance(view);
        return view;


    }

//    public void initInstance(View view) {
//        tvLearningWrong = (TextView) view.findViewById(R.id.tvLearningWrong);
//        tvLearningRight = (TextView) view.findViewById(R.id.tvLearningRight);
//        firebase = new Firebase("https://thaispellinggame-28cfe.firebaseio.com/Learning/0");
//        firebase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Map<String, String> map = dataSnapshot.getValue(Map.class);
//                String wordWrong = map.get("wordWrong");
//                String wordRight = map.get("wordRight");
//                Log.v("E_Value", "Wrong : " + wordWrong);
//                Log.v("E_Value", "Right : " + wordRight);
//                tvLearningWrong.setText(wordWrong);
//                tvLearningRight.setText(wordRight);
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//
//        btnTrickLeaning = (Button) view.findViewById(R.id.btnTrickLeaning);
//        btnTrickLeaning.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Dialog dialog = new Dialog(getContext());
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog.setContentView(R.layout.activity_popup_tic_learning);
//                dialog.setCancelable(true);
//
//                btnOkTrick = (Button) dialog.findViewById(R.id.btnOkTrick);
//                btnOkTrick.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.cancel();
//                    }
//                });
//                dialog.show();
//            }
//        });
//        imgBack = (ImageView) view.findViewById(R.id.imgBack);
//        imgBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentLearningMainSection();
//            }
//        });
//    }
    public void FragmentLearningMainSection() {
        Fragment fragment = new LearningMainSectionFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
