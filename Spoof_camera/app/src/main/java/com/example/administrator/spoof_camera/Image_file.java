package com.example.administrator.spoof_camera;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Image_file extends BmobObject {
    private BmobFile img;

    public BmobFile getImg(){
        return img;
    }

    public void setImg(BmobFile new_file){
        img = new_file;
    }

}
