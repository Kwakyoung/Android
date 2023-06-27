package com.example.project01_kygtalk.opentalk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kygtalk.R;
import com.example.project01_kygtalk.databinding.FragmentOpenTalkMainBinding;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class OpenTalkMainFragment extends Fragment {

    FragmentOpenTalkMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOpenTalkMainBinding.inflate(inflater , container , false);
        // View v 로하면 v.find(R 이걸 많이 해야하기 때문
        // jsp  <-> Controller : jsp는 이미 조회가 완료 된 내용을 Model을 통해서 받아와서 el문법으로 '보여주는 처리만함' ( Controller 비즈니스로직 )
        // view <-> Adapter    : View(Recycler , Pager2)는 어댑터가 이미 결정한 모양을 보여주는 처리만함 ( 모든 처리는 Adapter 아이템 개수, 모양(레이아웃) )
        // Adapter는 개발자가 모양을 커스텀하기 편하게 기본 구조를 갖춰놓고 나머지는 자유롭게 메소드를 구현해서 모양을 만들게 해둠.
        FragmentAdapter adapter = new FragmentAdapter(this, getFragmentlist());
        binding.pager2.setAdapter(adapter);  // pager2칸에 어뎁터가 보여지게 하는 !?

        binding.chipGrp.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {

                if (checkedId == R.id.chip_1){
                    binding.pager2.setCurrentItem(0,true);
                } else if (checkedId == R.id.chip_2) {
                    binding.pager2.setCurrentItem(1,true);
                }else if (checkedId == R.id.chip_3) {
                    binding.pager2.setCurrentItem(2,true);
                }else if (checkedId == R.id.chip_4) {
                    binding.pager2.setCurrentItem(3,true);


                }
            }
        });


        binding.pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) { // 0~3
                super.onPageSelected(position);
                if (position == 0) {
                    binding.chipGrp.check(R.id.chip_1);
                } else if (position == 1) {
                    binding.chipGrp.check(R.id.chip_2);
                } else if (position == 2) {
                    binding.chipGrp.check(R.id.chip_3);
                } else if (position == 3) {
                    binding.chipGrp.check(R.id.chip_4);
                }

            }
        });

        return binding.getRoot();
    }

    ArrayList<Fragment> getFragmentlist(){
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new OpenSub2Fragment());
        list.add(new OpenSub2Fragment());
        list.add(new OpenSub2Fragment());
        list.add(new OpenSub1Fragment());
        return list;
    }

}