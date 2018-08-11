package com.example.administrator.moonstep.login_activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.administrator.moonstep.R;

public class Login_activity extends AppCompatActivity{

    private Button register_phone;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.login_page);

//        销毁引导页Activity
//        GuideActivity.guideactivity.finish();

//        initView();
    }

//    public void initView(){
//        register_phone = findViewById(R.id.register_phone);
//        register_phone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                jump_to_register_phone_page();
//            }
//        });
//    }

//    public void jump_to_register_phone_page(){
//        Intent intent = new Intent(this, Register_Phone_Activity.class);
//        startActivity(intent);
//    }
}
