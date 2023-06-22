package com.example.and09_fragmentadapter.grid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.and09_fragmentadapter.R;
import com.example.and09_fragmentadapter.listv.ListDTO;

import java.util.ArrayList;

public class GridFragment extends Fragment {

    GridView gridv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_grid, container, false);


        ArrayList<ListDTO> list = new ArrayList<>();
        list.add(new ListDTO(R.drawable.ogu1, "캐릭터1", "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.ogu2, "캐릭터12", "ㅋㅋ"));

        gridv = v.findViewById(R.id.gridv);
        // 1. 어떤 모양이든 상관없음 단 위젯을 두개 이상 포함하는 item_gridv 만들기.
        // 2. BaseAdapter를 상속받은 AdapterGridview 구현하기.
        // 3. gridv.setAdapter(AdapterGridview);

        AdapterGridview adapter = new AdapterGridview(inflater);
        gridv.setAdapter(adapter);


        return v;
    }
}