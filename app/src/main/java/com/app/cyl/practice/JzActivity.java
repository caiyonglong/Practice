package com.app.cyl.practice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by caiyonglong0 on 2015/8/23.
 */
public class JzActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight);
        final EditText weight= (EditText) findViewById(R.id.weight);
        final RadioButton man= (RadioButton) findViewById(R.id.man);
        final RadioButton woman= (RadioButton) findViewById(R.id.woman);
        Button jisuan= (Button) findViewById(R.id.calculator);
        final TextView result= (TextView) findViewById(R.id.result);
        jisuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ww=weight.getText().toString().trim();
                if(ww.equals("")){
                   showMessage("请输入体重!");
                }else{
                    double weight=Double.parseDouble(ww);
                    StringBuffer sb=new StringBuffer();
                    sb.append("------------评估结果----------- \n");
                    if(man.isChecked())
                    {

                        sb.append("男性标准身高：");
                        double result=evaluateHeight(weight,"男");//执行运算
                        sb.append((int)result+"（厘米）");

                    }else if(woman.isChecked())
                    {
                        sb.append("女性标准身高：");
                        double result=evaluateHeight(weight,"女");//执行运算
                        sb.append((int)result+"（厘米）");
                    }
                    //输出页面现实结果
                    result.setText(sb.toString());
                }
            }
        });
    }

    private void showMessage(String s) {
        final AlertDialog alert;
        alert = new AlertDialog.Builder(this).create();
        alert.setTitle("系统消息");
        alert.setMessage(s);
//        alert.setButton("确定",new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                alert.dismiss();
//            }
//        });
        alert.show();
    }

    private double evaluateHeight(double weight,String sex){
        double height;
        if(sex=="男"){
            height =170-(62- weight)/0.6;
        }else{
            height=158-(52- weight)/0.5;
        }
        return height;
    }

}
