package com.example.administrator.spoof_camera;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ImageView photo;
    private Button bt;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    File mediaFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
    }

    public void initView(){
        photo = findViewById(R.id.your_photo);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open();
            }
        });
    }

    private void open(){
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        it.putExtra(MediaStore.EXTRA_OUTPUT, getOutputMediaFileUri(MEDIA_TYPE_IMAGE));
        startActivityForResult(it, 0);
    }

    /** Create a file Uri for saving an image or video */
    private Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    private  File getOutputMediaFile(int type) {
        //通过这个地方来判断sd卡是否成功插入
        String status = Environment.getExternalStorageState();

        if (status.equals(Environment.MEDIA_MOUNTED)) {
            Log.i("TAG","SD卡已经成功插入");
        } else {
            Log.i("TAG","SD卡插入失败");
        }

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()) {
                Log.i("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        //Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        if(type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
            + "IMG_" + timeStamp + ".jpg");
        }else if(type == MEDIA_TYPE_VIDEO){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
            + "VID_" + timeStamp + ".mp4");
        }else{
            return null;
        }
        Log.i("TAG","创建的文件是："+mediaFile.getPath());
        return mediaFile;
    }

    //重写onActivityResult方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        //直接打开图片的方式
//        Bitmap bp = (Bitmap)data.getExtras().get("data");
//        photo.setImageBitmap(bp);
        //从内存中读取照片再打开的方式
        Uri uri = Uri.fromFile(mediaFile);
        photo.setImageURI(uri);
    }
}
