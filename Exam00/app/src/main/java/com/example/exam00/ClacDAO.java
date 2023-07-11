package com.example.exam00;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

// 계산용 DAO
public class ClacDAO {
    // 클래스의 멤버는 크케 2가지가 있다.
    // 그냥 static으로 쓰면 되는걸 왜 멤버를 나눠서 사용을 할까??
    // 인싸와 아싸다..
    // 객체지향이란 말은 뭘까??




    // 인스턴스멤버, 스태틱멤버
    int num1 , num2;   // default
    private int num3;  //
    public int num4;   //
    static int num5;  //
    private static int num6;
    public static int num7;


    // 지역변수 (메소드 내부에서 선언되어 사용되는 변수 )
    public void method(){
        // 외부에서 절대로 접근이 불가능하다 ==> 사용해주려면 return
        int num1 = 0; // 지역변수
    }




    // void타입은 리턴이 없는 메소드임. 결과를 받을수가 없다 (외부)
    public int getSum (int i, int j){

        return i + j ;
    }



//    public void getSum(int i, int j, TextView tv1){
//        Log.d("두수의 합", "getSum: "+(i+j));
//        tv1.setText(i+j+"");
//
//    }
//    public void getSum(int i, int j, Button btn1){
//        Log.d("두수의 합", "getSum: "+(i+j));
//        btn1.setText(i+j+"");
//
//    }

}
