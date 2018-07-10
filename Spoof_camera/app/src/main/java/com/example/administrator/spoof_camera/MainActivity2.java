package com.example.administrator.spoof_camera;

import android.content.Intent;
import android.hardware.Camera;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.bmob.v3.Bmob;

public class MainActivity2 extends AppCompatActivity {
    private SurfaceView sfv_preview;
    private Button btn_take;
    private Camera camera = null;
    private File mediaFile;
    private String APP_ID = "76f761eb0b3b7c43e979bb382d4eb168";
    private SurfaceHolder.Callback cpHolderCallback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            startPreview();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            stopPreview();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //默认初始化
        Bmob.initialize(this, APP_ID);
        bindViews();
    }

    private void bindViews() {
        sfv_preview = findViewById(R.id.sfv_preview);
        btn_take = findViewById(R.id.bt);
        sfv_preview.getHolder().addCallback(cpHolderCallback);

        btn_take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camera.takePicture(null, null, new Camera.PictureCallback() {
                    @Override
                    public void onPictureTaken(byte[] data, Camera camera) {
                        String path = "";
                        if ((path = saveFile(data)) != null){
                            Log.i("TAG","文件的绝对路径为："+path);
                            Intent it = new Intent(MainActivity2.this,PreviewActivity.class);
                            it.putExtra("path", path);
                            startActivity(it);
                        }else {
                            Toast.makeText(MainActivity2.this, "保存照片失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    //保存临时文件的方法
    @NonNull
    private String saveFile(byte[] bytes) {
        try {
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
                mediaFile = new File(mediaStorageDir.getPath() + File.separator
                        + "IMG_" + timeStamp + ".jpg");

            FileOutputStream fos = new FileOutputStream(mediaFile);
            fos.write(bytes);
            fos.flush();
            fos.close();
            return mediaFile.getPath();//绝对路径
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //开始预览
    private void startPreview() {
        if(camera != null) camera.release();
        camera = Camera.open(1);//0表示启用后置摄像头，1表示启用前置摄像头
        try {
            camera.setPreviewDisplay(sfv_preview.getHolder());
            camera.setDisplayOrientation(90);//让相机旋转90度
            camera.startPreview();//开始预览
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //停止预览
    private void stopPreview() {
        camera.stopPreview();
        camera.release();//用来释放相机资源，不然一直占用的话，别的程序就无法使用相机功能了
        camera = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add("别点这里");
        menu.add("别点这里+1");
        menu.add("别点这里+2");
        menu.add("别点这里+3");
        menu.add("别点这里+4");
        menu.add("别点这里+5");
        menu.add("别点这里+6");
        return true;
    }
}
