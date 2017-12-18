/**
 * activity继承此类可以侧滑关闭当前活动
 *
 */
package com.zia.test;

import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by zia on 2017/4/6.
 */

public class SlipActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    /**
     * 经过瞎几把测试，这样设置貌似比较不错
     * max为y轴相关设定，防止上下滚屏过快导致关闭页面
     */
    private float MIN_DISTANCE = 400;
    private float MAX_DISTANCE = 200;
    private float MIN_VELOCITY = 35;
    private float MAX_VELOCITY = 20;
    GestureDetector detector = new GestureDetector(this);

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        if(motionEvent1.getX()-motionEvent.getX() > MIN_DISTANCE
                && Math.abs(v)>MIN_VELOCITY
                && Math.abs(motionEvent1.getY()-motionEvent.getY()) < MAX_DISTANCE
                && Math.abs(v1)<MAX_VELOCITY){
            this.finish();
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}
