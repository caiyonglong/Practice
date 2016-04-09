package com.app.cyl.practice;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.app.cyl.notes.MyNotes;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button jz= (Button) findViewById(R.id.btn_ht);
        Button dc= (Button) findViewById(R.id.btn_dc);
        Button game = (Button) findViewById(R.id.btn_game);
        Button camera = (Button) findViewById(R.id.btn_camera);
        jz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent success=new Intent();
                success.setClass(MainActivity.this,JzActivity.class);
                startActivity(success);
            }
        });
        dc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent success=new Intent();
                success.setClass(MainActivity.this,MyNotes.class);
                startActivity(success);
            }
        });
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,Game2048.class);
                startActivity(intent);
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("android.media.action.IMAGE_CAPTURE");
                intent.addCategory("android.intent.category.DEFAULT");

                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.exit) {
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
