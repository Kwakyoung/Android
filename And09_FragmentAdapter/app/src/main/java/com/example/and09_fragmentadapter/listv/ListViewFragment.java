package com.example.and09_fragmentadapter.listv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;


public class ListViewFragment extends Fragment {

    ListView listv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<ListDTO> list = new ArrayList<>();
        list.add(new ListDTO(R.drawable.ogu1, "캐릭터1", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.ogu2, "캐릭터12", "ㅋㅋ"));
        list.add(new ListDTO(R.drawable.ogu3, "캐릭터13", "ㅎㅎ"));
        list.add(new ListDTO(R.drawable.ogu4, "캐릭터14", "ㅂㅂ"));
        list.add(new ListDTO(R.drawable.ogu5, "캐릭터15", "ㅅㅅ"));


        listv = v.findViewById(R.id.listv);
        AdapterListView adapter = new AdapterListView(inflater, list);
        listv.setAdapter(adapter);
        return v;

    }
}