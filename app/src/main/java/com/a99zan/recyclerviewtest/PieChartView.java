package com.a99zan.recyclerviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by 99zan on 2018/3/15.
 */

public class PieChartView extends View {

    private Paint mPaint;

    private List<Percent> mPercentList;

    public PieChartView(Context context) {
        super(context);
        init();
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PieChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 移动画布
        canvas.translate(getWidth() / 2, getHeight() / 2);

        mPaint.setColor(Color.BLUE);
        for (int j = 0; j < 15; j++) {
            canvas.drawCircle(0, 0, 300, mPaint);
            canvas.drawCircle(0, 0, 280, mPaint);
            canvas.rotate(j);
            // 旋转画布 并画线![enter description here][6]
            for (float i = j; i <= 360f; i += 10f) {
                canvas.drawLine(0, 280, 0, 300, mPaint);
                canvas.rotate(10);
            }
            canvas.scale(0.75f, 0.75f);
        }
    }

    /**
     * 采用封装的思想
     */
    public static class Percent {
        String tag;
        float percent;
        int color;

        public Percent(String tag, float percent, int color) {
            this.tag = tag;
            this.percent = percent;
            this.color = color;
        }

        /**
         * 绘制 这个百分比
         *
         * @param paint
         * @param canvas
         * @param startAngle
         * @param rectF
         * @return 返回绘制的角度大小
         */
        public float drawArc(Paint paint, Canvas canvas, float startAngle, RectF rectF) {
            int oldColor = paint.getColor();
            Paint.Style oldStyle = paint.getStyle();

            paint.setColor(color);
            paint.setStyle(Paint.Style.FILL);

            canvas.drawArc(rectF, startAngle, 360 * percent, true, paint);

            paint.setColor(oldColor);
            paint.setStyle(oldStyle);

            return 360 * percent;
        }
    }
}
