package com.wenson.litepal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import com.wenson.litepal.R;


/**
 * Created by Wenson_Luo on 2017/9/6.
 */

public class WaterButton extends AppCompatImageButton {

    public static final int INVALIDATE_DURATION = 15;
    private static int DIFFUSE_GAP = 10;
    private static int TAP_TIMEOUT;

    private int viewWidth, viewHeigth;
    private int pointX, pointY;
    private int maxRadio;
    private int shaderRadio;

    private Paint bottomPaint, colorPaint;
    private boolean isPushButton;

    private int eventX, eventY;
    private long downTime = 0;//按下的时间

    public WaterButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        //短按走向长按前的毫秒时间
        TAP_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    }

    private void initPaint() {
        colorPaint = new Paint();
        bottomPaint = new Paint();
        colorPaint.setColor(getResources().getColor(R.color.reveal_color));
        bottomPaint.setColor(getResources().getColor(R.color.bottom_color));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);//如果第一次view第一次添加到布局，w h 是当前宽高，old是0
        this.viewWidth = w;
        this.viewHeigth = h;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (downTime == 0) {
                    downTime = SystemClock.elapsedRealtime();//拿到按下的时间
                }
                eventX = (int) event.getX();
                eventY = (int) event.getY();
                //计算最大半径：
                countMaxRadio();
                isPushButton = true;
                postInvalidateDelayed(INVALIDATE_DURATION);
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                if (SystemClock.elapsedRealtime() - downTime < TAP_TIMEOUT) {
                    DIFFUSE_GAP = 30;//短按则扩散更快
                } else {
                    clearData();//长按恢复数据
                }
        }
        return super.onTouchEvent(event);

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!isPushButton) {
            return;
        }
        canvas.drawRect(pointX, pointY, pointX + viewWidth, pointY + viewHeigth, bottomPaint);
        canvas.save();
        canvas.clipRect(pointX, pointY, pointX + viewWidth, pointY + viewHeigth);
        canvas.drawCircle(eventX, eventY, shaderRadio, colorPaint);
        canvas.restore();

        if (shaderRadio < maxRadio) {
            postInvalidateDelayed(INVALIDATE_DURATION, pointX, pointY, pointX + viewWidth, pointY + viewHeigth);
            shaderRadio += DIFFUSE_GAP;
        } else {
            clearData();
        }
    }



    private void clearData() {
        downTime = 0;
        DIFFUSE_GAP = 10;
        isPushButton = false;
        shaderRadio = 0;
        postInvalidate();//刷新UI
    }

    private void countMaxRadio() {
        if (viewWidth > viewHeigth) {
            if (eventX < viewWidth / 2) {
                maxRadio = viewWidth - eventX;
            } else {
                maxRadio = eventX;
            }
        } else {
            if (eventY < viewHeigth / 2) {
                maxRadio = viewHeigth - eventY;
            } else {
                maxRadio = eventY;
            }
        }
    }
}
