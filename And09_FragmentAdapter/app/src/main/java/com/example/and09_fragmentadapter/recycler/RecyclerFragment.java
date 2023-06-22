package com.example.and09_fragmentadapter.recycler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;
import java.util.Random;


public class RecyclerFragment extends Fragment {
    RecyclerView recv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler, container, false);
        // Context : 현재 앱의 모든 상태와 외부의 리소스 등에 접근하는 모든 기능들을 의미함.
        // ※ 안드로이드 4대 컴포넌트는 모두 Context를 이용해서 만들어졌고 4대 컴포넌트들만 Context에 자유롭게 접근이 가능하다. ※
        // 4대 컴포넌트 <= Activity
        // Fragment 는 무조건 Activity위에 있다..
        new NormalClass().testToast(getContext(),"프래그먼트이기때문에 get으로 받아옴.!");

        recv = v.findViewById(R.id.recv);
        recv.setAdapter(new AdapterRecv(inflater,getList()));
        recv.setLayoutManager(new LinearLayoutManager(getContext()));  // 중요! 꼭 걸어줘야함


        return v;
    }

    ArrayList<RecvDTO> getList(){
        // 데이터 10건을 포함하고있는 리스트 만들기
        ArrayList<RecvDTO> list = new ArrayList<>();
        int img[] = {R.drawable.ogu1, R.drawable.ogu2,R.drawable.ogu3,R.drawable.ogu4,R.drawable.ogu5};

        String name = "영균";
        for (int i = 0; i < 10; i++) {
            list.add(new RecvDTO(img[new Random().nextInt(img.length)],name+i,"남자"+i,"1"+i,i+"동"));

        }

        return list;
    }


}