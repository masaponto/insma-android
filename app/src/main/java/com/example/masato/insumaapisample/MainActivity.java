package com.example.masato.insumaapisample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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


    public void intentStartMatching(View view){
        Intent intent = MatchingActivity.createIntent(this);
        startActivity(intent);
    }

}
