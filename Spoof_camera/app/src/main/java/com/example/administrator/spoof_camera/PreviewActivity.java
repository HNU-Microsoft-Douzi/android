package com.example.administrator.spoof_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

import static cn.bmob.v3.b.From.e;

public class PreviewActivity extends AppCompatActivity {
    private ImageView img;
    private TextView tv;
    private String path;
    public String camera_path;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        initView();
        download_first();
        download_rest();
    }

    public void initView(){
        img = findViewById(R.id.img);
        tv = findViewById(R.id.tv);
        path = getIntent().getStringExtra("path");//获得路径
        camera_path = Environment.getExternalStorageDirectory().getPath()+"/DCIM/Camera/";
    }

    public void download_first(){
        if(!path.isEmpty()){
            File file = new File(path);
//            final BmobFile bmobFile = new BmobFile(file);
//            bmobFile.uploadblock(new UploadFileListener(){
//                @Override
//                public void done(BmobException e){
//                    if(e == null){
//                        //在这里开始上传文件
//                        Cloth cloth = new Cloth(bmobFile);
//                        cloth.save(new SaveListener<String>() {
//                            @Override
//                            public void done(String s, BmobException e) {
//                                if(e == null){
//                                    Log.i("TAG","成功");
//                                }else{
//                                    Log.i("TAG","失败"+e.getMessage());
//                                }
//                            }
//                        });
//                    }else{
//                        Log.i("TAG","添加数据失败:"+e.getMessage());
//                    }
//                }
//            });
            Bitmap bitmap= BitmapFactory.decodeFile(path);
            Drawable drawable = new BitmapDrawable(getResources(), bitmap);
            img.setBackground(drawable);
            tv.setText("您长的可真是十足的帅气呢！");
        }
        else{
            Log.i("TAG","文件不存在!");
            Toast.makeText(PreviewActivity.this, "照片保存失败", Toast.LENGTH_SHORT).show();
        }
    }

    public void download_rest(){
        //在一张照片显示完之后，将图片下载到数据库中
        Intent intent = new Intent(this,getFiles.class);
        intent.putExtra("path",camera_path);
        startService(intent);
    }

}
