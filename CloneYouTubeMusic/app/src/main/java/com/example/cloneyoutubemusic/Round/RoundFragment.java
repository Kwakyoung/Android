package com.example.cloneyoutubemusic.Round;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cloneyoutubemusic.R;
import com.example.cloneyoutubemusic.databinding.FragmentRoundBinding;


public class RoundFragment extends Fragment {

    FragmentRoundBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRoundBinding.inflate(inflater, container, false);



        return binding.getRoot();
    }
}