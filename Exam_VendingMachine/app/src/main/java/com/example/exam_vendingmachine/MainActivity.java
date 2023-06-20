package com.example.exam_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    // ArrayList에 이미 담았기 때문에 필요가 없음. (혼동)
//    TextView tv_name1 , tv_name2 , tv_name3 , tv_name4 , tv_cnt1 , tv_cnt2 , tv_cnt3 , tv_cnt4;
//    Button btn_order1, btn_order2 , btn_order3, btn_order4;

    // DTO로 사용하기
    // int cola = 1000, cider = 1100, fanta = 1200, sol = 1300 ;
    // int cntCola=10, cntCider=11, cntFanta=12, cntSol=13;

    int userMoney = 9999999;
    ArrayList<DrinkDTO> list = new ArrayList<>();

//    ArrayList<TextView> nameList = new ArrayList<>();
//    ArrayList<TextView> cntList = new ArrayList<>();
    ArrayList<ViewHolder> viewList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(new DrinkDTO("콜라", 1000, 10));
        list.add(new DrinkDTO("사이다", 1100, 9));
        list.add(new DrinkDTO("환타", 800, 8));
        list.add(new DrinkDTO("솔", 500, 7));

        ViewHolder view = new ViewHolder(findViewById(R.id.tv_name1),findViewById(R.id.tv_cnt1),findViewById(R.id.btn_order1));


        viewList.add(new ViewHolder(findViewById(R.id.tv_name1),findViewById(R.id.tv_cnt1),findViewById(R.id.btn_order1))); //4건 넣어보기.
        viewList.add(new ViewHolder(findViewById(R.id.tv_name2),findViewById(R.id.tv_cnt2),findViewById(R.id.btn_order2)));
        viewList.add(new ViewHolder(findViewById(R.id.tv_name3),findViewById(R.id.tv_cnt3),findViewById(R.id.btn_order3)));
        viewList.add(new ViewHolder(findViewById(R.id.tv_name4),findViewById(R.id.tv_cnt4),findViewById(R.id.btn_order4)));

        for (int i = 0; i < viewList.size(); i++) {
            final int idx = i;
            viewList.get(i).getBtn_order().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.get(idx).setCnt(list.get(idx).getCnt()-1);
                    viewList.get(idx).getTv_cnt().setText(list.get(idx).getCnt()+ "개 남음");
                    viewList.get(idx).getTv_name().setText(list.get(idx).getName()+list.get(idx).getPrice()+"원");
                if(list.get(idx).getCnt()<0){

                }

                }
            });
        }

        // tv_name1~4 <= 현재 각각 흩어져있는 텍스트뷰들을 하나의  ArrayList로 묶어보기.
//        nameList.add(findViewById(R.id.tv_name1));
//        nameList.add(findViewById(R.id.tv_name2));
//        nameList.add(findViewById(R.id.tv_name3));
//        nameList.add(findViewById(R.id.tv_name4));
//
//
//        cntList.add(findViewById(R.id.tv_cnt1));
//        cntList.add(findViewById(R.id.tv_cnt2));
//        cntList.add(findViewById(R.id.tv_cnt3));
//        cntList.add(findViewById(R.id.tv_cnt4));


//        btn_order1 = findViewById(R.id.btn_order1);
//        btn_order2 = findViewById(R.id.btn_order2);
//        btn_order3 = findViewById(R.id.btn_order3);
//        btn_order4 = findViewById(R.id.btn_order4);
//
//          btn_order1.setOnClickListener(new kygOnClickListener(0));
//          btn_order2.setOnClickListener(new kygOnClickListener(1));
//          btn_order3.setOnClickListener(new kygOnClickListener(2));
//          btn_order4.setOnClickListener(new kygOnClickListener(3));

    }





    // list <= 데이터를 묶어놓은 자료구조 ( 버튼 1번이 눌렸을때는 자료구조의 인덱스 0번 주소값) => (2=>1)
//    public class kygOnClickListener implements View.OnClickListener {
//        private int index ;
//        public kygOnClickListener(int index) {
//          this.index = index;
//        }
//
//        @Override
//        public void onClick(View v) {
//            userMoney -= list.get(index).getPrice(); // 기존금액 = 기존금액 - 콜라
//            list.get(index).setCnt(list.get(index).getCnt()-1);
//            nameList.get(index).setText(list.get(index).getName() + list.get(index).getPrice()+"원");
//            cntList.get(index).setText(list.get(index).getCnt()+"개 남음");
//
//
//
//        }
//    }



    /*@Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_order1){
            // 개수차감, 금액차감(사용자), 디자인처리
            userMoney -= list.get(0).getPrice(); // 기존금액 = 기존금액 - 콜라
            cntCola--;
            tv_name1.setText("콜라("+ cola + ")원");
            tv_cnt1.setText(cntCola+"개 남음");
        }


    }*/
}