package com.app.cyl.practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by caiyonglong0 on 2015/8/22.
 */
public class Login extends Activity{
    Button btn_login,btn_cancel;
    EditText user,psw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btn_login= (Button) findViewById(R.id.btn_login);
        btn_cancel= (Button) findViewById(R.id.btn_cancel);
        user= (EditText) findViewById(R.id.user);
        psw= (EditText) findViewById(R.id.psw);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=user.getText().toString();
                String pass=psw.getText().toString();
                if(name.equals("test")&&pass.equals("123")){
                    Toast tt=Toast.makeText(Login.this,"登录成功",Toast.LENGTH_LONG);
                    tt.show();
                    Intent success=new Intent();
                    success.setClass(Login.this,MainActivity.class);
                    startActivity(success);
                    finish();
                }
                else{
                    Toast tt=Toast.makeText(Login.this,"登录失败",Toast.LENGTH_LONG);
                    tt.show();
                }

            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast tt=Toast.makeText(Login.this,"点击了取消按钮",Toast.LENGTH_LONG);
                tt.show();
                finish();
            }
        });

    }
}
