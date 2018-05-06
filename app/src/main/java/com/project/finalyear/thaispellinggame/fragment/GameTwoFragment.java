package com.project.finalyear.thaispellinggame.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import android.support.v4.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.finalyear.thaispellinggame.R;
import com.project.finalyear.thaispellinggame.adapter.GridViewAnswerAdapter;
import com.project.finalyear.thaispellinggame.adapter.GridViewSuggestAdapter;
import com.project.finalyear.thaispellinggame.common.Common;
import com.project.finalyear.thaispellinggame.controller.GameTwoController;
import com.project.finalyear.thaispellinggame.model.GameTwoModel;

/**
 * Created by Namwan on 5/4/2018.
 */

public class GameTwoFragment extends Fragment implements GameTwoController.GameTwoCallBack{

    private FirebaseAuth mAuth;
    private DatabaseReference mRefDatabase;
    private FirebaseUser mCurrentUser;
    private String current_uid;
    private String user_id = null;

    private GameTwoController gameTwoController;
    private ArrayList<GameTwoModel> gameTwoArrayList;

    public static void showToast(Context mContext, String message){
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public List<String> suggestSource = new ArrayList<>();

    public GridViewAnswerAdapter answerAdapter;
    public GridViewSuggestAdapter suggestAdapter;

    public Button btnSubmit;

    public GridView gridViewAnswer,gridViewSuggest;

    public ImageView imgViewQuestion;

    int[] image_list={
            R.drawable.mae_kob,
            R.drawable.mae_kod,
            R.drawable.mae_kok,
            R.drawable.mae_kom,
            R.drawable.mae_kon
    };

    public char[] answer;

    String correct_answer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game_two, container, false);

        //Init View
        initView(view);
        gameTwoController = new GameTwoController(this);

        loadDataGameTwo();

        return view;
    }

    private void initView(View view) {

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        current_uid = mCurrentUser.getUid();
        mRefDatabase = FirebaseDatabase.getInstance().getReference();

        gridViewAnswer = (GridView) view.findViewById(R.id.gridAnswer);
        gridViewSuggest = (GridView) view.findViewById(R.id.gridViewSuggest);

        imgViewQuestion = (ImageView) view.findViewById(R.id.imgLogo);

        btnSubmit = (Button)view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result="";
                for (int i = 0; i< Common.user_submit_answer.length; i++){
                    result += String.valueOf(Common.user_submit_answer[i]);
                }
                if (result.equals(correct_answer)){
                    Toast.makeText(getActivity(),"Finish ! This is "+result,
                            Toast.LENGTH_SHORT).show();

                    //Reset
                    Common.count = 0;
                    Common.user_submit_answer = new char[correct_answer.length()];

                    //Set Adapter
                    GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(setupNullList(),getActivity());
                    gridViewAnswer.setAdapter(answerAdapter);
                    answerAdapter.notifyDataSetChanged();

                    GridViewSuggestAdapter suggestAdapter = new GridViewSuggestAdapter(suggestSource,getActivity(),GameTwoFragment.this);
                    gridViewSuggest.setAdapter(suggestAdapter);
                    suggestAdapter.notifyDataSetChanged();

                    setupList(gameTwoArrayList);

                }
                else {
                    Toast.makeText(getActivity(),"Incorrect!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadDataGameTwo(){
        gameTwoController.dataPull();
    }

    private void setupList(ArrayList<GameTwoModel> gameTwoArrayList) {

        //Random question
        Random random = new Random();
        int imageSelected = image_list[random.nextInt(image_list.length)];
        imgViewQuestion.setImageResource(imageSelected);

        int answerList = random.nextInt(gameTwoArrayList.size());
        correct_answer = gameTwoArrayList.get(answerList).getWord();
        correct_answer = correct_answer.substring(correct_answer.lastIndexOf("/")+1);

        answer = correct_answer.toCharArray();

        Common.user_submit_answer = new char[answer.length];

        //Add Answer character to List
        suggestSource.clear();
        for (char item:answer){
            //Add vocabulary to list
            suggestSource.add(String.valueOf(item));
        }

        //Random and some character to list
        for (int i=answer.length; i<answer.length*2; i++)
            suggestSource.add(Common.alphabet_character[random.nextInt(Common.alphabet_character.length)]);

        //Sort random
        Collections.shuffle(suggestSource);

        //Set for GridView
        answerAdapter = new GridViewAnswerAdapter(setupNullList(),getActivity());
        suggestAdapter = new GridViewSuggestAdapter(suggestSource,getActivity(),this);

        answerAdapter.notifyDataSetChanged();
        suggestAdapter.notifyDataSetChanged();

        gridViewSuggest.setAdapter(suggestAdapter);
        gridViewAnswer.setAdapter(answerAdapter);





    }

    private char[] setupNullList() {
        char result[] = new char[answer.length];
        for (int i=0; i<answer.length; i++)
            result[i] = ' ';

        return result;
    }

    @Override
    public void displayGameTwo(int index, ArrayList<GameTwoModel> gameTwoArrayList) {
        this.gameTwoArrayList = gameTwoArrayList;
        setupList(gameTwoArrayList);
    }

    @Override
    public void onCancel(String messageError) {

    }
}
