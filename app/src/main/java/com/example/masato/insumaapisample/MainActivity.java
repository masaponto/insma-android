package com.example.masato.insumaapisample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button matchingButton = (Button) findViewById(R.id.button);
        matchingButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                intentStartMatching(view);
            }
        });

    }

    public String getImageURL(int uniqueId) {
        return "https://s3-ap-northeast-1.amazonaws.com/irohaes-s3/unique_icon/" + uniqueId +".png";
    }


    public void intentStartMatching(View view){
        Intent intent = MatchingActivity.createIntent(this);
        startActivity(intent);
    }

}
