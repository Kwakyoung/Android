package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();

        String strValue1 = intent.getStringExtra("stringkey");
        String strValue2 = intent.getStringExtra("intkey");
        String strValue3 = intent.getStringExtra("pluskey");
        String strValue4 = intent.getStringExtra("list");
        Log.d("오", "onCreate: "+strValue1);
        Log.d("오", "onCreate: "+strValue2);
        Log.d("오", "onCreate: "+strValue3);
        Log.d("오", "onCreate: "+strValue4);
    }
}


