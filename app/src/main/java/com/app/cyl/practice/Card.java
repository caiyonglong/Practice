package com.app.cyl.practice;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by caiyonglong0 on 2015/8/23.
 */
public class Card extends FrameLayout {
    public Card(Context context) {
        super(context);

        label = new TextView(getContext());
        label.setTextSize(32);
        label.setBackgroundColor(0x33ffffff);
        label.setGravity(Gravity.CENTER);

        LayoutParams lp=new LayoutParams(-1,-1);
        lp.setMargins(10,10,0,0);
        addView(label, lp);


        setNum(0);
    }
    private int num=0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        if (num <= 0) {
            label.setBackgroundColor(0x33ffffff);
            label.setText("");
        }else{

        label.setText(num+"");
            if(num==2){
                label.setBackgroundColor(0x77ffffff);
            }
            else if (num==4){
                label.setBackgroundColor(0x5500ff00);
            }
            else if (num==8){
                label.setBackgroundColor(0x33ff0000);
            }
            else if (num==16){
                label.setBackgroundColor(0x330000ff);
            }
            else if (num==32){
                label.setBackgroundColor(0x330000ff);
            }
            else if (num==64){
                label.setBackgroundColor(0x33ffffff);
            }
            else if (num==128){
                label.setBackgroundColor(0x3311ff22);
            }
            else if (num==256){
                label.setBackgroundColor(0x33ff5555);
            }
            else if (num==512){
                label.setBackgroundColor(0x33f0f000);
            }
            else {
                label.setBackgroundColor(0x33ffffff);
            }
        }
    }

    public boolean equals(Card o) {
        return  getNum()==o.getNum();
    }

    private TextView label;
}
