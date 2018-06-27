package com.example.administrator.tulingrobottraining;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.administrator.tulingrobottraining.ChatMessage.Type.INPUT;

public class TuLing extends Activity {
    /*
       展示消息的listView
    */
    private ListView mChatView;
    /*
    文本域
     */
    private EditText mMsg;
    /*
    存储聊天消息
     */
    private List<ChatMessage> mDatas = new ArrayList<ChatMessage>();
    /*
    适配器
     */
    private ChatMessageAdapter mAdapter;

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            ChatMessage from = (ChatMessage) msg.obj;//相当于响应消息
            mDatas.add(from);
            mAdapter.notifyDataSetChanged();
            mChatView.setSelection(mDatas.size() - 1);//始终让ListView只显示最后的几条数据
        }

        ;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//启用窗体的扩展特性
        setContentView(R.layout.tuling_robot);

        initView();//所有的View进行初始化

        mDatas.add(new ChatMessage(INPUT, "你好，我的master!"));
        mAdapter = new ChatMessageAdapter(this, mDatas);
        mChatView.setAdapter(mAdapter);
    }

    private void initView() {
        mChatView = findViewById(R.id.id_chat_listView);
        mMsg = findViewById(R.id.id_chat_msg);
    }

    public void sendMessage(View view) {
        final String msg = mMsg.getText().toString();
        if (TextUtils.isEmpty(msg)) {//TextUtils是android用来判断的一个自动工具类
            Toast.makeText(this, "您还没有填写信息呢!", Toast.LENGTH_SHORT).show();
            return;
        }
        ChatMessage to = new ChatMessage(ChatMessage.Type.OUTPUT, msg);
        to.setDate(new Date());//设置日期
        mDatas.add(to);

        mAdapter.notifyDataSetChanged();
        mChatView.setSelection(mDatas.size() - 1);

        mMsg.setText("");
        //关闭软键盘
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //得到InputMethodManager的实例
        if (imm.isActive()) {
            // 如果开启
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
                    InputMethodManager.HIDE_NOT_ALWAYS);
            // 关闭软键盘，开启方法相同，这个方法是切换开启与关闭状态的
        }
        ChatMessage from = null;
        try {
            List<ChatMessage> date = mDatas;
            from = HttpUtils.sendMsg(msg);//从网络上获取消息
            Log.i("TAG",msg);
            Log.i("TAG",from.getMsg());
        } catch (Exception e) {
            from = new ChatMessage(INPUT, "服务器挂了...");//消息获取失败
        }
        Message message = Message.obtain();
        message.obj = from;
        mHandler.sendMessage(message);//利用适配器的Handler类传递数据
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        mDatas.clear();
        Log.i("TAG","onStop");
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        mDatas.clear();
        Log.i("TAG","onDestroy");
        super.onDestroy();
    }
}
