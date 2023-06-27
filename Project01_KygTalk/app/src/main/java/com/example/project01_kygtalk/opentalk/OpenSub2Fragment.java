package com.example.project01_kygtalk.opentalk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kygtalk.R;
import com.example.project01_kygtalk.databinding.FragmentOpenSub2Binding;


public class OpenSub2Fragment extends Fragment {

    FragmentOpenSub2Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOpenSub2Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}