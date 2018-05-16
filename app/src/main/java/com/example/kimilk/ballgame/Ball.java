package com.example.kimilk.ballgame;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Ball extends View {


    protected int sizeFactor;
    protected int position;
    protected float maxY;
    protected Pad pad;

    public void setPad(Pad pad){
        this.pad = pad;
    }

    public Ball(Context context) {
        super(context);
    }

    public Ball(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Ball(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Ball(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        sizeFactor = MeasureSpec.getSize(widthMeasureSpec) / 10;
        maxY = (float) MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(sizeFactor, sizeFactor);
    }






    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(sizeFactor * 0.5f, sizeFactor * 0.5f, sizeFactor *0.5f, paint);

        if (getY() > maxY){

        }

        position += (sizeFactor * 0.2f);
        setY(position);

        if (pad.getY() <= getY() + sizeFactor){
            float padLeft = pad.getX();
            float padRight = pad.getWidth() + pad.getX();
            float ballCenter = getX() + sizeFactor*0.5f;

            if (ballCenter >= padLeft && ballCenter <= padRight){
                Log.i("Ball_Game", "Catch_BAll");
            }

            position = -sizeFactor;
            setX(((float) Math.random()) * 9f *sizeFactor);
            setY(-sizeFactor);


            postInvalidateDelayed(500);
        }else {

            postInvalidateDelayed(50);

        }




    }
}
