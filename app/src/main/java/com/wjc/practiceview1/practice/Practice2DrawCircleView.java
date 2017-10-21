package com.wjc.practiceview1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by WJC on 2017/10/21.
 */

public class Practice2DrawCircleView extends View{

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画圆，四个圆分别是
        // 1.实心圆
        // 2.空心圆
        // 3.蓝色实心圆
        // 4.线宽为20的空心圆

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawCircle(300,200,150,paint);

        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(700,200,150,paint1);

        Paint paint2 = new Paint();
        paint2.setColor(Color.BLUE);
        canvas.drawCircle(300,500,150,paint2);

        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(50);
        canvas.drawCircle(700,500,150,paint3);


    }
}
