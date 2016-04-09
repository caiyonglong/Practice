package com.app.cyl.practice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by caiyonglong0 on 2015/8/23.
 */
public class GameView extends GridLayout {

    public GameView(Context context) {
        super(context);


        initGameView();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initGameView();
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initGameView();
    }
    private void initGameView(){
        setColumnCount(4);
        setBackgroundColor(0xffbbada0);

        setOnTouchListener(new OnTouchListener() {

            private float startX,StartY,offsetX,offsetY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                 switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        startX =event.getX();
                        StartY =event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        offsetX =event.getX()-startX;
                        offsetY =event.getY()-StartY;

                        if (Math.abs(offsetX)>Math.abs(offsetY)) {
                            if (offsetX <-5) {
                                //left
                                swipeLeft();
                            }else if (offsetX>5){
                                //right
                                swipeRight();
                            }
                        }else {
                            if (offsetY<-5) {
                                //up
                                 swipeUp();
                            }else if (offsetY>5){
                                //down
                                swipeDown();
                            }
                        }
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        
        int cardWidth = (Math.min(w,h)-10)/4;
        
        addCard(cardWidth,cardWidth);

        startGame();
    }
    private void addCard(int cardWidth, int cardHeight){
        
        Card c;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                c=new Card(getContext());
                c.setNum(0);
                addView(c,cardWidth,cardHeight);

                cardsMap[x][y]=c;
            }
        }
    }
    private void startGame(){

        Game2048.getGame2048().clearScore();

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                cardsMap[x][y].setNum(0);
            }
        }
        addRandomNum();
        addRandomNum();
    }
    private void addRandomNum(){

        emptyPoints.clear();
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (cardsMap[x][y].getNum()<=0) {
                    emptyPoints.add(new Point(x,y));
                }
            }
        }

        Point p = emptyPoints.remove((int)(Math.random()*emptyPoints.size()));
        cardsMap[p.x][p.y].setNum(Math.random()>0.1?2:4);
    }

    private void swipeLeft(){

        boolean merge =false;

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {

                for (int x1 = x+1; x1 < 4; x1++) {
                    if (cardsMap[x1][y].getNum()>0) {
                        if (cardsMap[x][y].getNum()<=0) {
                            cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
                            cardsMap[x1][y].setNum(0);

                            x--;
                            merge = true;


                        }else if (cardsMap[x][y].equals(cardsMap[x1][y])) {
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum()*2);
                            cardsMap[x1][y].setNum(0);

                            Game2048.getGame2048().addScore(cardsMap[x][y].getNum());
                            merge =true;
                        }
                        break;
                    }
                }
            }
        }
        if (merge) {
            addRandomNum();
            checkComplete();
        }
    }
    private void swipeRight(){
        boolean merge= false;
        for (int y = 0; y < 4; y++) {
            for (int x = 3; x >=0; x--) {

                for (int x1 = x-1; x1 >=0; x1--) {
                    if (cardsMap[x1][y].getNum()>0) {
                        if (cardsMap[x][y].getNum()<=0) {
                            cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
                            cardsMap[x1][y].setNum(0);

                            x++;
                            merge = true;
                        }else if (cardsMap[x][y].equals(cardsMap[x1][y])) {
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum()*2);
                            cardsMap[x1][y].setNum(0);

                            Game2048.getGame2048().addScore(cardsMap[x][y].getNum());
                            merge=true;
                        }
                        break;
                    }
                }
            }
        }
        if (merge) {
            addRandomNum();
            checkComplete();
        }
    }
    private void swipeUp(){
        boolean merge= false;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {

                for (int y1 = y+1; y1 < 4; y1++) {
                    if (cardsMap[x][y1].getNum()>0) {
                        if (cardsMap[x][y].getNum()<=0) {
                            cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
                            cardsMap[x][y1].setNum(0);

                            y--;
                            merge = true;
                        }else if (cardsMap[x][y].equals(cardsMap[x][y1])) {
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum()*2);
                            cardsMap[x][y1].setNum(0);

                            Game2048.getGame2048().addScore(cardsMap[x][y].getNum());
                            merge=true;
                        }
                        break;
                    }
                }
            }
        }
        if (merge) {
            addRandomNum();
            checkComplete();
        }
    }
    private void swipeDown(){

        boolean merge= false;
        for (int x = 0; x < 4; x++) {
            for (int y = 3; y >=0; y--) {

                for (int y1 = y-1; y1 >=0; y1--) {
                    if (cardsMap[x][y1].getNum()>0) {
                        if (cardsMap[x][y].getNum()<=0) {
                            cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
                            cardsMap[x][y1].setNum(0);

                            y++;
                            merge = true;
                        }else if (cardsMap[x][y].equals(cardsMap[x][y1])) {
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum()*2);
                            cardsMap[x][y1].setNum(0);

                            Game2048.getGame2048().addScore(cardsMap[x][y].getNum());
                            merge=true;
                        }
                        break;
                    }
                }
            }
        }
        if (merge) {
            addRandomNum();
            checkComplete();
        }
    }

    private void checkComplete(){
        boolean complete = true;
        int flag=1;
        ALL:
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (cardsMap[x][y].getNum()==0||
                        (x>0&&cardsMap[x][y].equals(cardsMap[x-1][y]))||
                        (x<3&&cardsMap[x][y].equals(cardsMap[x+1][y]))||
                        (y>0&&cardsMap[x][y].equals(cardsMap[x][y-1]))||
                        (y<3&&cardsMap[x][y].equals(cardsMap[x][y+1]))) {

                    complete = false;
                    flag=1;
                    break ALL;
                }
                else if (cardsMap[x][y].getNum()==2048){
                    complete = false;
                    flag=2;
                    break ALL;
                }
            }
        }


        if (complete) {
            if(flag==1) {
                new AlertDialog.Builder(getContext()).setTitle("关人你好！").setMessage("无路可走，再见！").setPositiveButton("再来一战！", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startGame();
                    }
                }).show();
            }
            else if (flag == 2) {
                new AlertDialog.Builder(getContext()).setTitle("关人你好！").setMessage("恭喜通关，用时....").setPositiveButton("再创佳绩！", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startGame();
//                        TextView sc= (TextView) findViewById(R.id.tvScore);
//                        sc.setText();
                    }
                }).show();
            }
        }
    }
    private Card[][] cardsMap=new Card[4][4];
    private List<Point> emptyPoints =new ArrayList<Point>();

}
