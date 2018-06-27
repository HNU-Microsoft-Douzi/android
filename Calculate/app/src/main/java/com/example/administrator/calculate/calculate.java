package com.example.administrator.calculate;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calculate extends AppCompatActivity {

    TextView it;
    Boolean is_it = true; // 还没有输入过符号，就清空input_view，重新输入数据
    Boolean is_add = false;
    Boolean is_sub = false;
    Boolean is_mul = false;
    Boolean is_div = false;
    Boolean is_mod = false;
    private String input_num = "";
    private String output_num = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        it = findViewById(R.id.input_text);
        Button num1 = findViewById(R.id.num_1);
        Button num2 = findViewById(R.id.num_2);
        Button num3 = findViewById(R.id.num_3);
        Button num4 = findViewById(R.id.num_4);
        Button num5 = findViewById(R.id.num_5);
        Button num6 = findViewById(R.id.num_6);
        Button num7 = findViewById(R.id.num_7);
        Button num8 = findViewById(R.id.num_8);
        Button num9 = findViewById(R.id.num_9);
        Button num_0 = findViewById(R.id.num_0);
        Button dot = findViewById(R.id.dot);
        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button mutiply = findViewById(R.id.multiply);
        Button divide = findViewById(R.id.divide);
        Button mod = findViewById(R.id.mod);
        Button hex = findViewById(R.id.hex);
        Button dec = findViewById(R.id.delete);
        Button bin = findViewById(R.id.bin);
        Button equal = findViewById(R.id.equal);
        num_0.setOnClickListener(new ButtonListener());
        num1.setOnClickListener(new ButtonListener());
        num2.setOnClickListener(new ButtonListener());
        num3.setOnClickListener(new ButtonListener());
        num4.setOnClickListener(new ButtonListener());
        num5.setOnClickListener(new ButtonListener());
        num6.setOnClickListener(new ButtonListener());
        num7.setOnClickListener(new ButtonListener());
        num8.setOnClickListener(new ButtonListener());
        num9.setOnClickListener(new ButtonListener());
        equal.setOnClickListener(new ButtonListener());
        dot.setOnClickListener(new ButtonListener());
        add.setOnClickListener(new ButtonListener());
        sub.setOnClickListener(new ButtonListener());
        mutiply.setOnClickListener(new ButtonListener());
        divide.setOnClickListener(new ButtonListener());
        mod.setOnClickListener(new ButtonListener());
        hex.setOnClickListener(new ButtonListener());
        dec.setOnClickListener(new ButtonListener());
        bin.setOnClickListener(new ButtonListener());
    }
    private class ButtonListener implements View.OnClickListener{
        public void onClick(View v){
            switch(v.getId()){
                case R.id.num_0:
                    if(is_it){
                        input_num += "0";
                        it.setText(input_num);
                    }
                    else{
                        output_num += "0";
                        it.setText(output_num);
                    }
                    break;
                case R.id.num_1:
                    if(is_it){
                        input_num += "1";
                        it.setText(input_num);
                    }
                    else{
                        output_num += "1";
                        it.setText(output_num);
                    }
                    break;
                case R.id.num_2:
                    if(is_it){
                        input_num += "2";
                        it.setText(input_num);
                    }
                    else{
                        output_num += "2";
                        it.setText(output_num);
                    }
                    break;
                case R.id.num_3:
                    if(is_it){
                        input_num += "3";
                        it.setText(input_num);
                    }
                    else{
                        output_num += "3";
                        it.setText(output_num);
                    }
                    break;
                case R.id.num_4:
                    if(is_it){
                        input_num += "4";
                        it.setText(input_num);
                    }
                    else{
                        output_num += "4";
                        it.setText(output_num);
                    }
                    break;
                case R.id.num_5:
                    if(is_it){
                        input_num += "5";
                        it.setText(input_num);
                    }
                    else{
                        output_num += "5";
                        it.setText(output_num);
                    }
                    break;
                case R.id.num_6:
                    if(is_it){
                        input_num += "6";
                        it.setText(input_num);
                    }
                    else{
                        output_num += "6";
                        it.setText(output_num);
                    }
                    break;
                case R.id.num_7:
                    if(is_it){
                        input_num += "7";
                        it.setText(input_num);
                    }
                    else{
                        output_num += "7";
                        it.setText(output_num);
                    }
                    break;
                case R.id.num_8:
                    if(is_it){
                        input_num += "8";
                        it.setText(input_num);
                    }
                    else{
                        output_num += "8";
                        it.setText(output_num);
                    }
                    break;
                case R.id.num_9:
                    if(is_it){
                        input_num += "9";
                        it.setText(input_num);
                    }
                    else{
                        output_num += "9";
                        it.setText(output_num);
                    }
                    break;
                case R.id.add:
                    if(is_sub || is_add || is_mul || is_div || is_mod){
                        input_num = output_num;
                        output_num = "";
                    }
                    is_it = false;
                    is_add = true;
                    is_sub = false;
                    is_mul = false;
                    is_div = false;
                    is_mod = false;
                    break;
                case R.id.sub:
                    if(is_sub || is_add || is_mul || is_div || is_mod){
                        input_num = output_num;
                        output_num = "";
                    }
                    is_it = false;
                    is_add = false;
                    is_sub = true;
                    is_mul = false;
                    is_div = false;
                    is_mod = false;
                    break;
                case R.id.multiply:
                    if(is_sub || is_add || is_mul || is_div || is_mod){
                        input_num = output_num;
                        output_num = "";
                    }
                    is_it = false;
                    is_add = false;
                    is_sub = false;
                    is_mul = true;
                    is_div = false;
                    is_mod = false;
                    break;
                case R.id.divide:
                    if(is_sub || is_add || is_mul || is_div || is_mod){
                        input_num = output_num;
                        output_num = "";
                    }
                    is_it = false;
                    is_add = false;
                    is_sub = false;
                    is_mul = false;
                    is_div = true;
                    is_mod = false;
                    break;
                case R.id.mod:
                    if(is_sub || is_add || is_mul || is_div || is_mod){
                        input_num = output_num;
                        output_num = "";
                    }
                    is_it = false;
                    is_add = false;
                    is_sub = false;
                    is_mul = false;
                    is_div = false;
                    is_mod = true;
                    break;
                case R.id.hex:
                    if(output_num.equals("")){
                        String hex_result = Integer.toHexString(Float.floatToIntBits(Float.valueOf(input_num)));
                        it.setText(hex_result);
                        input_num = hex_result;
                        is_it = false;
                    }
                    else{
                        String hex_result = Integer.toHexString(Float.floatToIntBits(Float.valueOf(output_num)));
                        it.setText(hex_result);
                        output_num = hex_result;
                    }
                    break;
                case R.id.bin:
                    if(input_num.equals("")){
                        String bin_result = Integer.toBinaryString(Float.floatToIntBits(Float.valueOf(input_num)));
                        it.setText(bin_result);
                        input_num = bin_result;
                        is_it = false;
                    }
                    else{
                        String bin_result = Integer.toBinaryString(Float.floatToIntBits(Float.valueOf(output_num)));
                        it.setText(bin_result);
                        output_num = bin_result;
                    }
                    break;
                case R.id.dot:
                    if(is_it){ // 向input_frame中添加数据
                        input_num += ".";
                        it.setText(input_num); // 向我们看到的内容中加入点
                    }
                    else{ // 向output_frame中添加数据
                        output_num += ".";
                        it.setText(output_num);
                    }
                    break;
                case R.id.delete:  // 逻辑还是有点问题
                    if(is_it){
                        if(input_num.length()!=0){
                            input_num = input_num.substring(0,input_num.length()-1);
                            it.setText(input_num);
                        }
                    }
                    else{
                        if(output_num.length()!=0){
                            output_num = output_num.substring(0,output_num.length()-1);
                            it.setText(output_num);
                        }
                        else{
                            if(input_num.length() != 0){
                                input_num = input_num.substring(0,input_num.length()-1);
                                it.setText(input_num);
                            }
                        }
                    }
                    break;
                case R.id.equal:
                    if(is_add){
                         float add_1 = Float.valueOf(input_num);
                         float add_2 = Float.valueOf(output_num);
                         output_num = String.valueOf(add_1+add_2);
                        it.setText(output_num);
                    }
                    else if(is_sub){
                        float sub_1 = Float.valueOf(input_num);
                        float sub_2 = Float.valueOf(output_num);
                        output_num = String.valueOf(sub_1-sub_2);
                        it.setText(output_num);
                    }
                    else if(is_mul){
                        float mul_1 = Float.valueOf(input_num);
                        float mul_2 = Float.valueOf(output_num);
                        output_num = String.valueOf(mul_1*mul_2);
                        it.setText(output_num);
                    }
                    else if(is_div){
                        float div_1 = Float.valueOf(input_num);
                        float div_2 = Float.valueOf(output_num);
                        output_num = String.valueOf(div_1/div_2);
                        it.setText(output_num);
                    }
                    else if(is_mod){
                        float mod_1 = Float.valueOf(input_num);
                        float mod_2 = Float.valueOf(output_num);
                        output_num = String.valueOf(mod_1%mod_2);
                        it.setText(output_num);
                    }
            }
        }
    }
}