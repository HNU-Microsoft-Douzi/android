package com.example.administrator.spoof_camera;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Cloth extends BmobObject{
    private BmobFile bf;
    Cloth(BmobFile bf0){
        this.bf = bf0;
    }

    public void setBf(BmobFile bf2){
        this.bf = bf2;
    }

    public BmobFile getBf(){
        return this.bf;
    }
}
