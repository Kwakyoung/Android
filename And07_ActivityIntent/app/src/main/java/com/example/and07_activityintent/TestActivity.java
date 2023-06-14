package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();

        String strValue = intent.getStringExtra("stringkey");
        int intValue = intent.getIntExtra("intkey", 1);
        TestDTO dto = (TestDTO) intent.getSerializableExtra("pluskey");
        ArrayList<TestDTO> list = (ArrayList<TestDTO>) intent.getSerializableExtra("list");
        Log.d("오", "onCreate1: "+strValue);
        Log.d("오", "onCreate2: "+intValue);
        Log.d("오", "onCreate3: "+dto.getMax()+dto.getMax());
        Log.d("오", "onCreate4: "+list);
    }
}


