package com.example.and09_fragmentadapter.melon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and09_fragmentadapter.R;
import com.example.and09_fragmentadapter.recycler.AdapterRecv;
import com.example.and09_fragmentadapter.recycler.RecvDTO;

import java.util.ArrayList;


public class MelonFragment extends Fragment {
    RecyclerView recv_melon ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_melon, container, false);


        recv_melon = v.findViewById(R.id.recv_melon);
        recv_melon.setAdapter(new AdapterMelon(inflater, getList()));
        recv_melon.setLayoutManager(new LinearLayoutManager(getContext()));


        return v;
    }

    ArrayList<MelonDTO> getList() {
        ArrayList<MelonDTO> list = new ArrayList<>();
        int img[] = {R.drawable.chart_img1,
                     R.drawable.chart_img2,
                     R.drawable.chart_img3,
                     R.drawable.chart_img4,
                     R.drawable.chart_img4,
                     R.drawable.chart_img2,
                     R.drawable.chart_img5,
                     R.drawable.chart_img6,
                     R.drawable.chart_img7};


        String name[] = {"(여자)아이들","IVE(아이브)","aespa","LE SSERAFIM(르세라핌)","LE SSERAFIM(르세라핌)","IVE(아이브)","임영웅","임영웅","누구세요"};
        String title[] = {"퀸카 (Queencard)", "I AM", "Spicy", "이브, 프시케 그리고 푸른수", "UNFORGIVEN", "Kitsch", "사랑은 늘 도망가","모래 알갱이", "누구세요"};

        for (int i = 0; i < img.length; i++) {
            if(img[i] == R.drawable.chart_img1){
                name[i]="ㅋㅋ";
            }

            list.add(new MelonDTO(img[i], title[i], name[i],i+1+""));


        }

        return list;
    }
}