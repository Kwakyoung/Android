package com.example.cloneyoutubemusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cloneyoutubemusic.Home.HomeFragment;
import com.example.cloneyoutubemusic.Library.LibraryFragment;
import com.example.cloneyoutubemusic.Round.RoundFragment;
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
                fragment = new RoundFragment();

            } else if (item.getItemId()==R.id.tab3) {
                fragment = new LibraryFragment();
            }else{
                return false;
            }

            if (fragment == null) {
                Toast.makeText(this, "아직 준비되지 않았습니다.", Toast.LENGTH_SHORT).show();
            }else {
                manager.beginTransaction().replace(R.id.container,fragment).commit();
            }
            return true;
        });

    }


}