package com.wjc.practiceview1.practice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import com.wjc.practiceview1.R;

/**
 * Created by WJC on 2017/10/21.
 */

public class Practice11PieChatView extends TextView {
    /**
     * 饼图半径
     */
    private int mRaduis;
    /**
     * 一级颜色
     */
    private int mFirstPointColor;
    /**
     * 二级颜色
     */
    private int mSecondPointColor;

    /**
     * 第一比例
     */
    private float mFirstPoint;
    /**
     * 饼图上的字体大小
     */
    private int mPointTextSize;
    /**
     * 线条宽度
     */
    private int mLineWith;
    /**
     * 线条颜色
     */
    private int mLineColor;
    /**
     * 填充的画笔
     */
    private Paint mPaint;

    /**
     * 用来描边的画笔
     */
    private Paint mStokePaint;
    /**
     * 描边颜色
     */
    private int mStokeColor;
    /**
     * 绘制文字的画笔
     */
    private Paint mTextPaint;
    /**
     * 绘制文字的颜色
     */
    private int mTextColor;

    /**
     * @param mFirstPoint 设置第一比例
     */
    public void setmFirstPoint(float mFirstPoint) {
        this.mFirstPoint = mFirstPoint;
    }


    public Practice11PieChatView(Context context) {
        this(context, null);
    }

    public Practice11PieChatView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice11PieChatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获取我们的自定义属性
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircleChart, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CircleChart_mRaduis:
                    mRaduis = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CircleChart_mFirstPoint:
                    mFirstPoint = a.getFloat(attr, 50);
                    break;
                case R.styleable.CircleChart_mLinewith:
                    mLineWith = a.getDimensionPixelOffset(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CircleChart_mLineColor:
                    mLineColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CircleChart_mFirstPointColor:
                    mFirstPointColor = a.getColor(attr, Color.BLUE);
                    break;
                case R.styleable.CircleChart_mSecondPointColor:
                    mSecondPointColor = a.getColor(attr, Color.RED);
                    break;
                case R.styleable.CircleChart_mPointTextsize:
                    mPointTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CircleChart_mStokeColor:
                    mStokeColor = a.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.CircleChart_mTextColor:
                    mTextColor = a.getColor(attr, Color.BLACK);
                    break;
            }
        }
        a.recycle();

        //初始化paint

        mPaint = new Paint();
        mStokePaint = new Paint();
        mTextPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setAntiAlias(true);//消除锯齿
        mStokePaint.setAntiAlias(true);//消除锯齿
        mTextPaint.setAntiAlias(true);//消除锯齿
        mStokePaint.setStyle(Paint.Style.STROKE);
        mStokePaint.setStrokeWidth(mLineWith / 2);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mFirstPointColor);
        mStokePaint.setColor(mStokeColor);
        RectF oval = new RectF(mRaduis, mRaduis, mRaduis * 3, mRaduis * 3);

        //绘制实心圆弧
        canvas.drawArc(oval, 135 - (mFirstPoint / 100 * 360) / 2, (mFirstPoint / 100 * 360), true, mPaint);

        //绘制与底色相同的圆环
        canvas.drawArc(oval, 135 - (mFirstPoint / 100 * 360) / 2, (mFirstPoint / 100 * 360), true, mStokePaint);
        mPaint.setColor(mSecondPointColor);

        //绘制实心圆弧
        canvas.drawArc(oval, 315 - (360 - mFirstPoint / 100 * 360) / 2, (360 - mFirstPoint / 100 * 360), true, mPaint);

        //绘制与底色相同的圆环
        canvas.drawArc(oval, 315 - (360 - mFirstPoint / 100 * 360) / 2, (360 - mFirstPoint / 100 * 360), true, mStokePaint);
        mTextPaint.setColor(mTextColor);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setStrokeWidth(1);

        //绘制折线
        canvas.drawLine((float) (1 - Math.sqrt(2) / 2) * mRaduis + mRaduis, (float) (1 + Math.sqrt(2) / 2) * mRaduis + mRaduis, mRaduis, 3 * mRaduis, mTextPaint);
        canvas.drawLine(mRaduis, 2 * mRaduis + mRaduis, 0, 3 * mRaduis, mTextPaint);
        canvas.drawLine((float) (2 + Math.sqrt(2) / 2) * mRaduis, (float) (2 * mRaduis - Math.sqrt(2) / 2 * mRaduis), 3 * mRaduis, mRaduis, mTextPaint);
        canvas.drawLine(3 * mRaduis, mRaduis, 4 * mRaduis, mRaduis, mTextPaint);

        //绘制文字
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mPointTextSize);
        canvas.drawText("一级", 0, 3 * mRaduis - mRaduis / 20, mTextPaint);
        canvas.drawText("二级", 4 * mRaduis - mTextPaint.measureText("二级"), mRaduis - mRaduis / 20, mTextPaint);
        mTextPaint.setColor(mFirstPointColor);
        canvas.drawText((int) mFirstPoint + "%", 0, 3 * mRaduis + mRaduis / 20 + mPointTextSize, mTextPaint);
        mTextPaint.setColor(mSecondPointColor);
        canvas.drawText((int) (100 - mFirstPoint) + "%", 4 * mRaduis - mTextPaint.measureText("75%"), mRaduis + mRaduis / 20 + mPointTextSize, mTextPaint);
    }
}
