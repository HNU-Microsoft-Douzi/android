package com.example.administrator.spoof_camera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
    private String root = "376358913";
    private String root_pwd = "1998813123";
    private String account;
    private String pwd;
    private EditText user_login;
    private EditText user_pwd;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initView();
        click_event();
    }

    public void initView(){
        user_login = findViewById(R.id.user_account_login);
        user_pwd = findViewById(R.id.user_password_login);
        bt = findViewById(R.id.user_login);

        user_login.requestFocus();//请求获取焦点
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);//手动的弹出键盘
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        user_login.clearFocus();
        user_pwd.requestFocus();
        InputMethodManager imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm1.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        user_pwd.clearFocus();

        account = user_login.getText().toString();
        pwd = user_pwd.getText().toString();
    }

    public void click_event(){
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(account.equals(root) && (pwd.equals(root_pwd))){
                    Intent intent = new Intent(Login.this,Master.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Login.this,MainActivity2.class);
                    startActivity(intent);
                }
            }
        });
    }
}
