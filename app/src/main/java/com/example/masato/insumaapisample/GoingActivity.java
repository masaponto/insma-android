package com.example.masato.insumaapisample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.masato.insumaapisample.Model.MatchingInfo;
import com.example.masato.insumaapisample.Model.MatchingPointId;
import com.example.masato.insumaapisample.Model.MatchingStatus;
//import com.example.masato.insumaapisample.Model.MatchingUser;
import com.example.masato.insumaapisample.Model.MatchingUser;
import com.example.masato.insumaapisample.Model.MatchingUsers;
import com.example.masato.insumaapisample.api.InsumaServiceHolder;

import java.util.ArrayList;


import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class GoingActivity extends AppCompatActivity {

    public static final String UNIQUE_ID = "unique_id";
    public static final String MATCHING_ID = "matching_id";

    int matchingId;
    String uniqueId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_going);

        Intent intent = getIntent();

        matchingId = intent.getIntExtra(MATCHING_ID, -1);
        uniqueId = intent.getStringExtra(UNIQUE_ID);

        InsumaServiceHolder.get()
                .getNumberOfPeople(new MatchingPointId(matchingId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MatchingUsers>() {
                    @Override
                    public void call(MatchingUsers matchingUsers) {
                        ArrayList<MatchingUser> users = matchingUsers.getUsers();
                        Log.d("log", users.size()+"");
                        //Log.d("aaa", user.getDestination());
                    }
                });
    }


    public static Intent createIntent(Activity from, int matchingId, String uniqueId) {
        Intent intent = new Intent(from, GoingActivity.class);
        intent.putExtra(MATCHING_ID, matchingId);
        intent.putExtra(UNIQUE_ID, uniqueId);
        return intent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        MatchingInfo matchingInfo = new MatchingInfo(matchingId, uniqueId);

        InsumaServiceHolder.get()
                .endMatching(matchingInfo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MatchingStatus>() {
                    @Override
                    public void call(MatchingStatus matchingStatus) {

                    }
                });

    }

}
