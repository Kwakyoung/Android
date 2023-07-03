package com.example.project01_kygtalk.exam;

import android.view.View;

import androidx.annotation.NonNull;

public class KygAdapterParent {





    public abstract static class KygViewHolder {
        // 디자인 파일을 묶어놓은 객체  ==> View
        @NonNull
        final View view  ;  // = null ==>  상수의 규칙 ( 1. 상수를 선언과 동시에 값 할당 ==> 초기화 해놓는 방법 )

        protected KygViewHolder(@NonNull View view) {  //             ( 2. 생성자를 이용해서 초기화 하는 방법 )
            this.view = view;
        }

    }


}
