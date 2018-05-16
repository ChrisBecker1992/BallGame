package com.example.kimilk.ballgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {


    protected FrameLayout gameField;
    protected View touchpad;
    protected Pad pad;
    protected float lastX;

    protected Ball currentBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        pad = new Pad(this);
        touchpad = findViewById(R.id.touchpad);
        touchpad.setOnTouchListener(this);
        gameField = (FrameLayout) findViewById(R.id.game_field);
        gameField.addView(pad);

        startGame();

    }

    public void startGame(){
        currentBall = new Ball(this);
        currentBall.setPad(pad);
        gameField.addView(currentBall);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //Log.i("Touch Events", "X:" + motionEvent.getX());
        //pad.setX(motionEvent.getX());

        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            lastX = motionEvent.getX();
        }else if(motionEvent.getAction() == MotionEvent.ACTION_MOVE){
            if (lastX < motionEvent.getX()){
                pad.moveRight();
            }else {
                pad.moveLeft();
            }
            lastX = motionEvent.getX();
        }

        return true;
    }
}
