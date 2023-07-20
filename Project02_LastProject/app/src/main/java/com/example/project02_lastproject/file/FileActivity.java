package com.example.project02_lastproject.file;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.RetrofitClient;
import com.example.project02_lastproject.common.RetrofitInterface;
import com.example.project02_lastproject.databinding.ActivityFileBinding;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FileActivity extends AppCompatActivity {

    // 갤러리 또는 카메라에서 발생되는 이미지를 File형태로 바꾸고 해당하는 파일을 Multipart형태로 Spring 전송.

    ActivityFileBinding binding;
    private final int REQ_GELLARY = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Glide.with(this).load("http://localhost:8080/middle/img/andimg.jpg").into(binding.imgv);

        binding.imgv.setOnClickListener(v -> {
            showDialogd();
        });
    }


    public void showDialogd(){
        String[] dialog_item = {"갤러리", "카메라"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("사진 업로드 방식");
        builder.setSingleChoiceItems(dialog_item , -1 , (dialog, i) -> {
            if(dialog_item[i].equals("갤러리")){
                // 갤러리 로직
                showGallery();
            } else if (dialog_item[i].equals("카메라")) {
                // 카메라 로직
            }
            dialog.dismiss();
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void showGallery(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
//        startActivity(intent); // 단순 실행. 결과를 알수가 없다.
        startActivityForResult(intent , REQ_GELLARY );
    }

    // startActivityForResult로 띄운 액티비티가 종료되면 반드시 ↓ 메소드가 실행됨.
    // 카메라 액티비티의 종료인지 , 갤러리 액티비티의 종료인지 , 그외에 액티비티 종료인지를 구분할 수 있는 변수가 필요하다.
    // requestCode <- 내가 넣어놨떤 코드가 그대로 다시 들어옴.
    @Override // 자동완성한것 onActivityResult 치고
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_GELLARY && resultCode == RESULT_OK) {
            // 갤러리 액티비티가 종료됨. ( 사용자가 사진을 선택했는지? RESULT_OK )
            Log.d("갤러리", "onActivityResult: "+ data.getData());
            Log.d("갤러리", "onActivityResult: "+ data.getData().getPath()); // 주소
            Glide.with(this).load(data.getData()).into(binding.imgv);  // 갤러리 이미지가 잘 붙는지?
            String img_path = getRealPath(data.getData());

            // MultiPart 형태로 전송 ( File )
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(img_path));
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.jpg", fileBody);
            RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
            api.clientSendFile("file.f" , new HashMap<>(), filePart).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                t.getMessage();
                }
            });


            // MultiPart <- Spring 처리  RequestMapping(Controller)가 MultiPart를 받으려면 어떻게 했을까?
            // form태그 : 태그 사이에 있는 모든 입력 양식을 감싸는 태그로 , name , action.. 등의 속성을 가지고 전송용 태그.
            // ecnType : 폼데이터 ↑ 서버로 전송될때 "파일을 담고 있다면" 데이터의 인코딩 과정이 필요하다.
            // multipart/form-data <- 파일과 데이터는 담겨지는 영역이 다르기 때문에 여러부분 (Multi)Body(Part)
        }
    }

    // 오라클 커서 : ?  선택? 데이터빼오기위한
    public String getRealPath(Uri contentUri){
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA}; // "_Data"
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Cursor cursor = getContentResolver().query(contentUri, proj , null ,null);  // 내용제공자 모든 데이터를 표형태로 가져오는 애
            if(cursor.moveToFirst()){ // 헤더에서 로우로 이동했을때 = 셀렉터를 했을때
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                res = cursor.getString(column_index);
            }
            cursor.close(); // 다썻으니까 닫음.
        }
        Log.d("TAG", "getRealPath: " + res);
        return res;
    }
}