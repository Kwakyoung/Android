package com.example.cloneyoutubemusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.cloneyoutubemusic.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentManager manager = getSupportFragmentManager();

        manager.beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            if (item.getItemId()==R.id.tab1){
                fragment = new HomeFragment();

            } else if (item.getItemId()==R.id.tab2) {

            }
            return true;
        });

    }


}