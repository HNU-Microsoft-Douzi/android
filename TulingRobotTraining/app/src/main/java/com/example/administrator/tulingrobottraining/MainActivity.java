package com.example.administrator.tulingrobottraining;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private String login_number = "123";
    private String passwd = "1";
    private EditText account;
    private EditText pwd;
    private String input_account;
    private String input_pwd;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        account = findViewById(R.id.user_account_login);
        pwd = findViewById(R.id.user_password_login);
        login = findViewById(R.id.user_login);
        account.requestFocus();//请求获取焦点
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);//手动的弹出键盘
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        account.clearFocus();
        pwd.requestFocus();
        InputMethodManager imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm1.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        pwd.clearFocus();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_pwd = pwd.getText().toString();
                input_account = account.getText().toString();
                if(login_number.equals(input_account)&& passwd.equals(input_pwd)){
                    Log.i("tag:","将在这里跳转到下一个activity");
                    // 给bnt1添加点击响应事件
                    Intent intent =new Intent(MainActivity.this,TuLing.class);//设置点击事件的跳转页面
                    //启动
                    startActivity(intent);
                }
                else{
                    AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("您的账户或密码输入错误，请重新尝试");//设置标题
                    builder.show();
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Log.i("tag:","用户点击了确定按钮。");
                        }
                    });
                }
            }
        });
//        //QQ第三方登录
//        Tencent   mTencent = Tencent.createInstance("1106904165",getApplicationContext());
//        ImageView QQlogin = (ImageView) findViewById(R.id.login_image_QQlogin);
//        QQlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //get_simple_userinfo
//                mTencent.login(LoginActivity.this,"all",new BaseUiListener());
//            }
//        });

    }
}
