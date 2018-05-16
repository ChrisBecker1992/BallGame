package com.example.kimilk.ballgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kimilk on 02.11.2017.
 */

public class Pad extends View {


    protected int maxX;
    protected int sizeFactor;
    protected float width;
    protected float height;


    public Pad(Context context) {
        super(context);
    }
    public Pad(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public Pad(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public Pad(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       sizeFactor = MeasureSpec.getSize(widthMeasureSpec) / 10;

        width = sizeFactor * 1.5f;
        height = sizeFactor * 2f;

        maxX = MeasureSpec.getSize(widthMeasureSpec) - (int) width;


        setY(MeasureSpec.getSize(heightMeasureSpec)-height);
        
        setMeasuredDimension((int) width, (int) height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
       // canvas.drawRGB(255,0,0);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        canvas.drawRoundRect(0,0, width, sizeFactor / 4f, sizeFactor*0.15f,sizeFactor*0.15f,paint); // drawLine und drawCircle für Übung 1
    }

    public void moveLeft(){
        if (getX() > 0){
            setX(getX() - sizeFactor*0.3f);
        }

    }

    public void moveRight(){
        if (getX() < maxX){
            setX(getX() + sizeFactor+0.3f);
        }

    }

}
