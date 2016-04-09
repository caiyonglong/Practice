package com.app.cyl.practice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by caiyonglong0 on 2015/8/23.
 */
public class Game2048 extends Activity {

    public Game2048 (){
        game2048 =this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game2048);
        
        tvScore = (TextView) findViewById(R.id.tvScore);
//        rsScore= (TextView) findViewById(R.id.rsScore);
    }
    
    public void clearScore(){
        score =0;
        showscore();
        
    }

    public void showscore() {
        tvScore.setText(score+"");
//        rsScore.setText("当前积分为：\n\t\t"+rsScore);

    }

    public void addScore(int s){
        score+=s;
        showscore();
    }

    private  int score=0;
    private TextView tvScore,rsScore;
    private static Game2048 game2048 =null;
    public static Game2048 getGame2048(){
        return game2048;
    }
}
