package com.example.administrator.tulingrobottraining;

import android.support.annotation.NonNull;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Timer;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/*
用来封装一个请求API的类
实际上是一个get请求
 */
public class HttpUtils {
    static String url = "http://www.tuling123.com/openapi/api";
    public static String res = "";
    public static String from = "" ;
    public HttpUtils() {
    }

    /*
    同步okhttp3的get方法
     */
    private static void okHttp_synchronousGet() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                    mainfunction();
            }
        }).start();
    }

    private static void mainfunction(){
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("key", "e6eb986937064262b603f0ac471fd44b")
                .add("info",from)
                .build();
        Request request = new Request.Builder().
                url(url)
                .post(requestBody)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            String responseData = response.body().string();
            JSONObject jsonObject = new JSONObject(responseData);
                if(jsonObject.optString("code").equals("100000")){
                    res = jsonObject.getString("text");
                }
                else if(jsonObject.optString("code").equals("40001")){
                    res = "吾之master，你的key不对!";
                }
                else if(jsonObject.optString("code").equals("40004")){
                    res = "吾之master，saber已经累了，明天再聊吧！";
                }
                else if(jsonObject.optString("code").equals("40007")){
                    res = "吾之master，请规范您的言辞！";
                }
                else{
                    res = "我不知道您在说什么呢！";
                }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    public static ChatMessage sendMsg(String msg) {
        from = msg;
        res = "";
        Log.i("TAG1",res);
        while(res.equals("")){
            okHttp_synchronousGet();
        }
        return new ChatMessage(ChatMessage.Type.INPUT, res);
    }
}