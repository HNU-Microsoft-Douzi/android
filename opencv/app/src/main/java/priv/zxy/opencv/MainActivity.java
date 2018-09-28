package priv.zxy.opencv;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private ImageView imageView;

    /**
     * 导入OpenCV库
     */
    private void initLoadOpenCVLibs() {
        boolean success = OpenCVLoader.initDebug();
        String TAG = "TAG";
        if (success) {
            Log.d(TAG, "initLoadOpenCVLibs:OpenCV加载成功!");
        } else {
            Log.d(TAG, "initLoadOpenCVLibs:OpenCV加载失败!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化,opencv的静态加载方式
        initLoadOpenCVLibs();
        initView();
    }

    public void click(View view) {
        convert2Grey();
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.imageView);
        Button button = (Button) findViewById(R.id.button);
    }

    private void convert2Grey(){
        Mat src = new Mat();//Mat是Opencv的一种图像格式
        Mat temp = new Mat();
        Mat dst = new Mat();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.spider_man);
        Utils.bitmapToMat(bitmap, src);
        Imgproc.cvtColor(src, temp, Imgproc.COLOR_RGB2BGR);
        Imgproc.cvtColor(temp, dst, Imgproc.COLOR_BGR2GRAY);
        Utils.matToBitmap(dst, bitmap);
        imageView.setImageBitmap(bitmap);

        //
        src.release();
        temp.release();
        dst.release();
    }
}
