package com.example.cloneyoutubemusic.Library;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cloneyoutubemusic.R;
import com.example.cloneyoutubemusic.databinding.FragmentLibraryBinding;
import com.example.cloneyoutubemusic.search.SearchActivity;

import java.util.ArrayList;

public class LibraryFragment extends Fragment {

    FragmentLibraryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLibraryBinding.inflate(inflater, container , false);

        binding.search.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), SearchActivity.class);
            startActivity(intent);
        });

        binding.recvLibrary.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recvLibrary.setAdapter(new AdapterLibrary(getlist(),getContext()));



        return binding.getRoot();
    }


    ArrayList<LibraryDTO> getlist() {
        ArrayList<LibraryDTO> list = new ArrayList<>();
        list.add(new LibraryDTO(R.drawable.made_sound,"미친 소리","이예준"));
        list.add(new LibraryDTO(R.drawable.lucy,"히어로","루시"));
        list.add(new LibraryDTO(R.drawable.quick_paulkim,"우린 제법 잘어울려요","폴킴"));

        return list;
    }
}