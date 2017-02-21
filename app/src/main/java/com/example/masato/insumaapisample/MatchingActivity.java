package com.example.masato.insumaapisample;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.masato.insumaapisample.Model.MatchingInfo;
import com.example.masato.insumaapisample.Model.MatchingStatus;
import com.example.masato.insumaapisample.Model.UserMoveInfo;
import com.example.masato.insumaapisample.api.InsumaServiceHolder;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MatchingActivity extends AppCompatActivity {

    int matchingId;
    String uniqueId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);


        final Button goMatchingButton = (Button) findViewById(R.id.button2);
        goMatchingButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                intentGoing(view);
            }
        });

        goMatchingButton.setEnabled(false);


        String userID = "masaponto";
        double x = 2.5;
        double y = 3.4;
        String destination = "Macdonarld";

        UserMoveInfo userMoveInfo = new UserMoveInfo(userID, x, y, destination);

        InsumaServiceHolder.get()
                .matchingInfo(userMoveInfo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MatchingInfo>() {
                    @Override
                    public void call(MatchingInfo matchingInfo) {

                        matchingId = matchingInfo.getMatchingpointID();
                        uniqueId = matchingInfo.getUniqueID();

                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("matching id = " + matchingId);

                        TextView textView2 = (TextView) findViewById(R.id.textView2);
                        textView2.setText("unique id = " + uniqueId);

                        goMatchingButton.setEnabled(true);
                    }
                });

    }


    public void intentGoing(View view){
        Intent intent = GoingActivity.createIntent(this, matchingId, uniqueId);
        startActivity(intent);
    }


    public static Intent createIntent(Activity from) {
        Intent intent = new Intent(from, MatchingActivity.class);
        return intent;
    }

}
